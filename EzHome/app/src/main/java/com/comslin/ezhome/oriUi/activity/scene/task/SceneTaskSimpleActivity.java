package com.comslin.ezhome.oriUi.activity.scene.task;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.SceneDataCenter;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.activity.room.RoomListActivity;
import com.comslin.ezhome.oriUi.http.bean.room.RoomEquipments;
import com.comslin.ezhome.oriUi.http.bean.scene.SceneTaskList;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by linChao on 2017-08-27.
 */

public class SceneTaskSimpleActivity extends BaseActivity implements View.OnClickListener{
    private TextView mSceneSetTastSelDeviceTv;
    private LinearLayout mSceneSetTastSelDevice;
    private ListView mSceneSetTastSelDeviceListView;
    private ImageView mSceneSetTastSelDeviceOpenIcon;
    private LinearLayout mSceneSetTastSelDeviceOpen;
    private ImageView mSceneSetTastSelDeviceCloseIcon;
    private LinearLayout mSceneSetTastSelDeviceClose;
    private LinearLayout mSceneLaunchLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.scene_set_tast_layout, topContentView, true);
        EventBus.getDefault().register(this);
        initData();
        initView();
        init();
        setTopRightText(R.string.common_save);
        topRightTitleTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSimpleData();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void init(){
        if (taskLists!=null&&taskLists.size()!=0){

        }
    }
    List<SceneTaskList> taskLists = new ArrayList<>();
    private void initData(){
        taskLists = getIntent().getParcelableArrayListExtra("task");
    }
    private void initView() {
        mSceneSetTastSelDeviceTv = (TextView) findViewById(R.id.scene_set_tast_sel_device_tv);
        mSceneSetTastSelDevice = (LinearLayout) findViewById(R.id.scene_set_tast_sel_device);
        mSceneSetTastSelDeviceListView = (ListView) findViewById(R.id.scene_set_tast_sel_device_listView);
        mSceneSetTastSelDeviceOpenIcon = (ImageView) findViewById(R.id.scene_set_tast_sel_device_open_icon);
        mSceneSetTastSelDeviceOpen = (LinearLayout) findViewById(R.id.scene_set_tast_sel_device_open);
        mSceneSetTastSelDeviceCloseIcon = (ImageView) findViewById(R.id.scene_set_tast_sel_device_close_icon);
        mSceneSetTastSelDeviceClose = (LinearLayout) findViewById(R.id.scene_set_tast_sel_device_close);
        mSceneLaunchLayout = (LinearLayout) findViewById(R.id.scene_launch_layout);
    }
    public void saveSimpleData() {
        SceneTaskList sceneTaskList = new SceneTaskList();
        sceneTaskList.setBeginTime("2000");
        sceneTaskList.setAction("action");
        SceneDataCenter.sceneTaskList.add(sceneTaskList);
        onBackPressed();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scene_set_tast_sel_device:
                Intent intent = new Intent(this, RoomListActivity.class);
                startActivity(intent);
            case R.id.scene_set_tast_sel_device_open:
                mSceneSetTastSelDeviceCloseIcon.setVisibility(View.INVISIBLE);
                mSceneSetTastSelDeviceOpenIcon.setVisibility(View.VISIBLE);
                break;
            case R.id.scene_set_tast_sel_device_close:
                mSceneSetTastSelDeviceCloseIcon.setVisibility(View.INVISIBLE);
                mSceneSetTastSelDeviceOpenIcon.setVisibility(View.VISIBLE);
                break;
        }
    }
    @Subscribe
    public void onMessageEvent(RoomEquipments roomEquipments){
        finish();
    }
}
