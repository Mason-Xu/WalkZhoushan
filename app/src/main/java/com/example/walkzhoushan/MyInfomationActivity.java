package com.example.walkzhoushan;

/**
 * Created by Mason on 2017/12/19.
 */

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import cn.bmob.v3.BmobUser;

public class MyInfomationActivity extends BaseActivity implements View.OnClickListener {

    private String[] sexArry = new String[] { "不告诉你","女", "男" };// 性别选择

    private Button title_button_back;

    private Button changename_button;
    private Button changebirth_button;
    private Button exitaccount_button;
    private Button changesex_button;
    private TextView username_textview;


    private TextView changesex_textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinformation_layout);

        title_button_back = (Button) findViewById(R.id.title_button_back);

        changename_button = (Button) findViewById(R.id.changename_button);
        changebirth_button = (Button) findViewById(R.id.changebirth_button);
        exitaccount_button = (Button) findViewById(R.id.exitaccount_button);
        changesex_button = (Button) findViewById(R.id.changesex_button);


        //get username from bmob and set text for username_textview
        String username = (String) BmobUser.getObjectByKey("username");
        username_textview = (TextView) findViewById(R.id.username_textview);
        username_textview.setText(username);


        InitView();
    }

    private void InitView() {
        title_button_back.setOnClickListener(this);

        changename_button.setOnClickListener(this);
        changebirth_button.setOnClickListener(this);
        exitaccount_button.setOnClickListener(this);
        changesex_button.setOnClickListener(this);
    }

    /**
     * 日期选择器对话框监听
     */
    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            int mYear = year;
            int mMonth = monthOfYear;
            int mDay = dayOfMonth;
            TextView tv_date = (TextView) findViewById(R.id.changebirth_textview);
            String days;
            if (mMonth + 1 < 10) {
                if (mDay < 10) {
                    days = new StringBuffer().append(mYear).append("年").append("0").
                            append(mMonth + 1).append("月").append("0").append(mDay).append("日").toString();
                } else {
                    days = new StringBuffer().append(mYear).append("年").append("0").
                            append(mMonth + 1).append("月").append(mDay).append("日").toString();
                }

            } else {
                if (mDay < 10) {
                    days = new StringBuffer().append(mYear).append("年").
                            append(mMonth + 1).append("月").append("0").append(mDay).append("日").toString();
                } else {
                    days = new StringBuffer().append(mYear).append("年").
                            append(mMonth + 1).append("月").append(mDay).append("日").toString();
                }

            }
            tv_date.setText(days);
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_button_back:
                onBackPressed();
                break;
            case R.id.changebirth_button:
                Calendar ca = Calendar.getInstance();
                final int mYear = ca.get(Calendar.YEAR);
                final int mMonth = ca.get(Calendar.MONTH);
                final int mDay = ca.get(Calendar.DAY_OF_MONTH);
                //TODO 调用时间选择器
                new DatePickerDialog(MyInfomationActivity.this, onDateSetListener, mYear, mMonth, mDay).show();
                break;
            case R.id.exitaccount_button:
                CertainExit();
                break;
            case R.id.changesex_button:
                changesex_textview = (TextView) findViewById(R.id.changesex_textview);
                SexChooseDialog();
                break;
            case R.id.changename_button: // 设置昵称
                onCreateNameDialog();
                break;
            default:
                break;

        }
    }

    private void onCreateNameDialog() {
        // 使用LayoutInflater来加载dialog_setname.xml布局
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View nameView = layoutInflater.inflate(R.layout.dialog_setname, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // 使用setView()方法将布局显示到dialog
        alertDialogBuilder.setView(nameView);

        final EditText userInput = (EditText) nameView.findViewById(R.id.changename_edit);
        final TextView name = (TextView) findViewById(R.id.changename_textview);


        // 设置Dialog按钮
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // 获取edittext的内容,显示到textview
                                name.setText(userInput.getText());
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    private void CertainExit() {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder1 = new AlertDialog.Builder(MyInfomationActivity.this);
        builder1.setMessage("确定退出账号?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        BmobUser.logOut();   //清除缓存用户对象
                        BmobUser currentUser = BmobUser.getCurrentUser(); // 现在的currentUser是null了;
                        toast("退出账号成功");
                        onBackPressed();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        toast("取消");
                    }
                });
        // Create the AlertDialog object and return it
        builder1.show();
    }

    private void SexChooseDialog() {
        AlertDialog.Builder builder3 = new AlertDialog.Builder(this);// 自定义对话框
        builder3.setSingleChoiceItems(sexArry, 0, new DialogInterface.OnClickListener() {// 2默认的选中

            @Override
            public void onClick(DialogInterface dialog, int which) {// which是被选中的位置
                // showToast(which+"");
                changesex_textview.setText(sexArry[which]);
                dialog.dismiss();// 随便点击一个item消失对话框，不用点击确认取消
            }
        });
        builder3.show();// 让弹出框显示
    }
}