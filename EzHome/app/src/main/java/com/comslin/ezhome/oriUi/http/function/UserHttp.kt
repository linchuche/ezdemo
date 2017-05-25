package com.comslin.ezhome.oriUi.http.function


import android.util.Log

import com.comslin.ezhome.oriUi.http.HttpResultBean
import com.comslin.ezhome.oriUi.http.ResultCallBack
import com.comslin.ezhome.oriUi.http.RigisterRequest
import com.comslin.ezhome.oriUi.http.bean.user.LoginRequest
import com.comslin.ezhome.oriUi.http.bean.user.SendSmsCode
import com.google.gson.Gson
import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.request.RequestCall

import okhttp3.MediaType

import com.comslin.ezhome.oriUi.http.function.HttpConstant.EzHomeHost


/**
 * Created by linChao on 2017-04-17.
 */

class UserHttp : BaseHttpFunc() {
    companion object {

        private val LOGIN = EzHomeHost + "/api/user/login"//1
        private val LOGOUT = EzHomeHost + "/api/user/logout"//1
        private val RESETPW = EzHomeHost + "/api/user/resetPassword"//
        private val SENDSMS = EzHomeHost + "/api/user/sendVerificationCode"//
        private val RIGISTER = EzHomeHost + "/api/user/register"//

        private val TAG = "HttpUtils"


        fun login(loginRequest: LoginRequest): RequestCall {
            val params = Gson().toJson(loginRequest)
            return OkHttpUtils.postString()
                    .url(LOGIN)
                    .mediaType(MediaType.parse("application/json"))
                    .content(params)
                    .build()
        }

        fun loginOut() {
            OkHttpUtils.post()
                    .url(LOGOUT)
                    .addHeader("Access-Token", BaseHttpFunc.token)
                    .build()
                    .execute(object : ResultCallBack<Any>(Any::class.java) {
                        override fun onResponse(response: HttpResultBean<Any>, id: Int) {
                            Log.d(TAG, "onResponse: " + response.desc)
                        }
                    })
        }

        fun reSetPassWord(rp: RigisterRequest): RequestCall {
            val params = Gson().toJson(rp)
            return OkHttpUtils.postString()
                    .url(RESETPW)
                    .mediaType(MediaType.parse("application/json"))
                    .content(params)
                    .build()
        }

        fun sendSms(loginRequest: SendSmsCode): RequestCall {
            val params = Gson().toJson(loginRequest)
            return OkHttpUtils.postString()
                    .url(SENDSMS)
                    .mediaType(MediaType.parse("application/json"))
                    .content(params)
                    .build()
        }

        fun rigister(loginRequest: RigisterRequest): RequestCall {
            val params = Gson().toJson(loginRequest)
            return OkHttpUtils.postString()
                    .url(RIGISTER)
                    .mediaType(MediaType.parse("application/json"))
                    .content(params)
                    .build()
        }
    }
}
