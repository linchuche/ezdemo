package com.comslin.ezhome.oriUi

import android.app.Application

import com.comslin.ezhome.oriUi.manager.SpManager
import com.uuzuche.lib_zxing.activity.ZXingLibrary
import com.zhy.http.okhttp.OkHttpUtils

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient

/**
 * Created by linChao on 2017-04-22.
 */

class EzApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SpManager.init(this)
        val okHttpClient = OkHttpClient.Builder()
                //                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build()

        OkHttpUtils.initClient(okHttpClient)
        ZXingLibrary.initDisplayOpinion(this)
    }
}
