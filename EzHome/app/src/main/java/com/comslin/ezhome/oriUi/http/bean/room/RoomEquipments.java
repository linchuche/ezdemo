package com.comslin.ezhome.oriUi.http.bean.room;

import android.os.Parcel;
import android.os.Parcelable;

public class RoomEquipments implements Parcelable {
    private String subTypeName;
    private String typeName;
    private String equipmentName;
    private int typeId;
    private int subTypeId;
    private int slotNo;
    private int equipmentId;
    private String status;

    public String getSubTypeName() {
        return this.subTypeName;
    }

    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getEquipmentName() {
        return this.equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getTypeId() {
        return this.typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getSubTypeId() {
        return this.subTypeId;
    }

    public void setSubTypeId(int subTypeId) {
        this.subTypeId = subTypeId;
    }

    public int getSlotNo() {
        return this.slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public int getEquipmentId() {
        return this.equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.subTypeName);
        dest.writeString(this.typeName);
        dest.writeString(this.equipmentName);
        dest.writeInt(this.typeId);
        dest.writeInt(this.subTypeId);
        dest.writeInt(this.slotNo);
        dest.writeInt(this.equipmentId);
        dest.writeString(this.status);
    }

    public RoomEquipments() {
    }

    protected RoomEquipments(Parcel in) {
        this.subTypeName = in.readString();
        this.typeName = in.readString();
        this.equipmentName = in.readString();
        this.typeId = in.readInt();
        this.subTypeId = in.readInt();
        this.slotNo = in.readInt();
        this.equipmentId = in.readInt();
        this.status = in.readString();
    }

    public static final Parcelable.Creator<RoomEquipments> CREATOR = new Parcelable.Creator<RoomEquipments>() {
        @Override
        public RoomEquipments createFromParcel(Parcel source) {
            return new RoomEquipments(source);
        }

        @Override
        public RoomEquipments[] newArray(int size) {
            return new RoomEquipments[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEquipments that = (RoomEquipments) o;

        if (typeId != that.typeId) return false;
        if (subTypeId != that.subTypeId) return false;
        if (slotNo != that.slotNo) return false;
        if (equipmentId != that.equipmentId) return false;
        if (subTypeName != null ? !subTypeName.equals(that.subTypeName) : that.subTypeName != null)
            return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null)
            return false;
        if (equipmentName != null ? !equipmentName.equals(that.equipmentName) : that.equipmentName != null)
            return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = subTypeName != null ? subTypeName.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (equipmentName != null ? equipmentName.hashCode() : 0);
        result = 31 * result + typeId;
        result = 31 * result + subTypeId;
        result = 31 * result + slotNo;
        result = 31 * result + equipmentId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
