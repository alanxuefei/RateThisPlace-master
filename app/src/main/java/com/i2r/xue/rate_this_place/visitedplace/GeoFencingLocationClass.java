package com.i2r.xue.rate_this_place.visitedplace;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Alan on 17/11/2015.
 */
public class GeoFencingLocationClass {
    String Name;
    LatLng location;
    int Geofence_Radius_In_Meters;

    public GeoFencingLocationClass(String name, LatLng location, int geofence_Radius_In_Meters) {
        Name = name;
        this.location = location;
        Geofence_Radius_In_Meters = geofence_Radius_In_Meters;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public int getGeofence_Radius_In_Meters() {
        return Geofence_Radius_In_Meters;
    }

    public void setGeofence_Radius_In_Meters(int geofence_Radius_In_Meters) {
        Geofence_Radius_In_Meters = geofence_Radius_In_Meters;
    }




}
