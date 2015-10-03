package com.i2r.xue.rate_this_place.myrewards;

import android.content.Context;
import android.os.AsyncTask;
//import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

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

public class AsyncTaskGetDataToMyReward extends AsyncTask {
    private Context context;
    private String UserID;
    protected static final String AsyncTaskGetDataToMyReward_TAG = "AsyncTaskGetData_MYREWARDS";

    TextView TextViewConnection,TextViewPoint;
    ProgressBar ProgressBar_wait;





    public AsyncTaskGetDataToMyReward(Context context0,TextView TextViewPoint0, ProgressBar Progressbar0) {
        super();
        this.context=context0;
        this.TextViewPoint=TextViewPoint0;
        this.ProgressBar_wait= Progressbar0;

       // this.progressBar_points=progressBar_points0;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();



    }


    @Override
    protected Object doInBackground(Object[] params) {
       // Log.i(AsyncTaskGetDataToMyReward_TAG, "start");
        URL url = null;

        JSONObject JsonGenerator_basicrating = new JSONObject();
        try {
            JsonGenerator_basicrating.put("UserID", context.getSharedPreferences("UserInfo", context.MODE_PRIVATE).getString("UserID", null));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {

            url = new URL("http://www.ratethisplace.co/getMyRewards.php?MyRewardsJson="+JsonGenerator_basicrating.toString().replaceAll(" ", "%20"));
           // Log.i(AsyncTaskGetDataToMyReward_TAG, "http://www.ratethisplace.co/getMyRewards.php?MyRewardsJson="+JsonGenerator_basicrating.toString().replaceAll(" ", "%20"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (urlConnection!=null) {

            InputStream in = null;
            try {
                in = new BufferedInputStream(urlConnection.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (in!=null) {
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

                return total.toString();
            }
        }
        return null;
    }


    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
       // Log.i(AsyncTaskGetDataToMyReward_TAG, o.toString());
        if (o!=null){


            try {
                JSONObject mJsonResponse = new JSONObject(o.toString().replace("[],",""));

                context.getSharedPreferences("UserInfo", context.MODE_PRIVATE)
                        .edit()
                        .putString("Rewards", mJsonResponse.getString("Reward"))
                .apply();
                ProgressBar_wait.setVisibility(View.GONE);
                TextViewPoint.setText(mJsonResponse.getString("Reward")+" Points");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else{
            TextViewConnection.setText("Internet is not available");

        }


    }




    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
       // Toast.makeText(this.context, "Connecting to The Server", Toast.LENGTH_SHORT).show();

    }








}