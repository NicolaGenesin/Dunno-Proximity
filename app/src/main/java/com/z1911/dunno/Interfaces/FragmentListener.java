package com.z1911.dunno.Interfaces;

import android.support.v4.app.Fragment;

/**
 * Created by nicola on 06/08/2015.
 */
public interface FragmentListener {
    void onChange(Fragment fragment);

    void clearFragmentManagerBackStack();
}
