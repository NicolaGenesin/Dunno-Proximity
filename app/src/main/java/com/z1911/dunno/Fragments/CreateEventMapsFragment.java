package com.z1911.dunno.Fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
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
    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps_create_event, container, false);
        ButterKnife.bind(this, view);

        SupportMapFragment mMapFragment = SupportMapFragment.newInstance();
        mMap = mMapFragment.getMap();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.map_container, mMapFragment).commit();

        return view;
    }


    @OnClick(R.id.button_acceptMap)
    public void acceptMapPressEvent() {
        mCommunicationDelegate.changeTo(new ConfirmCreateEventFragment());
    }
}