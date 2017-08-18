package com.comslin.ezhome.oriUi.activity.gateway;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;

/**
 * Created by linchaoer@qq.com on 2017/8/18.
 */

public class FindGateWayActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.config_gateway_guide_layout,topContentView);
    }
}
