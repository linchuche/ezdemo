package com.comslin.ezhome.oriUi;

import com.comslin.ezhome.oriUi.http.bean.room.RoomEquipments;
import com.comslin.ezhome.oriUi.http.bean.scene.SceneTaskList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linChao on 2017-08-31.
 */

public class SceneDataCenter {
    public static List<RoomEquipments> roomEquipmentsList = new ArrayList<>();
    public static List<SceneTaskList> sceneTaskList = new ArrayList<>();
    public static void clearAll(){
        roomEquipmentsList.clear();
        sceneTaskList.clear();
    }
}
