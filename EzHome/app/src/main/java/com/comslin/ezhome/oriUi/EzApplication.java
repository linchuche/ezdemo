package com.comslin.ezhome.oriUi;

import android.app.Application;

import com.comslin.ezhome.oriUi.manager.SpManager;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by linChao on 2017-04-22.
 */

public class EzApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SpManager.init(this);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
