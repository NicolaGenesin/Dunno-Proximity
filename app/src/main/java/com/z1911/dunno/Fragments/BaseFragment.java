package com.z1911.dunno.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.z1911.dunno.Interfaces.IApplicationDataHolder;
import com.z1911.dunno.Interfaces.IFacebookHolder;
import com.z1911.dunno.Interfaces.IFragmentCommunicationManager;
import com.z1911.dunno.MainActivity;

/**
 * Created by nicola on 21/07/2015.
 */
public class BaseFragment extends Fragment {

    protected IApplicationDataHolder mIApplicationDataHolder;
    protected IFragmentCommunicationManager mIFragmentCommunicationManager;
    protected IFacebookHolder mIFacebookHolder;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            ((MainActivity) activity).getBus().register(this);
            mIFacebookHolder = (IFacebookHolder) activity;
            mIFragmentCommunicationManager = (IFragmentCommunicationManager) activity;
            mIApplicationDataHolder = (IApplicationDataHolder) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IFragmentCommunicationManager&&IApplicationDataHolder&&IFacebookHolder");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        ((MainActivity) getActivity()).getBus().unregister(this);
        mIFacebookHolder = null;
        mIFragmentCommunicationManager = null;
        mIApplicationDataHolder = null;
    }

}
