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
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PointActivity extends AppCompatActivity {

    public static final String POINT_NAME = "point_name";

    public static final String POINT_IMAGE_ID = "point_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_point_text);
        Intent intent = getIntent();
        String pointName = intent.getStringExtra(POINT_NAME);
        int pointImageId = intent.getIntExtra(POINT_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView pointImageView = (ImageView) findViewById(R.id.point_image_view);
        TextView pointContentText = (TextView) findViewById(R.id.point_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(pointName);
        Glide.with(this).load(pointImageId).into(pointImageView);
        String pointContent = generatePointContent(pointName);
        if(!TextUtils.isEmpty(pointContent)){
            pointContentText.setText(pointContent);
        }

        pointContentText.setText(pointContent);
    }

    private String generatePointContent(String pointName) {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder pointContent = new StringBuilder();
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

            pointContent.append(pointName);
        }

        return pointContent.toString();
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
