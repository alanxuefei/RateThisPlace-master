package com.i2r.xue.rate_this_place.ratethisplace;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.i2r.xue.rate_this_place.mapview.MapsActivity;
import com.i2r.xue.rate_this_place.utility.Constants;
import com.i2r.xue.rate_this_place.utility.DataLogger;
import com.i2r.xue.rate_this_place.utility.globalvariable;
import com.i2r.xue.rate_this_place.visitedplace.VisitedPlacesActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Xue Fei on 1/7/2015.
 */

public class AsyncTaskUploadActivity extends AsyncTask {
    private Context context;
    String userid;
    protected static final String FTP_TAG = "FTP";
    JSONObject JsonGenerator_activity;




    public AsyncTaskUploadActivity(Context context, JSONObject JsonGenerator_activity0) {
        super();
        this.context=context;
        this.JsonGenerator_activity =JsonGenerator_activity0;

    }

    ProgressDialog barProgressDialog;

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
        barProgressDialog = new ProgressDialog(context);
        barProgressDialog.setTitle("Uploading");
        barProgressDialog.setMessage("Upload in progress ...");
        barProgressDialog.setProgressStyle(barProgressDialog.STYLE_SPINNER);

       // barProgressDialog.setProgress(0);
       // barProgressDialog.setMax(10);
        barProgressDialog.show();


        userid=context.getSharedPreferences("UserInfo", context.MODE_PRIVATE).getString("UserID","unknown");
    }


    @Override
    protected Object doInBackground(Object[] params) {



        try {
            UploadActivitytoServer(JsonGenerator_activity);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }



    public void ShowToastMessage(String i){
        Toast toast = Toast.makeText(context, i, Toast.LENGTH_LONG);
        LinearLayout toastLayout = (LinearLayout) toast.getView();
        TextView toastTV = (TextView) toastLayout.getChildAt(0);

        toastTV.setTextSize(30);
        toastTV.setBackgroundColor(Color.BLACK);
        toast.show();
    }


    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        barProgressDialog.dismiss();

        if (globalvariable.isRating_rated){
             context.startActivity(new Intent(context, MapsActivityFromRatethisPlace.class));
           // context.startActivity(new Intent(context, VisitedPlacesActivity.class));
        }
        else{

            Intent RateThisPlaceActivityIntent=new Intent(context, RateThisPlaceActivity.class);
            RateThisPlaceActivityIntent.putExtra("from", "Activity");
            context.startActivity(RateThisPlaceActivityIntent);
        }
    }


    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        Toast.makeText(this.context, "uploading", Toast.LENGTH_SHORT).show();



    }



    public void UploadActivitytoServer(JSONObject obj) throws JSONException {



        URL url = null;
        try {

            url = new URL("http://www.ratethisplace.co/uploadActivitytoDB.php?ActivityJson="+obj.toString().replaceAll(" ", "%20"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            //Log.i("php",  "network is not available");
            DataLogger.writeSimpleRatingTolog(url.toString());
            e.printStackTrace();
        }



        InputStream in = null;
        try {
            in = new BufferedInputStream(urlConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        StringBuilder total = new StringBuilder();
        String line;
        try {
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       // Log.i("php", total.toString());




    }


}