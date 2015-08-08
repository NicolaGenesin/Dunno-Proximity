package com.z1911.dunno.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.z1911.dunno.Interfaces.ApplicationDataHolder;
import com.z1911.dunno.Interfaces.FacebookHolder;
import com.z1911.dunno.Interfaces.IFragmentCommunicationManager;
import com.z1911.dunno.MainActivity;

/**
 * Created by nicola on 21/07/2015.
 */
public class BaseFragment extends Fragment {

    protected ApplicationDataHolder mApplicationDataHolder;
    protected IFragmentCommunicationManager mIFragmentCommunicationManager;
    protected FacebookHolder mFacebookHolder;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            ((MainActivity) activity).getBus().register(this);
            mFacebookHolder = (FacebookHolder) activity;
            mIFragmentCommunicationManager = (IFragmentCommunicationManager) activity;
            mApplicationDataHolder = (ApplicationDataHolder) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IFragmentCommunicationManager&&ApplicationDataHolder&&FacebookHolder");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        ((MainActivity) getActivity()).getBus().unregister(this);
        mFacebookHolder = null;
        mIFragmentCommunicationManager = null;
        mApplicationDataHolder = null;
    }

}
