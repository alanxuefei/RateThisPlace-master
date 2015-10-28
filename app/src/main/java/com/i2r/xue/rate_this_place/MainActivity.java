package com.i2r.xue.rate_this_place;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.i2r.xue.rate_this_place.mapview.MapsActivity;
import com.i2r.xue.rate_this_place.myrewards.AsyncTaskGetDataToMyRewardBar;
import com.i2r.xue.rate_this_place.myrewards.MyRewardActivity;
import com.i2r.xue.rate_this_place.pasivedatacollection.PassiveDataToFTPIntentService;
import com.i2r.xue.rate_this_place.ratethisplace.RateThisPlaceActivity;
import com.i2r.xue.rate_this_place.usersetting.AboutUsDialogFragment;
import com.i2r.xue.rate_this_place.usersetting.UserAgreementDialogFragment;
import com.i2r.xue.rate_this_place.usersetting.UserProfileActivity;
import com.i2r.xue.rate_this_place.utility.Commonfunctions;
import com.i2r.xue.rate_this_place.utility.DataLogger;
import com.i2r.xue.rate_this_place.utility.globalvariable;
import com.i2r.xue.rate_this_place.visitedplace.VisitedPlacesActivity;

/**
 * Created by Xue Fei on 19/5/2015.
 */

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener   {

    protected static final String FirstRun_TAG = "FirstRun";
    protected static final String ActionBar_TAG = "ActionBar";
    protected static final String GoogleSignIn_TAG = "GoogleSignIn";
    protected static final String Toolbar_TAG = "Toolbar";
    protected static final String GPS_Internet_Check_TAG = "GPS_Internet_Check";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        DataLogger.CheckAndCreateFolder(String.valueOf("RateThisPlace"));
        DataLogger.CheckAndCreateFolder(String.valueOf("RateThisPlace" + "/" + "PassiveData"));
        DataLogger.CheckAndCreateFolder(String.valueOf("RateThisPlace" + "/" + "ActiveData"));
        DataLogger.CheckAndCreateFolder(String.valueOf("RateThisPlace" + "/" + "PendingToSend"));

    }






    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_main, popup.getMenu());
        popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        popup.show();
    }

    @Override
    public void onStart() {
        super.onStart();



       // Intent intent = new Intent(this, SensorListenerService.class);
       // startService(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        checkFirstRun();

        // Intent intent = new Intent(this, SensorListenerService.class);
       // startService(intent);
    }

    @Override
    public void onPause() {
        super.onPause();
        //Intent intent = new Intent(this, SensorListenerService.class);
       // stopService(intent);

    }

    @Override
    protected void onStop() {
        super.onStop();

        //Intent intent = new Intent(this, SensorListenerService.class);
       // stopService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

      //  Intent intent = new Intent(this, SensorListenerService.class);
       // stopService(intent);
    }






    public void clickImage_activity_log(View view) {
      /*  Toast.makeText(this, "Activity_log", Toast.LENGTH_SHORT).show();*/
        //DataLogger.writeTolog("_________________________________start_a_new_test____________________________" + "\n");
        Intent intent = new Intent(this, VisitedPlacesActivity.class);
        startActivity(intent);

    }


    public void clickImage_myreward(View view) {

        Intent intent = new Intent(this, MyRewardActivity.class);
        startActivity(intent);

    }


    public void clickImage_rate_this_place(View view) {

        globalvariable.isActivity_rated=false;
        globalvariable.isRating_rated=false;
        Intent intent = new Intent(this, RateThisPlaceActivity.class);
        intent.putExtra("From", "MainActivity");
        startActivity(intent);

    }



    public void checkFirstRun() {
        boolean DoesUserAgree = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("DoesUserAgree", false);


        if (DoesUserAgree){

         //   Log.i(FirstRun_TAG, "User  agree");
            ((TextView)findViewById(R.id.textView_UserID)).setText("UserID: " + this.getSharedPreferences("UserInfo", this.MODE_PRIVATE).getString("UserID", null));
            checkNetworkandGPS();
            Commonfunctions.setSensingAlarm(this);

        }
        else{
         //   Log.i(FirstRun_TAG, "User have not agree yet");
            UserAgreementDialogFragment UserAgreement = new UserAgreementDialogFragment();
            UserAgreement.show(getSupportFragmentManager(), "NoticeDialogFragment");
        }

    }




    public void checkNetworkandGPS()
    {

        final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

        if (manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
          //  Log.i(GPS_Internet_Check_TAG, "GPS Yes");
            if (isConnectingToInternet())
            {
                ((TextView)findViewById(R.id.textView8)).setText("");
               // Log.i(GPS_Internet_Check_TAG, "internet Yes");
                new AsyncTaskGetDataToMyRewardBar(this,(ProgressBar)findViewById(R.id.progressBar_promote),(TextView)findViewById(R.id.textView_promote),
                        (ImageView)findViewById(R.id.imageView_rewards1),
                        (ImageView)findViewById(R.id.imageView_rewards2),(ImageView)findViewById(R.id.imageView_rewards3),
                        (ImageView)findViewById(R.id.imageView_rewards4),(ProgressBar)findViewById(R.id.progressBar_rewards),(TextView)findViewById(R.id.textView_Rewards)).execute();
            }
            else{
                ((TextView)findViewById(R.id.textView8)).setText("Internet is not available");

               // Log.i(GPS_Internet_Check_TAG, "internet No");
            }
        }
        else{

           // Log.i(GPS_Internet_Check_TAG, "GPS No");
            if (isConnectingToInternet())
            {
                ((TextView)findViewById(R.id.textView8)).setText("GPS is off");
              //  Log.i(GPS_Internet_Check_TAG, "internet Yes");
                new AsyncTaskGetDataToMyRewardBar(this,(ProgressBar)findViewById(R.id.progressBar_promote),(TextView)findViewById(R.id.textView_promote),
                        (ImageView)findViewById(R.id.imageView_rewards1),
                        (ImageView)findViewById(R.id.imageView_rewards2),(ImageView)findViewById(R.id.imageView_rewards3),
                        (ImageView)findViewById(R.id.imageView_rewards4),(ProgressBar)findViewById(R.id.progressBar_rewards),(TextView)findViewById(R.id.textView_Rewards)).execute();
            }
            else{
                ((TextView)findViewById(R.id.textView8)).setText("Internet is not available and GPS is off");

                //Log.i(GPS_Internet_Check_TAG, "internet No");
            }

        }


    }

    public boolean isConnectingToInternet(){
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }

        }
        return false;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_Menu:
                if (isConnectingToInternet()){
                    startActivity(new Intent(this, MapsActivity.class));
                }
                else{
                    Toast.makeText(this, "Please connect to Internet", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.action_manualupload:
                if (isConnectingToInternet()){
                    startService(new Intent(getBaseContext(), PassiveDataToFTPIntentService.class));
                }
                else{
                    Toast.makeText(this, "Please connect to Internet", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.action_userprofile:
                startActivity(new Intent(this, UserProfileActivity.class));
                break;
            case R.id.action_aboutus:
                AboutUsDialogFragment AboutUs = new AboutUsDialogFragment();
                AboutUs.show(getSupportFragmentManager(), "NoticeDialogFragment");
                break;

        }

        return super.onOptionsItemSelected(item);

    }


}
