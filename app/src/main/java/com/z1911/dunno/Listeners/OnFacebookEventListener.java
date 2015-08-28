package com.z1911.dunno.Listeners;

import android.util.Log;

import com.squareup.otto.Bus;
import com.sromku.simple.fb.entities.Event;
import com.sromku.simple.fb.listeners.OnEventsListener;

import java.util.List;

/**
 * Created by Nicola Genesin on 06/08/2015.
 * Copyright (C) 2015 1911.
 */
public class OnFacebookEventListener extends OnEventsListener {
    Bus bus;

    public OnFacebookEventListener(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void onComplete(List<Event> events) {
        super.onComplete(events);
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
