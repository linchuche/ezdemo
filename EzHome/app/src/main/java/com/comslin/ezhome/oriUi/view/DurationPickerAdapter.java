package com.comslin.ezhome.oriUi.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.comslin.ezhome.R;

/**
 * Created by linChao on 2017-09-03.
 */

public class DurationPickerAdapter extends BaseAdapter {
    public static final int TYPE_HOUR = 0;
    public static final int TYPE_MINUTE = 1;
    public static final int TYPE_SECOND = 2;
    int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getCount() {
        switch (type){
            case TYPE_HOUR:
                return 24;
            case TYPE_MINUTE:
            case TYPE_SECOND:
                return 60;

        }
        return 0;
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
        if (layoutInflater==null){
            layoutInflater=LayoutInflater.from(parent.getContext());
        }
        TextView textView;
        if (convertView == null){
            convertView =  layoutInflater.inflate(R.layout.item_tv,null);
            textView= (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(textView);
        }
        else {
            textView = (TextView)convertView.getTag();
        }
        textView.setText(position+"");
        return convertView;
    }
}
