package com.comslin.ezhome.oriUi.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.andview.refreshview.XRefreshView;
import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.view.NotificationAdapter;

public class NotificationActivity extends BaseActivity {

    private RecyclerView mRvNotification;
    private XRefreshView mXrvNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLeftButton(R.drawable.back);
        setTitle("通知中心");
        LayoutInflater.from(this).inflate(R.layout.activity_notification, topContentView);
        initView();
        NotificationAdapter notificationAdapter=new NotificationAdapter();
        mRvNotification.setAdapter(notificationAdapter);
    }

    private void initView() {
        mRvNotification = (RecyclerView) findViewById(R.id.rv_notification);
        mXrvNotification = (XRefreshView) findViewById(R.id.xrv_notification);
    }
}
