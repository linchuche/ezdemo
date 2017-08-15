package com.comslin.ezhome.oriUi.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.http.bean.devices.Device;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linChao on 2017-05-06.
 */

public class DevicesAdapter extends BaseAdapter {
    List<Device> deviceList = new ArrayList<>();
    Context mContext;
    LayoutInflater layoutInflater;
    boolean displayAll;

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public DevicesAdapter(List<Device> deviceList) {
        this.deviceList = deviceList;
        displayAll = false;
    }

    public DevicesAdapter() {
        displayAll = true;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return displayAll ? 10 : deviceList.size();
    }

    @Override
    public Object getItem(int position) {//for asymmetricGridView display on mainViewPager
        Device device = new Device();
        if (position == 0) {
            device.setRowSpan(2);
            device.setColumnSpan(2);
        }
        return device;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (mContext == null) mContext = parent.getContext();
        if (layoutInflater == null) layoutInflater = LayoutInflater.from(mContext);
        DeviceHolder deviceHolder;
        if (convertView == null) {
            deviceHolder = new DeviceHolder();
            convertView = layoutInflater.inflate(R.layout.device_type_list_item_layout, parent, false);
            deviceHolder.imageView = (ImageView) convertView.findViewById(R.id.device_type_list_item_icon);
            deviceHolder.name = (TextView) convertView.findViewById(R.id.device_type_list_item_title_txtvew);
            convertView.setTag(deviceHolder);
        } else {
            deviceHolder = (DeviceHolder) convertView.getTag();
        }
        if (displayAll) {
            deviceHolder.imageView.setImageResource(getResByTypeId(position));
            deviceHolder.name.setText(getNameByTypeId(position));
        } else {
            Device device = deviceList.get(position);
            deviceHolder.imageView.setImageResource(getResByTypeId(device.getDeviceTypeId()));
        }
        return convertView;
    }

    private String getNameByTypeId(int typeId) {
        switch (typeId) {
            case 0:
                return "照明";
            case 1:
                return "插座、电器";
            case 2:
                return "传感器";
            case 3:
                return "能耗计量";
            case 4:
                return "门窗磁";
            case 5:
                return "电机";
            case 6:
                return "家电遥控";
            case 7:
                return "暖通系统";
            case 8:
                return "开关";
            case 9:
                return "锁";
            default:
                return "设备";
        }
    }

    public  static int getResByTypeId(int typeId) {
        switch (typeId) {
            case 0:
                return R.drawable.device_type_id1000_icon;
            case 1:
                return R.drawable.device_type_id2000_icon;
            case 2:
                return R.drawable.device_type_id3000_icon;
            case 3:
                return R.drawable.device_type_id4000_icon;
            case 4:
                return R.drawable.device_type_id5000_icon;
            case 5:
                return R.drawable.device_type_id6000_icon;
            case 6:
                return R.drawable.device_type_id7000_icon;
            case 7:
                return R.drawable.device_type_id8000_icon;
            case 8:
                return R.drawable.device_type_id9000_icon;
            case 9:
                return R.drawable.device_type_id10001_icon;
            default:
                return R.drawable.device_type_id1000_icon;
        }
    }

    class DeviceHolder {
        ImageView imageView;
        TextView name;
    }
}
