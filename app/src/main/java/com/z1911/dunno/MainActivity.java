package com.z1911.dunno;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {

    int mRadius = 10;
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
        mMap.setMyLocationEnabled(true);
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));


        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {
                //todo if it is not enabled, prompt it
                mMap.addMarker(new MarkerOptions().position(new LatLng(51.509387, 0.000392)).title("Me"));
                //mMap.addMarker(new MarkerOptions().position(new LatLng(mMap.getMyLocation().getLatitude(), mMap.getMyLocation().getLongitude())).title("Me"));
                return false;
            }
        });


        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {

                if (mMap.getMyLocation() != null) {
                    LatLng sourceLatLng = new LatLng(mMap.getMyLocation().getLatitude(), mMap.getMyLocation().getLongitude());

                    //move camera
                    CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(sourceLatLng, 18);
                    mMap.animateCamera(yourLocation);

                    //set target
                    RangeLocation targetLocation = new RangeLocation("target", mRadius);
                    targetLocation.setLatitude(51.519317);
                    targetLocation.setLongitude(0.000992);
                    LatLng latlng = new LatLng(targetLocation.getLatitude(), targetLocation.getLongitude());

                    //add markers
                    mMap.addMarker(new MarkerOptions().position(latlng).title("Target"));
                    mMap.addCircle(new CircleOptions().center(latlng).radius(mRadius).fillColor(Color.parseColor("#05ff0000")));

                    if (targetLocation.contains(sourceLatLng)) {
                        Log.wtf("FOUND", "IDDQD");
                        mMap.addCircle(new CircleOptions().center(latlng).radius(mRadius).fillColor(Color.parseColor("#6600ff00")));
                    }
                }
                new Handler().postDelayed(this, 1000);

            }
        };

        handler.postDelayed(r, 1000);
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP: {
                mRadius += 10;
                break;
            }
            case KeyEvent.KEYCODE_VOLUME_DOWN: {
                mRadius -= 10;
                break;
            }
            default:
        }
        return true;
    }


}
