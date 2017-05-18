package com.comslin.ezhome.oriUi.http.bean.gateway;

public class AddRequest {
    private String serialNumber;
    private String name;
    private String model;
    private String gatewayNativeId;
    private String brand;
    private String manufacturer;

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGatewayNativeId() {
        return this.gatewayNativeId;
    }

    public void setGatewayNativeId(String gatewayNativeId) {
        this.gatewayNativeId = gatewayNativeId;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
