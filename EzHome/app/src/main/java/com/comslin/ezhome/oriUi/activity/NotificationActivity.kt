package com.comslin.ezhome.oriUi.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater

import com.andview.refreshview.XRefreshView
import com.comslin.ezhome.R
import com.comslin.ezhome.oriUi.view.NotificationAdapter

class NotificationActivity : BaseActivity() {

    private var mRvNotification: RecyclerView? = null
    private var mXrvNotification: XRefreshView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLeftButton(R.drawable.back)
        setTitle("通知中心")
        LayoutInflater.from(this).inflate(R.layout.activity_notification, topContentView)
        initView()
        val notificationAdapter = NotificationAdapter()
        mRvNotification!!.layoutManager = LinearLayoutManager(this)

        mXrvNotification!!.setXRefreshViewListener(object : XRefreshView.SimpleXRefreshListener() {
            override fun onRefresh(isPullDown: Boolean) {
                super.onRefresh(isPullDown)
            }

            override fun onLoadMore(isSilence: Boolean) {
                super.onLoadMore(isSilence)
            }

            override fun onRelease(direction: Float) {
                super.onRelease(direction)
            }

            override fun onHeaderMove(offset: Double, offsetY: Int) {
                super.onHeaderMove(offset, offsetY)
            }
        })
        mRvNotification!!.adapter = notificationAdapter
    }

    private fun initView() {
        mRvNotification = findViewById(R.id.rv_notification) as RecyclerView
        mXrvNotification = findViewById(R.id.xrv_notification) as XRefreshView
    }
}
