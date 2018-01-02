package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Mason on 2017/12/13.
 */

public class Setting extends BaseActivityFinishAllActivity implements View.OnClickListener {
    private Button exit;
    private Button back;
    private Button qqLink;
    private Button weChatLink;
    private Button helpLink;
    private Button about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);

        back = (Button) findViewById(R.id.title_button_back);
        exit = (Button) findViewById(R.id.exitapp_button);

        initView();

    }

    private void initView() {
        back.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_button_back:
                onBackPressed();
                break;
            case R.id.exitapp_button:
                ActivityCollector.finishyAll();
                break;
            default:
                break;
        }
    }


}
