package com.comslin.ezhome.oriUi.http.function

import com.comslin.ezhome.oriUi.http.bean.scene.ChanggeSceneAble
import com.zhy.http.okhttp.request.RequestCall

/**
 * Created by linchaoer@qq.com on 2017/8/14.
 */
class SceneHttp : BaseHttpFunc(){
    companion object{
        private val LIST = HttpConstant.EzHomeHost+"/api/scene/list";
        private val CHANGE_ABLE= HttpConstant.EzHomeHost+"/api/scene/enable";

        fun list() :RequestCall{
            return BaseHttpFunc.getTokenBuilder(LIST);
        }
        fun changeAble(scene:ChanggeSceneAble):RequestCall{
            return BaseHttpFunc.getTokenBuilder(CHANGE_ABLE,scene)
        }
    }
}