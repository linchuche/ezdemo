package com.comslin.ezhome.oriUi.view;

import android.os.Parcel;

import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;

/**
 * Created by linChao on 2017-05-06.
 */

public class AsvGridItem implements AsymmetricItem {
    private int columnSpan;
    private int rowSpan;


    public AsvGridItem(int columnSpan, int rowSpan) {
        this.columnSpan = columnSpan;
        this.rowSpan = rowSpan;
    }

    @Override
    public int getColumnSpan() {
        return 0;
    }

    @Override
    public int getRowSpan() {
        return 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.columnSpan);
        dest.writeInt(this.rowSpan);
    }

    public AsvGridItem() {
    }

    protected AsvGridItem(Parcel in) {
        this.columnSpan = in.readInt();
        this.rowSpan = in.readInt();
    }

    public static final Creator<AsvGridItem> CREATOR = new Creator<AsvGridItem>() {
        @Override
        public AsvGridItem createFromParcel(Parcel source) {
            return new AsvGridItem(source);
        }

        @Override
        public AsvGridItem[] newArray(int size) {
            return new AsvGridItem[size];
        }
    };
}
