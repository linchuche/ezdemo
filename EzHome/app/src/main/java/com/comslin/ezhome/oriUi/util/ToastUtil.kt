package com.comslin.ezhome.oriUi.util

import android.content.Context
import android.widget.Toast

/**
 * Created by linChao on 2017-03-16.
 */

object ToastUtil {
    private var toast: Toast? = null
    fun showToast(context: Context, content: String?) {//防止多次Toast叠加
        if(content==null){
            return
        }
        if (toast != null)
            toast!!.cancel()
        toast = Toast.makeText(context.applicationContext, content, Toast.LENGTH_SHORT)
        toast!!.show()
    }
    fun showToast(context: Context, res: Int) {//防止多次Toast叠加
        if (toast != null)
            toast!!.cancel()
        toast = Toast.makeText(context.applicationContext, res, Toast.LENGTH_SHORT)
        toast!!.show()
    }
}
