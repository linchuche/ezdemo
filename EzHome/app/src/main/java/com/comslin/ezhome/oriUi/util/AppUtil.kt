package com.comslin.ezhome.oriUi.util

import android.R.attr.versionCode
import android.R.attr.versionName
import android.content.Context


/**
 * Created by linchaoer@qq.com on 2017/8/15.
 */
object AppUtil {
    fun getAppVersionName(context: Context): String? {
        var versionName: String?
        val pm = context.getPackageManager()
        val pi = pm.getPackageInfo(context.getPackageName(), 0)
        versionName = pi.versionName
        return versionName
    }
}