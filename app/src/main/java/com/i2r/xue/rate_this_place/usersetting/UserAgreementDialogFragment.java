package com.i2r.xue.rate_this_place.usersetting;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Dialog;
import android.app.FragmentManager;
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
import android.util.Log;
import android.util.Patterns;

import com.i2r.xue.rate_this_place.MainActivity;
import com.i2r.xue.rate_this_place.R;
import com.i2r.xue.rate_this_place.utility.Commonfunctions;

import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Created by Xue Fei on 3/6/2015.
 */
public class UserAgreementDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.user_agreement)
                .setPositiveButton(R.string.agree, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        getActivity().getSharedPreferences("PREFERENCE", getActivity().MODE_PRIVATE)
                                .edit()
                                .putBoolean("DoesUserAgree", true)
                                .apply();

                        ReadGoogleAccount();


                        getActivity().getSharedPreferences("VisitedPlaceStatus", getActivity().MODE_PRIVATE)
                                .edit()
                                .putString("VisitedPlaceStatusExtraIndex", "0")
                                .apply();

                        Commonfunctions.startPassiveDataCollection(getActivity());
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();

                    }
                })
                .setNegativeButton(R.string.disagree, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        getActivity().getSharedPreferences("PREFERENCE", getActivity().MODE_PRIVATE)
                                .edit()
                                .putBoolean("DoesUserAgree", false)
                                .apply();

                        getActivity().finish();
                        System.exit(0);
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    public void ReadGoogleAccount() {

        Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
        String possibleEmail = null;
        Account[] accounts = AccountManager.get(getActivity()).getAccounts();
        for (Account account : accounts) {
            if (emailPattern.matcher(account.name).matches()) {
                possibleEmail = account.name;
             //   Log.i("GoogleAccount", possibleEmail);
            }
        }

        String uniqueUserID=possibleEmail+"_"+getUniqueHardwareID();

        UUID uid = UUID.nameUUIDFromBytes(uniqueUserID.getBytes());
        Log.i("123", uid.toString());
        getActivity().getSharedPreferences("UserInfo", getActivity().MODE_PRIVATE)
                .edit()
                .putString("UserID",uid.toString())
                .apply();

    }

    public String getUniqueHardwareID(){
     /*   WifiManager wifiMan = (WifiManager) getActivity().getSystemService(
                Context.WIFI_SERVICE);
        WifiInfo wifiInf = wifiMan.getConnectionInfo();
        String wifimacAddr = wifiInf.getMacAddress();
        if (wifimacAddr != null){
            return "wifi_"+wifimacAddr;
        }
        else {
            BluetoothAdapter myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (myBluetoothAdapter!=null){
                String bluetoothmacAddr = myBluetoothAdapter.getAddress();
                if (bluetoothmacAddr!=null){
                    return "Blue_"+bluetoothmacAddr;
                }
                else{*/
                    String android_id = Settings.Secure.getString(getActivity().getContentResolver(),
                            Settings.Secure.ANDROID_ID);
                    if (android_id!=null){
                        return "Aid_"+android_id;
                    }
                    else{
                        return "no_available_hardwareID";

                    }
              /*  }
            }
            else{
                String android_id = Settings.Secure.getString(getActivity().getContentResolver(),
                        Settings.Secure.ANDROID_ID);
                if (android_id!=null){
                    return "Aid_"+android_id;
                }
                else{
                    return "no_available_hardwareID";

                }
            }
        }*/
    }


}
