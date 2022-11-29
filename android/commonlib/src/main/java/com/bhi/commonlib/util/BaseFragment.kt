package com.bhi.commonlib.util

import android.app.Dialog
import android.app.Service
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.text.TextUtils
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bhi.commonlib.R
import com.bhi.commonlib.app.ProcessUtil

/**
 * @author Rahul Rastogi.
 *
 * Provides some basic methods to all sub-classes of Fragment class.
 * It must be used only if related Activity is inherited from BaseActivity class.
 */
open class BaseFragment : Fragment(), View.OnClickListener, OnBackPressed {

    private var isInResumeState = false
    protected var isAttached: Boolean = false
    private val attachSafeRunnable = mutableListOf<Runnable>()
    private var viewPostRunnable: Runnable? = null
    private var alertDialog: Dialog? = null
    private var progressBarDialog: Dialog? = null

    private var requestCode = -1
    val locationRequestCode = 10001

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

    fun checkAndRequestPermissions(
        requestCode: Int,
        permissionsList: List<String>,
        requestPermission: Boolean = true
    ): Boolean {
        if (Build.VERSION.SDK_INT < 23) {
            return true
        }
        val pendingPermissionList = mutableListOf<String>()
        //Preparing pending permission list
        for (permission in permissionsList) {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                pendingPermissionList.add(permission)
            }
        }
        return if (pendingPermissionList.isEmpty()) {
            true
        } else {
            //requesting pending permissions
            if (requestPermission) {
                this.requestCode = requestCode
                requestPermissionLauncher.launch(pendingPermissionList.toTypedArray())
            }
            false
        }
    }

    protected fun isNormallyCreated(): Boolean {
        if (activity != null && !ProcessUtil.isAppProcessNormallyCreated) {
            ProcessUtil.restartAppNormally(requireActivity())
            return false
        }
        return true
    }

    fun setAttachSafeRunnable(runnable: Runnable) {
        if (isAttached) {
            runnable.run()
            attachSafeRunnable.clear()
        } else {
            attachSafeRunnable.add(runnable)
        }
    }

    fun setViewPostRunnable(runnable: Runnable) {
        view?.post {
            if (isAttached) {
                viewPostRunnable = null
                Runnable { runnable.run() }
            } else {
                viewPostRunnable = runnable
            }
        }
    }

    override fun onClick(v: View) {}

    protected fun showToast(message: String?) {
        if (TextUtils.isEmpty(message))
            return
        setAttachSafeRunnable(Runnable { MyToast.makeText(requireActivity(), message!!) })
    }

    protected fun showToast(@StringRes resId: Int) {
        setAttachSafeRunnable(Runnable { MyToast.makeText(requireActivity(), resId) })
    }

    protected fun isTablet(): Boolean {
        return (activity as BaseActivity?)?.isTablet() ?: false
    }

    fun isInResumeState() = isInResumeState

    override fun onResume() {
        super.onResume()
        isInResumeState = true
    }

    override fun onPause() {
        super.onPause()
        isInResumeState = false
    }

    override fun onDetach() {
        super.onDetach()
        dismissAlertDialog()
        dismissProgressDialog()
        isAttached = false
        setAttachSafeRunnable(Runnable { MyKeyboard.hideKeyboard(requireActivity()) })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        dismissAlertDialog()
        dismissProgressDialog()
    }

    protected fun dismissAlertDialog() {
        if (alertDialog?.isShowing == true) {
            alertDialog?.dismiss()
            alertDialog = null
        }
    }

    protected fun dismissProgressDialog() {
        if (progressBarDialog?.isShowing == true) {
            progressBarDialog?.dismiss()
            progressBarDialog = null
        }
    }

    open fun showProgressDialog(@ColorInt tintColor: Int? = null) {
        if (progressBarDialog?.isShowing == true) {
            return
        }
        val progressBar = ProgressBar(context)
        tintColor?.apply {
            progressBar.indeterminateDrawable?.setColorFilter(this, PorterDuff.Mode.MULTIPLY)
        }

        context?.apply {
            val dialog = Dialog(this)
            dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
            dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.setContentView(progressBar)

            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
            dialog.show()
            this@BaseFragment.progressBarDialog = dialog
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        isAttached = true
        for (runnable in attachSafeRunnable) {
            runnable.run()
        }
        attachSafeRunnable.clear()
        viewPostRunnable?.run()
        viewPostRunnable = null
    }

    open fun showAlertDialog(
        title: String? = null, message: String?,
        @StringRes positiveResId: Int? = null, @ColorInt tintColorPositive: Int? = null,
        onPositiveButtonClickListener: DialogInterface.OnClickListener? = null,
        @StringRes negativeResId: Int? = null, @ColorInt tintColorNegative: Int? = null,
        onNegativeButtonClickListener: DialogInterface.OnClickListener? = null,
        cancelOnTouchOutside: Boolean = false
    ) {
        context?.apply {
            val dialogBuilder = AlertDialog.Builder(this)

            title?.apply { dialogBuilder.setTitle(this) }
            dialogBuilder.setMessage(message)

            positiveResId?.apply {
                dialogBuilder.setPositiveButton(
                    this,
                    onPositiveButtonClickListener
                )
            }

            onNegativeButtonClickListener?.apply {
                negativeResId?.apply {
                    dialogBuilder.setNegativeButton(
                        this,
                        onNegativeButtonClickListener
                    )
                }
            }
                ?: negativeResId?.apply { dialogBuilder.setNegativeButton(this) { p0, _ -> p0.dismiss() } }

            val dialog = dialogBuilder.create()
            dialog.setCanceledOnTouchOutside(cancelOnTouchOutside)

            dialog.setOnShowListener {
                tintColorPositive?.apply {
                    dialog.getButton(AlertDialog.BUTTON_POSITIVE)?.setTextColor(this@apply)
                }
                tintColorNegative?.apply {
                    dialog.getButton(AlertDialog.BUTTON_NEGATIVE)?.setTextColor(this@apply)
                }
            }

            dialog.show()
            this@BaseFragment.alertDialog = dialog
        }
    }

    fun showOkDialog(message: String?, title: String? = null) {
        showAlertDialog(title = title, message = message, positiveResId = R.string.ok,
            onPositiveButtonClickListener = { p0, p1 -> p0?.dismiss() })
    }

    protected fun hideKeyboard() {
        activity?.apply {
            MyKeyboard.hideKeyboard(this)
            val imm = getSystemService(Service.INPUT_METHOD_SERVICE) as InputMethodManager
            view?.windowToken?.apply {
                imm.hideSoftInputFromWindow(this, 0)
            }
        }
    }

    override fun onBackPressed(): Boolean {
        for (fragment in childFragmentManager.fragments) {
            if (fragment is OnBackPressed && fragment.onBackPressed()) {
                return true
            }
        }
        return false
    }
}
