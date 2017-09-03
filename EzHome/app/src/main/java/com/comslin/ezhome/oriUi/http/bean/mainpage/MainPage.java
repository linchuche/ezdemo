package com.comslin.ezhome.oriUi.http.bean.mainpage;

import com.comslin.ezhome.oriUi.http.bean.room.RoomEquipments;
import com.comslin.ezhome.oriUi.http.bean.scene.Scene;
import com.google.gson.annotations.SerializedName;

public class MainPage {
    private String updateTime;
    private int userId;
    @SerializedName("MainPageResultEquipment1")
    private RoomEquipments equipment1;
    @SerializedName("MainPageResultEquipment2")
    private RoomEquipments equipment2;
    @SerializedName("MainPageResultEquipment3")
    private RoomEquipments equipment3;
    @SerializedName("MainPageResultSensor1")
    private Sensor sensor1;
    @SerializedName("MainPageResultSensor2")
    private Sensor sensor2;
    @SerializedName("MainPageResultSensor3")
    private Sensor sensor3;
    @SerializedName("MainPageResultSensor4")
    private Sensor sensor4;
    @SerializedName("MainPageResultSensor5")
    private Sensor sensor5;
    @SerializedName("MainPageResultManualScene1")
    private Scene manualScene1;
    @SerializedName("MainPageResultManualScene2")
    private Scene manualScene2;
    @SerializedName("MainPageResultManualScene3")
    private Scene manualScene3;
    private int id;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public RoomEquipments getEquipment1() {
        return equipment1;
    }

    public void setEquipment1(RoomEquipments equipment1) {
        this.equipment1 = equipment1;
    }

    public RoomEquipments getEquipment2() {
        return equipment2;
    }

    public void setEquipment2(RoomEquipments equipment2) {
        this.equipment2 = equipment2;
    }

    public RoomEquipments getEquipment3() {
        return equipment3;
    }

    public void setEquipment3(RoomEquipments equipment3) {
        this.equipment3 = equipment3;
    }

    public Sensor getSensor1() {
        return sensor1;
    }

    public void setSensor1(Sensor sensor1) {
        this.sensor1 = sensor1;
    }

    public Sensor getSensor2() {
        return sensor2;
    }

    public void setSensor2(Sensor sensor2) {
        this.sensor2 = sensor2;
    }

    public Sensor getSensor3() {
        return sensor3;
    }

    public void setSensor3(Sensor sensor3) {
        this.sensor3 = sensor3;
    }

    public Sensor getSensor4() {
        return sensor4;
    }

    public void setSensor4(Sensor sensor4) {
        this.sensor4 = sensor4;
    }

    public Sensor getSensor5() {
        return sensor5;
    }

    public void setSensor5(Sensor sensor5) {
        this.sensor5 = sensor5;
    }

    public Scene getManualScene1() {
        return manualScene1;
    }

    public void setManualScene1(Scene manualScene1) {
        this.manualScene1 = manualScene1;
    }

    public Scene getManualScene2() {
        return manualScene2;
    }

    public void setManualScene2(Scene manualScene2) {
        this.manualScene2 = manualScene2;
    }

    public Scene getManualScene3() {
        return manualScene3;
    }

    public void setManualScene3(Scene manualScene3) {
        this.manualScene3 = manualScene3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
