package com.i2r.xue.rate_this_place.utility;

import android.location.Location;

/**
 * Created by Alan on 16/9/2015.
 */
public class globalvariable {
    public static void setThelocation(Location thelocation) {
        globalvariable.thelocation = thelocation;
    }

    public static Location thelocation;
    public int myrewards;
    public static boolean isRating_rated;
    public static boolean isActivity_rated;
    public static boolean isIncremented;
}
