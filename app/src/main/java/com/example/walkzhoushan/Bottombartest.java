package com.example.walkzhoushan;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class Bottombartest extends AppCompatActivity {

    private HomeFragment fragment1;
    private MessageFragment fragment2;
    private MineFragment fragment3;
    private Fragment[] fragments;
    private FrameLayout frameLayout;
    private int lastShowFragment = 0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(lastShowFragment!=0){
                        switchFrament(lastShowFragment,0);
                        lastShowFragment = 0;
                    }
                    return true;
                case R.id.navigation_message:
                    if(lastShowFragment!=1){
                        switchFrament(lastShowFragment,1);
                        lastShowFragment = 1;
                    }
                    return true;
                case R.id.navigation_mine:
                    if(lastShowFragment!=2){
                        switchFrament(lastShowFragment,2);
                        lastShowFragment = 2;
                    }
                    return true;
            }
            return false;
        }
    };

    //设置mine界面的按钮点击事件
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnMinePageButton = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch ()
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        frameLayout = (FrameLayout)findViewById(R.id.fragment_container);
        //添加 BottomNavigationView 的事件监听
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initFragments();
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

    }
    /**
     * 切换Fragment
     *
     * @param lastIndex 上个显示Fragment的索引
     * @param index     需要显示的Fragment的索引
     */
    public void switchFrament(int lastIndex, int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastIndex]);
        if (!fragments[index].isAdded()) {
            transaction.add(R.id.fragment_container, fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }

    private void initFragments() {
        fragment1 = new HomeFragment();
        fragment2 = new MessageFragment();
        fragment3 = new MineFragment();
        fragments = new Fragment[]{fragment1,fragment2,fragment3};
        lastShowFragment = 0;
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container,fragment1)
                .show(fragment1)
                .commit();
    }
}
