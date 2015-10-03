package com.i2r.xue.rate_this_place.ratethisplace;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.i2r.xue.rate_this_place.utility.globalvariable;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
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
    }

    public void clickImage_happyface(View view) {



        ((RadioButton)findViewById(com.i2r.xue.rate_this_place.R.id.radioButton)).setChecked(true);
        ((TextView)findViewById(com.i2r.xue.rate_this_place.R.id.textView)).setText("This place makes me feel: Happy");
        usermood = Mood.HAPPY;

    }

    public void addListenerOnRatingBar() {

        final String[] ratingscale = {"Very poor","Poor", "Average", "Good","Excellent"};

        RatingBar ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarCLEANNESS);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {

                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewCLEANNESS)).setText(ratingscale[(int) rating - 1]);
            }
        });

        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarSAFTY);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {

                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewSAFTY)).setText(ratingscale[(int) rating - 1]);
            }
        });

        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarBEAUTIFULNESS);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {


                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewBEAUTIFULNESS)).setText(ratingscale[(int) rating - 1]);
            }
        });

        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarGREENNESS);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {


                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewGREENNESS)).setText(ratingscale[(int)rating-1]);
            }
        });


        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarFRIENDLINESS);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {


                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewFRIENDLINESS)).setText(ratingscale[(int) rating - 1]);
            }
        });

        ratingBar = (RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarCONVENIENCE);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,  boolean fromUser) {

                ((TextView) findViewById(com.i2r.xue.rate_this_place.R.id.textViewCONVENIENCE)).setText(ratingscale[(int) rating - 1]);
            }
        });

    }








    public void clickButton_submit(View view) {

        SimpleDateFormat datetimeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = datetimeformat.format(new Date());
        JSONObject JsonGenerator_rating = new JSONObject();
        JSONObject JsonGenerator_rating_location = new JSONObject();

        try {



            JsonGenerator_rating.put("UserID", this.getSharedPreferences("UserInfo", this.MODE_PRIVATE).getString("UserID", null));


            JsonGenerator_rating.put("Nickname", PreferenceManager.getDefaultSharedPreferences(this).getString("display_name", ""));
            if (globalvariable.thelocation==null){
                JsonGenerator_rating_location =null;
                JsonGenerator_rating.put("PictureURL", "null");
            }
            else {
                JsonGenerator_rating_location.put("longitude", globalvariable.thelocation.getLongitude());
                JsonGenerator_rating_location.put("latitude", globalvariable.thelocation.getLatitude());
                JsonGenerator_rating.put("PictureURL", globalvariable.thelocation.getAccuracy());
            }
            JsonGenerator_rating.put("Datatime", timestamp);
            JsonGenerator_rating.put("Location", JsonGenerator_rating_location);
            JsonGenerator_rating.put("Feeling", usermood.toString());
            JsonGenerator_rating.put("Rating_Cleanness", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarCLEANNESS)).getRating());
            JsonGenerator_rating.put("Rating_Safty", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarSAFTY)).getRating());
            JsonGenerator_rating.put("Rating_Beauty", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarBEAUTIFULNESS)).getRating());
            JsonGenerator_rating.put("Rating_Friendliness", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarFRIENDLINESS)).getRating());
            JsonGenerator_rating.put("Rating_Convenience", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarCONVENIENCE)).getRating());
            JsonGenerator_rating.put("Rating_Greenness", ((RatingBar) findViewById(com.i2r.xue.rate_this_place.R.id.ratingBarGREENNESS)).getRating());



           // JsonGenerator_rating.put("Commentary", ((EditText) findViewById(com.i2r.alan.rate_this_place.R.id.AutoCompleteTextView_Commentary)).getText().toString());
          //  Log.i("JSON", JsonGenerator_rating.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
       // clickbuttonRecieve();

        AsyncTaskUploadRating myfileuploader = new AsyncTaskUploadRating(this,JsonGenerator_rating);
        myfileuploader.execute();



    }







}
