package com.comslin.ezhome.oriUi.activity.scene;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.http.bean.scene.Scene;
import com.comslin.ezhome.oriUi.http.bean.scene.SceneConditionList;
import com.comslin.ezhome.oriUi.http.bean.scene.SceneTaskList;

/**
 * Created by linchaoer@qq.com on 2017/8/15.
 */

public class SceneAutoInfoActivity extends BaseActivity implements View.OnClickListener {
    private TextView mSceneAutoInfoName;
    private TextView mSceneAutoInfoDesc;
    private TextView mSceneAutoInfoCondTxt;
    private LinearLayout mSceneAutoInfoCond;
    private TextView mSceneAutoInfoTaskTxt;
    private LinearLayout mSceneAutoInfoTask;
    private TextView mSceneAddAutoExetimeTxt;
    private LinearLayout mSceneAddAutoExetime;
    private ImageView mSceneAutoInfoOn;
    private LinearLayout mSceneAutoInfoOnLayout;
    private ImageView mSceneAutoInfoOff;
    private LinearLayout mSceneAutoInfoOffLayout;
    private LinearLayout mSceneAutoInfoSwitchflagLayout;
    private LinearLayout mSceneAutoInfoLayout;
    private Scene scene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.scene_auto_info_layout, topContentView);
        initIntent();
        initView();
        initTextContent();
    }

    private void initIntent() {
        scene = getIntent().getParcelableExtra("scene");

    }

    private void initView() {
        mSceneAutoInfoName = (TextView) findViewById(R.id.scene_auto_info_name);
        mSceneAutoInfoDesc = (TextView) findViewById(R.id.scene_auto_info_desc);
        mSceneAutoInfoCondTxt = (TextView) findViewById(R.id.scene_auto_info_cond_txt);
        mSceneAutoInfoCond = (LinearLayout) findViewById(R.id.scene_auto_info_cond);
        mSceneAutoInfoCond.setOnClickListener(this);
        mSceneAutoInfoTaskTxt = (TextView) findViewById(R.id.scene_auto_info_task_txt);
        mSceneAutoInfoTask = (LinearLayout) findViewById(R.id.scene_auto_info_task);
        mSceneAutoInfoTask.setOnClickListener(this);
        mSceneAddAutoExetimeTxt = (TextView) findViewById(R.id.scene_add_auto_exetime_txt);
        mSceneAddAutoExetime = (LinearLayout) findViewById(R.id.scene_add_auto_exetime);
        mSceneAddAutoExetime.setOnClickListener(this);
        mSceneAutoInfoOn = (ImageView) findViewById(R.id.scene_auto_info_on);
        mSceneAutoInfoOnLayout = (LinearLayout) findViewById(R.id.scene_auto_info_on_layout);
        mSceneAutoInfoOff = (ImageView) findViewById(R.id.scene_auto_info_off);
        mSceneAutoInfoOffLayout = (LinearLayout) findViewById(R.id.scene_auto_info_off_layout);
        mSceneAutoInfoSwitchflagLayout = (LinearLayout) findViewById(R.id.scene_auto_info_switchflag_layout);
        mSceneAutoInfoLayout = (LinearLayout) findViewById(R.id.scene_auto_info_layout);
    }

    private void initTextContent() {
        mSceneAutoInfoName.setText(scene.getSceneName());
        mSceneAutoInfoDesc.setText(scene.getDescription());
        StringBuilder taskSb = new StringBuilder();
        for (SceneTaskList sceneTaskList : scene.getTaskList()) {
            taskSb.append(sceneTaskList.getAction());
            taskSb.append("&");
        }
        if (scene.getTaskList().length > 0) {
            taskSb.deleteCharAt(taskSb.length() - 1);
        }
        mSceneAutoInfoTaskTxt.setText(taskSb.toString());
        StringBuilder conditionSb = new StringBuilder();
        for (SceneConditionList sceneConditionList:scene.getConditionList()){
            conditionSb.append(sceneConditionList.getConditionType());
            conditionSb.append(sceneConditionList.getConditionExp());
            conditionSb.append("&");
        }
        if (scene.getConditionList().length > 0) {
            conditionSb.deleteCharAt(conditionSb.length() - 1);
        }
        mSceneAutoInfoCondTxt.setText(conditionSb.toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scene_auto_info_cond:
                break;
            case R.id.scene_auto_info_task:
                break;
            case R.id.scene_add_auto_exetime:
                break;
        }
    }
}
