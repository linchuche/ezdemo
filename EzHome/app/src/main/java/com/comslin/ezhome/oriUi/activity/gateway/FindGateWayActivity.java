package com.comslin.ezhome.oriUi.activity.gateway;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;

/**
 * Created by linchaoer@qq.com on 2017/8/18.
 */

public class FindGateWayActivity extends BaseActivity implements View.OnClickListener{
    View step1Layout;
    View step2Layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.config_gateway_guide_layout,topContentView);
        setTitle(R.string.config_gateway_guide_find_gate);
        step1Layout = findViewById(R.id.step1_layout);
        step2Layout = findViewById(R.id.step2_layout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.config_gate_step1_cancel:
                onBackPressed();
                break;
            case R.id.config_gate_step1_ok:
                step1Layout .setVisibility(View.GONE);
                step2Layout.setVisibility(View.VISIBLE);
                break;
            case R.id.config_gate_step2_yes:
                Intent intent=new Intent(this,ConnectModeActivity.class);
                startActivity(intent);
        }
    }
}
