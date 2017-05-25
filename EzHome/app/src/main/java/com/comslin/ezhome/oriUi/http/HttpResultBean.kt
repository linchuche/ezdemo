package com.comslin.ezhome.oriUi.http

/**
 * Created by CQQ on 2016/8/9.
 */
class HttpResultBean<T> {
    var code: Int = 0
    var desc: String? = null
    var result: T? = null
    var isSuccess: Boolean = false

    override fun toString(): String {
        return "HttpResultBean{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                ", result=" + result +
                ", success=" + isSuccess +
                '}'
    }
}

