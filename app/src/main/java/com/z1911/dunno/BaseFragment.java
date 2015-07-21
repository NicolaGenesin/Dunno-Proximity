package com.z1911.dunno;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by nicola on 21/07/2015.
 */
public class BaseFragment extends Fragment{

    //activity data
    ApplicationData mApplicationData;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        getDataFromActivity(activity);
    }

//    @Override
//    public void onResume(){
//        super.onResume();
//    }

    public void getDataFromActivity(Activity activity){
        if (activity instanceof ApplicationDataHolder) {
            mApplicationData = ((ApplicationDataHolder) activity).getApplicationData();
        } else
            throw new IllegalStateException("Activity must implement ApplicationDataHolder interface");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mApplicationData = null;
    }
}
