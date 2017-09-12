package com.comslin.ezhome.oriUi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;

public class DeviceShareActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_device_share,topContentView,true);
        setTitle(R.string.setting_share);
    }
}
