package com.comslin.ezhome.oriUi.http.bean.gateway;

public class Gateway {
    private String serialNumber;
    private GatewayDeviceAdapters[] deviceAdapters;
    private String name;
    private boolean binding;
    private String model;
    private int id;
    private int userId;
    private String brand;
    private String status;
    private String manufacturer;

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public GatewayDeviceAdapters[] getDeviceAdapters() {
        return this.deviceAdapters;
    }

    public void setDeviceAdapters(GatewayDeviceAdapters[] deviceAdapters) {
        this.deviceAdapters = deviceAdapters;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getBinding() {
        return this.binding;
    }

    public void setBinding(boolean binding) {
        this.binding = binding;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
