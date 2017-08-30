//package com.comslin.ezhome.oriUi.activity;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.widget.GridView;
//
//import com.comslin.ezhome.R;
//import com.comslin.ezhome.oriUi.http.bean.room.RoomEquipments;
//
//public class RoomDetailActivity extends BaseActivity {
//    private GridView gridView;
//
//    private String title = "";
//    private RoomEquipments[] roomEquipmentses;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        initValue();
//        initView();
//    }
//    private void initValue(){
//        title = getIntent().getStringExtra("title");
//        roomEquipmentses = (RoomEquipments[]) getIntent().getParcelableArrayExtra("equipments");
//    }
//    private void initView(){
//        LayoutInflater.from(this).inflate(R.layout.room_add_layout, topContentView);
//        gridView = (GridView) findViewById(R.id.gv_room_detail);
//
//    }
//}
