package com.comslin.ezhome.oriUi.activity.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.andview.refreshview.XRefreshView;
import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.activity.scene.task.EquipmentActivity;
import com.comslin.ezhome.oriUi.http.HttpListResultBean;
import com.comslin.ezhome.oriUi.http.ListResultCallBack;
import com.comslin.ezhome.oriUi.http.bean.room.Room;
import com.comslin.ezhome.oriUi.http.bean.room.RoomEquipments;
import com.comslin.ezhome.oriUi.http.function.RoomHttp;
import com.comslin.ezhome.oriUi.view.ListRoomAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import okhttp3.Call;

/**
 * Created by linChao on 2017-08-28.
 */

public class RoomListActivity extends BaseActivity implements XRefreshView.XRefreshViewListener {
    @Override
    public void onRefresh() {
        getRoom();
    }

    @Override
    public void onRefresh(boolean isPullDown) {

    }

    @Override
    public void onLoadMore(boolean isSilence) {

    }

    @Override
    public void onRelease(float direction) {

    }

    @Override
    public void onHeaderMove(double headerMovePercent, int offsetY) {

    }

    GridView gridView;
    XRefreshView xRefreshView;
    ListRoomAdapter listRoomAdapter = new ListRoomAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_gridview, topContentView, true);
        EventBus.getDefault().register(this);
        gridView = (GridView) findViewById(R.id.gv_room_list);
        gridView.setNumColumns(3);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent  = new Intent(RoomListActivity.this, EquipmentActivity.class);
                startActivity(intent);

            }
        });
        xRefreshView = (XRefreshView) findViewById(R.id.xrv_room_list);
        xRefreshView.setXRefreshViewListener(this);
        xRefreshView.startRefresh();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void onMessageEvent(RoomEquipments roomEquipments){
        finish();
    }
    private void getRoom() {

        RoomHttp.Companion.list().execute(new ListResultCallBack<Room>(Room.class) {
            @Override
            public void onError(Call call, Exception e, int id) {
                xRefreshView.stopRefresh(false);

            }

            @Override
            public void onResponse(HttpListResultBean response, int id) {
                listRoomAdapter.setRoomList(response.getData());
                xRefreshView.stopRefresh(true);
            }
        });
    }
}
