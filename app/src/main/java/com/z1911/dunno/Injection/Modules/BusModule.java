package com.z1911.dunno.Injection.Modules;


import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Nicola Genesin on 27/08/2015.
 * Copyright (C) 2015 1911.
 */
@Module
public class BusModule {
    private Bus mBus;

    public BusModule(){
        mBus = new Bus(ThreadEnforcer.MAIN);
    }

    @Provides
    @Singleton
    public Bus provideBusInstance() {
        return mBus;
    }
}
