package com.comslin.ezhome.oriUi.http;



import android.util.Log;

import com.comslin.ezhome.oriUi.http.bean.mainpage.MainPage;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.Callback;

import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Response;


public abstract class TypeCallBack<T> extends Callback<HttpResultBean<T>> {
    private static final String TAG = TypeCallBack.class.getName();
    private Class<T> mClass ;
    public TypeCallBack(Class<T> mClass) {
        this.mClass = mClass ;
    }

    @Override
    public void onError(Call call, Exception e, int id) {
//        Log.i(TAG, "parseNetworkResponse body: "+e.toString());
    }

    @Override
    public HttpResultBean<T> parseNetworkResponse(Response response, int id) throws Exception {
        String body = response.body().string() ;
        Log.i(TAG, "parseNetworkResponse body: "+body);
        HttpResultBean<T> httpResultBean = new Gson().fromJson(body,
                new TypeToken<HttpResultBean<MainPage>>(){}.getType());

        return httpResultBean ;
    }
}
