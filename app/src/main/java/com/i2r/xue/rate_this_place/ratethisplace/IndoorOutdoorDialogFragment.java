package com.i2r.xue.rate_this_place.ratethisplace;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.i2r.xue.rate_this_place.usersetting.AboutUsDialogFragment;

/**
 * Created by Xue Fei on 3/6/2015.
 */
public class IndoorOutdoorDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Are you indoor or outdoor? If you are outdoor, the APP will use GPS to obtain your current location. If you are indoor the APP will use network to obtain your current location.")
                .setPositiveButton("Indoor", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        Intent intent = new Intent(getActivity(), RateThisPlaceActivity.class);
                        intent.putExtra("from", "MainActivity");
                        intent.putExtra("environment", "Indoor");
                        startActivity(intent);

                    }
                }).setNegativeButton("Outdoor", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {


                final LocationManager manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

                if (!manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {


                    (new GPSEnableDialogFragment()).show(getActivity().getSupportFragmentManager(), "NoticeDialogFragment");

                }else{


                    Intent intent = new Intent(getActivity(), RateThisPlaceActivity.class);
                    intent.putExtra("from", "MainActivity");
                    intent.putExtra("environment", "Outdoor");
                    startActivity(intent);
                }


            }
        });
        // Create the AlertDialog object and return it
        return builder.create();
    }



}
