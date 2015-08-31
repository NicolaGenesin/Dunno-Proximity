package com.z1911.dunno.Fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.sromku.simple.fb.entities.Profile;
import com.z1911.dunno.Adapters.FacebookFriendsAdapter;
import com.z1911.dunno.Interfaces.IFacebookHolder;
import com.z1911.dunno.R;

import java.util.List;

import butterknife.Bind;

/**
 * Created by nicola on 20/07/2015.
 */
public class FriendsSelectorFragment extends BaseFragment {

    @Bind(R.id.friends_list)
    RecyclerView mRecyclerView;
    private List<Profile> mTestList;
    private FacebookFriendsAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_selector, container, false);

        setUpReciclerView();

        if (getActivity() instanceof IFacebookHolder){
            mCommunicationDelegate.getFriends();
        }

        addDummyProfiles();

        return view;
    }

    private void addDummyProfiles() {
        mTestList.add(new Profile());
        mTestList.add(new Profile());
        mTestList.add(new Profile());
        mTestList.add(new Profile());
        mTestList.add(new Profile());
        mAdapter.notifyDataSetChanged();
    }

    private void setUpReciclerView(){
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new FacebookFriendsAdapter(getActivity(), mTestList);
        mRecyclerView.setAdapter(mAdapter);
    }


}
