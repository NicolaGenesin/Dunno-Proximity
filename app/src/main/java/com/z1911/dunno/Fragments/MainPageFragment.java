package com.z1911.dunno.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;
import com.sromku.simple.fb.entities.Profile;
import com.z1911.dunno.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by nicola on 03/08/2015.
 */
public class MainPageFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_page, container, false);
        ButterKnife.bind(this, view);

        //checks if we need to restore the fab
        mCommunicationDelegate.checkRestoreFab();

        return view;
    }

    @Subscribe
    public void getMessage(ArrayList<Profile> profiles) {
    }

    @OnClick(R.id.button_searchEvent)
    public void searchPressEvent() {
        mCommunicationDelegate.changeTo(new SearchEventFragment());
    }

    @OnClick(R.id.button_collection)
    public void collectPressEvent() {
        mCommunicationDelegate.changeTo(new CollectionFragment());
    }

}
