package com.z1911.dunno.Util;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Nicola Genesin on 08/08/2015.
 * Copyright (C) 2015 1911.
 */
public class Ui {
    public static void hideKeyboard(View view, InputMethodManager manager) {
        if (view != null) {
            manager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
