package com.example.ar_integration

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.NonNull
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import com.bhi.commonlib.app.ProcessUtil
import ex2india.com.furnituredrop.FurnitureDropActivity
import  ex2india.com.measureapp.MeasureActivity
import ex2india.com.pointofinterest.PointOfInterestActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import ex2india.com.pointofinterest.utils.LocationUtil

class MainActivity: FlutterActivity() {
    private val CHANNEL = "samples.flutter.dev/arIntegration"
    private var permissionRequested = false
    private var requestCode = -1

    companion object {
        val TAG = this::class.toString()

        private const val RC_AR_MEASURE_PERMISSIONS = 1
        private const val RC_AR_POI_PERMISSIONS = 2
        private const val RC_AR_FURNITURE_PERMISSIONS = 3
    }

//    private val requestPermissionLauncher =
//        registerForActivityResult(
//        ) { requestPermissionsResult ->
//            if (requestPermissionsResult.isNotEmpty()) {
//                val grantedPermissionsList = ArrayList<String>()
//                val deniedPermissionsList = ArrayList<String>()
//                for (key in requestPermissionsResult.keys) {
//                    if (requestPermissionsResult[key] == true) {
//                        grantedPermissionsList.add(key)
//                    } else {
//                        deniedPermissionsList.add(key)
//                    }
//                }
//                //if any of the pending permission is not granted
//                if (deniedPermissionsList.isNotEmpty()) {
//                    onPermissionsDenied(requestCode, grantedPermissionsList, deniedPermissionsList)
//                } else {
//                    onPermissionsGranted(requestCode, requestPermissionsResult.keys.toList())
//                }
//            }
//        }

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
          pendingPermissionList.forEach { it
              Log.d("permission", it.toString())
          }
            //requesting pending permissions
            this.requestCode = requestCode
           // requestPermissionLauncher.launch(pendingPermissionList.toTypedArray())
             requestPermissions(pendingPermissionList.toTypedArray(), requestCode)
            false
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
         Log.d("permission-->", grantResults.toString())
        val myIntent = Intent(this, FurnitureDropActivity::class.java)
        this.startActivity(myIntent)
    }

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        ProcessUtil.mainApplicationId = BuildConfig.APPLICATION_ID
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
                call, result ->
            // This method is invoked on the main thread.
            when (call.method) {
                "loadFurnitureDrop" -> {
                    onTouchFurnitureDrop()
                }
                "loadRoomMeasurement" -> {
                    onTouchRoomMeasurement()
                }
                "loadPOI" -> {
                    onTouchPointOfInterest(url = "", header = mapOf())
                }
                else -> {
                    result.notImplemented()
                }
            }
        }
    }

    private fun onTouchRoomMeasurement() {
        val arMeasurePermissionList = listOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )
        if (checkAndRequestPermissions(RC_AR_MEASURE_PERMISSIONS, arMeasurePermissionList)) {
            permissionRequested = false
            val measureIntent = Intent(this, MeasureActivity::class.java)
            this.startActivity(measureIntent)
        } else {
            permissionRequested = true
        }
    }

    private fun onTouchFurnitureDrop() {
        Log.d("myTag", "This is my message");
        val arFurniturePermissionList = listOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (checkAndRequestPermissions(RC_AR_FURNITURE_PERMISSIONS, arFurniturePermissionList)) {
            permissionRequested = false
            val furnitureIntent = Intent(this, FurnitureDropActivity::class.java)
            this.startActivity(furnitureIntent)
        } else {
            permissionRequested = true
        }
    }

    private fun onTouchPointOfInterest(url: String, header: Map<String, String>) {
        if (LocationUtil.checkLocationSetting(this)) {
            val poiPermissionList = listOf(
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
            )

            if (checkAndRequestPermissions(RC_AR_POI_PERMISSIONS, poiPermissionList)) {
                permissionRequested = false

                val bundle = Bundle()
                bundle.putInt(
                    PointOfInterestActivity.KEY_TINT_COLOR,
                    Color.BLUE)
                ActivityUtils.startActivity(this, PointOfInterestActivity::class.java, bundle)
            } else {
                permissionRequested = true
            }
        }
    }

}

