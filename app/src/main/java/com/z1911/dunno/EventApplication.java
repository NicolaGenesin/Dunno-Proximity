package com.z1911.dunno;

import android.app.Application;

import com.z1911.dunno.Activities.MainActivity;
import com.z1911.dunno.Injection.Components.DaggerGenericComponent;
import com.z1911.dunno.Injection.Components.GenericComponent;
import com.z1911.dunno.Injection.Modules.BusModule;
import com.z1911.dunno.Injection.Modules.FacebookModule;

import javax.annotation.Nonnull;

/**
 * Created by NicolaWin on 27/08/2015.
 */
public class EventApplication extends Application {
    private static GenericComponent facebookClientComponent;

    public static GenericComponent getFacebookClientComponent(@Nonnull MainActivity target) throws Exception {
        if (facebookClientComponent == null) {
            if (target instanceof MainActivity) {
                facebookClientComponent = DaggerGenericComponent
                        .builder()
                        .facebookModule(new FacebookModule(target))
                        .busModule(new BusModule())
                        .build();
            } else {
                throw new Exception("invalid activity injection instance");
            }
        }
        return facebookClientComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
