package com.comslin.ezhome.oriUi.http.bean.devices;

public class Device {
    private int deviceAdapterId;
    private int deviceTypeId;
    private String currentStatus;
    private String name;
    private String deviceTypeName;
    private String deviceSubTypeName;
    private int id;
    private int deviceSubTypeId;
    private int slotNo;
    private int userId;
    private int gatewayId;

    public int getDeviceAdapterId() {
        return this.deviceAdapterId;
    }

    public void setDeviceAdapterId(int deviceAdapterId) {
        this.deviceAdapterId = deviceAdapterId;
    }

    public int getDeviceTypeId() {
        return this.deviceTypeId;
    }

    public void setDeviceTypeId(int deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getCurrentStatus() {
        return this.currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceTypeName() {
        return this.deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceSubTypeName() {
        return this.deviceSubTypeName;
    }

    public void setDeviceSubTypeName(String deviceSubTypeName) {
        this.deviceSubTypeName = deviceSubTypeName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeviceSubTypeId() {
        return this.deviceSubTypeId;
    }

    public void setDeviceSubTypeId(int deviceSubTypeId) {
        this.deviceSubTypeId = deviceSubTypeId;
    }

    public int getSlotNo() {
        return this.slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGatewayId() {
        return this.gatewayId;
    }

    public void setGatewayId(int gatewayId) {
        this.gatewayId = gatewayId;
    }
}
