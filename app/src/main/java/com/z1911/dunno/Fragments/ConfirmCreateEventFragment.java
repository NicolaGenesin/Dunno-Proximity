package com.z1911.dunno.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.z1911.dunno.Interfaces.FragmentListener;
import com.z1911.dunno.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nicola on 04/08/2015.
 */
public class ConfirmCreateEventFragment extends BaseFragment {
    @Bind(R.id.button_create_event_confirmation)
    Button mButtonEventConfirmation;
    FragmentListener activityListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_confirm_create_event, container, false);
        ButterKnife.bind(this, view);

        mButtonEventConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityListener = ((FragmentListener) getActivity());
                activityListener.clearFragmentManagerBackStack();
                activityListener.onChange(new MainPageFragment());

                Toast.makeText(v.getContext(), "EVENT CREATED", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activityListener = null;
    }

}

