package com.comslin.ezhome.oriUi.http.bean.scene;

import android.os.Parcel;
import android.os.Parcelable;

public class SceneConditionList implements Parcelable {
    private String conditionExp;
    private String conditionType;
    private int id;
    private int equipmentId;

    public String getConditionExp() {
        return this.conditionExp;
    }

    public void setConditionExp(String conditionExp) {
        this.conditionExp = conditionExp;
    }

    public String getConditionType() {
        return this.conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquipmentId() {
        return this.equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.conditionExp);
        dest.writeString(this.conditionType);
        dest.writeInt(this.id);
        dest.writeInt(this.equipmentId);
    }

    public SceneConditionList() {
    }

    protected SceneConditionList(Parcel in) {
        this.conditionExp = in.readString();
        this.conditionType = in.readString();
        this.id = in.readInt();
        this.equipmentId = in.readInt();
    }

    public static final Parcelable.Creator<SceneConditionList> CREATOR = new Parcelable.Creator<SceneConditionList>() {
        @Override
        public SceneConditionList createFromParcel(Parcel source) {
            return new SceneConditionList(source);
        }

        @Override
        public SceneConditionList[] newArray(int size) {
            return new SceneConditionList[size];
        }
    };
}
