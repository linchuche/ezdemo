package com.comslin.ezhome.oriUi.activity.scene;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.SceneDataCenter;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.activity.scene.task.SceneTaskAdvancedActivity;
import com.comslin.ezhome.oriUi.activity.scene.task.SceneTaskSimpleActivity;
import com.comslin.ezhome.oriUi.http.HttpResultBean;
import com.comslin.ezhome.oriUi.http.ResultCallBack;
import com.comslin.ezhome.oriUi.http.bean.scene.Scene;
import com.comslin.ezhome.oriUi.http.bean.scene.SceneConditionList;
import com.comslin.ezhome.oriUi.http.bean.scene.SceneTaskList;
import com.comslin.ezhome.oriUi.http.function.SceneHttp;
import com.comslin.ezhome.oriUi.util.ToastUtil;

public class SceneAutoAddActivity extends BaseActivity implements View.OnClickListener {


    View launchCondition;
    View launchTask;
    View validTime;
    String TAG = "TAG";
    ViewGroup contentView;
    private EditText mSceneAutoInfoName;
    private EditText mSceneAutoInfoDesc;
    private TextView mSceneAutoInfoCondTxt;
    private TextView mSceneAutoInfoTaskTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTopBar();
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        StringBuilder taskBuild = new StringBuilder();
        for (SceneTaskList sceneTaskList : SceneDataCenter.sceneTaskList) {
            taskBuild.append(sceneTaskList.getAction());
            taskBuild.append(".");
        }
        if (!TextUtils.isEmpty(taskBuild))
        mSceneAutoInfoTaskTxt.setText(taskBuild.toString());
        StringBuilder condBuild = new StringBuilder();
        for (SceneConditionList sceneConditionList:SceneDataCenter.sceneConditionList){
            condBuild.append(sceneConditionList.getConditionType());
            condBuild.append(sceneConditionList.getConditionExp());
            condBuild.append(".");
        }
        if (!TextUtils.isEmpty(condBuild))
            mSceneAutoInfoCondTxt.setText(condBuild);
    }

    private void initTopBar() {
        contentView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.scene_auto_add_layout, topContentView);
        setLeftButton(R.drawable.backbtn_selector);
        setTitle(R.string.scene_add_auto_title);
        setTopRightText(R.string.scene_save);
        topRightTitleTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveScene();
            }
        });
    }

    private void saveScene() {
        String desc = mSceneAutoInfoDesc.getText().toString();
        String name = mSceneAutoInfoName.getText().toString();
        if (TextUtils.isEmpty(desc)) {
            ToastUtil.INSTANCE.showToast(this, "描述不能为空");
        }
        if (TextUtils.isEmpty(name)) {
            ToastUtil.INSTANCE.showToast(this, "名称不能为空");
        }

        Scene scene = SceneDataCenter.getScene();
        scene.setDescription(desc);
        scene.setSceneType(Scene.AUTO);
        scene.setTriggerType("AND");
        scene.setValidTime("08:00-23:00");
        scene.setSceneId(1);
        showProgress(true);
        SceneHttp.Companion.save(SceneDataCenter.scene).execute(new ResultCallBack<Object>(Object.class) {
            @Override
            public void onResponse(HttpResultBean<Object> response, int id) {
                ToastUtil.INSTANCE.showToast(SceneAutoAddActivity.this, response.getDesc());
                showProgress(false);
                onBackPressed();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SceneDataCenter.clearAll();
    }

    private void initView() {
        launchCondition = findViewById(R.id.scene_auto_info_cond);
        launchTask = findViewById(R.id.scene_add_auto_task);
        validTime = findViewById(R.id.scene_add_auto_exetime);
        mSceneAutoInfoName = (EditText) findViewById(R.id.scene_auto_info_name);
        mSceneAutoInfoDesc = (EditText) findViewById(R.id.scene_auto_info_desc);
        mSceneAutoInfoCondTxt = (TextView) findViewById(R.id.scene_auto_info_cond_txt);
        mSceneAutoInfoTaskTxt = (TextView) findViewById(R.id.scene_auto_info_task_txt);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scene_auto_info_cond:
                Intent intent = new Intent(this, ChoseConditionActivity.class);
                startActivity(intent);
                break;
            case R.id.scene_auto_info_task:
                View pupView = LayoutInflater.from(this).inflate(R.layout.select_scene_level_dialog_layout, null);
                PopupWindow popupWindow = new PopupWindow(pupView);
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.showAtLocation(contentView, Gravity.BOTTOM, 0, 0);
                break;
            case R.id.sceneLevel_advanced:
                Intent intent1 = new Intent(this, SceneTaskAdvancedActivity.class);
                startActivity(intent1);
                break;
            case R.id.sceneLevel_simple:
                Intent intent2 = new Intent(this, SceneTaskSimpleActivity.class);
                startActivity(intent2);

        }
    }
}
