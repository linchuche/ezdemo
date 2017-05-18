package com.comslin.ezhome.oriUi.view;

import com.comslin.ezhome.R;

/**
 * Created by linChao on 2017-05-14.
 */

public class ResContent {
    public static int ROOM_TYPE_COUNT=7;
    public static int getRoomTypeByTypeId(int typeId) {
        switch (typeId) {
            case 0:
                return R.drawable.room_type10;
            case 1:
                return R.drawable.room_type11;
            case 2:
                return R.drawable.room_type12;
            case 3:
                return R.drawable.room_type13;
            case 4:
                return R.drawable.room_type14;
            case 5:
                return R.drawable.room_type15;
            default:
                return R.drawable.room_type16;
        }
    }
    public static String getRoomNameByTypeId(int typeId){
        switch (typeId) {
            case 0:
                return "客厅";
            case 1:
                return "餐厅";
            case 2:
                return "厨房";
            case 3:
                return "卧室";
            case 4:
                return "卫生间";
            case 5:
                return "阳台";
            default:
                return "书房";
        }

    }
}
