package com.comslin.ezhome.oriUi.manager;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by linChao on 2017-04-21.
 */

public class SpManager {
    public static final String ACCOUNT = "account";
    public static final String PW = "password";
    private static SpManager spManager;
    static SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static void init(Context context) {
        sharedPreferences = context.getSharedPreferences("spManager", 0);
        spManager = new SpManager();
    }

    public static SpManager getInstance() {
        return spManager;
    }

    public void putData(String act, String pw) {
        editor = sharedPreferences.edit();
        editor.putString(ACCOUNT, act);
        editor.putString(PW, pw);
        editor.apply();
    }

    public void clearLoginData() {
        editor = sharedPreferences.edit();
        editor.putString(ACCOUNT, "");
        editor.putString(PW, "");
        editor.apply();
    }

    public String getAccount() {
        return sharedPreferences.getString(ACCOUNT,"");
    }
    public String getPassword() {
        return sharedPreferences.getString(PW,"");
    }


}
