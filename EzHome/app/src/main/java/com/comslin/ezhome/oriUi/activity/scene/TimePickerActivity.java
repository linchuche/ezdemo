package com.comslin.ezhome.oriUi.activity.scene;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.SceneDataCenter;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.http.bean.scene.SceneConditionList;

/**
 * Created by linchaoer@qq.com on 2017/8/17.
 */

public class TimePickerActivity extends BaseActivity implements View.OnClickListener {


    private TextView mSceneSelTimeCycleTv;
    private LinearLayout mSceneSelTimeCycleType;
    private TimePicker mTpScene;
    private LinearLayout mSceneLaunchLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.scene_sel_time_layout, topContentView);
        initView();
        setTitle(R.string.scene_sel_time_title);
        setTopRightText(R.string.common_save);
        topRightTitleTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private void saveCondition(){
        SceneConditionList sceneConditionList  = new SceneConditionList();
        sceneConditionList.setConditionType("时间设置");
        sceneConditionList.setConditionExp("时间设置");
        sceneConditionList.setEquipmentId(1);
        sceneConditionList.setId(1);
        SceneDataCenter.sceneConditionList.add(sceneConditionList);
        onBackPressed();
    }
    private void initView() {
        mSceneSelTimeCycleTv = (TextView) findViewById(R.id.scene_sel_time_cycle_tv);
        mSceneSelTimeCycleType = (LinearLayout) findViewById(R.id.scene_sel_time_cycle_type);
        mTpScene = (TimePicker) findViewById(R.id.tp_scene);
        mSceneLaunchLayout = (LinearLayout) findViewById(R.id.scene_launch_layout);
        mSceneSelTimeCycleType.setClickable(true);
        mSceneSelTimeCycleType.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scene_sel_time_cycle_type:
                showPopMenu(R.layout.scene_sel_time_cycletype_layout);
                break;
            case R.id.scene_seltime_cycletype_custom:
                showPopMenu(R.layout.scene_sel_time_cycletype_custom_layout);
                break;

/*
            case R.id.scene_seltime_cycletype_custom_thursday
            case R.id.scene_seltime_cycletype_custom_friday
            case R.id.scene_seltime_cycletype_custom_saturday
            case R.id.scene_seltime_cycletype_custom_sunday
            case R.id.scene_seltime_cycletype_custom_thursday
            case R.id.scene_seltime_cycletype_custom_monday
            case R.id.scene_seltime_cycletype_custom_wednesday*/

        }
    }


}
