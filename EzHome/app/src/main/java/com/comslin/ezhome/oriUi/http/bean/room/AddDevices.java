package com.comslin.ezhome.oriUi.http.bean.room;

public class AddDevices {
    private int[] deviceIds;
    private int roomId;

    public int[] getDeviceIds() {
        return this.deviceIds;
    }

    public void setDeviceIds(int[] deviceIds) {
        this.deviceIds = deviceIds;
    }

    public int getRoomId() {
        return this.roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
