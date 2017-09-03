package com.comslin.ezhome.oriUi.http;



import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.Callback;

import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Response;


public abstract class ResultCallBack<T> extends Callback<HttpResultBean<T>> {
    private static final String TAG = ResultCallBack.class.getName();
    private Class<T> mClass ;
    public ResultCallBack(Class<T> mClass) {
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
        JsonObject jsonObject = new JsonParser().parse(body).getAsJsonObject();
        Gson gson = new Gson() ;
        Type jsonType = new TypeToken<HttpResultBean>(){}.getType();
        HttpResultBean<T> requestBean = gson.fromJson(body ,jsonType);
        if(requestBean.getCode() == 200 && mClass != null){
            JsonObject dataJson = jsonObject.getAsJsonObject("result") ;
            T t =new Gson().fromJson(dataJson,mClass);
            requestBean.setResult(t);
        }
        return requestBean ;
    }
}
