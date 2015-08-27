package com.z1911.dunno.Injection.Modules;


import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by NicolaWin on 27/08/2015.
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
