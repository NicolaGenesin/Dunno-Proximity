package com.z1911.dunno.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.z1911.dunno.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by nicola on 19/07/2015.
 */
public class FacebookFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_facebook, container, false);
        ButterKnife.bind(this,view);

        return view;
    }

    @OnClick(R.id.button_facebook_login)
    public void doFacebookLogin(){
        mIFacebookHolder.login();
    }
}
