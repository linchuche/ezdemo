package com.comslin.ezhome.oriUi.http.bean.gateway;

public class ShareRequest {
    private String appellation;
    private int gatewayId;
    private String sharedPhoneNumber;

    public String getAppellation() {
        return this.appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public int getGatewayId() {
        return this.gatewayId;
    }

    public void setGatewayId(int gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getSharedPhoneNumber() {
        return this.sharedPhoneNumber;
    }

    public void setSharedPhoneNumber(String sharedPhoneNumber) {
        this.sharedPhoneNumber = sharedPhoneNumber;
    }
}
