package com.z1911.dunno.Fragments;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.sromku.simple.fb.entities.Profile;
import com.z1911.dunno.Interfaces.IFacebookHolder;
import com.z1911.dunno.R;

import java.util.List;

import butterknife.Bind;

/**
 * Created by nicola on 20/07/2015.
 */
public class FriendsSelectorFragment extends BaseFragment {

    @Bind(R.id.friends_list)
    RecyclerView mRecyclerList;
    private List<Profile> mTestList;
    private ArrayAdapter<Profile> mAdapter;

    public List<Profile> getTestList() {
        return mTestList;
    }

    public void setTestList(List<Profile> mTestList) {
        this.mTestList = mTestList;
    }

    public ArrayAdapter<Profile> getAdapter() {
        return mAdapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_selector, container, false);

        mAdapter = new ArrayAdapter<Profile>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, mTestList);

        if (getActivity() instanceof IFacebookHolder){
            mCommunicationDelegate.getFriends(this.getClass().toString());
        }

        return view;
    }


}
