package com.z1911.dunno;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.entities.Profile;
import com.sromku.simple.fb.listeners.OnFriendsListener;

import java.util.List;

/**
 * Created by nicola on 20/07/2015.
 */
public class FriendsSelectorFragment extends Fragment {

    //fragment data
    ListView mListView;
    //activity data
    ApplicationData mApplicationData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friends_selector_fragment, container, false);

        mListView = (ListView)view.findViewById(R.id.friends_list);

        SimpleFacebook.getInstance(getActivity()).getFriends(new OnFriendsListener() {
            @Override
            public void onException(Throwable throwable) {
                super.onException(throwable);
            }

            @Override
            public void onComplete(List<Profile> response) {
                super.onComplete(response);
            }

            @Override
            public void onFail(String reason) {
                super.onFail(reason);
            }
        });

        return view;
    }

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
