package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Mason on 2017/12/24.
 */

public class Travelnote_add extends AppCompatActivity implements View.OnClickListener {
    private Button back;
    private Button travelnote_addtext1;
    private Button travelnote_addtext2;
    private Button travelnote_addimg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_travelnote1);

        back = (Button) findViewById(R.id.title_button_back);
        travelnote_addtext1 = (Button) findViewById(R.id.add_text);
        travelnote_addtext2 = (Button) findViewById(R.id.add_travelnotetitle_next);
        travelnote_addimg = (Button) findViewById(R.id.add_img);
        initView();
    }

    private void initView() {
        back.setOnClickListener(this);
        travelnote_addtext1.setOnClickListener(this);
        travelnote_addtext2.setOnClickListener(this);
        travelnote_addimg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_button_back:
                onBackPressed();
                break;
            case R.id.add_text:
            case R.id.add_travelnotetitle_next:
                startActivity(new Intent(Travelnote_add.this, Travelnote_addtext.class));
                break;
            case R.id.add_img:
                openAlbum();
            default:
                break;
        }
    }

    private void openAlbum() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        startActivityForResult(intent, 5002);
    }
}
