package com.comslin.ezhome.oriUi.http.bean.user;

/**
 * Created by linChao on 2017-04-23.
 */

public class ResetPassword {

    private String newPassword;
    private String phoneNumber;
    private String verificationCode;

    public ResetPassword(String newPassword, String phoneNumber, String verificationCode) {
        this.newPassword = newPassword;
        this.phoneNumber = phoneNumber;
        this.verificationCode = verificationCode;
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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


}
