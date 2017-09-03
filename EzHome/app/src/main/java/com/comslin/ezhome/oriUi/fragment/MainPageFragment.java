package com.comslin.ezhome.oriUi.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.XRefreshView;
import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.http.HttpListResultBean;
import com.comslin.ezhome.oriUi.http.HttpResultBean;
import com.comslin.ezhome.oriUi.http.ListResultCallBack;
import com.comslin.ezhome.oriUi.http.ResultCallBack;
import com.comslin.ezhome.oriUi.http.bean.gateway.Gateway;
import com.comslin.ezhome.oriUi.http.bean.mainpage.MainPage;
import com.comslin.ezhome.oriUi.http.bean.room.Room;
import com.comslin.ezhome.oriUi.http.bean.scene.Scene;
import com.comslin.ezhome.oriUi.http.function.GatewayHttp;
import com.comslin.ezhome.oriUi.http.function.MainPageHttp;
import com.comslin.ezhome.oriUi.http.function.RoomHttp;
import com.comslin.ezhome.oriUi.http.function.SceneHttp;
import com.comslin.ezhome.oriUi.view.MainPagerAdapter;
import com.comslin.ezhome.oriUi.widget.DiffTablayout;

import okhttp3.Call;

public class MainPageFragment extends Fragment {
    private DiffTablayout mStlMain;
    private ViewPager mVpMain;
    private MainPagerAdapter mAdapterMain;
    private XRefreshView xRefreshView;

    public MainPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSceneList();
        getRoom();
        getGateway();
    }

    String TAG = "MainPageFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_page, container, false);
        mStlMain = (DiffTablayout) v.findViewById(R.id.stl_main);
        mVpMain = (ViewPager) v.findViewById(R.id.vp_main);
        xRefreshView = (XRefreshView) v.findViewById(R.id.xrv_main_page);
        xRefreshView.setMoveForHorizontal(true);
        xRefreshView.setPinnedContent(true);
        mAdapterMain = new MainPagerAdapter(getActivity());
//        xRefreshView.setXRefreshViewListener(mAdapterMain);
        xRefreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                Log.d(TAG, "onRefresh: " + mAdapterMain.getCurrentPosition());
                switch (mAdapterMain.getCurrentPosition()) {
//                {"main", "场景", "类型", "房间", "网关"};
                    case 1:
                       getMainPage();
                        break;
                    case 2:
                        getSceneList();
                        break;
                    case 3:
                        xRefreshView.stopRefresh();
                        break;
                    case 4:
                        getRoom();
                        break;
                    case 5:
                        getGateway();
                    default:
                        xRefreshView.stopRefresh();
                        break;

                }
            }
        });
        mVpMain.setAdapter(mAdapterMain);
        mStlMain.setViewPager(mVpMain);
        mStlMain.setSelectedIndicatorColors(Color.WHITE);
        return v;
    }
    private void getMainPage(){
        MainPageHttp.Companion.getMainPage().execute(new ResultCallBack<MainPage>(MainPage.class) {
            @Override
            public void onResponse(HttpResultBean<MainPage> response, int id) {
                MainPage mainPage = response.getResult();
                xRefreshView.stopRefresh(true);

            }
        });
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

    private void getGateway() {
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

    private void getSceneList() {
        SceneHttp.Companion.list().execute(new ListResultCallBack<Scene>(Scene.class) {
            @Override
            public void onError(Call call, Exception e, int id) {
                xRefreshView.stopRefresh(false);
            }

            @Override
            public void onResponse(HttpListResultBean response, int id) {
                xRefreshView.stopRefresh(true);
                mAdapterMain.setScendList(response.getData());

            }
        });
    }
}
