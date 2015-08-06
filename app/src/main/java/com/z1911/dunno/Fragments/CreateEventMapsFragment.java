package com.z1911.dunno.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.z1911.dunno.Interfaces.FragmentListener;
import com.z1911.dunno.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by nicola on 04/08/2015.
 */
public class CreateEventMapsFragment extends BaseFragment {

    @Bind(R.id.button_acceptMap)
    Button mButtonAcceptMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps_create_event, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.button_acceptMap)
    public void acceptMapPressEvent() {
        ((FragmentListener) getActivity()).onChange(new ConfirmCreateEventFragment());
    }
}