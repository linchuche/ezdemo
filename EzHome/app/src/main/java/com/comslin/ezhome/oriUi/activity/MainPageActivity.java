package com.comslin.ezhome.oriUi.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.fragment.BlankFragment;
import com.comslin.ezhome.oriUi.fragment.MainPageFragment;
import com.comslin.ezhome.oriUi.fragment.PersonInfoFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainPageActivity extends BaseActivity {

    private BottomBar mBottomBar;
    private String TAG = "MainPageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRunningActivity(this);
        initView();
//        setSelectedPage(0);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                Log.d(TAG, "onTabSelected: " + tabId);
                if (tabId == R.id.tab_home) setSelectedPage(0);
                else if (tabId == R.id.tab_camera) setSelectedPage(1);
                else if (tabId == R.id.tab_person) setSelectedPage(2);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setRunningActivity(null);
    }

    MainPageFragment mainPageFragment;
    BlankFragment blankFragment1;
    PersonInfoFragment personFragment;
    private String[] fgTags = {"我的", "摄像", "个人"};

    private void setSelectedPage(int i) {
        if (i < 0) return;
        hideAllFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (i) {
            case 0:
                if (getFragmentManager().findFragmentByTag(fgTags[i]) == null) {
                    mainPageFragment = new MainPageFragment();
                    transaction.add(R.id.fragment_container,mainPageFragment, fgTags[i]);
                }
                transaction.show(mainPageFragment);
                break;
            case 1:
                if (getFragmentManager().findFragmentByTag(fgTags[i]) == null) {
                    blankFragment1 = new BlankFragment();
                    transaction.add(R.id.fragment_container,blankFragment1, fgTags[i]);
                }
                transaction.show(blankFragment1);
                break;
            case 2:
                if (getFragmentManager().findFragmentByTag(fgTags[i]) == null) {
                    personFragment = new PersonInfoFragment();
                    transaction.add(R.id.fragment_container,personFragment, fgTags[i]);
                }
                transaction.show(personFragment);
                break;
        }
        transaction.commit();
    }

    private void hideAllFragment() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (mainPageFragment != null)
            transaction.hide(mainPageFragment);
        if (blankFragment1 != null)
            transaction.hide(blankFragment1);
        if (personFragment != null)
            transaction.hide(personFragment);
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
    long exitTime = 0;

    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
        }
    }

    private void initView() {
        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);

    }
}
