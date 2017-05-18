package com.comslin.ezhome.oriUi.http.function;

import com.comslin.ezhome.oriUi.http.bean.room.AddDevices;
import com.comslin.ezhome.oriUi.http.bean.room.DeleteDevice;
import com.comslin.ezhome.oriUi.http.bean.room.RoomAdd;
import com.comslin.ezhome.oriUi.http.bean.room.RoomUpdate;
import com.zhy.http.okhttp.request.RequestCall;

import static com.comslin.ezhome.oriUi.constant.HttpConstant.URL;

/**
 * Created by linChao on 2017-04-25.
 */

public class RoomHttp extends BaseHttpFunc {
    private static final String ADD_ROOM = URL + "/api/room/add";
    private static final String ADD_DEVICE = URL + "/api/room/addDevice";
    private static final String DELETE = URL + "/api/room/delete";
    private static final String DELETE_DEVICE = URL + "/api/room/deleteDevice";
    private static final String LIST = URL + "/api/room/list";
    private static final String UPDATE = URL + "/api/room/update";

    public static RequestCall addRoom(RoomAdd rq) {
        return getTokenBuilder(ADD_ROOM, rq);
    }

    public static RequestCall addDevice(AddDevices rq) {
        return getTokenBuilder(ADD_DEVICE, rq);
    }

    public static RequestCall delete() {
        return getTokenBuilder(DELETE, new Object());
    }

    public static RequestCall delete_device(DeleteDevice rq) {
        return getTokenBuilder(DELETE_DEVICE, rq);
    }

    public static RequestCall list() {
        return getTokenBuilder(LIST, new Object());
    }

    public static RequestCall update(RoomUpdate rq) {
        return getTokenBuilder(UPDATE, rq);
    }


}
