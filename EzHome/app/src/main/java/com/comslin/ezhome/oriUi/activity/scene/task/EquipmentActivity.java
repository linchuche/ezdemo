package com.comslin.ezhome.oriUi.activity.scene.task;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.SceneDataCenter;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.http.bean.room.RoomEquipments;
import com.comslin.ezhome.oriUi.util.ToastUtil;
import com.comslin.ezhome.oriUi.view.EquipmentAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by linChao on 2017-08-28.
 */

public class EquipmentActivity extends BaseActivity {
    GridView gridView;
    boolean select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_gridview,topContentView,true);
        gridView = (GridView) findViewById(R.id.gv_room_list);
        final List<RoomEquipments> roomEquipmentsList=getIntent().getParcelableArrayListExtra("eqip");
        final EquipmentAdapter equipmentAdapter = new EquipmentAdapter(roomEquipmentsList);
        topRightTitleTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomEquipments roomEquipments=roomEquipmentsList.get(equipmentAdapter.getSelect());
                if (SceneDataCenter.roomEquipmentsList.contains(roomEquipments)){
                    ToastUtil.INSTANCE.showToast(EquipmentActivity.this,"设备已存在任务中");
                    return;
                }
                SceneDataCenter.roomEquipmentsList.add(roomEquipments);
                EventBus.getDefault().post(roomEquipments);
                finish();
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (equipmentAdapter.getSelect() == position){
                    equipmentAdapter.setSelect(-1);
                    topRightTitleTxt.setVisibility(View.INVISIBLE);
                    return;
                }
                equipmentAdapter.setSelect(position);
                setTopRightText(R.string.complete_txt);

            }
        });
    }
}
