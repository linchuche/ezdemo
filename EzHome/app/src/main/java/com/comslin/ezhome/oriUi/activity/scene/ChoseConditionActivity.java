package com.comslin.ezhome.oriUi.activity.scene;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;

/**
 * Created by linchaoer@qq.com on 2017/8/14.
 */

public class ChoseConditionActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.scene_sel_cond_type_layout, topContentView);
        setTitle(R.string.scene_sel_cond_title);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scene_sel_cond_type_time:
            case R.id.scene_sel_cond_type_location:
            case R.id.scene_sel_cond_type_weather:
            case R.id.scene_sel_cond_type_sensor:
                break;

        }
    }
}
