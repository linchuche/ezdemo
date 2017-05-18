package com.comslin.ezhome.oriUi.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by linChao on 2017-03-16.
 */

public class ToastUtil {
    private static Toast toast;
    public static void showToast(Context context, String content) {//防止多次Toast叠加
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(context.getApplicationContext(), content, Toast.LENGTH_SHORT);
        toast.show();
    }
}
