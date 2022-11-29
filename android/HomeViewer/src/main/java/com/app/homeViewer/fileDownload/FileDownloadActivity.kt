package com.app.homeViewer.fileDownload

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import androidx.databinding.DataBindingUtil
import com.app.homeViewer.HomeViewerActivity
import com.app.homeViewer.R
import com.app.homeViewer.databinding.ActivityFileDownloadBinding
import com.app.homeViewer.repository.ModelRepository
import com.app.homeViewer.util.HomeViewerFileUtil
import com.app.homeViewer.util.zip.MZipper
import com.app.homeViewer.util.zip.Zipper
import com.bhi.commonlib.app.ProcessUtil
import com.bhi.commonlib.util.ActivityUtils
import com.bhi.commonlib.util.BaseActivity
import com.bhi.commonlib.util.MyToast
import java.io.File
import java.lang.ref.WeakReference
import java.net.UnknownHostException
import kotlin.properties.Delegates

class FileDownloadActivity : BaseActivity() {

    companion object {
        const val KEY_BDX_PLAN_ID = "bdx_plan_id"
        const val KEY_HOME_VIEWER_URL = "home_viewer_url"
        const val KEY_HOME_ON_LOT_URL = "home_on_lot_url"
        const val KEY_TINT_COLOR = "tint_color"

        private const val COMPRESSED_FILE_EXTENSION = ".zip"
    }

    //    private var downloadDialog: DownloadDialog? = null
    private var zipper: Zipper = MZipper()
    private var fileUnZipTask: FileUnZipTask? = null
    private var isShowingOnLot = false
    private var progressTint = Color.BLACK

    private var bdxPlanId by Delegates.notNull<Int>()

    //URL of current model's zip file.
    private var homeViewerURL: String? = null /* = "https://bdxmedia3dmodels.s3.amazonaws.com/HomePreview_Android.zip"*/
    private var homeOnLotURL: String? = null  /*"https://bdxmedia3dmodels.s3.amazonaws.com/HomeOnLot_Android.zip"*/

    //This directory holds current model's unzipped file.
    private lateinit var currentModelDirectory: File

    //This is the zip file of current model which gets downloaded in current model's directory.
    private lateinit var homeViewerZipFile: File

    private lateinit var activityFileDownloadBinding: ActivityFileDownloadBinding
    private var fileDownloadCallback: WeakReference<FileDownloader.Callback>? = null
    private var responseHandler: WeakReference<Handler>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!ProcessUtil.isAppProcessNormallyCreated) {
            ProcessUtil.restartAppNormally(this)
            return
        }

        activityFileDownloadBinding = DataBindingUtil.setContentView(this, R.layout.activity_file_download)

        bdxPlanId = intent.getIntExtra(KEY_BDX_PLAN_ID, 0)
        homeViewerURL = intent.getStringExtra(KEY_HOME_VIEWER_URL)
        homeOnLotURL = intent.getStringExtra(KEY_HOME_ON_LOT_URL)

        isShowingOnLot = !TextUtils.isEmpty(homeOnLotURL)

        initDirectoryAndFiles()

        if (HomeViewerFileUtil.isRenderableFilesExist(currentModelDirectory)) {
            //If model already exists for given URL, then loading it from disk.
            moveToHomeViewerActivity()
        } else {
            //Fetching 3D model from server
            downloadRenderableFilesFromNetwork()
        }
    }

    private fun initDirectoryAndFiles() {
        val prefix = if (isShowingOnLot) "HomeOnLot" else "HomePreview"
        //This directory will keep 3D model folder of every plan.
        val allModelsDirectory = File(filesDir, "$prefix/Models")
        if (!allModelsDirectory.exists()) {
            allModelsDirectory.mkdirs()
        }

        currentModelDirectory = File(allModelsDirectory, bdxPlanId.toString())
        if (!currentModelDirectory.exists()) {
            currentModelDirectory.mkdirs()
        }

        homeViewerZipFile = File(currentModelDirectory, "$bdxPlanId$COMPRESSED_FILE_EXTENSION")
    }

    @SuppressLint("StaticFieldLeak")
    private inner class FileUnZipTask : AsyncTask<Void, Void, Boolean>() {

        override fun doInBackground(vararg params: Void?): Boolean {
            val unzipException = zipper.unZipFile(homeViewerZipFile.path, currentModelDirectory.path, null)

            return if (unzipException == null) {
                //Deleting zip file, once the file has been un-zipped.
                homeViewerZipFile.delete()
                true
            } else {
                false
            }
        }

        override fun onPostExecute(result: Boolean) {
            super.onPostExecute(result)

            if (result) {
                MyToast.makeText(this@FileDownloadActivity, R.string.msg_home_download_success)

                //Now, zip file has been downloaded and un-zipped. So, the renderableFile should get available.
                if (HomeViewerFileUtil.isRenderableFilesExist(currentModelDirectory)) {
                    moveToHomeViewerActivity()
                } else {
                    MyToast.makeText(this@FileDownloadActivity, R.string.msg_something_went_wrong)
                }
            } else {
                MyToast.makeText(this@FileDownloadActivity, R.string.msg_something_went_wrong)
            }
        }
    }


    private fun downloadRenderableFilesFromNetwork() {
        if (!homeViewerZipFile.exists()) {
            homeViewerZipFile.createNewFile()
        }

        val onCancelClick = { fileDownloader: FileDownloader ->
            fileDownloader.isCancelled = true
            fileUnZipTask?.cancel(false)
            finish()
        }

        val serverURL = if (isShowingOnLot) homeOnLotURL!! else homeViewerURL!!

        responseHandler = WeakReference(Handler(Looper.getMainLooper()))
        fileDownloadCallback = WeakReference(ZipFileDownloadCallback())
        val fileDownloader = ModelRepository.getInstance().download3DModel(responseHandler!!, serverURL, homeViewerZipFile, fileDownloadCallback!!)

        activityFileDownloadBinding.ivCloseScreen.setOnClickListener { onCancelClick(fileDownloader) }
    }

    /**
     * This callback gets called when the ZIP file download completes.
     */
    private inner class ZipFileDownloadCallback : FileDownloader.Callback {

        override fun onProgressUpdate(progress: Int) {
            activityFileDownloadBinding.progressTv.text = "$progress%"
            changeImage(progress)
        }

        override fun onDownloadSuccess() {
            //Un-zipping file
            fileUnZipTask = FileUnZipTask()
            fileUnZipTask!!.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
        }

        override fun onDownloadFailure(exception: Exception) {
            if (exception is UnknownHostException) {
                MyToast.makeText(this@FileDownloadActivity, R.string.msg_no_network)
            } else {
                MyToast.makeText(this@FileDownloadActivity, R.string.msg_something_went_wrong)
            }
        }

        override fun onDownloadCancel() {}
    }

    private fun moveToHomeViewerActivity() {
        val bundle = Bundle()
        bundle.putInt(HomeViewerActivity.KEY_BDX_PLAN_ID, bdxPlanId)
        bundle.putBoolean(HomeViewerActivity.IS_SHOWING_ON_LOT, isShowingOnLot)
        ActivityUtils.startActivity(this, HomeViewerActivity::class.java, bundle)
        finish()
    }

    private fun changeImage(progress: Int) {
        val drawableResId = if (progress < 16.66) {
            R.drawable.home_1
        } else if (progress > 16.66 && progress < 33.32) {
            R.drawable.home_2
        } else if (progress > 33.32 && progress < 49.98) {
            R.drawable.home_3
        } else if (progress > 49.98 && progress < 66.64) {
            R.drawable.home_4
        } else if (progress > 66.64 && progress < 83.3) {
            R.drawable.home_5
        } else {
            R.drawable.home_6
        }

        activityFileDownloadBinding.homeIv.setImageDrawable(getDrawable(drawableResId))
    }

    override fun onAppInForeground() {}

    override fun onAppInBackground() {}

    override fun onDestroy() {
        super.onDestroy()
        responseHandler?.clear()
        fileDownloadCallback?.clear()
    }
}
