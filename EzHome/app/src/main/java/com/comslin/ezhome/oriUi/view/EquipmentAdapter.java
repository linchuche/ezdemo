package com.comslin.ezhome.oriUi.view;

import android.support.annotation.AnyRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.http.bean.room.RoomEquipments;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linchaoer@qq.com on 2017/8/14.
 */

public class EquipmentAdapter  extends BaseAdapter{
    List<RoomEquipments> roomEquipmentses=new ArrayList<>();
    public EquipmentAdapter(List<RoomEquipments> roomEquipments) {
        roomEquipmentses=roomEquipments;
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
        if (layoutInflater==null)layoutInflater=LayoutInflater.from(parent.getContext());
        if (convertView==null){
//            convertView=layoutInflater.inflate()
        }
        return null;
    }
    @AnyRes
    private int getLayoutByType(int position){
        switch (position){
//            case 0:return R.layout.
        }
        return 0;
    }
}
