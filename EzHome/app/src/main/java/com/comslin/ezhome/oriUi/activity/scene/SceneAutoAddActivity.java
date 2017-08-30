package com.comslin.ezhome.oriUi.activity.scene;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;

public class SceneAutoAddActivity extends BaseActivity implements View.OnClickListener{


    View launchCondition;
    View launchTask;
    View validTime;
    String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTopBar();
        initView();
    }

    private void initTopBar() {
        LayoutInflater.from(this).inflate(R.layout.scene_auto_add_layout, topContentView);
        setLeftButton(R.drawable.backbtn_selector);
        setTitle(R.string.scene_add_auto_title);
        setTopRightText(R.string.scene_save);
    }
    private void initView(){
        launchCondition = findViewById(R.id.scene_auto_info_cond);
        launchTask = findViewById(R.id.scene_add_auto_task);
        validTime = findViewById(R.id.scene_add_auto_exetime);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scene_auto_info_cond:
                Intent intent=new Intent(this,ChoseConditionActivity.class);
                startActivity(intent);
                break;
            case R.id.scene_auto_info_task:
                View pupView  = LayoutInflater.from(this).inflate(R.layout.select_scene_level_dialog_layout,null);
                PopupWindow popupWindow=new PopupWindow(pupView);
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.showAtLocation(topContentView,0,0, Gravity.BOTTOM);
                break;
            case R.id.sceneLevel_advanced:

            case R.id.sceneLevel_simple:
        }
    }
}
