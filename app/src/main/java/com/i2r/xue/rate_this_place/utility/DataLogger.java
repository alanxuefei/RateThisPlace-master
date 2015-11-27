package com.i2r.xue.rate_this_place.utility;

import android.os.Environment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by Xue Fei on 25/5/2015.
 */
public class DataLogger {

    /* write into text file*/
    protected static final String Log_TAG = "Log";

    private static StringBuffer sBuffer = new StringBuffer("");
    private static int NumberOfInsert=0;

    public static String mystorefilename;


    public static void writeTolog(String content,String logswich)  {

        SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss:SSS");
        String timestamp = timeformat.format(new Date());
        content = timestamp+" "+" "+content;
        sBuffer.append(content);
        NumberOfInsert++;
        if (NumberOfInsert>5000) {
            File file;
            FileOutputStream outputStream = null;

            //SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            String datestamp = dateformat.format(new Date());
            mystorefilename = datestamp + logswich + ".txt";

            try {
                file = new File(Environment.getExternalStorageDirectory(), "/" + "RateThisPlace" + "/" + "PassiveData/" + mystorefilename);
                outputStream = new FileOutputStream(file, true);
                outputStream.write(sBuffer.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            sBuffer.delete(0, sBuffer.length());
            NumberOfInsert=0;
        }
    }





    public static void writeSimpleRatingTolog(String content) {
        try {

            FileWriter file = new FileWriter(Environment.getExternalStorageDirectory() + "/" + "RateThisPlace" + "/" + "ActiveData/" + "simplerating.txt",true);
            file.write(content+"\n");
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void CheckAndCreateFolder(String path)  {

        File folder = new File(Environment.getExternalStorageDirectory() + "/"+path);
        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdir();
        }
        if (success) {
            // Do something on success
        } else {
            // Do something else on failure
        }

    }


    public static void EmptyFolder(String path) {

        File dir = new File(path);
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                new File(dir, children[i]).delete();
            }
        }

    }


    public static void AddtoVisitedPlacesList(String geofenceTransitionDetails) {






        SimpleDateFormat datetimeformat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

        String datetime  = datetimeformat.format(new Date());
        JSONObject EnteredPlace = new JSONObject();
        try {
            EnteredPlace.put("Datetime", datetime);
            EnteredPlace.put("Geofence",geofenceTransitionDetails);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            addtofile(Environment.getExternalStorageDirectory() + "/" + "RateThisPlace" + "/" + "ActiveData/" + "visitedplace.txt", EnteredPlace.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

      /*  FileWriter file = null;
        try {
            file = new FileWriter(Environment.getExternalStorageDirectory() + "/" + "RateThisPlace" + "/" + "ActiveData/" + "visitedplace.txt", true);
            file.write(EnteredPlace.toString()+ "," + "\n");
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    public static  void addtofile(String Input,String geofenceTransitionDetails) throws IOException, ParseException {
        String[] value ={null,null,null,null,null};
        if ( new File(Input).exists()){


        BufferedReader in = new BufferedReader(new FileReader(Input));

        String line;
        int linecount=0;
        while(((line = in.readLine()) != null)&&(linecount<5)){
          //  Log.i("DsssssD", line);
            value[linecount]=line;
            linecount++;
        }

          in.close();
        }


        File file = new File(Input);
        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        bw.append(geofenceTransitionDetails + ","+ '\n');
        for(int i=0; i<4; i++){
            if (value[i]!=null){
                bw.append(value[i]+'\n');
            }
        }
        bw.close();







    }

}
