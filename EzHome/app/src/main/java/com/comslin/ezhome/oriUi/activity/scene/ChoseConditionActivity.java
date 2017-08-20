package com.comslin.ezhome.oriUi.activity.scene;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linchaoer@qq.com on 2017/8/14.
 */

public class ChoseConditionActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.scene_sel_cond_type_layout, topContentView);
        setTitle(R.string.scene_sel_cond_title);
        initPermission();
    }
    //定位所需权限组
    private String[] needPermissions = new String[]{
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE
    };
    final int PERMISSON_REQUESTCODE = 101;
    private void initPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        List<String> permissionList = new ArrayList<>();
        for (int i = 0; i < needPermissions.length; i++) {
            if (ContextCompat.checkSelfPermission(this, needPermissions[i]) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(needPermissions[i]);
            }
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            requestPermissions(permissions, PERMISSON_REQUESTCODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSON_REQUESTCODE:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            ToastUtil.INSTANCE.showToast(this, "必须同意所有权限才能使用此功能");
//                            initPermission();
                            return;
                        }
                    }
                } else {
                    ToastUtil.INSTANCE.showToast(this, "发生未知错误");
                }
                break;
            default:
        }
    }
    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.scene_sel_cond_type_time:
                intent = new Intent(this, TimePickerActivity.class);
                break;
            case R.id.scene_sel_cond_type_location:
                intent = new Intent(this, LocationConditionActivity.class);
                break;
            case R.id.scene_sel_cond_type_weather:
                intent = new Intent(this, WeatherConditionActivity.class);
                break;
            case R.id.scene_sel_cond_type_sensor:
                intent=new Intent(this,SensorSetActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
