package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mason on 2017/12/19.
 */

public class TravelNotePageActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private TravelNote[] travelNotes = {new TravelNote("茶人谷", R.drawable.charengu), new TravelNote("东极岛", R.drawable.img_point_dongjidao),
            new TravelNote("普陀山", R.drawable.img_point_putuoshan), new TravelNote("嵊泗", R.drawable.img_point_shengsi),
            new TravelNote("桃花岛", R.drawable.img_point_taohuadao), new TravelNote("朱家尖", R.drawable.img_point_zhujiajian)};

    private List<TravelNote> travelNoteList = new ArrayList<>();

    private TravelNoteAdapter adapter;

    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_travelnote_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Data deleted", Snackbar.LENGTH_SHORT)
//                        .setAction("Undo", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Toast.makeText(TravelNotePageActivity.this, "Data plus?", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .show();
                startActivity(new Intent(TravelNotePageActivity.this,Add_travelnote.class));
            }
        });
        initTravelNotes();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TravelNoteAdapter(travelNoteList);
        recyclerView.setAdapter(adapter);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshPoints();
            }
        });
    }

    //刷新
    private void refreshPoints() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initTravelNotes();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initTravelNotes() {
        travelNoteList.clear();
        for (int i = 0; i < 6; i++) {
            travelNoteList.add(travelNotes[i]);
        }
        for (int i = 0; i < 6; i++) {
            travelNoteList.add(travelNotes[i]);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intenthome = new Intent(TravelNotePageActivity.this,Bottombartest.class);
                startActivity(intenthome);
                break;
            case R.id.search:
                Toast.makeText(this, "You clicked Search", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
