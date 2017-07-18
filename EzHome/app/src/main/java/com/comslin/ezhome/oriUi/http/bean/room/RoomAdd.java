package com.comslin.ezhome.oriUi.http.bean.room;

public class RoomAdd {
    private String name;
    private String  roomType;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomTypeId() {
        return this.roomType;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomType = roomTypeId;
    }

    public RoomAdd(String name, String roomTypeId) {
        this.name = name;
        this.roomType = roomTypeId;
    }
}
