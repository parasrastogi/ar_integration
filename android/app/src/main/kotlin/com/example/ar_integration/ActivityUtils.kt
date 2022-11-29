package com.example.ar_integration

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle


/**
 * @author Rahul Rastogi
 *
 * A utility class which helps in launching activities with lesser boilerplate code.
 */
object ActivityUtils {

    fun startActivity(
        fragment: androidx.fragment.app.Fragment,
        activityClass: Class<out Activity>
    ) {
        startActivity(fragment, activityClass, null)
    }


    @JvmOverloads
    fun startActivity(context: Context, activityClass: Class<out Activity>, data: Bundle? = null) {
        val i = Intent(context, activityClass)
        if (null != data) {
            i.putExtras(data)
        }
        context.startActivity(i)
    }

    fun startActivity(
        frag: androidx.fragment.app.Fragment,
        activityClass: Class<out Activity>,
        data: Bundle?
    ) {

        val i = Intent(frag.activity, activityClass)
        if (null != data) {
            i.putExtras(data)
        }

        frag.startActivity(i)
    }

    fun clearBackStackActivities(
        context: Context,
        activity: Class<out Activity>,
        bundle: Bundle? = null
    ) {
        val intent = Intent(context, activity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

        if (null != bundle) {
            intent.putExtras(bundle)
        }
        context.startActivity(intent)
    }

    fun clearBackStackActivities(context: Context, intent: Intent, bundle: Bundle? = null) {
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

        if (null != bundle) {
            intent.putExtras(bundle)
        }
        context.startActivity(intent)
    }
}
