package com.z1911.dunno.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.z1911.dunno.Interfaces.ApplicationDataHolder;
import com.z1911.dunno.Models.ApplicationData;

/**
 * Created by nicola on 21/07/2015.
 */
public class BaseFragment extends Fragment {

    protected ApplicationData mApplicationData;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        getDataFromActivity(activity);
    }

    public void getDataFromActivity(Activity activity) {
        if (activity instanceof ApplicationDataHolder) {
            mApplicationData = ((ApplicationDataHolder) activity).getApplicationData();
        } else
            throw new IllegalStateException("Activity must implement ApplicationDataHolder interface");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mApplicationData = null;
    }

}
