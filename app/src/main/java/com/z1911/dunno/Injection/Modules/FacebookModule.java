package com.z1911.dunno.Injection.Modules;

import android.app.Activity;

import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.SimpleFacebookConfiguration;
import com.z1911.dunno.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by NicolaWin on 27/08/2015.
 */
@Module
public class FacebookModule {

    private static Permission[] permissions = new Permission[]{
            Permission.USER_PHOTOS,
            Permission.EMAIL,
            Permission.PUBLISH_ACTION
    };
    private Activity activity;

    public FacebookModule(Activity activity) {
        this.activity = activity;
        setUpFacebook();
    }

    private void setUpFacebook() {

        SimpleFacebookConfiguration configuration = new SimpleFacebookConfiguration.Builder()
                .setAppId(activity.getString(R.string.facebook_app_id))
                .setNamespace(activity.getApplicationContext().getPackageName())
                .setPermissions(permissions)
                .build();

        SimpleFacebook.setConfiguration(configuration);
    }

    @Provides
    @Singleton
    public SimpleFacebook provideFacebookInstance() {
        return SimpleFacebook.getInstance(activity);
    }

}
