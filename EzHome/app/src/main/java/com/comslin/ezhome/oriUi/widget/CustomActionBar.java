package com.comslin.ezhome.oriUi.widget;

import android.app.ActionBar;
import android.content.Context;
import android.widget.TextView;

/**
 * Created by linChao on 2016-12-14.
 */

public class CustomActionBar {
    public static AcBuilder build(ActionBar actionBar, Context context) {
        return new AcBuilder(actionBar, context);
    }
    public static void changeText(ActionBar actionBar, String s){

        if (actionBar==null){return;}
      if (actionBar.getCustomView() instanceof TextView)  {
          ((TextView) actionBar.getCustomView()).setText(s);
      }
    }
}

