package com.i2r.xue.rate_this_place.utility;

import android.content.Context;
import android.content.Intent;

import com.i2r.xue.rate_this_place.pasivedatacollection.SensorListenerService;
import com.i2r.xue.rate_this_place.visitedplace.GeofencingService;

/**
 * Created by Alan on 25/9/2015.
 */
public class Commonfunctions {

    public static void startPassiveDataCollection(Context context) {
        Intent startServiceIntent = new Intent(context, SensorListenerService.class);
        context.startService(startServiceIntent);
        context.startService(new Intent(context, GeofencingService.class));
    }
}



