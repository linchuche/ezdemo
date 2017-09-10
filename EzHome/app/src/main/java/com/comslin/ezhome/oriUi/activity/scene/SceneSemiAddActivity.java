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

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.SceneDataCenter;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.activity.scene.task.SceneTaskAdvancedActivity;
import com.comslin.ezhome.oriUi.activity.scene.task.SceneTaskSimpleActivity;
import com.comslin.ezhome.oriUi.http.HttpResultBean;
import com.comslin.ezhome.oriUi.http.ResultCallBack;
import com.comslin.ezhome.oriUi.http.bean.scene.Scene;
import com.comslin.ezhome.oriUi.http.function.SceneHttp;
import com.comslin.ezhome.oriUi.util.ToastUtil;

public class SceneSemiAddActivity extends BaseActivity implements View.OnClickListener{
    View launchCondition;
    View launchTask;
    View validTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.scene_auto_info_layout,topContentView);
        setLeftButton(R.drawable.backbtn_selector);
        setTitle(R.string.scene_add_semiauto_title);
        setTopRightText(R.string.scene_save);
        initView();
        topRightTitleTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveScene();
            }
        });
    }
    private EditText mSceneAutoInfoName;
    private EditText mSceneAutoInfoDesc;

    private void initView(){

        launchCondition = findViewById(R.id.scene_auto_info_cond);
        launchTask = findViewById(R.id.scene_add_auto_task);
        validTime = findViewById(R.id.scene_add_auto_exetime);
        mSceneAutoInfoName = (EditText) findViewById(R.id.scene_auto_info_name);
        mSceneAutoInfoDesc = (EditText) findViewById(R.id.scene_auto_info_desc);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SceneDataCenter.clearAll();
    }
    private void saveScene(){
        String desc = mSceneAutoInfoDesc.getText().toString();
        String name = mSceneAutoInfoName.getText() .toString();
        if (TextUtils.isEmpty(desc)){
            ToastUtil.INSTANCE.showToast(this,"描述不能为空");
        }
        if (TextUtils.isEmpty(name)) {
            ToastUtil.INSTANCE.showToast(this, "名称不能为空");
        }

        Scene scene = SceneDataCenter.getScene();
        scene.setDescription(desc);
        scene.setSceneType(Scene.AUTO);
        scene.setTriggerType("Semi");
        scene.setValidTime("08:00-23:00");
        scene.setSceneId(1);
        showProgress(true);
        SceneHttp.Companion.save(SceneDataCenter.scene).execute(new ResultCallBack<Object>(Object.class) {
            @Override
            public void onResponse(HttpResultBean<Object> response, int id) {
                ToastUtil.INSTANCE.showToast(SceneSemiAddActivity.this,response.getDesc());
                showProgress(false);
                onBackPressed();
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scene_auto_info_cond:
                Intent intent=new Intent(this,ChoseConditionActivity.class);
                startActivity(intent);
                break;
            case R.id.scene_auto_info_task:
                View pupView = LayoutInflater.from(this).inflate(R.layout.select_scene_level_dialog_layout, null);
                PopupWindow popupWindow = new PopupWindow(pupView);
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.showAtLocation(topContentView, Gravity.BOTTOM, 0, 0);
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
