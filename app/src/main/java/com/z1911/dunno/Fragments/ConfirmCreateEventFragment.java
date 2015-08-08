package com.z1911.dunno.Fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.z1911.dunno.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by nicola on 04/08/2015.
 */
public class ConfirmCreateEventFragment extends BaseFragment {
    @Bind(R.id.button_create_event_confirmation)
    Button mButtonEventConfirmation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_confirm_create_event, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.button_create_event_confirmation)
    public void createEventPressEvent() {

        mIFragmentCommunicationManager.showSnackBar("The event has been created successfully", "Ok", Snackbar.LENGTH_LONG, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        mIFragmentCommunicationManager.changeTo(new MainPageFragment(), true);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}

