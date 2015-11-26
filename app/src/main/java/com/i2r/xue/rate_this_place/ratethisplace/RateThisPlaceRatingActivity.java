package com.i2r.xue.rate_this_place.ratethisplace;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.i2r.xue.rate_this_place.R;
import com.i2r.xue.rate_this_place.usersetting.AboutUsDialogFragment;
import com.i2r.xue.rate_this_place.utility.Constants;
import com.i2r.xue.rate_this_place.utility.DataLogger;
import com.i2r.xue.rate_this_place.utility.globalvariable;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RateThisPlaceRatingActivity extends AppCompatActivity {

    /*google activity detection*/

    private enum Mood { NOFEELING, HAPPY, UNHAPPY}

    private Mood  usermood = Mood.NOFEELING;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.i2r.xue.rate_this_place.R.layout.activity_rating);


       // final EditText mAutoCompleteTextView_Commentary= (EditText) findViewById(com.i2r.alan.rate_this_place.R.id.AutoCompleteTextView_Commentary);

  /*      mAutoCompleteTextView_Commentary.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            public void afterTextChanged(Editable s) {

                // you can call or do what you want with your EditText here
                final Button mbutton_editdone = (Button) findViewById(com.i2r.alan.rate_this_place.R.id.button_editdone);
                mbutton_editdone.setVisibility(View.VISIBLE);
                mbutton_editdone.setOnClickListener(new View.OnClickListener() {

                    @Override

                    public void onClick(View view) {


                        mbutton_editdone.setVisibility(View.GONE);
                        //release the focus
                        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    }

                });

            }


        });*/

        addListenerOnRatingBar();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(com.i2r.xue.rate_this_place.R.menu.rate_this_place_menu_main, menu);
        return true;
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
        DataLogger.writeTolog("RateThisPlaceRatingActivity_clickImage_unhappyface" + " " + "\n", "");
    }

    public void clickImage_happyface(View view) {



        ((RadioButton)findViewById(com.i2r.xue.rate_this_place.R.id.radioButton)).setChecked(true);
        ((TextView)findViewById(com.i2r.xue.rate_this_place.R.id.textView)).setText("This place makes me feel: Happy");
        usermood = Mood.HAPPY;
        DataLogger.writeTolog("RateThisPlaceRatingActivity_clickImage_happyface" + " " + "\n", "");

    }

    public void addListenerOnRatingBar() {

        final String[] ratingscale = {"Very poor","Poor", "Average", "Good","Excellent"};

        RatingBar ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarLively);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {

                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewLively)).setText(ratingscale[(int) rating - 1]);
                DataLogger.writeTolog("RateThisPlaceRatingActivity_clickRatingBarLively" + " " + "\n", "");
            }
        });

        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarRelaxing);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {

                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewRelaxing)).setText(ratingscale[(int) rating - 1]);
                DataLogger.writeTolog("RateThisPlaceRatingActivity_clickratingBarRelaxing" + " " + "\n", "");
            }
        });

        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarCosy);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {


                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewCosy)).setText(ratingscale[(int) rating - 1]);
                DataLogger.writeTolog("RateThisPlaceRatingActivity_clickratingratingBarCosy" + " " + "\n", "");
            }
        });

        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarSafe);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {


                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewSafe)).setText(ratingscale[(int)rating-1]);
                DataLogger.writeTolog("RateThisPlaceRatingActivity_clickratingBarSafe" + " " + "\n", "");
            }
        });


        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarRearrangeable);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewRearrangeable)).setText(ratingscale[(int) rating - 1]);
                DataLogger.writeTolog("RateThisPlaceRatingActivity_clickratingBarRearrangeable" + " " + "\n", "");
            }
        });

        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarSociable);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {

                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewSociable)).setText(ratingscale[(int) rating - 1]);
                DataLogger.writeTolog("RateThisPlaceRatingActivity_clickratingBarSociable" + " " + "\n", "");
            }
        });

        ratingBar = (RatingBar) findViewById(R.id.ratingBarSpecialtome);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {

                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewSpecialtome)).setText(ratingscale[(int) rating - 1]);
                DataLogger.writeTolog("RateThisPlaceRatingActivity_clickratingBarSpecialtome" + " " + "\n", "");
            }
        });

        ratingBar = (RatingBar) findViewById(R.id.ratingBarPRIVACY);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {

                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewPRIVACY)).setText(ratingscale[(int) rating - 1]);
                DataLogger.writeTolog("RateThisPlaceRatingActivity_clickratingBarPRIVACY" + " " + "\n", "");
            }
        });
    }








    public void clickButton_submit(View view) throws JSONException {


        double VratingBarCLEANNESS = ((RatingBar) findViewById(R.id.ratingBarLively)).getRating();
        double VratingBarSAFTY = ((RatingBar) findViewById(R.id.ratingBarRelaxing)).getRating();
        double VratingBarBEAUTIFULNESS = ((RatingBar) findViewById(R.id.ratingBarCosy)).getRating();
        double VratingBarFRIENDLINESS = ((RatingBar) findViewById(R.id.ratingBarRearrangeable)).getRating();
        double VratingBarCONVENIENCE = ((RatingBar) findViewById(R.id.ratingBarSociable)).getRating();
        double VratingBarGREENNESS = ((RatingBar) findViewById(R.id.ratingBarSafe)).getRating();

        int usedratingbar = 0;
        if (VratingBarCLEANNESS != 0) usedratingbar++;
        if (VratingBarSAFTY != 0) usedratingbar++;
        if (VratingBarBEAUTIFULNESS != 0) usedratingbar++;
        if (VratingBarFRIENDLINESS != 0) usedratingbar++;
        if (VratingBarCONVENIENCE != 0) usedratingbar++;
        if (VratingBarGREENNESS != 0) usedratingbar++;

        if (globalvariable.thelocation != null) {
            if (usedratingbar> 0) {

                DataLogger.writeTolog("RateThisPlaceRatingActivity_clickButton_submit_RateThisPlaceRatingActivity" + " " + "\n", "");

                SimpleDateFormat datetimeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timestamp = datetimeformat.format(new Date());
                JSONObject JsonGenerator_rating = new JSONObject();
                JSONObject JsonGenerator_rating_location = new JSONObject();


                if (((globalvariable.getThelocation()).distanceTo(Constants.mainpoint1)<Constants.mainpointradius1)||
                        ((globalvariable.getThelocation()).distanceTo(Constants.mainpoint2)<Constants.mainpointradius2)||
                        ((globalvariable.getThelocation()).distanceTo(Constants.mainpoint3)<Constants.mainpointradius3)||
                        ((globalvariable.getThelocation()).distanceTo(Constants.mainpoint4)<Constants.mainpointradius4)||
                        ((globalvariable.getThelocation()).distanceTo(Constants.mainpoint5)<Constants.mainpointradius5)||
                        ((globalvariable.getThelocation()).distanceTo(Constants.mainpoint6)<Constants.mainpointradius6)) {

                    JsonGenerator_rating.put("IsTestbed", true);
                    ShowToastMessage("The data is uploaded successfully.");
                }
                else {

                    JsonGenerator_rating.put("IsTestbed", false);
                    ShowToastMessage("The data is uploaded successfully, but System shows this rated place is not in the research list. Thus 0 point is credited.");
                }

                try {


                    JsonGenerator_rating.put("UserID", this.getSharedPreferences("UserInfo", this.MODE_PRIVATE).getString("UserID", null));


                    JsonGenerator_rating.put("Nickname", PreferenceManager.getDefaultSharedPreferences(this).getString("display_name", ""));
                    if (globalvariable.thelocation == null) {
                        JsonGenerator_rating_location = null;
                        JsonGenerator_rating.put("LocationAccuracy", "null");
                    } else {
                        JsonGenerator_rating_location.put("longitude", globalvariable.thelocation.getLongitude());
                        JsonGenerator_rating_location.put("latitude", globalvariable.thelocation.getLatitude());
                        JsonGenerator_rating.put("LocationAccuracy", globalvariable.thelocation.getAccuracy());
                    }
                    JsonGenerator_rating.put("Datatime", timestamp);
                    JsonGenerator_rating.put("Location", JsonGenerator_rating_location);
                    JsonGenerator_rating.put("Feeling", usermood.toString());
                    JsonGenerator_rating.put("Rating_Lively", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarLively)).getRating());
                    JsonGenerator_rating.put("Rating_Relaxingy", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarRelaxing)).getRating());
                    JsonGenerator_rating.put("Rating_Privacy", ((RatingBar) findViewById(R.id.ratingBarPRIVACY)).getRating());
                    JsonGenerator_rating.put("Rating_Cosy", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarCosy)).getRating());
                    JsonGenerator_rating.put("Rating_Rearrangeable", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarRearrangeable)).getRating());
                    JsonGenerator_rating.put("Rating_Sociable", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarSociable)).getRating());
                    JsonGenerator_rating.put("Rating_Safe", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarSafe)).getRating());
                    JsonGenerator_rating.put("Rating_Specialtome", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarSpecialtome)).getRating());
                    JsonGenerator_rating.put("Rating_Safe", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarSafe)).getRating());


                    // JsonGenerator_rating.put("Commentary", ((EditText) findViewById(com.i2r.alan.rate_this_place.R.id.AutoCompleteTextView_Commentary)).getText().toString());
                      Log.i("JSON", JsonGenerator_rating.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // clickbuttonRecieve();

                AsyncTaskUploadRating myfileuploader = new AsyncTaskUploadRating(this, JsonGenerator_rating);
                myfileuploader.execute();


                globalvariable.isRating_rated = true;


                double avgrating = (VratingBarCLEANNESS + VratingBarSAFTY + VratingBarBEAUTIFULNESS + VratingBarFRIENDLINESS + VratingBarCONVENIENCE + VratingBarGREENNESS) / usedratingbar;

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String currentDate = sdf.format(new Date());
                sdf = new SimpleDateFormat("HH:mm:ss");
                String currentTime = sdf.format(new Date());
                String VisitedPlaceStatusExtraIndex = (this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).getString("VisitedPlaceStatusExtraIndex", "0"));
                DecimalFormat df = new DecimalFormat("0.0");
                this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).edit().putString("VisitedPlaceStatusLongitude" + VisitedPlaceStatusExtraIndex, String.valueOf(globalvariable.thelocation.getLongitude())).apply();
                this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).edit().putString("VisitedPlaceStatusLatitude" + VisitedPlaceStatusExtraIndex, String.valueOf(globalvariable.thelocation.getLatitude())).apply();
                this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).edit().putString("VisitedPlaceStatusExtraRating" + VisitedPlaceStatusExtraIndex, df.format(avgrating)).apply();
                this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).edit().putString("VisitedPlaceStatusExtra" + VisitedPlaceStatusExtraIndex + "DateTime", currentDate + "_" + currentTime).apply();
                if (!globalvariable.isActivity_rated)
                    this.getSharedPreferences("VisitedPlaceStatus", this.MODE_PRIVATE).edit().putString("VisitedPlaceStatusExtraActivity" + VisitedPlaceStatusExtraIndex, "NA").apply();


            }
            else{
                ShowToastMessage("Please input at least one rating");

            }
        }
        else{
            ShowToastMessage("Waiting for the location");
        }


    }

    public void ShowToastMessage(String i){
        Toast toast = Toast.makeText(this, i, Toast.LENGTH_SHORT);
        LinearLayout toastLayout = (LinearLayout) toast.getView();
        TextView toastTV = (TextView) toastLayout.getChildAt(0);
        toastTV.setTextSize(30);
        toastTV.setBackgroundColor(Color.BLACK);
        toast.show();
    }


    public void ShowInfo(View i){
        infoDialogFragment AboutUs = new infoDialogFragment();
        AboutUs.show(getSupportFragmentManager(), "Info");
    }


}
