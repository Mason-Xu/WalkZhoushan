package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Mason on 2017/12/21.
 */

public class Travelnote_addtext extends AppCompatActivity implements View.OnClickListener {
    private Button back1,back2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_travelnote);
        findViewById(R.id.title_button_back).setOnClickListener(this);
        findViewById(R.id.add_travelnotetext_back2).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_button_back:
            case R.id.add_travelnotetext_back2:
                onBackPressed();
                break;
            default:
                break;
        }
    }
}
