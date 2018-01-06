package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Mason on 2018/1/6.
 */

public class Home_Strategy extends BaseActivity implements View.OnClickListener {
    private Button back;
    private ImageView pujisi_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_strategy);
        findViewById(R.id.title_button_back).setOnClickListener(this);
        findViewById(R.id.strategy_pujisi_img).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_button_back:
                onBackPressed();
                break;
            case R.id.strategy_pujisi_img:
                startActivity(new Intent(Home_Strategy.this,Strategy_Pujisi.class));
                break;
                default:
                    break;
        }
    }
}
