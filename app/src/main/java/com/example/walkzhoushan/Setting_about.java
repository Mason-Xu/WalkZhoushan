package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mason on 2018/1/6.
 */

public class Setting_about extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_about);
        findViewById(R.id.title_button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
