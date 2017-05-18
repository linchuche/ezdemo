package com.comslin.ezhome.oriUi.http;

/**
 * Created by CQQ on 2016/8/9.
 */
public class HttpResultBean<T> {
    private int code;
    private String desc;
    private T result ;
    private boolean success;

    @Override
    public String toString() {
        return "HttpResultBean{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                ", result=" + result +
                ", success=" + success +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

