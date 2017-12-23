package com.example.walkzhoushan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Mason on 2017/12/19.
 */

public class TravelNoteAdapter extends RecyclerView.Adapter<TravelNoteAdapter.ViewHolder>{
    private static final String TAG = "TravelNoteAdapter";

    private Context mContext;

    private List<TravelNote> mTravelNoteList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView travelnoteImage;
        TextView travelnoteName;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            travelnoteImage = (ImageView) view.findViewById(R.id.travelnote_image);
            travelnoteName = (TextView) view.findViewById(R.id.travelnote_name);
        }
    }

    public TravelNoteAdapter(List<TravelNote> travelNoteList) {
        mTravelNoteList = travelNoteList;
    }

    @Override
    public TravelNoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.travelnote_item, parent, false);
        final TravelNoteAdapter.ViewHolder holder = new TravelNoteAdapter.ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                TravelNote travelNote = mTravelNoteList.get(position);
                Intent intent = new Intent(mContext, PointActivity.class);
                intent.putExtra(TravelNoteActivity.TRAVELNOTE_NAME, travelNote.getName());
                intent.putExtra(TravelNoteActivity.TRAVELNOTE_IMAGE_ID, travelNote.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(TravelNoteAdapter.ViewHolder holder, int position) {
        TravelNote travelNote = mTravelNoteList.get(position);
        holder.travelnoteName.setText(travelNote.getName());
        Glide.with(mContext).load(travelNote.getImageId()).into(holder.travelnoteImage);
    }

    @Override
    public int getItemCount() {
        return mTravelNoteList.size();
    }
}
