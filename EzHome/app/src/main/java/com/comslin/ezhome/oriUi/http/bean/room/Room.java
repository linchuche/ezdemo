package com.comslin.ezhome.oriUi.http.bean.room;

import android.os.Parcel;
import android.os.Parcelable;

public class Room implements Parcelable {
    private RoomEquipments[] equipments;
    private String typeName;
    private int typeId;
    private int roomId;
    private String roomName;

    public RoomEquipments[] getEquipments() {
        return this.equipments;
    }

    public void setEquipments(RoomEquipments[] equipments) {
        this.equipments = equipments;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getTypeId() {
        return this.typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getRoomId() {
        return this.roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(this.equipments, flags);
        dest.writeString(this.typeName);
        dest.writeInt(this.typeId);
        dest.writeInt(this.roomId);
        dest.writeString(this.roomName);
    }

    public Room() {
    }

    protected Room(Parcel in) {
        this.equipments = in.createTypedArray(RoomEquipments.CREATOR);
        this.typeName = in.readString();
        this.typeId = in.readInt();
        this.roomId = in.readInt();
        this.roomName = in.readString();
    }

    public static final Parcelable.Creator<Room> CREATOR = new Parcelable.Creator<Room>() {
        @Override
        public Room createFromParcel(Parcel source) {
            return new Room(source);
        }

        @Override
        public Room[] newArray(int size) {
            return new Room[size];
        }
    };
}
