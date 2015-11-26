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
import android.location.Location;
import android.util.Log;

import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.model.LatLng;
import com.i2r.xue.rate_this_place.visitedplace.GeoFencingLocationClass;

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
  /*  public static final String[] Locations = {"I2ROffice", "Pioneer", "Jurong East MRT","Bldg 3, SUTD","8 Somapah Rd","Expo MRT","Dover MRT"};
    public static final double[] Lat = new double[]{1.2993538, 1.337376, 1.333045, 1.340795, 1.340259, 1.334653,1.311317};
    public static final double[] Lng = new double[]{103.787726, 103.697103, 103.742301, 103.963389, 103.963124, 103.961371,103.778656};
    public static final int[] Radius_In_Meters = new int[]{10, 10, 10, 10, 10, 10,10};


    public static final String[] Locations = {     "Location1", "Location2", "Location3", "Location4", "Location5", "Location6", "Location7",     "Location8",      "Location9",     "Location10",    "Location11",         "Location12",       "Location13",       "Location14",       "Location15",       "Location16",       "Location17",     "Location18",      "Location19",     "Location20",        "Location21",       "Location22",       "Location23",       "Location24",       "Location25",       "Location26",       "Location27",           "Location28",      "Location29",     "Location30",      "Location31",       "Location32",       "Location33",       "Location34",       "Location35",       "Location36",       "Location37",     "Location38",      "Location39",     "Location40",        "Location41",       "Location42",       "Location43",       "Location44",       "Location45",       "Location46",       "Location47",     "Location48",      "Location49",     "Location50"};
    public static final double[] Lat = new double[]{1.298592,    1.298930,    1.298935,    1.299387,    1.299845,   1.300020,     1.300721,        1.301135,         1.29893008,      1.2988155,       1.29869471,          1.29853129,          1.29847415,        1.29850642,          1.29847939,        1.29847185,         1.29853772,       1.29865297,        1.29865745,        1.29863448,         1.29865813,          1.29868533,        1.29874431,         1.29873253,          1.2988115,          1.29883677,         1.29882743,            1.29889203,        1.29886434,        1.29920922,        1.29927492,        1.29933575,         1.29947881,         1.29979098,         1.29997515,         1.30010009,         1.29976619,       1.29942224,        1.29932057,       1.29918487,          1.29917792,          1.29879345,        1.29879004,         1.29879011,         1.29877273,          1.29898022,         1.29894178,      1.29892228,        1.29886875,       1.29882307};
    public static final double[] Lng = new double[]{103.787537,  103.786749,  103.786743,  103.785851,  103.785832, 103.785938,   103.786394,     103.786716,        103.78707368,    103.78680956,    103.736561473088,    103.78781409,        103.78773766,      103.78778153,        103.78779475,      103.7877876,        103.78766352,     103.78764426,      103.78762702,      103.78758315,       103.78754022,        103.78757455,      103.78752495,       103.78745335,        103.78737615,       103.78714785,       103.78682199,          103.7867115,       103.78674901,      103.78611396,      103.78603064,      103.78586344,       103.78578308,       103.78583538,       103.78588391,       103.78602559,       103.7858747,       103.78581121,     103.7859571,      103.78624236,        103.78698631,        103.78677287 ,   103.78680185,         103.78683759,       103.78675732,        103.78715604,       103.78709205,   103.78705098,       103.78696876,     103.78690835};
    public static final int[] Radius_In_Meters = new int[]{9999,   20,          20,          9999,       9999,         25,           25,             25,                 25,               25,               25,                   35,                   35,        35,                  35,                35,                 35,               35,                35,                35,                  5,                   35,                 5,                  5,                   5,                  5,              5,                         5,                 5,                 50,                 50,                 50,                  50,                  35,                  5,                  5,                  5,                  5,                  5,              10,                  10,                   100,                 100,             10,                  100,                  100,                  10,                  10,              10,                10};
    */


    public static final String[] Locations = {     "Location1",             "Location2",        "Location3",        "Location4",            "Location5",        "Location6",        "Location7",        "Location8",        "Location9",    "Location10",       "Location11",           "Location12",       "Location13",       "Location14",       "Location15",           "Location16",       "Location17",           "Location18",      "Location19",        "Location20",           "Location21",       "Location22",       "Location23",           "Location24",           "Location25",       "Location26",         "Location27",         "Location28",       "Location29",       "Location30",      "Location31",       "Location32",        "Location33",       "Location34",       "Location35",       "Location36",           "Location37",       "Location38",           "Location39",           "Location40",        "Location41",       "Location42",          "Location43",           "Location44",       "Location45",       "Location46",           "Location47",       "Location48",       "Location49",     "Location50"};
    public static final double[] Lat = new double[]{1.33927496855346,       1.33877132075472,    1.34026427672956,  1.33915805031447,       1.33879830188679,   1.34199624059302,   1.33901823170472,   1.33426,            1.333798,       1.333446,           1.34144245283019,       1.34134352201258,    1.34209,           1.34071396226415,    1.34128056603774,      1.34162232704403,   1.34164031446541,       1.3390051572327,   1.34039918238994,    1.33998547169811,       1.33887924528302,   1.34146044025157,   1.33838459119497,       1.33899616352201,       1.33797088050314,    1.33905012578616,     1.3378,              1.33844754716981,   1.3403272327044,    1.3407679245283,   1.33895119496855,   1.34101974842767,    1.34075893081761,   1.33981459119497,    1.3418741509434,    1.34136150943396,      1.34247672955975,    1.34068698113208,      1.34169427672956,       1.29918487,          1.29917792,          1.29879345,           1.29879004,             1.29879011,         1.29877273,          1.29898022,            1.29894178,         1.29892228,         1.29886875,       1.29882307};
    public static final double[] Lng = new double[]{103.738940269122,       103.739261005666,    103.738191883853,  103.738396798867,       103.740579589235,   103.737710188775,   103.740069661715,   103.742235,         103.742784,     103.742612,         103.73592,              103.736561473088,    103.736748569405,  103.736873300283,    103.737060396601,      103.737194036827,   103.738334433428,       103.738423526912,  103.738441345609,    103.7384948017,         103.738530439093,   103.738717535411,   103.739207549575,       103.739332280453,       103.739599560907,   103.739857932011,      103.740258852691,    103.740410311615,   103.741060694051,   103.741229971671,  103.741541798867,   103.741550708215,    103.741889263456,   103.742103087819,    103.736178371105,   103.736240736544,      103.736285283286,    103.736338739377,      103.73643674221,        103.78624236,        103.78698631,        103.78677287 ,        103.78680185,           103.78683759,       103.78675732,        103.78715604,          103.78709205,       103.78705098,       103.78696876,     103.78690835};
  //  public static final int[] Radius_In_Meters = new int[]{30,              30,                  30,                 30,                    30,                 30,                 30,                 30,                 30,             30,                 30,                     30,                  30,                30,                  30,                    30,            30,                     30,                30,                  30,                     30,                 30,                 30,                     30,                     30,                 30,                     30,                 30,                 30,                 30,                30,                 30,                  30,                 30,                  30,                  30,                   30,                  30,                    30,                     30,                  30,                  30,                   30,                     30,                 30,                  30,                    30,                 30,                 30,               30};
  // public static final int[] Radius_In_Meters = new int[]{50,              50,                  50,                50,                     50,                 50,                 50,                 50,                 50,             50,                 50,                     50,                  50,                50,                  50,                    50,                 50,                     50,                50,                  50,                     50,                 50,                 50,                     50,                     50,                 50,                     50,                 50,                 50,                 50,                50,                 50,                  50,                 50,                  50,                  50,                   50,                  50,                    50,                     50,                  50,                  50,                   50,                     50,                 50,                  50,                    50,                 50,                 50,               50};
   public static final int[] Radius_In_Meters = new int[]{100,              100,                  100,                100,                     100,                 100,                 100,                 100,                 100,             100,                 100,                     100,                  100,                100,                  100,                    100,                 100,                     100,                100,                  100,                     100,                 100,                 100,                     100,                     100,                 100,                     100,                 100,                 100,                 100,                100,                 100,                  100,                 100,                  100,                  100,                   100,                  100,                    100,                     100,                  100,                  100,                   100,                     100,                 100,                  100,                    100,                 100,                 100,               100};
 // public static final int[] Radius_In_Meters = new int[]{200,              200,                  200,                200,                     200,                 200,                 200,                 200,                 200,             200,                 200,                     200,                  200,                200,                  200,                    200,                 200,                     200,                200,                  200,                     200,                 200,                 200,                     200,                     200,                 200,                     200,                 200,                 200,                 200,                200,                 200,                  200,                 200,                  200,                  200,                   200,                  200,                    200,                     200,                  200,                  200,                   200,                     200,                 200,                  200,                    200,                 200,                 200,               200};

    public static final GeoFencingLocationClass[] AREA_LANDMARKS = new GeoFencingLocationClass[Locations.length];
    static {  // must be here
        for(int i=0; i<Locations.length; i++){
            AREA_LANDMARKS[i]=new GeoFencingLocationClass(Locations[i],new LatLng(Lat[i], Lng[i]),Radius_In_Meters[i]);
            Log.i("maplocation",AREA_LANDMARKS[i].getLocation().latitude+" "+AREA_LANDMARKS[i].getLocation().longitude);
        }

    }

    public static final Location mainpoint1 = new Location("mainpoint1");
    public static final int mainpointradius1 =200;

    public static final Location mainpoint2 = new Location("mainpoint2");
    public static final int mainpointradius2 =236;

    public static final Location mainpoint3 = new Location("mainpoint3");
    public static final int mainpointradius3 =120;

    public static final Location mainpoint4 = new Location("mainpoint4");
    public static final int mainpointradius4 =214;

    public static final Location mainpoint5 = new Location("mainpoint5");
    public static final int mainpointradius5 =215;

    public static final Location mainpoint6 = new Location("mainpoint6");
    public static final int mainpointradius6 =9000;

    static {
        mainpoint1.setLatitude(1.341020);
        mainpoint1.setLongitude(103.736863);

        mainpoint2.setLatitude(1.339771);
        mainpoint2.setLongitude(103.740032);

        mainpoint3.setLatitude(1.340538);
        mainpoint3.setLongitude(103.742051);

        mainpoint4.setLatitude(1.333977);
        mainpoint4.setLongitude(103.742279);

        mainpoint5.setLatitude(1.332799);
        mainpoint5.setLongitude(103.743471);

        mainpoint6.setLatitude(1.299169);
        mainpoint6.setLongitude(103.786926);
    }
}
