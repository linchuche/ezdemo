package com.comslin.ezhome.oriUi.http.bean.user;

/**
 * Created by linChao on 2017-04-23.
 */

public class SendSmsCode {

    private String phoneNumber;
    private String verificationAction;

    public SendSmsCode(String phoneNumber, String verificationAction) {
        this.phoneNumber = phoneNumber;
        this.verificationAction = verificationAction;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVerificationAction() {
        return verificationAction;
    }

    public void setVerificationAction(String verificationAction) {
        this.verificationAction = verificationAction;
    }
}
