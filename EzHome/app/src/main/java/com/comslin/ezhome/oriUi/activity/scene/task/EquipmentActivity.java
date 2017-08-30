package com.comslin.ezhome.oriUi.activity.scene.task;

import android.os.Bundle;
import android.widget.GridView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.view.EquipmentAdapter;

/**
 * Created by linChao on 2017-08-28.
 */

public class EquipmentActivity extends BaseActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_gridview,topContentView,true);
        gridView = (GridView) findViewById(R.id.gv_room_list);
        EquipmentAdapter equipmentAdapter = new EquipmentAdapter();
    }
}
