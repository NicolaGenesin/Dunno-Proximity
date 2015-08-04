package com.z1911.dunno.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.z1911.dunno.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nicola on 04/08/2015.
 */
public class PreviewMedalFragment extends BaseFragment {

    @Bind(R.id.button_acceptMedal)
    Button mButtonMedal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preview_medal, container, false);
        ButterKnife.bind(this, view);

        mButtonMedal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(R.id.container, new CreateEventMapsPage());
            }
        });

        return view;
    }
}