package com.comslin.ezhome.oriUi.http.function;

import com.comslin.ezhome.oriUi.http.bean.devices.DeviceAdapterId;
import com.comslin.ezhome.oriUi.http.bean.devices.DeviceTypeId;
import com.comslin.ezhome.oriUi.http.bean.gateway.GatewayId;
import com.zhy.http.okhttp.request.RequestCall;

/**
 * Created by linChao on 2017-04-25.
 */

public class DeviceHttp extends BaseHttpFunc {
    private final static String DELETE = "/api/device/delete";
    private final static String GET_BY_ADAPTER = "/api/device/getByAdapter";
    private final static String GET_BY_GATEWAY = "/api/device/getByGateway";
    private final static String GET_BY_TYPE = "/api/device/getByType";

    /* 删除设备*/
            /*获取设备信息*/
            /*获取网关所有设备信息*/
            /*获取某种设备类型所有设备*/
    public static RequestCall delete(DeviceAdapterId rq) {
        return getTokenBuilder(DELETE, rq);
    }

    public static RequestCall getByAdapter(DeviceAdapterId rq) {
        return getTokenBuilder(GET_BY_ADAPTER, rq);
    }

    public static RequestCall getByGateway(GatewayId rq) {
        return getTokenBuilder(GET_BY_GATEWAY, rq);
    }

    public static RequestCall getByType(DeviceTypeId rq) {
        return getTokenBuilder(GET_BY_TYPE, rq);
    }

}
