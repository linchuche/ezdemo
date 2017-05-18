package com.comslin.ezhome.oriUi.http.bean.room;

public class RoomAdd {
    private String name;
    private int roomTypeId;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomTypeId() {
        return this.roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public RoomAdd(String name, int roomTypeId) {
        this.name = name;
        this.roomTypeId = roomTypeId;
    }
}
