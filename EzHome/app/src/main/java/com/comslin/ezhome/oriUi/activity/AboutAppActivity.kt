package com.comslin.ezhome.oriUi.activity

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.comslin.ezhome.R
import com.comslin.ezhome.oriUi.util.AppUtil

class AboutAppActivity : BaseActivity() {
    var tv: TextView? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_layout)
        setLeftButton(R.drawable.backbtn_selector);
        setTitle("关于")
        tv = findViewById(R.id.about_version) as TextView;
        tv?.text=AppUtil.getAppVersionName(this)
    }
}
