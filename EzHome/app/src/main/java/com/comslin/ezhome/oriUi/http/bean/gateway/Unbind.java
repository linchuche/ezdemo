package com.comslin.ezhome.oriUi.http.bean.gateway;

public class Unbind {
    private UnbindResult result;
    private int code;
    private int gatewayId;
    private String desc;

    public UnbindResult getResult() {
        return this.result;
    }

    public void setResult(UnbindResult result) {
        this.result = result;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getGatewayId() {
        return this.gatewayId;
    }

    public void setGatewayId(int gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
