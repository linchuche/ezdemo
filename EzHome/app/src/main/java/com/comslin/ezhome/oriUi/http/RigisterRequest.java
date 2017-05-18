package com.comslin.ezhome.oriUi.http;

/**
 * Created by linChao on 2017-04-23.
 */

public class RigisterRequest {

    private String password;
    private String phoneNumber;
    private String verificationCode;
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public RigisterRequest() {
    }

    public RigisterRequest(String password, String phoneNumber, String verificationCode) {
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.verificationCode = verificationCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
