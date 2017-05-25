package com.comslin.ezhome.oriUi.http.function

import com.comslin.ezhome.oriUi.http.bean.room.AddDevices
import com.comslin.ezhome.oriUi.http.bean.room.DeleteDevice
import com.comslin.ezhome.oriUi.http.bean.room.RoomAdd
import com.comslin.ezhome.oriUi.http.bean.room.RoomUpdate
import com.comslin.ezhome.oriUi.http.function.HttpConstant.EzHomeHost
import com.zhy.http.okhttp.request.RequestCall

/**
 * Created by linChao on 2017-04-25.
 */

class RoomHttp : BaseHttpFunc() {
    companion object {
        private val ADD_ROOM = EzHomeHost + "/api/room/add"
        private val ADD_DEVICE = EzHomeHost + "/api/room/addDevice"
        private val DELETE = EzHomeHost + "/api/room/delete"
        private val DELETE_DEVICE = EzHomeHost + "/api/room/deleteDevice"
        private val LIST = EzHomeHost + "/api/room/list"
        private val UPDATE = EzHomeHost + "/api/room/update"

        fun addRoom(rq: RoomAdd): RequestCall {
            return BaseHttpFunc.getTokenBuilder(ADD_ROOM, rq)
        }

        fun addDevice(rq: AddDevices): RequestCall {
            return BaseHttpFunc.getTokenBuilder(ADD_DEVICE, rq)
        }

        fun delete(): RequestCall {
            return BaseHttpFunc.getTokenBuilder(DELETE, Any())
        }

        fun delete_device(rq: DeleteDevice): RequestCall {
            return BaseHttpFunc.getTokenBuilder(DELETE_DEVICE, rq)
        }

        fun list(): RequestCall {
            return BaseHttpFunc.getTokenBuilder(LIST, Any())
        }

        fun update(rq: RoomUpdate): RequestCall {
            return BaseHttpFunc.getTokenBuilder(UPDATE, rq)
        }
    }


}
