package com.comslin.ezhome.oriUi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.comslin.ezhome.R;

public class DeviceAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_add);
        setTitle("添加设备");
    }
}
