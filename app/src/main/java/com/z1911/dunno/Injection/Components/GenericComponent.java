package com.z1911.dunno.Injection.Components;

import com.z1911.dunno.Activities.MainActivity;
import com.z1911.dunno.Injection.Modules.BusModule;
import com.z1911.dunno.Injection.Modules.FacebookModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Nicola Genesin on 27/08/2015.
 * Copyright (C) 2015 1911.
 */
@Singleton
@Component(modules = {FacebookModule.class,BusModule.class})
public interface GenericComponent {
    void inject(MainActivity activity);
}
