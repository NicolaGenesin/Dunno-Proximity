package com.z1911.dunno.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.z1911.dunno.R;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by nicola on 03/08/2015.
 */
public class CreateEventDescriptionFragment extends BaseFragment {
    @Bind(R.id.text_eventName)
    EditText mTextEventName;
    @Bind(R.id.text_eventDate)
    EditText mTextEventDate;
    @Bind(R.id.text_eventType)
    EditText mTextEventType;
    @Bind(R.id.label_eventDate)
    android.support.design.widget.TextInputLayout mLabelEventDate;
    @Bind(R.id.button_createEventMedal)
    Button mButtonEventMedal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_description_event, container, false);
        ButterKnife.bind(this, view);

        mTextEventDate.setText(Calendar.getInstance().getTime().toString());

        return view;
    }

    @OnClick(R.id.text_eventDate)
    public void setDate() {
        mCommunicationDelegate.showDatePicker();
    }

    @OnClick(R.id.label_eventDate)
    public void setDate2() {
        //todo remove
        mCommunicationDelegate.showDatePicker();
    }

    @OnClick(R.id.button_createEventMedal)
    public void createMedalPressEvent() {
        String name = mTextEventName.getText().toString();
        String type = mTextEventType.getText().toString();
        String date = mTextEventDate.getText().toString();

        //if (!name.isEmpty() && !type.isEmpty() && !date.isEmpty()) {
        if (true) {
            mCommunicationDelegate.changeTo(new PreviewMedalFragment());
        }

        mCommunicationDelegate.hideKeyboard();
    }
}
