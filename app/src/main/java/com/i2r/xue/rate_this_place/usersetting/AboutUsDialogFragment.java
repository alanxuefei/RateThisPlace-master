package com.i2r.xue.rate_this_place.usersetting;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Patterns;

import com.i2r.xue.rate_this_place.MainActivity;
import com.i2r.xue.rate_this_place.R;
import com.i2r.xue.rate_this_place.utility.Commonfunctions;

import java.util.regex.Pattern;

/**
 * Created by Xue Fei on 3/6/2015.
 */
public class AboutUsDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("This App is developed for a scientific research project to understand how residents utilize the public space in their neighborhood area. This App has been optimized for power saving and advertisement free. No private data is collected. The anonymized device data is classified for research purpose only.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!


                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }



}
