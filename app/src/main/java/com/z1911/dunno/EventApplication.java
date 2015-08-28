package com.z1911.dunno;

import android.app.Application;

import com.z1911.dunno.Activities.MainActivity;
import com.z1911.dunno.Injection.Components.DaggerGenericComponent;
import com.z1911.dunno.Injection.Components.GenericComponent;
import com.z1911.dunno.Injection.Modules.BusModule;
import com.z1911.dunno.Injection.Modules.FacebookModule;

import javax.annotation.Nonnull;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by NicolaWin on 27/08/2015.
 */
public class EventApplication extends Application {
    private static GenericComponent components;

    public static GenericComponent getComponents(@Nonnull MainActivity target) throws Exception {
        if (components == null) {
            if (target instanceof MainActivity) {
                components = DaggerGenericComponent
                        .builder()
                        .facebookModule(new FacebookModule(target))
                        .busModule(new BusModule())
                        .build();
            } else {
                throw new Exception("invalid activity injection instance");
            }
        }
        return components;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setUpFont();
    }

    private void setUpFont() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/bold.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }
}
