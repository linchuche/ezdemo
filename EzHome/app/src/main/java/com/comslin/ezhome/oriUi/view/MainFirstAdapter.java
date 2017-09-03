package com.comslin.ezhome.oriUi.view;

import android.content.Context;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.http.bean.mainpage.MainPage;
import com.comslin.ezhome.oriUi.http.bean.mainpage.Sensor;
import com.comslin.ezhome.oriUi.http.bean.room.RoomEquipments;
import com.comslin.ezhome.oriUi.http.bean.scene.Scene;
import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;

/**
 * Created by linChao on 2017-09-04.
 */

public class MainFirstAdapter extends BaseAdapter {
    MainPage mainPage = new MainPage();

    public void setMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Object getItem(int position) {
        if (position == 0) {
            return sizeTwoItem;
        }
        return sizeOneItem;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    Context mContext;
    LayoutInflater layoutInflater;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (mContext == null) mContext = parent.getContext();
        if (layoutInflater == null) layoutInflater = LayoutInflater.from(mContext);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.device_type_list_item_layout, parent, false);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.device_type_list_item_icon);
            viewHolder.name = (TextView) convertView.findViewById(R.id.device_type_list_item_title_txtvew);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        switch (position) {
            case 0:
                viewHolder.imageView.setImageResource(R.drawable.speech_full_selector);
                viewHolder.name.setText(R.string.security_protect_yes);
                break;
            case 1:
                setEqipView(viewHolder, mainPage.getEquipment1());
                break;
            case 2:
                setEqipView(viewHolder, mainPage.getEquipment2());
                break;
            case 3:
                setEqipView(viewHolder, mainPage.getEquipment3());
                break;

            case 4:
                setSceneView(viewHolder, mainPage.getManualScene1());
                break;
            case 5:
                setSceneView(viewHolder, mainPage.getManualScene2());
                break;
            case 6:
                setSceneView(viewHolder, mainPage.getManualScene3());
                break;
            case 7:
                setSenserView(viewHolder, mainPage.getSensor1());
                break;
            case 8:
                setSenserView(viewHolder, mainPage.getSensor2());
                break;
            case 9:
                setSenserView(viewHolder, mainPage.getSensor3());
                break;
            case 10:
                setSenserView(viewHolder, mainPage.getSensor4());
                break;
            case 11:
                setSenserView(viewHolder, mainPage.getSensor5());
                break;
        }
        return convertView;
    }

    private void setEqipView(ViewHolder viewHolder, RoomEquipments roomEquipments) {
        if (roomEquipments != null) {
            viewHolder.imageView.setImageResource(DevicesAdapter.getResByTypeId(roomEquipments.getTypeId()));
            viewHolder.name.setText(roomEquipments.getEquipmentName());
        } else {
            viewHolder.imageView.setImageResource(R.drawable.add_src);
            viewHolder.name.setText("添加设备");
        }
    }

    private void setSenserView(ViewHolder viewHolder, Sensor sensor) {
        if (sensor != null) {
            viewHolder.imageView.setImageResource(DevicesAdapter.getResByTypeId(sensor.getTypeId()));
            viewHolder.name.setText(sensor.getDeviceName());
        } else {
            viewHolder.imageView.setImageResource(R.drawable.add_src);
            viewHolder.name.setText("添加传感器");
        }
    }

    private void setSceneView(ViewHolder viewHolder, Scene scene) {
        if (scene != null) {
            viewHolder.imageView.setImageResource(DevicesAdapter.getResByTypeId(scene.getSceneId()));
            viewHolder.name.setText(scene.getSceneName());
        } else {
            viewHolder.imageView.setImageResource(R.drawable.add_src);
            viewHolder.name.setText("添加情景");
        }
    }

    AsymmetricItem sizeOneItem = new AsymmetricItem() {
        @Override
        public int getColumnSpan() {
            return 1;
        }

        @Override
        public int getRowSpan() {
            return 1;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }
    };
    AsymmetricItem sizeTwoItem = new AsymmetricItem() {
        @Override
        public int getColumnSpan() {
            return 2;
        }

        @Override
        public int getRowSpan() {
            return 2;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }
    };

    class ViewHolder {
        ImageView imageView;
        TextView name;
    }
}
