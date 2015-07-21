package com.z1911.dunno;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by nicola on 20/07/2015.
 */
public class FriendsSelectorFragment extends BaseFragment {

    //fragment data
    ListView mListView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friends_selector_fragment, container, false);

        mListView = (ListView) view.findViewById(R.id.friends_list);

        return view;
    }


}
