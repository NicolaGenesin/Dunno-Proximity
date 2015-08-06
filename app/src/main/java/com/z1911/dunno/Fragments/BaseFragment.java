package com.z1911.dunno.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.z1911.dunno.Interfaces.ApplicationDataHolder;
import com.z1911.dunno.Interfaces.FacebookHolder;
import com.z1911.dunno.Interfaces.FragmentHolder;
import com.z1911.dunno.Models.ApplicationData;

/**
 * Created by nicola on 21/07/2015.
 */
public class BaseFragment extends Fragment {

    protected ApplicationDataHolder mApplicationDataHolder;
    protected FragmentHolder mFragmentHolder;
    protected FacebookHolder mFacebookHolder;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mFacebookHolder = (FacebookHolder) activity;
            mFragmentHolder = (FragmentHolder) activity;
            mApplicationDataHolder = (ApplicationDataHolder) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement FragmentHolder&&ApplicationDataHolder&&FacebookHolder");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mFacebookHolder = null;
        mFragmentHolder = null;
        mApplicationDataHolder = null;
    }

}
