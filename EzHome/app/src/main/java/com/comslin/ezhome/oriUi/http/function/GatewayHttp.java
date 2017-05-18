package com.comslin.ezhome.oriUi.http.function;

import com.comslin.ezhome.oriUi.http.bean.gateway.AddRequest;
import com.comslin.ezhome.oriUi.http.bean.gateway.GateWayShareingId;
import com.comslin.ezhome.oriUi.http.bean.gateway.GatewayId;
import com.comslin.ezhome.oriUi.http.bean.gateway.ShareRequest;
import com.comslin.ezhome.oriUi.http.bean.gateway.Unbind;
import com.comslin.ezhome.oriUi.http.bean.gateway.UpdateRequest;
import com.zhy.http.okhttp.request.RequestCall;

import static com.comslin.ezhome.oriUi.constant.HttpConstant.URL;

/**
 * Created by linChao on 2017-04-25.
 */

public class GatewayHttp extends BaseHttpFunc {
    private static final String ADD = URL + "/api/gateway/add";
    private static final String CANCEL_SHARING = URL + "/api/gateway/cancelSharing";
    private static final String CONFIRM_SHARING = URL + "/api/gateway/confirmSharing";
    private static final String DELETE = URL + "/api/gateway/delete";
    private static final String LIST = URL + "/api/gateway/list";
    private static final String LIST_MY = URL + "/api/gateway/listMy";
    private static final String LIST_SHARING = URL + "/api/gateway/listSharing";
    private static final String SHARE = URL + "/api/gateway/share";
    private static final String UNBIND = URL + "/api/gateway/unbind";
    private static final String UPDATE = URL + "/api/gateway/update";


    public static RequestCall Add(AddRequest rq) {
        return getTokenBuilder(ADD, rq);
    }

    public static RequestCall cancelSharing(GateWayShareingId rq) {
        return getTokenBuilder(CANCEL_SHARING, rq);
    }

    public static RequestCall confirmSharing(GateWayShareingId rq) {
        return getTokenBuilder(CONFIRM_SHARING, rq);
    }

    public static RequestCall delete(GatewayId rq) {
        return getTokenBuilder(DELETE, rq);
    }

    public static RequestCall list() {
        return getTokenBuilder(LIST);
    }

    public static RequestCall listMy() {
        return getTokenBuilder(LIST_MY);
    }

    public static RequestCall listSharing() {
        return getTokenBuilder(LIST_SHARING);
    }

    public static RequestCall share(ShareRequest rq) {
        return getTokenBuilder(SHARE, rq);
    }

    public static RequestCall UNBIND(Unbind rq) {
        return getTokenBuilder(UNBIND, rq);
    }

    public static RequestCall UPDATE(UpdateRequest rq) {
        return getTokenBuilder(UPDATE, rq);
    }



}
