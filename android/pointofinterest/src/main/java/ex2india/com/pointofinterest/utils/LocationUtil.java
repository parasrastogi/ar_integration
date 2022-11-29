package ex2india.com.pointofinterest.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;

import ex2india.com.pointofinterest.R;

public class LocationUtil {

    public static boolean checkLocationSetting(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        if (locationManager == null) {
            return false;
        }

        boolean gpsProviderEnabled = false;
        boolean networkProviderEnabled = false;

        try {
            gpsProviderEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            networkProviderEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (!networkProviderEnabled) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            if (!gpsProviderEnabled) {
                builder.setMessage(context.getResources().getString(R.string.msg_location_not_enabled_for_poi));
            } else {
                builder.setMessage(context.getResources().getString(R.string.msg_network_location_not_enabled_for_poi));
            }

            builder.setPositiveButton(context.getResources().getString(R.string.open_location_settings), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    context.startActivity(myIntent);
                }
            });

            builder.setNegativeButton(context.getString(R.string.cancel), null);
            builder.show();
            return false;
        }

        return true;
    }
}
