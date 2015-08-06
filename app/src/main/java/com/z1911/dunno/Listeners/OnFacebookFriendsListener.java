package com.z1911.dunno.Listeners;

import android.util.Log;

import com.sromku.simple.fb.entities.Profile;
import com.sromku.simple.fb.listeners.OnFriendsListener;

import java.util.List;

/**
 * Created by nicola on 06/08/2015.
 */
public class OnFacebookFriendsListener extends OnFriendsListener {

    public OnFacebookFriendsListener(){

    }

    @Override
    public void onComplete(List<Profile> friends) {
        Log.i("Facebook", "Number of friends = " + friends.size());
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
