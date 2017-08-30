package com.comslin.ezhome.oriUi.view;

import android.content.Context;
import android.support.annotation.AnyRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.http.bean.room.RoomEquipments;

import java.util.ArrayList;
import java.util.List;

import static com.comslin.ezhome.oriUi.view.DevicesAdapter.getResByTypeId;

/**
 * Created by linchaoer@qq.com on 2017/8/14.
 */

public class EquipmentAdapter extends BaseAdapter {
    List<RoomEquipments> roomEquipmentses = new ArrayList<>();
    Context mContext;
    private int select = -1;

    public EquipmentAdapter(List<RoomEquipments> roomEquipments) {
        roomEquipmentses = roomEquipments;
    }

    public void setSelect(int i) {
        if (select == i) {
            select = -1;
        } else {
            select = i;
        }
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return roomEquipmentses.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    LayoutInflater layoutInflater;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        {
            if (mContext == null) mContext = parent.getContext();
            if (layoutInflater == null) layoutInflater = LayoutInflater.from(mContext);
            EquipmentHolder eqpHolder;
            if (convertView == null) {
                eqpHolder = new EquipmentHolder();
                convertView = layoutInflater.inflate(R.layout.device_type_list_item_layout, parent, false);
                eqpHolder.imageView = (ImageView) convertView.findViewById(R.id.device_type_list_item_icon);
                eqpHolder.name = (TextView) convertView.findViewById(R.id.device_type_list_item_title_txtvew);
                eqpHolder.selected = (ImageView) convertView.findViewById(R.id.device_type_list_item_sle_icon);
                convertView.setTag(eqpHolder);
            } else {
                eqpHolder = (EquipmentHolder) convertView.getTag();
            }

            RoomEquipments roomEquipment = roomEquipmentses.get(position);
            eqpHolder.name.setText(roomEquipment.getEquipmentName());
            eqpHolder.imageView.setImageResource(getResByTypeId(roomEquipment.getTypeId()));
            if (select == position) {
                eqpHolder.selected.setVisibility(View.VISIBLE);
            } else {
                eqpHolder.selected.setVisibility(View.INVISIBLE);
            }
            return convertView;
        }
    }

    @AnyRes
    private int getLayoutByType(int position) {
        switch (position) {
//            case 0:return R.layout.
        }
        return 0;
    }

    class EquipmentHolder {
        ImageView imageView;
        TextView name;
        ImageView selected;
    }
}
