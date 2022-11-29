package com.bhi.commonlib.util

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Handler
import android.text.TextUtils
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bhi.commonlib.R
import com.bhi.commonlib.app.ProcessUtil
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.layout_app_common_toolbar.*


/**
 * @author Rahul Rastogi
 *
 * This class provides some common methods which may be used in almost every sub-class of AppCompatActivity class.
 */
abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        var stateHandler: Handler? = null
        var appInBackgroundRunnable: Runnable? = null
    }

    private var dialog: Dialog? = null

    var isActivityResumed = false
        private set

    private var requestCode = -1

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { requestPermissionsResult ->
            if (requestPermissionsResult.isNotEmpty()) {
                val grantedPermissionsList = ArrayList<String>()
                val deniedPermissionsList = ArrayList<String>()
                for (key in requestPermissionsResult.keys) {
                    if (requestPermissionsResult[key] == true) {
                        grantedPermissionsList.add(key)
                    } else {
                        deniedPermissionsList.add(key)
                    }
                }
                //if any of the pending permission is not granted
                if (deniedPermissionsList.isNotEmpty()) {
                    onPermissionsDenied(requestCode, grantedPermissionsList, deniedPermissionsList)
                } else {
                    onPermissionsGranted(requestCode, requestPermissionsResult.keys.toList())
                }
            }
        }

    open fun onPermissionsGranted(requestCode: Int, grantedPermissionList: List<String>) {
    }

    open fun onPermissionsDenied(
        requestCode: Int,
        grantedPermissionsList: List<String>,
        deniedPermissionsList: List<String>
    ) {
    }

    fun checkAndRequestPermissions(requestCode: Int, permissionsList: List<String>): Boolean {
        if (Build.VERSION.SDK_INT < 23) {
            return true
        }
        val pendingPermissionList = mutableListOf<String>()
        //Preparing pending permission list
        for (permission in permissionsList) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                pendingPermissionList.add(permission)
            }
        }
        return if (pendingPermissionList.isEmpty()) {
            true
        } else {
            //requesting pending permissions
            this.requestCode = requestCode
            requestPermissionLauncher.launch(pendingPermissionList.toTypedArray())
            false
        }
    }

    protected fun isNormallyCreated(): Boolean {
        if (!ProcessUtil.isAppProcessNormallyCreated) {
            ProcessUtil.restartAppNormally(this)
            return false
        }
        return true
    }

    fun setOrientation() {
        requestedOrientation = if (isTablet()) {
            ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        } else {
            ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
        }
    }

    fun dismissDialog() {
        if (dialog?.isShowing == true) {
            dialog?.dismiss()
            dialog = null
        }
    }

    open fun showProgressDialog(@ColorInt tintColor: Int? = null) {
        val progressBar = ProgressBar(this)
        tintColor?.apply {
            progressBar.indeterminateDrawable?.setColorFilter(this, PorterDuff.Mode.MULTIPLY)
        }
        val dialog = Dialog(this)
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setContentView(progressBar)

        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
        this@BaseActivity.dialog = dialog
    }

    fun hideProgressDialog() {
        dismissDialog()
    }

    override fun onDestroy() {
        super.onDestroy()
        dismissDialog()
    }

    override fun onPause() {
        super.onPause()
        isActivityResumed = false
        stateHandler = Handler()

        appInBackgroundRunnable = Runnable {
            stateHandler = null
            appInBackgroundRunnable = null
            onAppInBackground()
        }

        appInBackgroundRunnable?.let { stateHandler?.postDelayed(it, 2000) }
    }

    override fun onResume() {
        super.onResume()
        isActivityResumed = true

        if (stateHandler == null) {
            onAppInForeground()
        } else {
            appInBackgroundRunnable?.let { stateHandler?.removeCallbacks(it) }
            stateHandler = null
            appInBackgroundRunnable = null
        }
    }


    override fun onStart() {
        super.onStart()
        if (null != iv_toolbar_bar_back) {
            iv_toolbar_bar_back.setOnClickListener(this)
        }
    }

    protected abstract fun onAppInForeground()

    protected abstract fun onAppInBackground()

    fun isMobileDevice() = resources.getBoolean(R.bool.is_mobile_device)

    fun isTablet(): Boolean {
        return isNineInchTablet()
    }

    fun isSevenInchTablet() = resources.getBoolean(R.bool.is_seven_inch)

    fun isNineInchTablet() = resources.getBoolean(R.bool.is_nine_inch)

    fun hideActionBar() {
        supportActionBar?.hide()
    }

    fun setupActionBar(showBackIcon: Boolean, title: String) {
        iv_toolbar_bar_back?.visibility = if (showBackIcon) View.VISIBLE else View.GONE
        tv_toolbar_bar_title.text = title
    }

    fun setupActionBar(showBackIcon: Boolean, @StringRes titleResource: Int) {
        setupActionBar(showBackIcon, getString(titleResource))
    }

    fun setupActionBar(@DrawableRes leftIconResource: Int, @StringRes titleResource: Int) {
        setupActionBar(leftIconResource, getString(titleResource))
    }

    fun setupActionBar(@DrawableRes leftIconResource: Int, title: String) {
        iv_toolbar_bar_back.setImageResource(leftIconResource)
        setupActionBar(true, title)
    }

    fun setActionBarTitle(@StringRes titleRes: Int) {
        setActionBarTitle(getString(titleRes))
    }

    fun setActionBarTitle(title: String) {
        tv_toolbar_bar_title.text = title
    }

    fun setActionBarLogo(url: String?) {
        if (!TextUtils.isEmpty(url)) {
            ImageUtil.loadImage(this@BaseActivity, url!!, object : RequestListener<Drawable> {

                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    iv_toolbar_logo.visibility = View.GONE
                    return true
                }

                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?,
                                             dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    iv_toolbar_logo.visibility = View.VISIBLE
                    iv_toolbar_logo.setImageDrawable(resource)
                    return true
                }
            })
        }
    }

    protected fun showToast(message: String) {
        MyToast.makeText(this@BaseActivity, message)
    }

    protected fun showToast(@StringRes resId: Int) {
        showToast(getString(resId))
    }

    fun hideActionBarLogo() {
        iv_toolbar_logo.visibility = View.GONE
    }


    fun setStatusBarColor(@ColorRes colorResID: Int? = null) {
        if (colorResID != null && colorResID != 0) {
            Util.setStatusBarColorRes(this, colorResID)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if ((applicationContext.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) != Configuration.UI_MODE_NIGHT_YES) {
                    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
                window.statusBarColor = ContextCompat.getColor(this, R.color.bg_toolbar)
            } else {
                Util.setStatusBarColor(this, R.color.bg_toolbar_below_marshmallow)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                closeScreen()
                true
            }
            else ->
                super.onOptionsItemSelected(item)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.iv_toolbar_bar_back ->
                closeScreen()
        }
    }

    open fun getFragmentAtTop(): Fragment? {
        return null
    }

    override fun onBackPressed() {
        val fragmentAtTop = getFragmentAtTop()

        if (fragmentAtTop is OnBackPressed && fragmentAtTop.onBackPressed()) {
            return
        } else {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStackImmediate()
            } else {
                super.onBackPressed()
            }
        }
    }

    open fun closeScreen() {
        MyKeyboard.hideKeyboard(this)
        onBackPressed()
    }

    fun hideKeyboard() {
        val imm: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view: View? = currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(this@BaseActivity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    open fun showDialog(title: String? = null, message: String?,
                        @StringRes positiveResId: Int? = null, @ColorInt tintColorPositive: Int? = null,
                        onPositiveButtonClickListener: DialogInterface.OnClickListener? = null,
                        @StringRes negativeResId: Int? = null, @ColorInt tintColorNegative: Int? = null,
                        onNegativeButtonClickListener: DialogInterface.OnClickListener? = null,
                        cancelOnTouchOutside: Boolean = false,
                        isCancellable: Boolean = true) {

        val dialogBuilder = AlertDialog.Builder(this)

        title?.apply { dialogBuilder.setTitle(this) }
        dialogBuilder.setMessage(message)

        positiveResId?.apply { dialogBuilder.setPositiveButton(this, onPositiveButtonClickListener) }

        onNegativeButtonClickListener?.apply {
            negativeResId?.apply { dialogBuilder.setNegativeButton(this, onNegativeButtonClickListener) }
        }
                ?: negativeResId?.apply { dialogBuilder.setNegativeButton(this) { p0, _ -> p0.dismiss() } }

        val dialog = dialogBuilder.create()
        dialog.setCanceledOnTouchOutside(cancelOnTouchOutside)
        dialog.setCancelable(isCancellable)

        dialog.setOnShowListener {
            tintColorPositive?.apply {
                dialog.getButton(AlertDialog.BUTTON_POSITIVE)?.setTextColor(this@apply)
            }
            tintColorNegative?.apply {
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE)?.setTextColor(this@apply)
            }
        }

        dialog.show()
        this@BaseActivity.dialog = dialog
    }

    fun showOkDialog(message: String?, title: String? = null, isCancellable: Boolean = true,
                     onPositiveButtonClickListener: DialogInterface.OnClickListener? = null) {
        showDialog(title = title, message = message, positiveResId = R.string.ok,
                isCancellable = isCancellable,
                onPositiveButtonClickListener = onPositiveButtonClickListener
                        ?: DialogInterface.OnClickListener { p0, p1 -> p0?.dismiss() })
    }
}
