package com.comslin.ezhome.oriUi.widget;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by linChao on 2016-12-14.
 */

public class AcBuilder {

    private boolean showBackBtn = false;
    private ActionBar actionBar;
    private Context mContext;
    private String title;
    private ActionBar.LayoutParams layoutParams;
    private int gravity = Gravity.CENTER;
    private float size = 20;

    public AcBuilder(ActionBar actionBar, Context context) {
        mContext = context;
        this.actionBar = actionBar;
        layoutParams = new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    public AcBuilder title(String s) {
        title = s;
        return this;
    }

    public AcBuilder gravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public AcBuilder size(float f) {
        size = f;
        return this;
    }

    private String TAG = this.getClass().getName();

    public ActionBar create() {
        if (actionBar == null) return null;
        actionBar.setDisplayShowCustomEnabled(true);
        TextView text = new TextView(mContext);
        text.setText(title);
        text.setTextColor(Color.WHITE);
        text.setTextSize(size);
        text.setLines(1);
        text.setEllipsize(TextUtils.TruncateAt.END);
        layoutParams.gravity = gravity;
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setCustomView(text, layoutParams);
        return actionBar;
    }

}