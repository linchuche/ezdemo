package com.comslin.ezhome.oriUi.http;


import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.Callback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;


/**
 * Created by CQQ on 2016/8/9.
 */
public abstract class ListResultCallBack<T> extends Callback<HttpListResultBean> {
    private static final String TAG = ListResultCallBack.class.getName();
    private Class<T> mClaa;

    private ListResultCallBack() {
    }

    public ListResultCallBack(Class<T> mClass) {
        this.mClaa = mClass;
    }

    @Override
    public HttpListResultBean parseNetworkResponse(Response response, int id) throws Exception {
        List<T> list = new ArrayList<>();
        String body = response.body().string();
        Log.i(TAG, "parseNetworkResponse body: " + body);
        JsonObject jsonObject = new JsonParser().parse(body).getAsJsonObject();
        Gson gson = new Gson();
        Type jsonType = new TypeToken<HttpListResultBean>() {
        }.getType();
        HttpListResultBean<T> requestBean = gson.fromJson(body, jsonType);
        if (requestBean.getCode() == 0) {
            try {
                JsonArray dataArray = jsonObject.getAsJsonArray("result");
                if (dataArray != null) {
                    for (JsonElement element : dataArray) {
                        list.add(new Gson().fromJson(element, mClaa));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            requestBean.setData(list);
        }
        return requestBean;

    }
}
