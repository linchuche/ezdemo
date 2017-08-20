package com.comslin.ezhome.oriUi.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.http.bean.gateway.Gateway;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linChao on 2017-05-07.
 */

public class GatewayAdapter extends BaseAdapter {
    List<Gateway> gatewayList=new ArrayList<>();
    Context mContext;
    LayoutInflater layoutInflater;
    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void setGatewayList(List<Gateway> gatewayList) {
        this.gatewayList = gatewayList;
    }

    @Override
    public int getCount() {
        return gatewayList.size()+1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (mContext == null) mContext = parent.getContext();
        if (layoutInflater == null) layoutInflater = LayoutInflater.from(mContext);
        ImgTvHolder roomHolder;
        if (convertView == null) {
            roomHolder = new ImgTvHolder();
            convertView = layoutInflater.inflate(R.layout.device_type_list_item_layout, parent, false);
            roomHolder.imageView = (ImageView) convertView.findViewById(R.id.device_type_list_item_icon);
            roomHolder.name = (TextView) convertView.findViewById(R.id.device_type_list_item_title_txtvew);
            convertView.setTag(roomHolder);
        } else {
            roomHolder = (ImgTvHolder) convertView.getTag();
        }
        if (position<gatewayList.size()){

            Gateway gateway=gatewayList.get(position);
            roomHolder.imageView.setImageResource(R.drawable.notice_system_icon);
            roomHolder.name.setText(gateway.getGatewayName());
        }
        else {
            roomHolder.imageView.setImageResource(R.drawable.add_btn);
            roomHolder.name.setText("添加网关");
        }
        return convertView;
    }
}
