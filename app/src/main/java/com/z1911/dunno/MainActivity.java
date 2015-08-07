package com.z1911.dunno;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.f2prateek.dart.Dart;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.maps.SupportMapFragment;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;
import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.SimpleFacebookConfiguration;
import com.sromku.simple.fb.entities.Event;
import com.sromku.simple.fb.entities.Profile;
import com.sromku.simple.fb.listeners.OnFriendsListener;
import com.z1911.dunno.Fragments.CreateEventFragment;
import com.z1911.dunno.Fragments.FacebookFragment;
import com.z1911.dunno.Fragments.MainPageFragment;
import com.z1911.dunno.Interfaces.ApplicationDataHolder;
import com.z1911.dunno.Interfaces.FacebookHolder;
import com.z1911.dunno.Interfaces.FragmentHolder;
import com.z1911.dunno.Listeners.OnFacebookEventListener;
import com.z1911.dunno.Listeners.OnFacebookFriendsListener;
import com.z1911.dunno.Listeners.OnFacebookLoginListener;
import com.z1911.dunno.Listeners.OnFacebookLogoutListener;
import com.z1911.dunno.Models.ApplicationData;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ApplicationDataHolder, FragmentHolder, FacebookHolder {

    //private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private SimpleFacebook mSimpleFacebook;
    private ApplicationData mApplicationData;
    private Bus mBus;

    public Bus getBus() {
        return mBus;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dart.inject(this);
        ButterKnife.bind(this);

        mApplicationData = new ApplicationData();
        setUpBus(this);
        setUpFacebook();
        setUpFirstFragment();
    }

    private void setUpBus(Context context) {
        mBus = new Bus(ThreadEnforcer.MAIN);
        mBus.register(this);
    }

    public void setUpFirstFragment() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Fragment fragment;
                if (mSimpleFacebook.isLogin()) {
                    fragment = new MainPageFragment();
                } else {
                    fragment = new FacebookFragment();
                }
                MainActivity.this.onChange(fragment);
            }
        }, 2000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mSimpleFacebook.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setUpFacebook() {
        Permission[] permissions = new Permission[]{
                Permission.USER_PHOTOS,
                Permission.EMAIL,
                Permission.PUBLISH_ACTION
        };
        SimpleFacebookConfiguration configuration = new SimpleFacebookConfiguration.Builder()
                .setAppId(getString(R.string.facebook_app_id))
                .setNamespace(getApplicationContext().getPackageName())
                .setPermissions(permissions)
                .build();

        SimpleFacebook.setConfiguration(configuration);
        mSimpleFacebook = GetFacebookInstance();
    }

    public SimpleFacebook GetFacebookInstance() {
        if (mSimpleFacebook == null)
            mSimpleFacebook = SimpleFacebook.getInstance(this);
        return SimpleFacebook.getInstance(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mSimpleFacebook = GetFacebookInstance();
        //setUpMapIfNeeded();
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_DOWN: {
                mSimpleFacebook.logout(new OnFacebookLogoutListener());
                break;
            }
            case KeyEvent.KEYCODE_VOLUME_UP: {
                mSimpleFacebook.login(new OnFacebookLoginListener());
                break;
            }
            default:
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }

    }

    @OnClick(R.id.button_add_event)
    public void createEventPressEvent() {
        this.onChange(new CreateEventFragment());
    }


    @Override
    public ApplicationData getApplicationData() {
        return mApplicationData;
    }

    @Override
    public void onChange(Fragment fragment) {
        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment).addToBackStack(fragment.getClass().toString()).commit();
    }

    @Override
    public void onChange(Fragment fragment, boolean clearFragmentManagerBackStack) {
        if (clearFragmentManagerBackStack) {
            FragmentManager fm = this.getSupportFragmentManager();
            while (fm.getBackStackEntryCount() > 0) {
                fm.popBackStackImmediate();
            }
        }
        onChange(fragment);
    }

    @Override
    public void getFriends(String FragmentName) {
//        final Fragment fragment = getSupportFragmentManager().findFragmentByTag(FragmentName);
//        if (fragment instanceof FriendsSelectorFragment){
//            final FriendsSelectorFragment castedFragment = ((FriendsSelectorFragment)fragment);
//            mSimpleFacebook.getFriends(new OnFriendsListener() {
//                @Override
//                public void onComplete(List<Profile> response) {
//                    super.onComplete(response);
//                    castedFragment.setTestList(response);
//                    castedFragment.getAdapter().notifyDataSetChanged();
//                }
//            });
//        }

//        mSimpleFacebook.getFriends(new OnFriendsListener() {
//            @Override
//            public void onComplete(List<Profile> response) {
//                super.onComplete(response);
//                getBus().post(response);
//            }
//        });

        mSimpleFacebook.getFriends(new OnFacebookFriendsListener(mBus));
    }

    @Override
    public void getEvents() {
        mSimpleFacebook.getEvents(Event.EventDecision.ATTENDING, new OnFacebookEventListener());
    }

    @Override
    public void login() {
        mSimpleFacebook.login(new OnFacebookLoginListener());
    }

    @Override
    public void logout() {
        mSimpleFacebook.logout(new OnFacebookLogoutListener());
    }


    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link()} once when {@link #mMap} is not null.
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
//    private void setUpMapIfNeeded() {
//        // Do a null check to confirm that we have not already instantiated the map.
//        if (mMap == null) {
//            // Try to obtain the map from the SupportMapFragment.
//            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.big_container))
//                    .getMap();
//            // Check if we were successful in obtaining the map.
//            if (mMap != null) {
//                setUpMap();
//            }
//        }
//    }


    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
//    private void setUpMap() {
//        mMap.setMyLocationEnabled(true);
//        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
//
//
//        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
//            @Override
//            public boolean onMyLocationButtonClick() {
//                //todo if it is not enabled, prompt it
//                mMap.addMarker(new MarkerOptions().position(new LatLng(51.509387, 0.000392)).title("Me"));
//                //mMap.addMarker(new MarkerOptions().position(new LatLng(mMap.getMyLocation().getLatitude(), mMap.getMyLocation().getLongitude())).title("Me"));
//                return false;
//            }
//        });
//
//
//        final Handler handler = new Handler();
//
//        final Runnable r = new Runnable() {
//            public void run() {
//
//                if (mMap.getMyLocation() != null) {
//                    LatLng sourceLatLng = new LatLng(mMap.getMyLocation().getLatitude(), mMap.getMyLocation().getLongitude());
//
//                    //move camera
//                    CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(sourceLatLng, 18);
//                    mMap.animateCamera(yourLocation);
//
//                    //set target
//                    RangeLocation targetLocation = new RangeLocation("target", mRadius);
//                    targetLocation.setLatitude(51.519317);
//                    targetLocation.setLongitude(0.000992);
//                    LatLng latlng = new LatLng(targetLocation.getLatitude(), targetLocation.getLongitude());
//
//                    //add markers
//                    mMap.addMarker(new MarkerOptions().position(latlng).title("Target"));
//                    mMap.addCircle(new CircleOptions().center(latlng).radius(mRadius).fillColor(Color.parseColor("#05ff0000")));
//
//                    if (targetLocation.contains(sourceLatLng)) {
//                        Log.wtf("FOUND", "IDDQD");
//                        mMap.addCircle(new CircleOptions().center(latlng).radius(mRadius).fillColor(Color.parseColor("#6600ff00")));
//                    }
//                }
//                new Handler().postDelayed(this, 1000);
//
//            }
//        };
//
//        handler.postDelayed(r, 1000);
//    }


}
