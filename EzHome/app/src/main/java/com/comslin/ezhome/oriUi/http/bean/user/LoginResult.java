package com.comslin.ezhome.oriUi.http.bean.user;

/**
 * Created by linChao on 2017-04-23.
 */

public class LoginResult {
    private String accessToken;/*"string"*/
    private int expires; /*0*/
    private int userId; /*0*/

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
