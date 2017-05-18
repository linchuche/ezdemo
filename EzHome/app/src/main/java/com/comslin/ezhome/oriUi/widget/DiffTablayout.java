package com.comslin.ezhome.oriUi.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.comslin.ezhome.R;

/**
 * Created by linChao on 2017-04-26.
 */

public class DiffTablayout extends SlidingTabLayout {
    public DiffTablayout(Context context) {
        super(context);
    }

    public DiffTablayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DiffTablayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void populateTabStrip() {
        final PagerAdapter adapter = mViewPager.getAdapter();
        final OnClickListener tabClickListener = new TabClickListener();

        for (int i = 0; i < adapter.getCount(); i++) {

            View tabView = null;
            TextView tabTitleView = null;
            if (i == 0) {
                tabView = createFirstTab(getContext());
            } else {
                if (mTabViewLayoutId != 0) {
                    // If there is a custom tab view layout id set, try and inflate it
                    tabView = LayoutInflater.from(getContext()).inflate(mTabViewLayoutId, mTabStrip,
                            false);
                    tabTitleView = (TextView) tabView.findViewById(mTabViewTextViewId);
                }

                if (tabView == null) {
                    tabView = createDefaultTabView(getContext());
                }

                if (tabTitleView == null && TextView.class.isInstance(tabView)) {
                    tabTitleView = (TextView) tabView;
                }

                tabTitleView.setText(adapter.getPageTitle(i));
            }
            tabView.setOnClickListener(tabClickListener);
            layoutParams.weight = 1;
            mTabStrip.addView(tabView, layoutParams);
        }
    }

    protected ImageView createFirstTab(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.homeicon);
        int padding = (int) (TAB_VIEW_PADDING_DIPS * getResources().getDisplayMetrics().density);
        imageView.setPadding(padding, padding, padding, padding);
        imageView.setClickable(true);
        return imageView;
    }

    @Override
    protected TextView createDefaultTabView(Context context) {
        TextView textView = super.createDefaultTabView(context);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(20);
        return textView;
    }
}
