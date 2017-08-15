package com.comslin.ezhome.oriUi.activity.scene;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;

public class SceneAutoAddActivity extends BaseActivity implements View.OnClickListener{


    View launchCondition;
    View launchTask;
    View validTime;

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
        }
    }
}
