package com.comslin.ezhome.oriUi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.http.HttpListResultBean;
import com.comslin.ezhome.oriUi.http.HttpResultBean;
import com.comslin.ezhome.oriUi.http.function.UserHttp;
import com.comslin.ezhome.oriUi.http.ListResultCallBack;
import com.comslin.ezhome.oriUi.http.ResultCallBack;
import com.comslin.ezhome.oriUi.http.RigisterRequest;
import com.comslin.ezhome.oriUi.http.bean.user.LoginRequest;
import com.comslin.ezhome.oriUi.http.bean.user.SendSmsCode;
import com.comslin.ezhome.oriUi.util.ToastUtil;
import com.comslin.ezhome.oriUi.widget.Anticlockwise;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

//import com.comslin.ezhome.oriUi.http.HttpUtils;

public class ForgetPassword extends AppCompatActivity implements View.OnClickListener {
    int type;//0:reg,1:fog
    private EditText mEdtGeg1;
    private EditText mEdtGeg2;
    private EditText mEdtGeg3;
    private EditText mEdtGeg4;
    /**
     * 获取验证码
     */
    private Button mBtnSms;
    /**
     * 提交
     */
    private Button mBtnComplete;
    /**
     * 使用已有账号登录
     */
    private TextView mTvExitAcount;
    /**
     * 获取验证码
     */
    private Anticlockwise mChrSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password_layout);
        if (getIntent().getStringExtra("type") != null) {
            type = 0;

        } else type = 1;
        initView();
        initActionBar();

    }

    private void initActionBar() {
        if (getActionBar() != null) {
            if (getIntent().getStringExtra("type") != null) {
                getActionBar().setTitle("注册账号");
            } else {
                getActionBar().setTitle("找回密码");
            }
        }
        if (getSupportActionBar() != null) {
            if (getIntent().getStringExtra("type") != null) {
                getSupportActionBar().setTitle("注册账号");
            } else
                getSupportActionBar().setTitle("找回密码");
        }
    }

    List<EditText> edtList = new ArrayList<>();

    private void initView() {
        String[] args = new String[]{"请输入手机号", "验证码", "请输入密码", "请再次输入密码"};


        mEdtGeg1 = (EditText) findViewById(R.id.edt_geg1);
        mEdtGeg2 = (EditText) findViewById(R.id.edt_geg2);
        mEdtGeg3 = (EditText) findViewById(R.id.edt_geg3);
        mEdtGeg4 = (EditText) findViewById(R.id.edt_geg4);

        edtList.add(mEdtGeg1);
        edtList.add(mEdtGeg2);
        edtList.add(mEdtGeg3);
        edtList.add(mEdtGeg4);

        for (int i = 0; i < edtList.size(); i++) {
            edtList.get(i).setHint(args[i]);
        }

        mBtnSms = (Button) findViewById(R.id.btn_sms);
        mBtnSms.setOnClickListener(this);
        mBtnComplete = (Button) findViewById(R.id.btn_complete);
        mBtnComplete.setOnClickListener(this);
        mTvExitAcount = (TextView) findViewById(R.id.tv_exit_acount);
        mTvExitAcount.setOnClickListener(this);
        mChrSms = (Anticlockwise) findViewById(R.id.chr_sms);
        mChrSms.initTime(60);
        mChrSms.setTimeFormat("重新获取ss秒");
        mChrSms.setOnTimeCompleteListener(new Anticlockwise.OnTimeCompleteListener() {
            @Override
            public void onTimeComplete() {
                enableSendSms();
            }
        });
    }

    ListResultCallBack<Object> listResultCallBack = new ListResultCallBack<Object>(Object.class) {
        @Override
        public void onError(Call call, Exception e, int id) {
            ToastUtil.showToast(ForgetPassword.this, e.getMessage());
        }

        @Override
        public void onResponse(HttpListResultBean response, int id) {
            ToastUtil.showToast(ForgetPassword.this, response.getMsg());
        }
    };

    private void enableSendSms() {
        mChrSms.stop();
        mChrSms.setVisibility(View.GONE);
        mBtnSms.setVisibility(View.VISIBLE);
//        mBtnSms.setBackgroundResource(R.color.blue);
    }

    private void startTimer() {
        mChrSms.setVisibility(View.VISIBLE);
        mChrSms.reStart();
        mBtnSms.setVisibility(View.GONE);
//        mBtnSms.setBackgroundColor(333333);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sms:
                if (TextUtils.isEmpty(edtList.get(0).getText().toString())) {
//                    ToastUtil.showToast(this, "手机号不能为空");
                    Toast.makeText(this, "请填写手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                startTimer();
                UserHttp.sendSms(new SendSmsCode(mEdtGeg1.getText().toString(),"REGISTER"))
                        .execute(new ResultCallBack<LoginRequest>(LoginRequest.class) {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                ToastUtil.showToast(ForgetPassword.this, e.getMessage());
                                enableSendSms();
                            }

                            @Override
                            public void onResponse(HttpResultBean<LoginRequest> response, int id) {
                                ToastUtil.showToast(ForgetPassword.this, response.getDesc());
                                if (response.getDesc().equals("成功")) {
                                    ToastUtil.showToast(ForgetPassword.this, "请查看手机验证码");
                                }
                                else {
                                    enableSendSms();
                                }
                            }
                        });
                break;
            case R.id.btn_complete:
                if (!edtList.get(3).getText().toString().equals(edtList.get(2).getText().toString())) {
                    ToastUtil.showToast(this, "两次密码不相同");
                    return;
                }
                RigisterRequest registerBean = new RigisterRequest();
                registerBean.setPhoneNumber(edtList.get(0).getText().toString());
                registerBean.setVerificationCode(edtList.get(1).getText().toString());
                registerBean.setPassword(edtList.get(2).getText().toString());
                registerBean.setNewPassword(edtList.get(2).getText().toString());
                if (type == 0)
                    UserHttp.rigister(new RigisterRequest()).execute(listResultCallBack);
                else
                    UserHttp.reSetPassWord(registerBean).execute(listResultCallBack);
                break;
            case R.id.tv_exit_acount:
                onBackPressed();
                break;
        }

    }


}
