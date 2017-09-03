package com.comslin.ezhome.oriUi.activity.scene;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapClickListener;
import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.SceneDataCenter;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.http.bean.scene.SceneConditionList;


public class WeatherConditionActivity extends BaseActivity implements OnClickListener, OnGetGeoCoderResultListener {
    private static final String TAG = "WeatherCondition";
    // 定位相关
    LocationClient mLocClient;
    public MyLocationListenner myListener = new MyLocationListenner();
    private LocationMode mCurrentMode;
    Marker mCurrentMarker;
    MapView mMapView;
    BaiduMap mBaiduMap;
    private ListView mLvLocationNearBy;
    private ProgressBar pgbLoading;
    // UI相关
    OnCheckedChangeListener radioButtonListener;
    Button requestLocButton;
    boolean isFirstLoc = true;// 是否首次定位
    private AutoCompleteTextView searchText;// 输入搜索关键字
    private String currentLoc = "";
    private double latitude = 0.0;
    private double longitude = 0.0;
    private TextView mSceneWeatherTxt;
    private LinearLayout mSceneLocationCondPoint;
    private ImageView mSceneWeatherRainIcon;
    private LinearLayout mSceneWeatherRain;
    private ImageView mSceneWeatherNoRainIcon;
    private LinearLayout mSceneWeatherNoRain;
    private LinearLayout mSceneLaunchLayout;
    String currentLocation;

    @Override
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

    }

    @Override
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        if (reverseGeoCodeResult.getAddress() != null) {
            currentLocation = reverseGeoCodeResult.getAddress();
            mSceneWeatherTxt.setText(currentLocation);
        }
    }
    private void saveCondition(){
        SceneConditionList sceneConditionList  = new SceneConditionList();
        sceneConditionList.setConditionType("天气条件");
        sceneConditionList.setConditionExp(rainy?"有雨":"无雨");
        sceneConditionList.setEquipmentId(1);
        sceneConditionList.setId(1);
        SceneDataCenter.sceneConditionList.add(sceneConditionList);
        onBackPressed();
    }

    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // map view 销毁后不在处理新接收的位置
            Log.d(TAG, "onReceiveLocation: " + location.getLocType());
            if (location.getLocType() == BDLocation.TypeGpsLocation) {

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {

            } else {
                //定位失败了！
                return;
            }

            LatLng ptCenter = new LatLng(location.getLatitude(), location.getLongitude());

            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
            if (isFirstLoc) {
                isFirstLoc = false;
                MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ptCenter);
                mBaiduMap.animateMapStatus(u);
            }
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            mSearch.reverseGeoCode(new ReverseGeoCodeOption().location(ptCenter));

        }

        public void onReceivePoi(BDLocation poiLocation) {
        }
    }

    GeoCoder mSearch = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        mSearch = GeoCoder.newInstance();
        mSearch.setOnGetGeoCodeResultListener(this);

        LayoutInflater.from(this).inflate(R.layout.scene_weather_layout, topContentView);
        initView();
        initLocation();
    }

    private TextView popupText = null;// 泡泡view
    private TextView positionText;

    private void initView() {
        mCurrentMode = LocationMode.NORMAL;
        setLeftButton(R.drawable.backbtn_selector);
        setTitle(R.string.scene_sel_cond_type_weather);
        setTopRightText(R.string.common_save);
        topRightTitleTxt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCondition();
            }
        });
        mMapView = (MapView) findViewById(R.id.scene_weather_map);
        mSceneWeatherTxt = (TextView) findViewById(R.id.scene_weather_txt);
        mSceneLocationCondPoint = (LinearLayout) findViewById(R.id.scene_location_cond_point);
        mSceneWeatherRainIcon = (ImageView) findViewById(R.id.scene_weather_rain_icon);
        mSceneWeatherRain = (LinearLayout) findViewById(R.id.scene_weather_rain);
        mSceneWeatherNoRainIcon = (ImageView) findViewById(R.id.scene_weather_no_rain_icon);
        mSceneWeatherNoRain = (LinearLayout) findViewById(R.id.scene_weather_no_rain);
        mSceneLaunchLayout = (LinearLayout) findViewById(R.id.scene_launch_layout);
    }

    boolean rainy = true;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scene_weather_no_rain:
                mSceneWeatherRainIcon.setVisibility(View.INVISIBLE);
                mSceneWeatherNoRainIcon.setVisibility(View.VISIBLE);
                rainy = false;
                break;
            case R.id.scene_weather_rain:
                mSceneWeatherRainIcon.setVisibility(View.VISIBLE);
                mSceneWeatherNoRainIcon.setVisibility(View.INVISIBLE);
                rainy = true;
                break;

        }
    }

    /**
     * 地图初始化
     */
    private void initLocation() {
        // 地图初始化
        BaiduMapOptions options = new BaiduMapOptions();
        options.zoomControlsEnabled(false);
//        mMapView = new MapView(this, options);
        mBaiduMap = mMapView.getMap();
        UiSettings mUiSettings = mBaiduMap.getUiSettings();
        mUiSettings.setRotateGesturesEnabled(false);//启用手势旋转
        mUiSettings.setOverlookingGesturesEnabled(false);//启用俯视手势
        mUiSettings.setCompassEnabled(false);//启用指南针图层
        mBaiduMap.setOnMapClickListener(new OnMapClickListener() {
            public void onMapClick(LatLng point) {
                // 在此处理点击事件
            }

            public boolean onMapPoiClick(MapPoi poi) {
                // 在此处理底图标注点击事件
                if (poi != null) {
                    mBaiduMap.showInfoWindow(new InfoWindow(popupText, new LatLng(
                            poi.getPosition().latitude,
                            poi.getPosition().longitude), 0));

                    latitude = poi.getPosition().latitude;
                    longitude = poi.getPosition().longitude;
//                    positionText.setText(currentLoc + "-" + poi.getName());
                    MyLocationData locData = new MyLocationData.Builder()
                            .accuracy(0)
                            // 此处设置开发者获取到的方向信息，顺时针0-360
                            .direction(100).latitude(poi.getPosition().latitude)
                            .longitude(poi.getPosition().longitude).build();
                    mBaiduMap.setMyLocationData(locData);

                    LatLng ll = new LatLng(poi.getPosition().latitude,
                            poi.getPosition().longitude);
                    MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
                    mBaiduMap.animateMapStatus(u);
                    mSceneWeatherTxt.setText(poi.getName());
                }
                return false;
            }
        });

        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        // 定位初始化
        mLocClient = new LocationClient(this);
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true);// 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(-1);
        mLocClient.setLocOption(option);
        mLocClient.start();
    }

    /**
     * 手动请求定位的方法
     */
    public void requestLocation() {
        if (mLocClient != null && mLocClient.isStarted()) {
            isFirstLoc = true;
            pgbLoading.setVisibility(View.VISIBLE);
            mLocClient.requestLocation();
        } else {
            Log.d("log", "locClient is null or not started");
        }
    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mMapView.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        // 退出时销毁定位
        mLocClient.stop();
        // 关闭定位图层
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }
}
/*
61 ： GPS定位结果，GPS定位成功。
        62 ： 无法获取有效定位依据，定位失败，请检查运营商网络或者WiFi网络是否正常开启，尝试重新请求定位。
        63 ： 网络异常，没有成功向服务器发起请求，请确认当前测试手机网络是否通畅，尝试重新请求定位。
        65 ： 定位缓存的结果。
        66 ： 离线定位结果。通过requestOfflineLocaiton调用时对应的返回结果。
        67 ： 离线定位失败。通过requestOfflineLocaiton调用时对应的返回结果。
        68 ： 网络连接失败时，查找本地离线定位时对应的返回结果。
        161： 网络定位结果，网络定位成功。
        162： 请求串密文解析失败，一般是由于客户端SO文件加载失败造成，请严格参照开发指南或demo开发，放入对应SO文件。
        167： 服务端定位失败，请您检查是否禁用获取位置信息权限，尝试重新请求定位。
        502： AK参数错误，请按照说明文档重新申请AK。
        505：AK不存在或者非法，请按照说明文档重新申请AK。
        601： AK服务被开发者自己禁用，请按照说明文档重新申请AK。
        602： key mcode不匹配，您的AK配置过程中安全码设置有问题，请确保：SHA1正确，“;”分号是英文状态；且包名是您当前运行应用的包名，请按照说明文档重新申请AK。
        501～700：AK验证失败，请按照说明文档重新申请AK。*/