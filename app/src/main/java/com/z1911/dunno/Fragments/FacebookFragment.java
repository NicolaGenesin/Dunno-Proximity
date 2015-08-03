package com.z1911.dunno.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.z1911.dunno.Listeners.OnFacebookLoginListener;
import com.z1911.dunno.MainActivity;
import com.z1911.dunno.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nicola on 19/07/2015.
 */
public class FacebookFragment extends BaseFragment {
    @Bind(R.id.button_facebook_login)
    Button mFacebookButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.facebook_fragment, container, false);
        ButterKnife.bind(this,view);

        mFacebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).GetFacebookInstance().login(new OnFacebookLoginListener());
            }
        });

        return view;
    }

}
