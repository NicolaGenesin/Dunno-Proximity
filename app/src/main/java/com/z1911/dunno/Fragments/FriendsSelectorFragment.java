package com.z1911.dunno.Fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.sromku.simple.fb.entities.Profile;
import com.z1911.dunno.Adapters.FacebookFriendsAdapter;
import com.z1911.dunno.Interfaces.IFacebookHolder;
import com.z1911.dunno.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by nicola on 20/07/2015.
 */
public class FriendsSelectorFragment extends BaseFragment {

    @Bind(R.id.friends_list)
    RecyclerView mRecyclerView;
    @Bind(R.id.button_select_everyone)
    Button mButtonSelectEveryone;

    private List<Profile> mTestList;
    private FacebookFriendsAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_selector, container, false);
        ButterKnife.bind(this, view);

        addDummyProfiles();
        setUpRecyclerView();

        if (getActivity() instanceof IFacebookHolder){
            mCommunicationDelegate.getFriends();
        }

        return view;
    }

    private void addDummyProfiles() {
        mTestList = new ArrayList<>();
        for (int i=0;i<1000;i++) mTestList.add(new Profile());
    }

    private void setUpRecyclerView(){
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new FacebookFriendsAdapter(getActivity(), mTestList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnClick(R.id.button_select_everyone)
    public void onButtonClick(){
        mAdapter.select();
    }


}
