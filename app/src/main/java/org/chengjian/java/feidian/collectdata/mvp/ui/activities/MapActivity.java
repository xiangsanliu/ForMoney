package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.message.LocationMessage;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.BaseActivity;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MapActivity extends BaseActivity {

    private MapView mapView;
    private AMap aMap;
    private AMapLocationClient aMapLocationClient;
    private LocationMessage message = new LocationMessage();
    private Marker marker;
    private boolean isNeedSave;
    private TextView cancel;
    private TextView save;
    private TextView relocate;
    private TextView manual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mapView = (MapView) findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        aMap = mapView.getMap();
        cancel = (TextView) findViewById(R.id.button_cancel);
        save = (TextView) findViewById(R.id.button_save);
        relocate = (TextView) findViewById(R.id.button_relocate);
        manual = (TextView) findViewById(R.id.button_manual);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    private void setUpMap() {
        final MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.interval(2000);
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_FOLLOW);
        aMap.setMyLocationStyle(myLocationStyle);
        aMap.setMyLocationEnabled(true);
        CameraUpdate cameraUpdate = CameraUpdateFactory.zoomTo(17);
        aMap.animateCamera(cameraUpdate);
        UiSettings settings = aMap.getUiSettings();
        settings.setMyLocationButtonEnabled(true);
        settings.setCompassEnabled(true);
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setNeedAddress(true);
        aMapLocationClientOption.setInterval(2000);
        aMapLocationClient = new AMapLocationClient(getApplicationContext());
        aMapLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                message.setLatitude(aMapLocation.getLatitude());
                message.setLongitude(aMapLocation.getLongitude());
                message.setAddress(aMapLocation.getAddress());
            }
        });
        aMapLocationClient.setLocationOption(aMapLocationClientOption);
        aMapLocationClient.startLocation();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onLocate(LocationMessage locationMessage) throws InterruptedException {
        if (locationMessage.getLatitude()>3) {
            manual.setVisibility(View.GONE);
            LatLng latLng = new LatLng(locationMessage.getLatitude(), locationMessage.getLongitude());
            marker = aMap.addMarker(new MarkerOptions().position(latLng).title(locationMessage.getAddress()).snippet("DefaultMarker"));
            CameraUpdate cameraUpdate = CameraUpdateFactory.changeLatLng(latLng);
            aMap.animateCamera(cameraUpdate, 1000, null);
            isNeedSave = false;
        } else {
            relocate.setVisibility(View.GONE);
            isNeedSave = true;
            setUpMap();
            message.setEditable(true);
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNeedSave) {
                    EventBus.getDefault().post(message);
                }
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        relocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manual.setVisibility(View.VISIBLE);
                isNeedSave = true;
                message.setEditable(true);
                marker.remove();
                setUpMap();
                findViewById(R.id.button_relocate).setVisibility(View.GONE);
            }
        });
        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manual.setVisibility(View.GONE);
                enableManualMode();
            }
        });
    }

    private void enableManualMode() {
        aMapLocationClient.stopLocation();
        aMap.setOnMapClickListener(new AMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (marker != null) {
                    marker.remove();
                }
                marker = aMap.addMarker(new MarkerOptions().position(latLng).title("undefine").snippet("DefaultMarker"));
                message.setLatitude(latLng.latitude);
                message.setLongitude(latLng.longitude);
                message.setAddress("");
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_map_activity;
    }
}
