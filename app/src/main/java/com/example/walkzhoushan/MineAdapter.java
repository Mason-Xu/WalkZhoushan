package com.example.walkzhoushan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mason on 2017/12/12.
 */

public class MineAdapter extends ArrayAdapter{
    private int resourceId;
    public MineAdapter(Context context, int textViewResourceId, List<MineSetting> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MineSetting mineSetting = (MineSetting) getItem(position); // 获取当前项的Minesetting实例
        View view;
        ViewHoler viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new MineAdapter.ViewHoler();
            viewHolder.minesettingImage = (ImageView) view.findViewById(R.id.mine_img);
            viewHolder.minesettingText = (TextView) view.findViewById(R.id.mine_textview);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        }else{
            view = convertView;
            viewHolder = (MineAdapter.ViewHoler) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.minesettingImage.setImageResource(mineSetting.getUserImageId());
        viewHolder.minesettingText.setText(mineSetting.getSettingName());
        return view;
    }
    class ViewHoler{
        ImageView minesettingImage;
        TextView minesettingText;
    }
}
