package com.i2r.xue.rate_this_place.visitedplace;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.i2r.xue.rate_this_place.R;
import com.i2r.xue.rate_this_place.myrewards.AsyncTaskGetDataToMyRewardBar;
import com.i2r.xue.rate_this_place.ratethisplace.infoDialogFragment;
import com.i2r.xue.rate_this_place.utility.Constants;
import com.i2r.xue.rate_this_place.utility.DataLogger;
import com.i2r.xue.rate_this_place.utility.globalvariable;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RateThisPlaceRatingFromVisitedPlacesActivity extends AppCompatActivity {

 /*add*/
    private enum Mood { NOFEELING, HAPPY, UNHAPPY}

    private Mood  usermood = Mood.NOFEELING;
    public static String Locationname1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_fromvisitedplaces);
        new AsyncTaskGetDataToMyRewardBar(this,(ProgressBar)findViewById(R.id.progressBar_promote),(TextView)findViewById(R.id.textView_promote),
                (ImageView)findViewById(R.id.imageView_rewards1),
                (ImageView)findViewById(R.id.imageView_rewards2),(ImageView)findViewById(R.id.imageView_rewards3),
                (ImageView)findViewById(R.id.imageView_rewards4),(ProgressBar)findViewById(R.id.progressBar_rewards),(TextView)findViewById(R.id.textView_Rewards)).execute();
        addListenerOnRatingBar();
        Intent intent = getIntent();
        Locationname1 = intent.getStringExtra("From");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(com.i2r.xue.rate_this_place.R.menu.rate_this_place_menu_main, menu);
        return true;
    }

    public void ReturnButton(View v) {
    //    Log.i("test", "returen");
        DataLogger.writeTolog("RateThisPlaceRatingFromVisitedPlaceActivity_ReturnButton" + " " + "\n", "");
        Intent intent = new Intent(this, VisitedPlacesActivity.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplication(), VisitedPlacesActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.i2r.xue.rate_this_place.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickImage_unhappyface(View view) {


        ((RadioButton)findViewById(com.i2r.xue.rate_this_place.R.id.radioButton2)).setChecked(true);
        ((TextView)findViewById(com.i2r.xue.rate_this_place.R.id.textView)).setText("This place makes me feel: Unhappy");
        usermood = Mood.UNHAPPY;
        DataLogger.writeTolog("VisitedPlace_clickImage_unhappyface" + " " + "\n", "");
    }

    public void clickImage_happyface(View view) {

        ((RadioButton)findViewById(com.i2r.xue.rate_this_place.R.id.radioButton)).setChecked(true);
        ((TextView)findViewById(com.i2r.xue.rate_this_place.R.id.textView)).setText("This place makes me feel: Happy");
        usermood = Mood.HAPPY;
        DataLogger.writeTolog("VisitedPlace_clickImage_happyface" + " " + "\n", "");

    }

    public void addListenerOnRatingBar() {

        final String[] ratingscale = {"Very poor","Poor", "Average", "Good","Excellent"};

        RatingBar ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarLively);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {

                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewLively)).setText(ratingscale[(int) rating - 1]);
                DataLogger.writeTolog("VisitedPlace_clickRatingBarLively" + " " + "\n", "");
            }
        });

        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarRelaxing);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {

                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewRelaxing)).setText(ratingscale[(int) rating - 1]);
                DataLogger.writeTolog("VisitedPlace_clickratingBarRelaxing" + " " + "\n", "");
            }
        });

        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarCosy);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {


                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewCosy)).setText(ratingscale[(int) rating - 1]);
                DataLogger.writeTolog("VisitedPlace_clickratingratingBarCosy" + " " + "\n", "");
            }
        });

        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarSafe);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {


                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewSafe)).setText(ratingscale[(int)rating-1]);
                DataLogger.writeTolog("VisitedPlace_clickratingBarSafe" + " " + "\n", "");
            }
        });


        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarRearrangeable);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewRearrangeable)).setText(ratingscale[(int) rating - 1]);
                DataLogger.writeTolog("VisitedPlace_clickratingBarRearrangeable" + " " + "\n", "");
            }
        });

        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarSociable);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {

                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewSociable)).setText(ratingscale[(int) rating - 1]);
                DataLogger.writeTolog("VisitedPlace_clickratingBarSociable" + " " + "\n", "");
            }
        });

        ratingBar = (RatingBar) findViewById(R.id.ratingBarSpecialtome);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {

                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewSpecialtome)).setText(ratingscale[(int) rating - 1]);
                DataLogger.writeTolog("VisitedPlace_clickratingBarSpecialtome" + " " + "\n", "");
            }
        });

        ratingBar = (RatingBar) findViewById(R.id.ratingBarPRIVACY);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {

                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewPRIVACY)).setText(ratingscale[(int) rating - 1]);
                DataLogger.writeTolog("VisitedPlace_clickratingBarPRIVACY" + " " + "\n", "");
            }
        });
    }

    public void clickButton_submit(View view) {




        double VratingBar1 = ((RatingBar) findViewById(R.id.ratingBarLively)).getRating();
        double VratingBar2 = ((RatingBar) findViewById(R.id.ratingBarRelaxing)).getRating();
        double VratingBar3 = ((RatingBar) findViewById(R.id.ratingBarCosy)).getRating();
        double VratingBar4 = ((RatingBar) findViewById(R.id.ratingBarRearrangeable)).getRating();
        double VratingBar5 = ((RatingBar) findViewById(R.id.ratingBarSociable)).getRating();
        double VratingBar6 = ((RatingBar) findViewById(R.id.ratingBarSafe)).getRating();
        double VratingBar7 = ((RatingBar) findViewById(R.id.ratingBarSpecialtome)).getRating();
        double VratingBar8 = ((RatingBar) findViewById(R.id.ratingBarPRIVACY)).getRating();

        int usedratingbar = 0;
        if (VratingBar1 != 0) usedratingbar++;
        if (VratingBar2 != 0) usedratingbar++;
        if (VratingBar3 != 0) usedratingbar++;
        if (VratingBar4 != 0) usedratingbar++;
        if (VratingBar5 != 0) usedratingbar++;
        if (VratingBar6 != 0) usedratingbar++;
        if (VratingBar7 != 0) usedratingbar++;
        if (VratingBar8 != 0) usedratingbar++;

        if (usedratingbar > 0) {
            double avgrating = (VratingBar1+VratingBar2+VratingBar3+VratingBar4+VratingBar5+VratingBar6+VratingBar7+VratingBar8 ) / usedratingbar;
            DecimalFormat df = new DecimalFormat("0.0");

            SimpleDateFormat datetimeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = datetimeformat.format(new Date());
            JSONObject JsonGenerator_rating = new JSONObject();
            JSONObject JsonGenerator_rating_location = new JSONObject();

            try {


                JsonGenerator_rating.put("UserID", this.getSharedPreferences("UserInfo", this.MODE_PRIVATE).getString("UserID", null));


                JsonGenerator_rating.put("Nickname", PreferenceManager.getDefaultSharedPreferences(this).getString("display_name", ""));


                LatLng detectedlocation_LatLng = null;


                for (GeoFencingLocationClass item : Constants.AREA_LANDMARKS) {
                    if ((item.getName()).equals(Locationname1)){
                        detectedlocation_LatLng=item.getLocation();
                    }
                }

                if (detectedlocation_LatLng == null) {

                    if (((globalvariable.getThelocation()).distanceTo(Constants.mainpoint1)<Constants.mainpointradius1)||
                            ((globalvariable.getThelocation()).distanceTo(Constants.mainpoint2)<Constants.mainpointradius2)||
                            ((globalvariable.getThelocation()).distanceTo(Constants.mainpoint3)<Constants.mainpointradius3)||
                            ((globalvariable.getThelocation()).distanceTo(Constants.mainpoint4)<Constants.mainpointradius4)||
                            ((globalvariable.getThelocation()).distanceTo(Constants.mainpoint5)<Constants.mainpointradius5)||
                            ((globalvariable.getThelocation()).distanceTo(Constants.mainpoint6)<Constants.mainpointradius6)) {

                        JsonGenerator_rating.put("IsTestbed",true);
                        ShowToastMessage("The data is uploaded successfully.");
                    }
                    else {

                        JsonGenerator_rating.put("IsTestbed", false);
                        ShowToastMessage("The data is uploaded successfully, but System shows this rated place is not in the research list. Thus 0 point is credited.");
                    }
                    Log.i("location", String.valueOf(globalvariable.getThelocation().getLongitude()));
                    JsonGenerator_rating_location.put("longitude", String.valueOf(globalvariable.getThelocation().getLongitude()));
                    JsonGenerator_rating_location.put("latitude",  String.valueOf(globalvariable.getThelocation().getLatitude()));

                } else {
                    JsonGenerator_rating_location.put("longitude", detectedlocation_LatLng.longitude);
                    JsonGenerator_rating_location.put("latitude", detectedlocation_LatLng.latitude);
                    JsonGenerator_rating.put("LocationAccuracy", "Special");
                    JsonGenerator_rating.put("IsTestbed", true);
                }


                JsonGenerator_rating.put("Datatime", timestamp);
                JsonGenerator_rating.put("Location", JsonGenerator_rating_location);
                JsonGenerator_rating.put("Feeling", usermood.toString());
                JsonGenerator_rating.put("Rating_Lively", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarLively)).getRating());
                JsonGenerator_rating.put("Rating_Relaxing", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarRelaxing)).getRating());
                JsonGenerator_rating.put("Rating_Cosy", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarCosy)).getRating());
                JsonGenerator_rating.put("Rating_Rearrangeable", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarRearrangeable)).getRating());
                JsonGenerator_rating.put("Rating_Privacy", ((RatingBar) findViewById(R.id.ratingBarPRIVACY)).getRating());
                JsonGenerator_rating.put("Rating_Sociable", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarSociable)).getRating());
                JsonGenerator_rating.put("Rating_Safe", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarSafe)).getRating());
                JsonGenerator_rating.put("Rating_Specialtome", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarSpecialtome)).getRating());
                JsonGenerator_rating.put("Rating_Safe", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarSafe)).getRating());


                // JsonGenerator_rating.put("Commentary", ((EditText) findViewById(com.i2r.alan.rate_this_place.R.id.AutoCompleteTextView_Commentary)).getText().toString());
                //  Log.i("JSON", JsonGenerator_rating.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }


            AsyncTaskUploadRatingFromVisitedPlace myfileuploader = new AsyncTaskUploadRatingFromVisitedPlace(this, JsonGenerator_rating);
            myfileuploader.execute();

            this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).edit().putString(Locationname1+ "RatingStatus", df.format(avgrating)).apply();

        } else {
            ShowToastMessage("Please at least input one rating");
        }
        //  Log.i("VisitedPlace", Locationname1+"RatingStatus");
    }
    public void ShowInfo(View i){
        infoDialogFragment AboutUs = new infoDialogFragment();
        AboutUs.show(getSupportFragmentManager(), "Info");
    }

    public void ShowToastMessage(String i){
        Toast toast = Toast.makeText(this, i, Toast.LENGTH_SHORT);
        LinearLayout toastLayout = (LinearLayout) toast.getView();
        TextView toastTV = (TextView) toastLayout.getChildAt(0);
        toastTV.setTextSize(30);
        toastTV.setBackgroundColor(Color.BLACK);
        toast.show();
    }









}
