package com.comslin.ezhome.oriUi.activity.scene;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;

public class SceneManualActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.scene_manual_info_layout,topContentView);
        setLeftButton(R.drawable.backbtn_selector);
        setTitle(R.string.scene_add_manual_title);
        setTopRightText(R.string.scene_save);
    }
}
