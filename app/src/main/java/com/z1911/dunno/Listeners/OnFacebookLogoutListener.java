package com.z1911.dunno.Listeners;

import android.util.Log;

import com.squareup.otto.Bus;
import com.sromku.simple.fb.listeners.OnLogoutListener;

/**
 * Created by nicola on 03/08/2015.
 */
public class OnFacebookLogoutListener implements OnLogoutListener {
    Bus bus;

    public OnFacebookLogoutListener(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void onLogout() {
        Log.i("Facebook", "Logged out");
    }
}
