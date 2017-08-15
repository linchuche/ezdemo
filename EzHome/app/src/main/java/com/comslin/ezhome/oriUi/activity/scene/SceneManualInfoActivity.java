package com.comslin.ezhome.oriUi.activity.scene;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.http.bean.scene.Scene;
import com.comslin.ezhome.oriUi.http.bean.scene.SceneTaskList;

/**
 * Created by linchaoer@qq.com on 2017/8/15.
 */

public class SceneManualInfoActivity extends BaseActivity implements View.OnClickListener {
    Scene scene;
    private TextView mSceneManualInfoName;
    private TextView mSceneManualInfoDesc;
    private TextView mSceneManualInfoTaskTxt;
    private LinearLayout mSceneManualInfoTask;
    private Button mSceneManualInfoExecuteBtn;
    private LinearLayout mSceneManualInfoLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.scene_manual_info_layout, topContentView);
        initIntent();
        initView();
        initTextContent();
    }

    private void initIntent() {
        scene = getIntent().getParcelableExtra("scene");

    }

    private void initView() {
        mSceneManualInfoName = (TextView) findViewById(R.id.scene_manual_info_name);
        mSceneManualInfoDesc = (TextView) findViewById(R.id.scene_manual_info_desc);
        mSceneManualInfoTaskTxt = (TextView) findViewById(R.id.scene_manual_info_task_txt);
        mSceneManualInfoTask = (LinearLayout) findViewById(R.id.scene_manual_info_task);
        mSceneManualInfoExecuteBtn = (Button) findViewById(R.id.scene_manual_info_execute_btn);
        mSceneManualInfoExecuteBtn.setOnClickListener(this);
        mSceneManualInfoLayout = (LinearLayout) findViewById(R.id.scene_manual_info_layout);
    }
    private void initTextContent(){
        mSceneManualInfoName.setText(scene.getSceneName());
        mSceneManualInfoDesc.setText(scene.getDescription());
        StringBuilder sb = new StringBuilder();
        for (SceneTaskList sceneTaskList:scene.getTaskList()){
            sb.append(sceneTaskList.getAction());
            sb.append("&");
        }
        if (scene.getTaskList().length>0){
            sb.deleteCharAt(sb.length()-1);
        }
        mSceneManualInfoTaskTxt.setText(sb.toString());
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scene_manual_info_execute_btn:
                break;
        }
    }
}
