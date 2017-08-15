package com.comslin.ezhome.oriUi.http.bean.scene;

import android.os.Parcel;
import android.os.Parcelable;

public class SceneTaskList implements Parcelable {
    private int duration;
    private String action;
    private String beginTime;
    private int id;
    private int equipmentId;

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
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
        dest.writeInt(this.duration);
        dest.writeString(this.action);
        dest.writeString(this.beginTime);
        dest.writeInt(this.id);
        dest.writeInt(this.equipmentId);
    }

    public SceneTaskList() {
    }

    protected SceneTaskList(Parcel in) {
        this.duration = in.readInt();
        this.action = in.readString();
        this.beginTime = in.readString();
        this.id = in.readInt();
        this.equipmentId = in.readInt();
    }

    public static final Parcelable.Creator<SceneTaskList> CREATOR = new Parcelable.Creator<SceneTaskList>() {
        @Override
        public SceneTaskList createFromParcel(Parcel source) {
            return new SceneTaskList(source);
        }

        @Override
        public SceneTaskList[] newArray(int size) {
            return new SceneTaskList[size];
        }
    };
}
