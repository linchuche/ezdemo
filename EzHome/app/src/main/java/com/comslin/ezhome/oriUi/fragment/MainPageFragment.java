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
        getRoom();
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
        mAdapterMain = new MainViewPagerAdapter(getActivity());
//        xRefreshView.setXRefreshViewListener(mAdapterMain);
        xRefreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener(){
            @Override
            public void onRefresh(boolean isPullDown) {
                switch (mAdapterMain.getCurrentPosition()){
//                {"main", "场景", "类型", "房间", "网关"};
                    case 0:
                    case 1:
                    case 2:xRefreshView.stopRefresh();break;
                    case 3:getRoom();break;
                    case 4:getGateway();break;
                    default:xRefreshView.stopRefresh();break;

                }
            }
        });
        mVpMain.setAdapter(mAdapterMain);
        mStlMain.setViewPager(mVpMain);
        mStlMain.setSelectedIndicatorColors(Color.WHITE);
        return v;
    }
    private void getRoom() {
        RoomHttp.Companion.list().execute(new ListResultCallBack<Room>(Room.class) {
            @Override
            public void onError(Call call, Exception e, int id) {
                xRefreshView.stopRefresh(false);

            }

            @Override
            public void onResponse(HttpListResultBean response, int id) {
                mAdapterMain.setRoomList(response.getData());
                xRefreshView.stopRefresh(true);
            }
        });
    }
    private void getGateway(){
        GatewayHttp.Companion.list().execute(new ListResultCallBack<Gateway>(Gateway.class) {
            @Override
            public void onError(Call call, Exception e, int id) {
                xRefreshView.stopRefresh(false);
            }

            @Override
            public void onResponse(HttpListResultBean response, int id) {
                mAdapterMain.setGatewayList(response.getData());
                xRefreshView.stopRefresh(true);
            }
        });

    }
}
