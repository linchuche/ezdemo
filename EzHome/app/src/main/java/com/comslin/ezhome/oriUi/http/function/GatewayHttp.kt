package com.comslin.ezhome.oriUi.http.function

import com.comslin.ezhome.oriUi.http.bean.gateway.AddRequest
import com.comslin.ezhome.oriUi.http.bean.gateway.GateWayShareingId
import com.comslin.ezhome.oriUi.http.bean.gateway.GatewayId
import com.comslin.ezhome.oriUi.http.bean.gateway.ShareRequest
import com.comslin.ezhome.oriUi.http.bean.gateway.Unbind
import com.comslin.ezhome.oriUi.http.bean.gateway.UpdateRequest
import com.comslin.ezhome.oriUi.http.function.HttpConstant.EzHomeHost
import com.zhy.http.okhttp.request.RequestCall

/**
 * Created by linChao on 2017-04-25.
 */

class GatewayHttp : BaseHttpFunc() {
    companion object {
        private val ADD = EzHomeHost + "/api/gateway/add"
        private val CANCEL_SHARING = EzHomeHost + "/api/gateway/cancelSharing"
        private val CONFIRM_SHARING = EzHomeHost + "/api/gateway/confirmSharing"
        private val DELETE = EzHomeHost + "/api/gateway/delete"
        private val LIST = EzHomeHost + "/api/gateway/list"
        private val LIST_MY = EzHomeHost + "/api/gateway/listMy"
        private val LIST_SHARING = EzHomeHost + "/api/gateway/listSharing"
        private val SHARE = EzHomeHost + "/api/gateway/share"
        private val UNBIND = EzHomeHost + "/api/gateway/unbind"
        private val UPDATE = EzHomeHost + "/api/gateway/update"


        fun Add(rq: AddRequest): RequestCall {
            return BaseHttpFunc.getTokenBuilder(ADD, rq)
        }

        fun cancelSharing(rq: GateWayShareingId): RequestCall {
            return BaseHttpFunc.getTokenBuilder(CANCEL_SHARING, rq)
        }

        fun confirmSharing(rq: GateWayShareingId): RequestCall {
            return BaseHttpFunc.getTokenBuilder(CONFIRM_SHARING, rq)
        }

        fun delete(rq: GatewayId): RequestCall {
            return BaseHttpFunc.getTokenBuilder(DELETE, rq)
        }

        fun list(): RequestCall {
            return BaseHttpFunc.getTokenBuilder(LIST)
        }

        fun listMy(): RequestCall {
            return BaseHttpFunc.getTokenBuilder(LIST_MY)
        }

        fun listSharing(): RequestCall {
            return BaseHttpFunc.getTokenBuilder(LIST_SHARING)
        }

        fun share(rq: ShareRequest): RequestCall {
            return BaseHttpFunc.getTokenBuilder(SHARE, rq)
        }

        fun UNBIND(rq: Unbind): RequestCall {
            return BaseHttpFunc.getTokenBuilder(UNBIND, rq)
        }

        fun UPDATE(rq: UpdateRequest): RequestCall {
            return BaseHttpFunc.getTokenBuilder(UPDATE, rq)
        }
    }


}
