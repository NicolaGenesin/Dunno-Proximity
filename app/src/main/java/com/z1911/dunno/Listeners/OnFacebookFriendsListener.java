package com.z1911.dunno.Listeners;

import android.util.Log;

import com.squareup.otto.Bus;
import com.sromku.simple.fb.entities.Profile;
import com.sromku.simple.fb.listeners.OnFriendsListener;

import java.util.List;

/**
 * Created by nicola on 06/08/2015.
 */
public class OnFacebookFriendsListener extends OnFriendsListener {
    Bus bus;

    public OnFacebookFriendsListener(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void onComplete(List<Profile> response) {
        super.onComplete(response);
        response.add(new Profile());
        response.add(new Profile());
        response.add(new Profile());
        response.add(new Profile());
        response.add(new Profile());
        bus.post(response);
        Log.i("Facebook", "Number of friends = " + response.size());
    }

    @Override
    public void onException(Throwable throwable) {
        Log.i("Facebook", "exception " + throwable.getMessage().toString());
    }

    @Override
    public void onFail(String s) {
        Log.i("Facebook", "exception " + s);

    }
}
