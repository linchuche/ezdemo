package com.comslin.ezhome.oriUi.http.bean.devices;

import android.os.Parcel;

import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;

public class Device implements AsymmetricItem {
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

    @Override
    public int getColumnSpan() {
        return 1;
    }

    @Override
    public int getRowSpan() {
        return 1;
    }



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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.deviceAdapterId);
        dest.writeInt(this.deviceTypeId);
        dest.writeString(this.currentStatus);
        dest.writeString(this.name);
        dest.writeString(this.deviceTypeName);
        dest.writeString(this.deviceSubTypeName);
        dest.writeInt(this.id);
        dest.writeInt(this.deviceSubTypeId);
        dest.writeInt(this.slotNo);
        dest.writeInt(this.userId);
        dest.writeInt(this.gatewayId);
    }

    public Device() {
    }

    protected Device(Parcel in) {
        this.deviceAdapterId = in.readInt();
        this.deviceTypeId = in.readInt();
        this.currentStatus = in.readString();
        this.name = in.readString();
        this.deviceTypeName = in.readString();
        this.deviceSubTypeName = in.readString();
        this.id = in.readInt();
        this.deviceSubTypeId = in.readInt();
        this.slotNo = in.readInt();
        this.userId = in.readInt();
        this.gatewayId = in.readInt();
    }

    public static final Creator<Device> CREATOR = new Creator<Device>() {
        @Override
        public Device createFromParcel(Parcel source) {
            return new Device(source);
        }

        @Override
        public Device[] newArray(int size) {
            return new Device[size];
        }
    };
}
