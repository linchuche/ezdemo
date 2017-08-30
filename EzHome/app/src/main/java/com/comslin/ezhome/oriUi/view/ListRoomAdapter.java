package com.comslin.ezhome.oriUi.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.http.bean.room.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linChao on 2017-05-07.
 */

public class ListRoomAdapter extends BaseAdapter {
    List<Room> roomList = new ArrayList<>();
    Context mContext;
    LayoutInflater layoutInflater;
    boolean displayAll;

    public void setRoomList(List<Room> deviceList) {
        this.roomList = deviceList;
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return roomList.size();
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
        Room room = roomList.get(position);
        roomHolder.imageView.setImageResource(ResContent.getRoomTypeByTypeId(room.getRoomId()));
        roomHolder.name.setText(room.getRoomName());
        return convertView;
    }


}
