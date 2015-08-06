package com.z1911.dunno.Listeners;

import android.util.Log;

import com.sromku.simple.fb.entities.Event;
import com.sromku.simple.fb.listeners.OnEventsListener;

import java.util.List;

/**
 * Created by nicola on 06/08/2015.
 */
public class OnFacebookEventListener extends OnEventsListener {
    @Override
    public void onComplete(List<Event> events) {
        Log.i("Facebook", "Number of events = " + events.size());
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
