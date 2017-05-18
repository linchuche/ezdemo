package com.comslin.ezhome.oriUi.http.bean.room;

public class RoomUpdate {
    private int newRoomTypeId;
    private String newName;
    private int roomId;

    public int getNewRoomTypeId() {
        return this.newRoomTypeId;
    }

    public void setNewRoomTypeId(int newRoomTypeId) {
        this.newRoomTypeId = newRoomTypeId;
    }

    public String getNewName() {
        return this.newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public int getRoomId() {
        return this.roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
