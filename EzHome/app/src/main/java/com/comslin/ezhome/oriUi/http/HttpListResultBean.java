package com.comslin.ezhome.oriUi.http;

import java.util.List;

/**
 * Created by CQQ on 2016/8/9.
 */
public class HttpListResultBean<T> {
    private int code;
    private String msg;
    private List<T> data ;
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpResultBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}

