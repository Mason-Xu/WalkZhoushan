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

public class PointAdapter extends RecyclerView.Adapter<PointAdapter.ViewHolder>{

    private static final String TAG = "PointAdapter";

    private Context mContext;

    private List<Point> mPointList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView pointImage;
        TextView pointName;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            pointImage = (ImageView) view.findViewById(R.id.point_image);
            pointName = (TextView) view.findViewById(R.id.point_name);
        }
    }

    public PointAdapter(List<Point> pointList) {
        mPointList = pointList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.point_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Point point = mPointList.get(position);
                Intent intent = new Intent(mContext, PointActivity.class);
                intent.putExtra(PointActivity.POINT_NAME, point.getName());
                intent.putExtra(PointActivity.POINT_IMAGE_ID, point.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Point fruit = mPointList.get(position);
        holder.pointName.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageId()).into(holder.pointImage);
    }

    @Override
    public int getItemCount() {
        return mPointList.size();
    }

}
