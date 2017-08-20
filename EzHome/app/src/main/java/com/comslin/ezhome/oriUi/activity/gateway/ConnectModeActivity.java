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

public class ConnectModeActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.select_net_mode_layout, topContentView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.select_net_wired:
                Intent intent1 = new Intent(this, LineConnActivity.class);
                startActivity(intent1);
                break;
            case R.id.select_net_wireless:
                Intent intent2 = new Intent(this, WifiConnActivity.class);
                startActivity(intent2);
                break;

        }
    }
}
