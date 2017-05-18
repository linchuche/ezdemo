package com.comslin.ezhome.oriUi.http.bean.room;

import java.util.List;

/**
 * Created by linChao on 2017-04-25.
 */

public class RoomResponse {

    /**
     * devices : [{"currentStatus":"string","deviceAdapterId":2101,"deviceNativeId":"string","deviceSubTypeId":0,"deviceSubTypeName":"string","deviceTypeId":0,"deviceTypeName":"string","gatewayId":1001,"gatewayNativeId":"string","id":100101,"name":"餐厅电灯","slotNo":1}]
     * id : 1001
     * name : 主卧
     * roomTypeId : 5
     * roomTypeName : 卧室
     */

    private int id;
    private String name;
    private int roomTypeId;
    private String roomTypeName;
    private List<DevicesBean> devices;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public List<DevicesBean> getDevices() {
        return devices;
    }

    public void setDevices(List<DevicesBean> devices) {
        this.devices = devices;
    }

    public static class DevicesBean {
        /**
         * currentStatus : string
         * deviceAdapterId : 2101
         * deviceNativeId : string
         * deviceSubTypeId : 0
         * deviceSubTypeName : string
         * deviceTypeId : 0
         * deviceTypeName : string
         * gatewayId : 1001
         * gatewayNativeId : string
         * id : 100101
         * name : 餐厅电灯
         * slotNo : 1
         */

        private String currentStatus;
        private int deviceAdapterId;
        private String deviceNativeId;
        private int deviceSubTypeId;
        private String deviceSubTypeName;
        private int deviceTypeId;
        private String deviceTypeName;
        private int gatewayId;
        private String gatewayNativeId;
        private int id;
        private String name;
        private int slotNo;

        public String getCurrentStatus() {
            return currentStatus;
        }

        public void setCurrentStatus(String currentStatus) {
            this.currentStatus = currentStatus;
        }

        public int getDeviceAdapterId() {
            return deviceAdapterId;
        }

        public void setDeviceAdapterId(int deviceAdapterId) {
            this.deviceAdapterId = deviceAdapterId;
        }

        public String getDeviceNativeId() {
            return deviceNativeId;
        }

        public void setDeviceNativeId(String deviceNativeId) {
            this.deviceNativeId = deviceNativeId;
        }

        public int getDeviceSubTypeId() {
            return deviceSubTypeId;
        }

        public void setDeviceSubTypeId(int deviceSubTypeId) {
            this.deviceSubTypeId = deviceSubTypeId;
        }

        public String getDeviceSubTypeName() {
            return deviceSubTypeName;
        }

        public void setDeviceSubTypeName(String deviceSubTypeName) {
            this.deviceSubTypeName = deviceSubTypeName;
        }

        public int getDeviceTypeId() {
            return deviceTypeId;
        }

        public void setDeviceTypeId(int deviceTypeId) {
            this.deviceTypeId = deviceTypeId;
        }

        public String getDeviceTypeName() {
            return deviceTypeName;
        }

        public void setDeviceTypeName(String deviceTypeName) {
            this.deviceTypeName = deviceTypeName;
        }

        public int getGatewayId() {
            return gatewayId;
        }

        public void setGatewayId(int gatewayId) {
            this.gatewayId = gatewayId;
        }

        public String getGatewayNativeId() {
            return gatewayNativeId;
        }

        public void setGatewayNativeId(String gatewayNativeId) {
            this.gatewayNativeId = gatewayNativeId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSlotNo() {
            return slotNo;
        }

        public void setSlotNo(int slotNo) {
            this.slotNo = slotNo;
        }
    }

}
