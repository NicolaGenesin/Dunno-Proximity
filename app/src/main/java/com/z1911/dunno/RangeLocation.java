package com.z1911.dunno;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by nicola on 15/07/2015.
 */
public class RangeLocation extends Location {

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private double radius; //segment (meters) that has lat/long as origin

    public RangeLocation(String provider, double radius) {
        super(provider);
        this.radius = radius;
    }


    public boolean contains(LatLng position) {
        LatLng center = new LatLng(this.getLatitude(), this.getLongitude());
        double radius = getRadius();
        float distance = distanceBetween(position, center);
        return distance < radius;
    }

    public float distanceBetween(LatLng first, LatLng second) {
        float[] distance = new float[1];
        Location.distanceBetween(first.latitude, first.longitude, second.latitude, second.longitude, distance);
        return distance[0];
    }
}