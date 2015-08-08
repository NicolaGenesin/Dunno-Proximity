package com.z1911.dunno.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.z1911.dunno.Adapters.ImageAdapter;
import com.z1911.dunno.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by nicola on 04/08/2015.
 */
public class PreviewMedalFragment extends BaseFragment {

    @Bind(R.id.gridview_medals)
    GridView mGridMedals;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preview_medal, container, false);
        ButterKnife.bind(this, view);


        mGridMedals.setAdapter(new ImageAdapter(PreviewMedalFragment.this.getActivity()));
        mGridMedals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                mCommunicationDelegate.changeTo(new CreateEventMapsFragment());
            }
        });

        return view;
    }

}