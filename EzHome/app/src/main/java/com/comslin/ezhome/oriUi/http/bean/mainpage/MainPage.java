package com.comslin.ezhome.oriUi.http.bean.mainpage;

import com.comslin.ezhome.oriUi.http.bean.room.RoomEquipments;
import com.comslin.ezhome.oriUi.http.bean.scene.Scene;
import com.google.gson.annotations.SerializedName;

public class MainPage {
    public String updateTime;
    public int userId;
    @SerializedName("MainPageResultEquipment1")
    public RoomEquipments equipment1;
    @SerializedName("MainPageResultEquipment2")
    public RoomEquipments equipment2;
    @SerializedName("MainPageResultEquipment3")
    public RoomEquipments equipment3;
    @SerializedName("MainPageResultSensor1")
    public Sensor sensor1;
    @SerializedName("MainPageResultSensor2")
    public Sensor sensor2;
    @SerializedName("MainPageResultSensor3")
    public Sensor sensor3;
    @SerializedName("MainPageResultSensor4")
    public Sensor sensor4;
    @SerializedName("MainPageResultSensor5")
    public Sensor sensor5;
    @SerializedName("MainPageResultManualScene1")
    public Scene manualScene1;
    @SerializedName("MainPageResultManualScene2")
    public Scene manualScene2;
    @SerializedName("MainPageResultManualScene3")
    public Scene manualScene3;
    public int id;
    
}
