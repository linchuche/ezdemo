package com.comslin.ezhome.oriUi.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.http.bean.user.Notification;

/**
 * Created by linChao on 2017-05-18.
 */

public class NotificationAdapter extends BaseRecyclerAdapter {
    LayoutInflater layoutInflater;
    Notification notification;
    public void setData(Notification notification){
        this.notification = notification;
    }
    @Override
    public RecyclerView.ViewHolder getViewHolder(View view) {
        return null;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        if (layoutInflater==null)layoutInflater=LayoutInflater.from(parent.getContext());
        NotiViewHolder notiViewHolder=new NotiViewHolder(layoutInflater.inflate(R.layout.notification_list_item_layout,parent,false));
        return notiViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, boolean isItem) {

    }

    @Override
    public int getAdapterItemCount() {
        return 0;
    }

    class NotiViewHolder extends RecyclerView.ViewHolder {

        public NotiViewHolder(View itemView) {
            super(itemView);
        }
    }
}
