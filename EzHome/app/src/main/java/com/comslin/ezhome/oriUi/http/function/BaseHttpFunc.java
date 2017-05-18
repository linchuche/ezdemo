package com.comslin.ezhome.oriUi.http.function;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.request.RequestCall;

import okhttp3.MediaType;

/**
 * Created by linChao on 2017-04-25.
 */

public class BaseHttpFunc {

    public static String token;
    private Object object=new Object();
    public static RequestCall getTokenBuilder(String url, Object o) {
        return OkHttpUtils.postString()
                .url(url)
                .addHeader("Access-Token", token)
                .mediaType(MediaType.parse("application/json"))
                .content(new Gson().toJson(o))
                .build();
    }

    public static RequestCall getTokenBuilder(String url) {
        return OkHttpUtils.postString()
                .url(url)
                .addHeader("Access-Token", token)
                .mediaType(MediaType.parse("application/json"))
                .content(new Gson().toJson(new Object()))
                .build();
    }

}
