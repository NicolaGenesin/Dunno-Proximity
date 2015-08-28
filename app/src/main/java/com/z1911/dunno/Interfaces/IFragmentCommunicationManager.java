package com.z1911.dunno.Interfaces;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Nicola Genesin on 06/08/2015.
 * Copyright (C) 2015 1911.
 */
public interface IFragmentCommunicationManager {
    void checkRestoreFab();

    void changeTo(Fragment fragment);

    void changeTo(Fragment fragment, boolean clearFragmentManagerBackStack);

    void showSnackBar(String bodyText, String buttonText, int time, View.OnClickListener listener);

    void hideKeyboard();

    void showDatePicker();

    void showTimePicker();
}
