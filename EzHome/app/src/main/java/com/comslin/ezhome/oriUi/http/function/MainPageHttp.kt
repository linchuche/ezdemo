package com.comslin.ezhome.oriUi.http.function

import com.comslin.ezhome.oriUi.http.bean.scene.ChanggeSceneAble
import com.comslin.ezhome.oriUi.http.bean.scene.Scene
import com.zhy.http.okhttp.request.RequestCall

/**
 * Created by linchaoer@qq.com on 2017/8/14.
 */
class MainPageHttp : BaseHttpFunc(){
    companion object{
        private val MAIN_PAGE_GET = HttpConstant.EzHomeHost+"/api/system/home/get";




        fun getMainPage():RequestCall{
            return BaseHttpFunc.getTokenBuilder(MAIN_PAGE_GET)
        }
    }
}