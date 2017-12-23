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
 * Created by Mason on 2017/12/11.
 */

public class MessageAdapter extends ArrayAdapter {

    private int resourceId;
    public MessageAdapter(Context context, int textViewResourceId, List<MessageUser> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MessageUser messageUser = (MessageUser) getItem(position); // 获取当前项的Fruit实例
        View view;
        ViewHoler viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHoler();
            viewHolder.messageuserImage = (ImageView) view.findViewById(R.id.message_image);
            viewHolder.messageuserName = (TextView) view.findViewById(R.id.message_name);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        }else{
            view = convertView;
            viewHolder = (ViewHoler) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.messageuserImage.setImageResource(messageUser.getUserImageId());
        viewHolder.messageuserName.setText(messageUser.getName());
        return view;
    }
    static class ViewHoler{
        ImageView messageuserImage;
        TextView messageuserName;
    }
}
