package com.comslin.ezhome.oriUi.http.bean.room;

import com.comslin.ezhome.oriUi.http.bean.devices.Device;

public class Room {
    private Device[] devices;
    private String name;
    private String roomTypeName;
    private int id;
    private int roomTypeId;

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

    public String getRoomTypeName() {
        return this.roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomTypeId() {
        return this.roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
}
