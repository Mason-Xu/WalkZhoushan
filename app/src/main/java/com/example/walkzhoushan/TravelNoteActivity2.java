package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by Mason on 2017/12/24.
 */

public class TravelNoteActivity2 extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fab;
    private Button back;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_travelnote_main);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        back = (Button) findViewById(R.id.title_button_back);
        initView();
    }

    private void initView() {
        fab.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                startActivity(new Intent(TravelNoteActivity2.this, Travelnote_add.class));
                break;
            case R.id.title_button_back:
                onBackPressed();
                break;
            default:
                break;
        }
    }
}
