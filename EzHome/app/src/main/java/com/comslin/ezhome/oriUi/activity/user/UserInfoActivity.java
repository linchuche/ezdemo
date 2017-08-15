package com.comslin.ezhome.oriUi.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.activity.LoginActivity;
import com.comslin.ezhome.oriUi.activity.MainPageActivity;

/**
 * Created by linchaoer@qq.com on 2017/8/15.
 */

public class UserInfoActivity extends BaseActivity implements View.OnClickListener {
    private TextView mUserInfoAccountTitle;
    private TextView mUserInfoAccountTxtvew;
    private TextView mUserInfoCreateTimeTitle;
    private TextView mUserInfoCreateTimeTxtvew;
    private TextView mUserInfoPasswordTitle;
    private ImageView mUserInfoPasswordTxtvew;
    private LinearLayout mUserInfoPasswordLayout;
    private Button mUserInfoExitBtn;
    private Button mUserInfoLogoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.user_info_layout, topContentView);
        setContentView(R.layout.user_info_layout);
        initView();
    }

    private void initView() {
        mUserInfoAccountTitle = (TextView) findViewById(R.id.user_info_account_title);
        mUserInfoAccountTxtvew = (TextView) findViewById(R.id.user_info_account_txtvew);
        mUserInfoCreateTimeTitle = (TextView) findViewById(R.id.user_info_create_time_title);
        mUserInfoCreateTimeTxtvew = (TextView) findViewById(R.id.user_info_create_time_txtvew);
        mUserInfoPasswordTitle = (TextView) findViewById(R.id.user_info_password_title);
        mUserInfoPasswordTxtvew = (ImageView) findViewById(R.id.user_info_password_txtvew);
        mUserInfoPasswordLayout = (LinearLayout) findViewById(R.id.user_info_password_layout);
        mUserInfoExitBtn = (Button) findViewById(R.id.user_info_exit_btn);
        mUserInfoExitBtn.setOnClickListener(this);
        mUserInfoLogoutBtn = (Button) findViewById(R.id.user_info_logout_btn);
        mUserInfoLogoutBtn.setOnClickListener(this);

        mUserInfoAccountTxtvew.setText(UserInfo.phoneNumber);
        mUserInfoCreateTimeTxtvew.setText(UserInfo.registerTime);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_info_exit_btn:
                System.exit(0);
                break;
            case R.id.user_info_logout_btn:
                Intent intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
                UserInfo.clear();
                finish();
                if (getRunningActivity()!=null){
                    getRunningActivity().finish();}
                break;
        }
    }
}
