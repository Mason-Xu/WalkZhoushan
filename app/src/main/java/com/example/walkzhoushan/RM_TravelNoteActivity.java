package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.BufferedReader;
import java.io.FileInputStream;

/**
 * Created by Mason on 2017/12/19.
 */

public class RM_TravelNoteActivity extends AppCompatActivity{
    public static final String TRAVELNOTE_NAME = "travelnote_name";
    public static final String TRAVELNOTE_IMAGE_ID = "travelnote_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_travelnote_text);
        Intent intent = getIntent();
        String pointName = intent.getStringExtra(TRAVELNOTE_NAME);
        int pointImageId = intent.getIntExtra(TRAVELNOTE_IMAGE_ID , 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView travelnoteImageView = (ImageView) findViewById(R.id.travelnote_image_view);
        TextView travelnoteContentText = (TextView) findViewById(R.id.travelnote_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(pointName);
        Glide.with(this).load(pointImageId).into(travelnoteImageView);
        String travelnoteContent = generateTravelNoteContent(pointName);
        if(!TextUtils.isEmpty(travelnoteContent)){
            travelnoteContentText.setText(travelnoteContent);
        }

        travelnoteContentText.setText(travelnoteContent);
    }

    private String generateTravelNoteContent(String travelnoteName) {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder travelnoteContent = new StringBuilder();
//        try {
//            in = openFileInput("putuoshan_text");
//            reader = new BufferedReader(new InputStreamReader(in));
//            String line = "";
//            while ((line = reader.readLine()) != null) {
//                pointContent.append(line);
//            }
//            Toast.makeText(this, "you read over", Toast.LENGTH_SHORT).show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        for (int  i = 0;i<10000;i++){

            travelnoteContent.append(travelnoteName);
        }

        return travelnoteContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
