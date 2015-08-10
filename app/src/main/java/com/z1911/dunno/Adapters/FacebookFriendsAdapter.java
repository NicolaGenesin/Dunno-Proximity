package com.z1911.dunno.Adapters;

import android.content.Context;
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


/**
 * Created by nicola on 27/07/2015.
 */
public class FacebookFriendsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Profile> itemsData;
    private Context context;

    public FacebookFriendsAdapter (Context context, List<Profile> itemsData) {
        this.context = context;
        this.itemsData = itemsData;
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

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        if (position > 0) {
            ViewHolder view = (ViewHolder) viewHolder;

            view.textName.setText(itemsData.get(position).getName());

//            Picasso.with(context).
//                    load(itemsData.get(position).getPicture()).
//                    transform(new ImageBlurTransformation()).
//                    into(view.blurredBackgroundImage);

            Picasso.with(context).
                    load(itemsData.get(position).getPicture()).
                    transform(new ImageCircleCropTransformation()).
                    into(view.backgroundImage);
        }

    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemsData.size();
    }


    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textName;
        public ImageView backgroundImage;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            textName = (TextView) itemLayoutView.findViewById(R.id.text_friendName);
            backgroundImage = (ImageView) itemLayoutView.findViewById(R.id.image_friendPicture);
        }
    }

}
