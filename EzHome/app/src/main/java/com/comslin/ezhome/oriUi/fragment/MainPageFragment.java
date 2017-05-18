package com.comslin.ezhome.oriUi.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.http.HttpListResultBean;
import com.comslin.ezhome.oriUi.http.ListResultCallBack;
import com.comslin.ezhome.oriUi.http.bean.gateway.Gateway;
import com.comslin.ezhome.oriUi.http.bean.room.Room;
import com.comslin.ezhome.oriUi.http.function.GatewayHttp;
import com.comslin.ezhome.oriUi.http.function.RoomHttp;
import com.comslin.ezhome.oriUi.view.MainViewPagerAdapter;
import com.comslin.ezhome.oriUi.widget.DiffTablayout;

import okhttp3.Call;

public class MainPageFragment extends Fragment {
    private DiffTablayout mStlMain;
    private ViewPager mVpMain;
    private MainViewPagerAdapter mAdapterMain;

    public MainPageFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_page, container, false);
        mStlMain = (DiffTablayout) v.findViewById(R.id.stl_main);
        mVpMain = (ViewPager) v.findViewById(R.id.vp_main);
        mAdapterMain = new MainViewPagerAdapter(getActivity());
        mVpMain.setAdapter(mAdapterMain);
        mStlMain.setViewPager(mVpMain);
        mStlMain.setSelectedIndicatorColors(Color.WHITE);
        return v;
    }
    private void getData() {
        RoomHttp.list().execute(new ListResultCallBack<Room>(Room.class) {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(HttpListResultBean response, int id) {
                mAdapterMain.setRoomList(response.getData());
            }
        });
        GatewayHttp.list().execute(new ListResultCallBack<Gateway>(Gateway.class) {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(HttpListResultBean response, int id) {
                mAdapterMain.setGatewayList(response.getData());
            }
        });

    }
}
