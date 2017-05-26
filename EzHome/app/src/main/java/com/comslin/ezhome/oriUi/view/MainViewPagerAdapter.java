package com.comslin.ezhome.oriUi.view;

/**
 * Created by linChao on 2017-04-26.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.comslin.ezhome.oriUi.activity.RoomAddActivity;
import com.comslin.ezhome.oriUi.http.bean.devices.Device;
import com.comslin.ezhome.oriUi.http.bean.gateway.Gateway;
import com.comslin.ezhome.oriUi.http.bean.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private LayoutInflater layoutInflater;
    private List<Device> deviceList = new ArrayList<>();
    private List<Room> roomList = new ArrayList<>();
    RoomAdapter roomAdapter = new RoomAdapter();
    DevicesAdapter devicesAdapter = new DevicesAdapter();
    GatewayAdapter gatewayAdapter = new GatewayAdapter();

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
        devicesAdapter.setDeviceList(deviceList);
        devicesAdapter.notifyDataSetChanged();
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
        roomAdapter.setRoomList(roomList);
    }

    public void setGatewayList(List<Gateway> gatewayList) {
        gatewayAdapter.setGatewayList(gatewayList);
        gatewayAdapter.notifyDataSetChanged();
    }

    public MainViewPagerAdapter() {


    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return 5;
    }

    public MainViewPagerAdapter(Activity context) {
        mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
//        ListAdapter listAdapter
        initView();
    }

    GridView deviceGrid;
    GridView roomGrid;
    GridView gatewayGrid;
    private void initView() {
        deviceGrid = new GridView(mContext);
        roomGrid = new GridView(mContext);
        gatewayGrid = new GridView(mContext);
    }

    private String[] titles = new String[]{"main", "场景", "类型", "房间", "网关"};

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        switch (position) {
//            case 0:
//                DevicesAdapter devicesAdapter=new DevicesAdapter();
//                AsymmetricGridView asymmetricGridView=new AsymmetricGridView(mContext,null);
//                AsymmetricGridViewAdapter asymmetricGridViewAdapter=new AsymmetricGridViewAdapter(mContext,asymmetricGridView,devicesAdapter);
//                asymmetricGridView.setAdapter(asymmetricGridViewAdapter);
//                asymmetricGridView.setRequestedColumnCount(4);
//                return asymmetricGridView;
            case 2:
                deviceGrid.setNumColumns(3);
                deviceGrid.setAdapter(devicesAdapter);
                deviceGrid.setTag(position);
                container.addView(deviceGrid);
                return deviceGrid;
            case 3:
                roomGrid.setNumColumns(3);
                roomGrid.setAdapter(roomAdapter);
                roomGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position == roomAdapter.getCount() - 1) {
                            Intent intent = new Intent(mContext, RoomAddActivity.class);
                            mContext.startActivity(intent);
                        }
                    }
                });
                roomGrid.setTag(position);
                container.addView(roomGrid);
                return roomGrid;
            case 4:
                gatewayGrid.setNumColumns(3);
                gatewayGrid.setAdapter(gatewayAdapter);
                gatewayGrid.setTag(position);
                container.addView(gatewayGrid);
                return gatewayGrid;


        }
        TextView textView = new TextView(mContext);
        textView.setText("blank");
        textView.setGravity(Gravity.CENTER);
        container.addView(textView);
        return textView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}

