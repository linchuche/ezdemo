package com.comslin.ezhome.oriUi.http.function;


import android.util.Log;

import com.comslin.ezhome.oriUi.http.HttpResultBean;
import com.comslin.ezhome.oriUi.http.ResultCallBack;
import com.comslin.ezhome.oriUi.http.RigisterRequest;
import com.comslin.ezhome.oriUi.http.bean.user.LoginRequest;
import com.comslin.ezhome.oriUi.http.bean.user.SendSmsCode;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.request.RequestCall;

import okhttp3.MediaType;

import static com.comslin.ezhome.oriUi.constant.HttpConstant.URL;


/**
 * Created by linChao on 2017-04-17.
 */

public class UserHttp extends BaseHttpFunc{

    private static String LOGIN = URL + "/api/user/login";//1
    private static String LOGOUT = URL + "/api/user/logout";//1
    private static String RESETPW= URL + "/api/user/resetPassword";//
    private static String SENDSMS = URL + "/api/user/sendVerificationCode";//
    private static String RIGISTER= URL + "/api/user/register";//

    private static String TAG = "HttpUtils";


    public static RequestCall login(LoginRequest loginRequest) {
        String params = new Gson().toJson(loginRequest);
        return OkHttpUtils.postString()
                .url(LOGIN)
                .mediaType(MediaType.parse("application/json"))
                .content(params)
                .build();
    }

    public static void loginOut(){
        OkHttpUtils.post()
                .url(LOGOUT)
                .addHeader("Access-Token",token)
                .build()
                .execute(new ResultCallBack<Object>(Object.class) {
                    @Override
                    public void onResponse(HttpResultBean<Object> response, int id) {
                        Log.d(TAG, "onResponse: "+response.getDesc());
                    }
                });
    }
    public static RequestCall reSetPassWord(RigisterRequest rp){
        String params = new Gson().toJson(rp);
        return OkHttpUtils.postString()
                .url(RESETPW)
                .mediaType(MediaType.parse("application/json"))
                .content(params)
                .build();
    }
    public static RequestCall sendSms(SendSmsCode loginRequest) {
        String params = new Gson().toJson(loginRequest);
        return OkHttpUtils.postString()
                .url(SENDSMS)
                .mediaType(MediaType.parse("application/json"))
                .content(params)
                .build();
    }
    public static RequestCall rigister(RigisterRequest loginRequest) {
        String params = new Gson().toJson(loginRequest);
        return OkHttpUtils.postString()
                .url(RIGISTER)
                .mediaType(MediaType.parse("application/json"))
                .content(params)
                .build();
    }
}
