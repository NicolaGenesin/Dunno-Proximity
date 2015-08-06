package com.z1911.dunno.Listeners;

import android.util.Log;

import com.sromku.simple.fb.listeners.OnLogoutListener;

/**
 * Created by nicola on 03/08/2015.
 */
public class OnFacebookLogoutListener implements OnLogoutListener {
    @Override
    public void onLogout() {
        Log.i("Facebook", "Logged out");
    }
}
