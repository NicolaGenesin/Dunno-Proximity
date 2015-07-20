package com.z1911.dunno;

import android.util.Log;

import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.listeners.OnLoginListener;

import java.util.List;

/**
 * Created by nicola on 20/07/2015.
 */
public class OnFacebookLoginListener implements OnLoginListener {
    @Override
    public void onLogin(String s, List<Permission> list, List<Permission> list1) {
        Log.i("Facebook", "Logged in");

    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onException(Throwable throwable) {
        Log.i("Facebook", "exception "+ throwable.getMessage().toString());
    }

    @Override
    public void onFail(String s) {
        Log.i("Facebook", "exception "+ s);

    }
}
