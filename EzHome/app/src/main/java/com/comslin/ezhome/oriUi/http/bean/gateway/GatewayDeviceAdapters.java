package com.comslin.ezhome.oriUi.http.bean.gateway;

import com.comslin.ezhome.oriUi.http.bean.devices.Device;

public class GatewayDeviceAdapters {
    private int deviceAdapterTypeId;
    private Device[] devices;
    private String name;
    private String deviceAdapterTypeName;
    private int id;

    public int getDeviceAdapterTypeId() {
        return this.deviceAdapterTypeId;
    }

    public void setDeviceAdapterTypeId(int deviceAdapterTypeId) {
        this.deviceAdapterTypeId = deviceAdapterTypeId;
    }

    public Device[] getDevices() {
        return this.devices;
    }

    public void setDevices(Device[] devices) {
        this.devices = devices;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceAdapterTypeName() {
        return this.deviceAdapterTypeName;
    }

    public void setDeviceAdapterTypeName(String deviceAdapterTypeName) {
        this.deviceAdapterTypeName = deviceAdapterTypeName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
