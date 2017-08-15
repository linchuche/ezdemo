package com.comslin.ezhome.oriUi.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.http.HttpResultBean;
import com.comslin.ezhome.oriUi.http.ResultCallBack;
import com.comslin.ezhome.oriUi.http.bean.room.RoomAdd;
import com.comslin.ezhome.oriUi.http.function.RoomHttp;
import com.comslin.ezhome.oriUi.util.ToastUtil;
import com.comslin.ezhome.oriUi.view.AllRoomTypeAdapter;
import com.comslin.ezhome.oriUi.view.ResContent;
import com.google.gson.internal.LinkedTreeMap;

public class RoomAddActivity extends BaseActivity implements View.OnClickListener {

    private EditText mRoomAddEdittextLayout;
    private Button mRoomAddOkBtn;
    private ImageView mRoomAddTypeIcon;
    private TextView mRoomAddType;
    private LinearLayout mRoomAddSelType;
    private GridView mGridRoomType;
    private int selectedType=-1;
    private String selectedTypeName;
    PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initPopWindow();
    }
    private void initPopWindow(){
        View v=LayoutInflater.from(this).inflate(R.layout.room_select_type_dialog_layout,null,false);
        mGridRoomType=(GridView) v.findViewById(R.id.room_sel_type_dialog_gridView);
        mGridRoomType.setAdapter(new AllRoomTypeAdapter());
        popupWindow=new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        mGridRoomType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedType=position;
                mRoomAddTypeIcon.setImageResource(ResContent.getRoomTypeByTypeId(position));
                selectedTypeName = ResContent.getRoomNameByTypeId(position);
                mRoomAddType.setText(selectedTypeName);
                popupWindow.dismiss();
            }
        });
    }
    private void initView() {
        LayoutInflater.from(this).inflate(R.layout.room_add_layout, topContentView);
        setTitle("添加新房间");
        setLeftButton(R.drawable.common_title_back_selector);
        mRoomAddEdittextLayout = (EditText) findViewById(R.id.room_add_edittext_layout);
        mRoomAddOkBtn = (Button) findViewById(R.id.room_add_ok_btn);
        mRoomAddOkBtn.setOnClickListener(this);
        mRoomAddTypeIcon = (ImageView) findViewById(R.id.room_add_type_icon);
        mRoomAddType = (TextView) findViewById(R.id.room_add_type);
        mRoomAddSelType = (LinearLayout) findViewById(R.id.room_add_sel_type);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.room_add_ok_btn:
                String text = mRoomAddEdittextLayout.getText().toString();
                if (TextUtils.isEmpty(text)) {
                    ToastUtil.INSTANCE.showToast(this, "房间名不能为空");
                } else {
                    showProgress(true);
                    RoomAdd roomAdd = new RoomAdd(text, selectedTypeName);//改成了使用TYPE NAME而不是 TYPE ID
                    RoomHttp.Companion.addRoom(roomAdd).execute(
                            new ResultCallBack<LinkedTreeMap>(LinkedTreeMap.class) {
                                @Override
                                public void onResponse(HttpResultBean<LinkedTreeMap> response, int id) {
                                    showProgress(false);
                                    if (response.getDesc().equals("成功")) {
                                        ToastUtil.INSTANCE.showToast(RoomAddActivity.this, "添加房间成功");

                                    } else {
                                        ToastUtil.INSTANCE.showToast(RoomAddActivity.this, response.getDesc());
                                    }
                                }
                            }
                    );

                }
                break;
            case R.id.ll_room_type:
                popupWindow.showAtLocation(topContentView.getRootView(), Gravity.BOTTOM,0,0);
        }
    }
}
