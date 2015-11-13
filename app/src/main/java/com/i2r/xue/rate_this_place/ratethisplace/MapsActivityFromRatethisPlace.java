package com.i2r.xue.rate_this_place.ratethisplace;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.i2r.xue.rate_this_place.R;
import com.i2r.xue.rate_this_place.mapview.AsyncTaskGetActivitiesDataToMap;
import com.i2r.xue.rate_this_place.mapview.AsyncTaskGetRatingDataToMap;
import com.i2r.xue.rate_this_place.mapview.MapsActivity;
import com.i2r.xue.rate_this_place.utility.globalvariable;
import com.i2r.xue.rate_this_place.visitedplace.VisitedPlacesActivity;

import java.io.FileOutputStream;

//import android.util.Log;

public class MapsActivityFromRatethisPlace extends FragmentActivity implements GoogleMap.OnMapLoadedCallback {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }

        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
       // mMap.setMyLocationEnabled(true);
        mMap.setIndoorEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
      //  (new AsyncTaskGetRatingDataToMap(this,mMap)).execute();
      //  (new AsyncTaskGetActivitiesDataToMap(this,mMap)).execute();
        if(globalvariable.thelocation==null){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(1.348551, 103.813059), 10));
        }
        else{
            mMap.setOnMapLoadedCallback(this);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(globalvariable.thelocation.getLatitude(), globalvariable.thelocation.getLongitude()), 18));

        }
    }


    @Override
    public void onMapLoaded() {
        if (mMap != null) {
            CaptureMapScreen();
        }
    }

    public void ReturnButton(View v) {
      //  Log.i("test", "returen");
        super.onBackPressed();


    }

    public void CaptureMapScreen()
    {
        GoogleMap.SnapshotReadyCallback callback = new GoogleMap.SnapshotReadyCallback() {
            Bitmap bitmap;

            @Override
            public void onSnapshotReady(Bitmap snapshot) {
                // TODO Auto-generated method stub
                bitmap = snapshot;
                try {

                    String VisitedPlaceStatusExtraIndex = (getSharedPreferences("VisitedPlaceStatus", MODE_PRIVATE).getString("VisitedPlaceStatusExtraIndex", "0"));
                    int temp = Integer.parseInt(VisitedPlaceStatusExtraIndex) - 1;
                    Log.i("index", String.valueOf(temp));
                    if (temp < 0) {
                        temp = 4;
                    }
                    getSharedPreferences("VisitedPlaceStatus", MODE_PRIVATE).edit().putString("VisitedPlacePictureIndex", String.valueOf(temp)).apply();


                    String INPUT_FOLDER= Environment.getExternalStorageDirectory()+"/"+ "RateThisPlace"+"/ActiveData/";
                    FileOutputStream out = new FileOutputStream(INPUT_FOLDER
                            + "MapScreen"+temp
                            + ".png");

                    // above "/mnt ..... png" => is a storage path (where image will be stored) + name of image you can customize as per your Requirement

                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);

                    startActivity(new Intent(getApplication(), VisitedPlacesActivity.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        mMap.snapshot(callback);

        // myMap is object of GoogleMap +> GoogleMap myMap;
        // which is initialized in onCreate() =>
        // myMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_pass_home_call)).getMap();
    }
}
