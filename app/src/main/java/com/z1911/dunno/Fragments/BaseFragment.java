package com.z1911.dunno.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.z1911.dunno.Interfaces.ICommunication;
import com.z1911.dunno.Activities.MainActivity;

/**
 * Created by Nicola Genesin on 21/07/2015.
 * Copyright (C) 2015 1911.
 */
public class BaseFragment extends Fragment {

    protected ICommunication mCommunicationDelegate;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            ((MainActivity) activity).getBus().register(this);
            mCommunicationDelegate = (ICommunication) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement ICommunication");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        ((MainActivity) getActivity()).getBus().unregister(this);
        mCommunicationDelegate = null;
    }

}
