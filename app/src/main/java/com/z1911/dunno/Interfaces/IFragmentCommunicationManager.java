package com.z1911.dunno.Interfaces;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by nicola on 06/08/2015.
 */
public interface IFragmentCommunicationManager {
    void checkRestoreFab();
    void changeTo(Fragment fragment);
    void changeTo(Fragment fragment, boolean clearFragmentManagerBackStack);
    void showSnackBar(String bodyText, String buttonText, int time, View.OnClickListener listener);
    void hideKeyboard();
}
