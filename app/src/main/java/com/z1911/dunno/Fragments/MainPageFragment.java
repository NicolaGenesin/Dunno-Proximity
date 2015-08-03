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
 * Created by nicola on 03/08/2015.
 */
public class MainPageFragment extends BaseFragment {
    @Bind(R.id.button_searchEvent)
    Button mButtonSearch;
    @Bind(R.id.button_createEvent)
    Button mButtonCreate;
    @Bind(R.id.button_collection)
    Button mButtonCollection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_page, container, false);
        ButterKnife.bind(this,view);

        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(R.id.container,new SearchEventFragment());
            }
        });

        mButtonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(R.id.container,new CreateEventFragment());
            }
        });

        mButtonCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(R.id.container,new CollectionFragment());
            }
        });

        return view;
    }
}
