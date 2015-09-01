package com.z1911.dunno.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.sromku.simple.fb.entities.Profile;
import com.z1911.dunno.R;
import com.z1911.dunno.Transformations.ImageCircleCropTransformation;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Nicola Genesin on 27/07/2015.
 * Copyright (C) 2015 1911.
 */
public class FacebookFriendsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ISelector {
    private final boolean[] selectionMap;
    private List<Profile> itemsData;
    private Context context;

    public FacebookFriendsAdapter(Context context, List<Profile> itemsData) {
        this.context = context;
        this.itemsData = itemsData;
        this.selectionMap = new boolean[itemsData.size()];
    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        if (position == 0)
            return 0;
        return 1;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {

        if (viewType == 0) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_row, parent, false));
        }

        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_friend, null);

        ButterKnife.bind(itemLayoutView);

        // create ViewHolder
        return new ViewHolder(itemLayoutView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        if (position > 0) {
            ViewHolder view = (ViewHolder) viewHolder;

            view.row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!selectionMap[position]) {
                        v.setBackgroundColor(Color.parseColor("#999999"));
                        selectionMap[position] = true;
                    } else {
                        v.setBackgroundResource(0);
                        selectionMap[position] = false;
                    }
                }
            });

            if (selectionMap[position]) {
                view.row.setBackgroundColor(Color.parseColor("#999999"));
            } else {
                view.row.setBackgroundResource(0);
            }

            view.textName.setText(itemsData.get(position).getName());
            view.textName.setText("John Germano");

            //todo remove invalidation
            Picasso.with(context).invalidate("http://lorempixel.com/400/200/");
            Picasso.with(context).
                    //load(itemsData.get(position).getPicture()).
                            load("http://lorempixel.com/400/200/").
                    transform(new ImageCircleCropTransformation()).
                    into(view.backgroundImage);
        }
    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemsData.size();
    }

    @Override
    public void select() {
        //if there is at least one element that is false, select everything
        for (int i = 0; i < selectionMap.length; i++) {
            if (!selectionMap[i]){
                changeOverallSelections(true);
                return;
            }
        }
        //otherwise, un-select everything
        changeOverallSelections(false);
    }

    private void changeOverallSelections(boolean bool) {
        for (int i = 0; i < selectionMap.length; i++) {
            selectionMap[i] = bool;
        }
        this.notifyDataSetChanged();
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder  {

        @Bind(R.id.row_container)
        public View row;
        @Bind(R.id.text_friendName)
        public TextView textName;
        @Bind(R.id.image_friendPicture)
        public ImageView backgroundImage;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
        }
    }

}
