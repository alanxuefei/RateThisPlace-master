/**
 * Copyright 2014 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.i2r.xue.rate_this_place.utility;

import android.content.Context;
import android.content.res.Resources;

import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

/**
 * Constants used in this sample.
 */
public final class Constants {

    private Constants() {
    }

    public static final String PACKAGE_NAME = "com.i2r.alan.rate_this_place";

    public static final String BROADCAST_ACTION = PACKAGE_NAME + ".BROADCAST_ACTION";

    public static final String ACTIVITY_EXTRA = PACKAGE_NAME + ".ACTIVITY_EXTRA";

    public static final String SHARED_PREFERENCES_NAME = PACKAGE_NAME + ".SHARED_PREFERENCES";

    public static final String ACTIVITY_UPDATES_REQUESTED_KEY = PACKAGE_NAME +
            ".ACTIVITY_UPDATES_REQUESTED";

    public static final String DETECTED_ACTIVITIES = PACKAGE_NAME + ".DETECTED_ACTIVITIES";

    /**
     * The desired time between activity detections. Larger values result in fewer activity
     * detections while improving battery life. A value of 0 results in activity detections at the
     * fastest possible rate. Getting frequent updates negatively impact battery life and a real
     * app may prefer to request less frequent updates.
     */
    public static final long DETECTION_INTERVAL_IN_MILLISECONDS = 0;

    /**
     * List of DetectedActivity types that we monitor in this sample.
     */
    protected static final int[] MONITORED_ACTIVITIES = {
            DetectedActivity.STILL,
            DetectedActivity.ON_FOOT,
            DetectedActivity.WALKING,
            DetectedActivity.RUNNING,
            DetectedActivity.ON_BICYCLE,
            DetectedActivity.IN_VEHICLE,
            DetectedActivity.TILTING,
            DetectedActivity.UNKNOWN
    };

    /**
     * Returns a human readable String corresponding to a detected activity type.
     */
    public static String getActivityString(Context context, int detectedActivityType) {
        Resources resources = context.getResources();
        switch(detectedActivityType) {
            case DetectedActivity.IN_VEHICLE:
                return resources.getString(com.i2r.xue.rate_this_place.R.string.in_vehicle);
            case DetectedActivity.ON_BICYCLE:
                return resources.getString(com.i2r.xue.rate_this_place.R.string.on_bicycle);
            case DetectedActivity.ON_FOOT:
                return resources.getString(com.i2r.xue.rate_this_place.R.string.on_foot);
            case DetectedActivity.RUNNING:
                return resources.getString(com.i2r.xue.rate_this_place.R.string.running);
            case DetectedActivity.STILL:
                return resources.getString(com.i2r.xue.rate_this_place.R.string.still);
            case DetectedActivity.TILTING:
                return resources.getString(com.i2r.xue.rate_this_place.R.string.tilting);
            case DetectedActivity.UNKNOWN:
                return resources.getString(com.i2r.xue.rate_this_place.R.string.unknown);
            case DetectedActivity.WALKING:
                return resources.getString(com.i2r.xue.rate_this_place.R.string.walking);
            default:
                return resources.getString(com.i2r.xue.rate_this_place.R.string.unidentifiable_activity, detectedActivityType);
        }
    }


    /*location*/
    public static final int SUCCESS_RESULT = 0;
    public static final int FAILURE_RESULT = 1;

    public static final String RECEIVER = PACKAGE_NAME + ".RECEIVER";
    public static final String RESULT_DATA_KEY = PACKAGE_NAME +
            ".RESULT_DATA_KEY";
    public static final String LOCATION_DATA_EXTRA = PACKAGE_NAME +
            ".LOCATION_DATA_EXTRA";

    public static final String GEOFENCES_ADDED_KEY = PACKAGE_NAME + ".GEOFENCES_ADDED_KEY";

    /**
     * Used to set an expiration time for a geofence. After this amount of time Location Services
     * stops tracking the geofence.
     */
    public static final long GEOFENCE_EXPIRATION_IN_HOURS = 12;

    /**
     * For this sample, geofences expire after twelve hours.
     */
    public static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS =
            GEOFENCE_EXPIRATION_IN_HOURS * 60 * 60 * 1000;
   // public static final float GEOFENCE_RADIUS_IN_METERS = 1609/2; // 1 mile, 1.6 km
    public static final float GEOFENCE_RADIUS_IN_METERS = 100; // 1 mile, 1.6 km
    /**
     * Map for storing information about airports in the San Francisco bay area.
     */
    public static final String[] Locations = {"I2ROffice", "Pioneer", "Jurong East MRT","Bldg 3, SUTD","8 Somapah Rd","Expo MRT"};
    //public static final double[] Lat = new double[]{1.2993538, 1.337399, 1.307739, 1.334625, 1.340171, 1.335703};
    //public static final double[] Lng = new double[]{103.787726, 103.697090, 103.789675, 103.741915, 103.963100, 103.696774};
    public static final double[] Lat = new double[]{1.2993538, 1.337376, 1.333045, 1.340795, 1.340259, 1.334653};
    public static final double[] Lng = new double[]{103.787726, 103.697103, 103.742301, 103.963389, 103.963124, 103.961371};
    public static final HashMap<String, LatLng> AREA_LANDMARKS = new HashMap<String, LatLng>();
    static {
        for(int i=0; i<Locations.length; i++){
            AREA_LANDMARKS.put(Locations[i], new LatLng(Lat[i], Lng[i]));
        }
    }
}
