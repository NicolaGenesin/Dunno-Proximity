package com.z1911.dunno.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.z1911.dunno.Fragments.BaseFragment;
import com.z1911.dunno.R;

/**
 * Created by nicola on 19/07/2015.
 */
public class FacebookFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.facebook_fragment, container, false);
        return view;
    }

}
