package com.comslin.ezhome.oriUi.activity.room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.GridView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.http.bean.room.Room;
import com.comslin.ezhome.oriUi.http.bean.room.RoomEquipments;
import com.comslin.ezhome.oriUi.view.DevicesAdapter;
import com.comslin.ezhome.oriUi.view.EquipmentAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by linchaoer@qq.com on 2017/8/15.
 */

public class RoomDetailActivity extends BaseActivity {
    private GridView mGvRoomDetail;
    private EquipmentAdapter equipmentAdapter;
    private List<RoomEquipments> equipmentsList = new ArrayList<>();
    Room room;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.activity_room_detail, topContentView);
        initIntent();
        setLeftButton(R.drawable.backbtn_selector);
        setTitle(room.getRoomName());
        initView();
    }
    private void initIntent(){
        room = getIntent().getParcelableExtra("room");
        equipmentsList = Arrays.asList(room.getEquipments());
    }
    private void initView() {
        mGvRoomDetail = (GridView) findViewById(R.id.gv_room_detail);
        equipmentAdapter =new EquipmentAdapter(equipmentsList);
        mGvRoomDetail.setAdapter(equipmentAdapter);
    }
}
