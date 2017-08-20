package com.comslin.ezhome.oriUi.activity.scene;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;

public class SceneLanchActivity extends BaseActivity implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scene_launch_semiauto:
                Intent intent0=new Intent(this,SceneSemiAddActivity.class);
                startActivity(intent0);
                break;

            case R.id.scene_launch_auto:
                Intent intent1=new Intent(this,SceneAutoAddActivity.class);
                startActivity(intent1);
                break;
            case R.id.scene_launch_manual:
                Intent intent2=new Intent(this,SceneManualAddActivity.class);
                startActivity(intent2);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.scene_launch_layout,topContentView);
        setLeftButton(R.drawable.backbtn_selector);
        setTitle(R.string.scene_launch_title);
    }
}
