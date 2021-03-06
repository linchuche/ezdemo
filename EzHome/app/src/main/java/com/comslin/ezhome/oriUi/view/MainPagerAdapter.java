package com.comslin.ezhome.oriUi.view;

/**
 * Created by linChao on 2017-04-26.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.DeviceAddActivity;
import com.comslin.ezhome.oriUi.activity.RoomAddActivity;
import com.comslin.ezhome.oriUi.activity.SensorAddActivity;
import com.comslin.ezhome.oriUi.activity.gateway.FindGateWayActivity;
import com.comslin.ezhome.oriUi.activity.room.RoomDetailActivity;
import com.comslin.ezhome.oriUi.activity.scene.SceneLanchActivity;
import com.comslin.ezhome.oriUi.activity.scene.task.EquipmentActivity;
import com.comslin.ezhome.oriUi.http.bean.devices.Device;
import com.comslin.ezhome.oriUi.http.bean.gateway.Gateway;
import com.comslin.ezhome.oriUi.http.bean.mainpage.MainPage;
import com.comslin.ezhome.oriUi.http.bean.room.Room;
import com.comslin.ezhome.oriUi.http.bean.scene.Scene;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainPagerAdapter extends PagerAdapter implements XRefreshView.XRefreshViewListener {
    private Context mContext;
    private LayoutInflater layoutInflater;
    private List<Device> deviceList = new ArrayList<>();
    private List<Room> roomList = new ArrayList<>();
    private MainRoomAdapter roomAdapter = new MainRoomAdapter();
    private DevicesAdapter devicesAdapter = new DevicesAdapter();
    private GatewayAdapter gatewayAdapter = new GatewayAdapter();
    private SceneAdapter sceneAdapter = new SceneAdapter();
    private MainFirstAdapter mainFirstAdapter = new MainFirstAdapter();
    MainPage mainPage;
    public void setMainPage(MainPage page){
        mainPage = page;
        mainFirstAdapter.setMainPage(page);
    }
    private int currentPosition = 0;

    public int getCurrentPosition() {
        return currentPosition;
    }

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

    public void setScendList(List<Scene> scendList) {
        sceneAdapter.setSceneList(scendList);
        sceneAdapter.notifyDataSetChanged();
    }

    public MainPagerAdapter() {


    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return 5;
    }

    public MainPagerAdapter(Activity context) {
        mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
//        ListAdapter listAdapter
    }

    private String[] titles = new String[]{"main", "场景", "类型", "房间", "网关"};

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }


    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        currentPosition = position;
        switch (position) {
            case 0:


                AsymmetricGridView asymmetricGridView = new AsymmetricGridView(mContext, null);
                asymmetricGridView.setDebugging(false);
                AsymmetricGridViewAdapter<Device> asymmetricGridViewAdapter =
                        new AsymmetricGridViewAdapter<>(mContext, asymmetricGridView, mainFirstAdapter);
                asymmetricGridView.setRequestedColumnCount(4);
//                asymmetricGridView.setRequestedHorizontalSpacing(Utils.dpToPx(mContext, 3));
                asymmetricGridView.setAdapter(asymmetricGridViewAdapter);
                asymmetricGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Object o= view.getTag(R.id.item_device_type);
                        if (o!=null&&o instanceof Integer){
                            int i = (int)o;
                            switch (i){
                                case 0:mContext.startActivity(new Intent(mContext, DeviceAddActivity.class));
                                    break;
                                case 1:mContext.startActivity(new Intent(mContext, SensorAddActivity.class));
                                    break;
                                case 2:mContext.startActivity(new Intent(mContext, SceneLanchActivity.class));
                                    break;

                            }
                        }
                    }
                });
                container.addView(asymmetricGridView);
                return asymmetricGridView;
            case 1:
                RecyclerView recyclerView = new RecyclerView(mContext);
                recyclerView.setAdapter(sceneAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                container.addView(recyclerView);
                return recyclerView;
            case 2:
                DevicesAdapter deviceType = new DevicesAdapter();
                GridView gridView = new GridView(mContext);
                gridView.setNumColumns(3);
                gridView.setAdapter(deviceType);
                container.addView(gridView);
                return gridView;
            case 3:
                final GridView roomGrid = new GridView(mContext);
                roomGrid.setNumColumns(3);
                roomGrid.setAdapter(roomAdapter);
                roomGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position == roomAdapter.getCount() - 1) {
                            Intent intent = new Intent(mContext, RoomAddActivity.class);
                            mContext.startActivity(intent);
                        } else {
                            Intent intent = new Intent(mContext, RoomDetailActivity.class);
                            intent.putExtra("room", roomList.get(position));
                            mContext.startActivity(intent);
                        }
                    }
                });
                container.addView(roomGrid);
                return roomGrid;
            case 4:
                final GridView gatewayGrid = new GridView(mContext);
                gatewayGrid.setNumColumns(3);
                gatewayGrid.setAdapter(gatewayAdapter);
                container.addView(gatewayGrid);
                gatewayGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position == gatewayAdapter.getCount() - 1) {
                            Intent intent = new Intent(mContext, FindGateWayActivity.class);
                            mContext.startActivity(intent);
                        } else {

                        }

                    }
                });
                return gatewayGrid;
            default:
                TextView defaultTV = new TextView(mContext);
                defaultTV.setText("blank");
                defaultTV.setGravity(Gravity.CENTER);
                container.addView(defaultTV);
                return defaultTV;
        }

    }

    String TAG = "MainPagerAdapter";

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public void onRefresh() {
        Log.d(TAG, "onRefresh: ");
        switch (currentPosition) {

        }
    }

    @Override
    public void onRefresh(boolean isPullDown) {
        Log.d(TAG, "onRefresh: ");
    }

    @Override
    public void onLoadMore(boolean isSilence) {
        Log.d(TAG, "onLoadMore: ");
    }

    @Override
    public void onRelease(float direction) {
        Log.d(TAG, "onRelease: ");
    }

    @Override
    public void onHeaderMove(double headerMovePercent, int offsetY) {
        Log.d(TAG, "onHeaderMove: ");
    }
}

