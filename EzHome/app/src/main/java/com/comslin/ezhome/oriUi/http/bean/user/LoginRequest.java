package com.comslin.ezhome.oriUi.http.bean.user;

/**
 * Created by linChao on 2017-04-22.
 */

public class LoginRequest {

    private String password;/*"123456"*/
    private String phoneNumber;/*"18812341234"*/

    public LoginRequest(String password, String phoneNumber) {
        this.password = password;
        this.phoneNumber = phoneNumber;
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
}
