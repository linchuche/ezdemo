package com.comslin.ezhome.oriUi.activity.scene;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;

/**
 * Created by linchaoer@qq.com on 2017/8/17.
 */

public class TimePickerActivity extends BaseActivity implements View.OnClickListener{


    private TextView mSceneSelTimeCycleTv;
    private LinearLayout mSceneSelTimeCycleType;
    private TimePicker mTpScene;
    private LinearLayout mSceneLaunchLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.scene_sel_time_layout,topContentView);
        initView();
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
        switch (v.getId()){
            case R.id.scene_sel_time_cycle_type:

        }
    }

    private void popupCycleTypeWindow(){
        PopupWindow popupWindow = new PopupWindow();
        ListView listView=new ListView(this);
//        listView.setAdapter(new SimpleAdapter());
//        popupWindow.setContentView();
    }
}
