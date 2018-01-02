package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Mason on 2017/12/12.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    private ImageView spot_img;
    private ImageView trailnote_img;
    private ImageView strategy_img;
    private ImageView traffic_img;
    private ImageView hotel_img;
    private ImageView cate_img;
    private ImageView follow_img;
    private ImageView freewalk_img;
    private ImageView needknow_img;
    private ImageView more_img;
    private ImageView strategy_putuoshan_img;
    private Button homepage_putuo_button;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_home_page, container, false);

        trailnote_img = (ImageView) view.findViewById(R.id.trailnote_img);
        spot_img = (ImageView) view.findViewById(R.id.spot_img);
        strategy_img = (ImageView) view.findViewById(R.id.strategy_img);
        traffic_img = (ImageView) view.findViewById(R.id.traffic_img);
        hotel_img = (ImageView) view.findViewById(R.id.hotel_img);
        cate_img = (ImageView) view.findViewById(R.id.cate_img);
        follow_img = (ImageView) view.findViewById(R.id.follow_img);
        freewalk_img = (ImageView) view.findViewById(R.id.freewalk_img);
        needknow_img = (ImageView) view.findViewById(R.id.needknow_img);
        more_img = (ImageView) view.findViewById(R.id.more_img);
        strategy_putuoshan_img = (ImageView) view.findViewById(R.id.home_strategy_putuoshan_img);
        homepage_putuo_button = (Button) view.findViewById(R.id.homepage_putuo_button);
        InitView();
        return view;
    }

    private void InitView() {
        trailnote_img.setOnClickListener(this);
        spot_img.setOnClickListener(this);
        traffic_img.setOnClickListener(this);
        strategy_img.setOnClickListener(this);
        hotel_img.setOnClickListener(this);
        cate_img.setOnClickListener(this);
        follow_img.setOnClickListener(this);
        freewalk_img.setOnClickListener(this);
        more_img.setOnClickListener(this);
        needknow_img.setOnClickListener(this);
        strategy_putuoshan_img.setOnClickListener(this);
        homepage_putuo_button.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.trailnote_img:
                Intent intent1 = new Intent(getActivity(), TravelNoteActivity2.class);
                startActivity(intent1);
                break;
            case R.id.spot_img:
                Intent intent2 = new Intent(getActivity(), PointPageActivity.class);
                startActivity(intent2);
                break;
            case R.id.strategy_img:
                Intent intent3 = new Intent(getActivity(), NoDevelop.class);
                startActivity(intent3);
                break;
            case R.id.traffic_img:
                Intent intent4 = new Intent(getActivity(), Home_Traffic_activity.class);
                startActivity(intent4);
                break;
            case R.id.hotel_img:
                Intent intent5 = new Intent(getActivity(), Home_Hotel_activity.class);
                startActivity(intent5);
                break;
            case R.id.cate_img:
                Intent intent6 = new Intent(getActivity(),Home_Cate_activity.class);
                startActivity(intent6);
                break;
            case R.id.follow_img:
                Intent intent7 = new Intent(getActivity(), NoDevelop.class);
                startActivity(intent7);
                break;
            case R.id.freewalk_img:
                Intent intent8 = new Intent(getActivity(), NoDevelop.class);
                startActivity(intent8);
                break;
            case R.id.needknow_img:
                Intent intent9 = new Intent(getActivity(), Needknow_ScrollingActivity.class);
                startActivity(intent9);
                break;
            case R.id.more_img:
                Intent intent10 = new Intent(getActivity(), NoDevelop.class);
                startActivity(intent10);
                break;
            case R.id.home_strategy_putuoshan_img:
                startActivity(new Intent(getActivity(),Strategy_Pujisi.class));
            case R.id.homepage_putuo_button:
                Intent intent11 = new Intent(getActivity(), Point_putuoshan.class);
                startActivity(intent11);
                break;

            default:
                break;
        }
    }
}
