package com.comslin.ezhome.oriUi.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.XRefreshView;
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
    private XRefreshView xRefreshView;
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
        xRefreshView=(XRefreshView)v.findViewById(R.id.xrv_main_page);
        xRefreshView.setMoveForHorizontal(true);
        xRefreshView.setPinnedContent(true);
        xRefreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener(){
            @Override
            public void onRefresh(boolean isPullDown) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xRefreshView.stopRefresh();
                    }
                }, 2000);

            }
        });
        mAdapterMain = new MainViewPagerAdapter(getActivity());
        mVpMain.setAdapter(mAdapterMain);
        mStlMain.setViewPager(mVpMain);
        mStlMain.setSelectedIndicatorColors(Color.WHITE);
        return v;
    }
    private void getData() {
        RoomHttp.Companion.list().execute(new ListResultCallBack<Room>(Room.class) {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(HttpListResultBean response, int id) {
                mAdapterMain.setRoomList(response.getData());
            }
        });
        GatewayHttp.Companion.list().execute(new ListResultCallBack<Gateway>(Gateway.class) {
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
