package com.comslin.ezhome.oriUi.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.DataManagerActivity;
import com.comslin.ezhome.oriUi.DeviceShareActivity;
import com.comslin.ezhome.oriUi.activity.account.AboutAppActivity;
import com.comslin.ezhome.oriUi.activity.NotificationActivity;
import com.comslin.ezhome.oriUi.activity.user.UserInfoActivity;

/**
 * Created by linChao on 2017-04-26.
 */

public class PersonInfoFragment extends Fragment implements View.OnClickListener {
    private View view;
    /**
     * \ 13913913900
     */
    private TextView mSettingTel;
    private LinearLayout mSettingPerson;
    private TextView mSceneListItemDesc;
    private TextView mSettingUnreadTv;
    private LinearLayout mSettingNotion;
    private LinearLayout mSettingShare;
    private LinearLayout mSettingDataManager;
    private LinearLayout mSettingAbout;
    private LinearLayout mSettingLayout;

    public PersonInfoFragment() {

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.setting_layout, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        mSettingTel = (TextView) v.findViewById(R.id.setting_tel);
        mSettingPerson = (LinearLayout) v.findViewById(R.id.setting_person);
        mSceneListItemDesc = (TextView) v.findViewById(R.id.scene_list_item_desc);
        mSettingUnreadTv = (TextView) v.findViewById(R.id.setting_unread_tv);
        mSettingNotion = (LinearLayout) v.findViewById(R.id.setting_notion);
        mSettingShare = (LinearLayout) v.findViewById(R.id.setting_share);
        mSettingDataManager = (LinearLayout) v.findViewById(R.id.setting_data_manager);
        mSettingAbout = (LinearLayout) v.findViewById(R.id.setting_about);
        mSettingLayout = (LinearLayout) v.findViewById(R.id.setting_layout);

        mSettingNotion.setOnClickListener(this);
        mSettingAbout.setOnClickListener(this);
        mSettingPerson.setOnClickListener(this);
        mSettingDataManager.setOnClickListener(this);
        mSettingShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_notion:
                Intent intent=new Intent(getActivity(), NotificationActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.setting_about:
                Intent intent2=new Intent(getActivity(), AboutAppActivity.class);
                getActivity().startActivity(intent2);
                break;
            case R.id.setting_person:
                Intent intent3=new Intent(getActivity(), UserInfoActivity.class);
                getActivity().startActivity(intent3);
                break;
            case R.id.setting_data_manager:
                getActivity().startActivity(new Intent(getActivity(), DataManagerActivity.class));
                break;
            case R.id.setting_share:
                getActivity().startActivity(new Intent(getActivity(), DeviceShareActivity.class));

                break;

        }
    }
}
