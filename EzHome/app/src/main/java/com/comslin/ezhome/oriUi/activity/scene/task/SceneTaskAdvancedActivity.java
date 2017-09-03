package com.comslin.ezhome.oriUi.activity.scene.task;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.SceneDataCenter;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.activity.room.RoomListActivity;
import com.comslin.ezhome.oriUi.http.bean.scene.SceneTaskList;
import com.comslin.ezhome.oriUi.util.ToastUtil;
import com.comslin.ezhome.oriUi.view.DurationPickerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linChao on 2017-08-27.
 */

public class SceneTaskAdvancedActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout mSceneAdvanceDeviceLayout;
    private LinearLayout mSceneAdvanceActionLayout;
    private LinearLayout mSceneAdvanceStartTimeLayout;
    private LinearLayout mSceneAdvanceContinueTimeLayout;
    private LinearLayout mSceneAdvanceActLayout;
    /**
     * 4分钟
     */
    private TextView mSceneAdvanceStartTimeDesc;
    /**
     * 4分钟
     */
    private TextView mSceneAdvanceContinueTimeDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.scene_advance_item_layout, topContentView, true);
        initView();
    }

    public void advanceTaskClick(View v) {

    }

    private void initView() {
        mSceneAdvanceDeviceLayout = (LinearLayout) findViewById(R.id.scene_advance_device_layout);
        mSceneAdvanceDeviceLayout.setOnClickListener(this);
        mSceneAdvanceActionLayout = (LinearLayout) findViewById(R.id.scene_advance_action_layout);
        mSceneAdvanceActionLayout.setOnClickListener(this);
        mSceneAdvanceStartTimeLayout = (LinearLayout) findViewById(R.id.scene_advance_start_time_layout);
        mSceneAdvanceContinueTimeLayout = (LinearLayout) findViewById(R.id.scene_advance_continue_time_layout);
        mSceneAdvanceContinueTimeLayout.setOnClickListener(this);
        mSceneAdvanceActLayout = (LinearLayout) findViewById(R.id.scene_advance_act_layout);

        mSceneAdvanceStartTimeDesc = (TextView) findViewById(R.id.scene_advance_start_time_desc);
        mSceneAdvanceContinueTimeDesc = (TextView) findViewById(R.id.scene_advance_continue_time_desc);
        setTitle(R.string.scene_advance_title);
        setTopRightText(R.string.common_save);
        topRightTitleTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAdvanceData();
            }
        });
    }

    public void saveAdvanceData() {
        SceneTaskList sceneTaskList = new SceneTaskList();
        sceneTaskList.setDuration(duration);
        sceneTaskList.setBeginTime("2000");
        sceneTaskList.setAction("action");
        SceneDataCenter.sceneTaskList.add(sceneTaskList);
        onBackPressed();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.scene_advance_device_layout:
                intent = new Intent(this, RoomListActivity.class);
                startActivity(intent);
                break;
            case R.id.scene_advance_action_layout:
                if (SceneDataCenter.roomEquipmentsList.size() == 0) {
                    ToastUtil.INSTANCE.showToast(this, "请选择设备");
                    break;
                }
                showPopMenu(R.layout.window_advance_action);
                break;
            case R.id.scene_advance_continue_time_layout:
                showPopMenu(R.layout.window_advance_duration);
                break;
            case R.id.scene_set_tast_sel_time_custom:
                showTimePickerWindow();
                break;
            case R.id.scene_set_tast_sel_time_pernamon:
                mSceneAdvanceContinueTimeDesc.setText(R.string.scene_advance_continue_time_con1);
                dismissPopWindow();
                duration = 0;
                break;


        }
    }

    List<ListView> listViews;
    int duration = 0;

    private void showTimePickerWindow() {
        ViewGroup viewGroup = (ViewGroup) showPopMenu(R.layout.window_duration_costom);
        listViews = new ArrayList<>();
        ListView hour = (ListView) viewGroup.findViewById(R.id.lv_custom_hour);
        ListView mnt = (ListView) viewGroup.findViewById(R.id.lv_custom_minute);
        ListView sec = (ListView) viewGroup.findViewById(R.id.lv_custom_second);
        listViews.add(hour);
        listViews.add(mnt);
        listViews.add(sec);
        for (int i = 0; i < listViews.size(); i++) {
            ListView listView = listViews.get(i);
            listView.setOnScrollListener(pickerListener);
            listView.setScrollBarSize(0);

        }

        hourPicker.setType(DurationPickerAdapter.TYPE_HOUR);
        minutePicker.setType(DurationPickerAdapter.TYPE_MINUTE);
        secondPicker.setType(DurationPickerAdapter.TYPE_SECOND);
        hour.setAdapter(hourPicker);
        mnt.setAdapter(minutePicker);
        sec.setAdapter(secondPicker);

        viewGroup.findViewById(R.id.btn_custom_durtion_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissPopWindow();
            }
        });
        viewGroup.findViewById(R.id.btn_custom_durtion_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listViews == null || listViews.size() == 0) {
                    return;
                }
                StringBuilder timeText = new StringBuilder();
                for (int i = 0; i < listViews.size(); i++) {
                    int position = listViews.get(i).getFirstVisiblePosition();

                    if (position == 0) {
                        continue;
                    }
                    timeText.append(position);
                    switch (i) {
                        case 0:
                            timeText.append("时");
                            duration = 3600 * position + duration;

                            break;
                        case 1:
                            timeText.append("分");
                            duration = 60 * position + duration;
                            break;
                        case 2:
                            timeText.append("秒");
                            duration = duration + position;

                            break;
                    }
                }
                mSceneAdvanceContinueTimeDesc.setText(timeText);
                dismissPopWindow();
            }
        });
    }

    DurationPickerAdapter hourPicker = new DurationPickerAdapter();
    DurationPickerAdapter minutePicker = new DurationPickerAdapter();
    DurationPickerAdapter secondPicker = new DurationPickerAdapter();
    AbsListView.OnScrollListener pickerListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            Log.d(TAG, "onScrollStateChanged: " + scrollState);
            if (SCROLL_STATE_IDLE == scrollState) {
                view.smoothScrollToPosition(view.getFirstVisiblePosition());
            }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    };
}
