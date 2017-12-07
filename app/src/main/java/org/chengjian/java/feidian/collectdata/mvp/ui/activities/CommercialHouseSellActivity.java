package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModel;
import org.chengjian.java.feidian.collectdata.databinding.ActivityCommercialHouseTradeBinding;
import org.chengjian.java.feidian.collectdata.mvp.model.ResultMessage;
import org.chengjian.java.feidian.collectdata.mvp.model.StickyMessage;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailCHSPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.DetailBaseActivity;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailCHSView;
import org.chengjian.java.feidian.collectdata.shared.Constants;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;


public class CommercialHouseSellActivity extends DetailBaseActivity implements View.OnClickListener, DetailCHSView {


    ActivityCommercialHouseTradeBinding binding;
    private CommercialHouseTradeModel model;
    private DetailCHSPresenter presenter;
    AMapLocationClient aMapLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        presenter = new DetailCHSPresenter(this);
        presenter.attachView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_commercial_house_trade;
    }

    @Override
    protected void initExpandableLayout() {
        binding.childBase.buttonExtra.setOnClickListener(this);
        binding.childChsBuildingSituation.buttonBuildingSituation.setOnClickListener(this);
        binding.childChsLandSituation.buttonLandSituation.setOnClickListener(this);
        binding.childChsTradeSituation.buttonTradeSituation.setOnClickListener(this);
        binding.buttonDelete.setOnClickListener(this);
        binding.buttonEdit.setOnClickListener(this);
        binding.buttonSave.setOnClickListener(this);
        binding.childChsLandSituation.etAuthorizedTime.setOnClickListener(this);
        binding.childChsTradeSituation.etTradeTime.setOnClickListener(this);
        binding.childBase.locate.setOnClickListener(this);
    }

    @Override
    public void initSpinner() {
        binding.childChsLandSituation.spBuildingDirection.setSelection(citySellRent.getBuildingDirection());
        binding.childChsLandSituation.spCrossroadSituation.setSelection(citySellRent.getCrossRoadSituation());
        binding.childChsLandSituation.spIsGore.setSelection(citySellRent.isGore()?0:1);
        binding.childChsLandSituation.spLandDevelopingSituation.setSelection(citySellRent.getLandDevelopingSituation());
        binding.childChsLandSituation.spLandShape.setSelection(citySellRent.getLandShape());
        binding.childChsLandSituation.spNearbyStreetSituation.setSelection(citySellRent.getNearbyStreetSituation());
        binding.childChsLandSituation.spUsageActucal.setSelection(model.getUseageActual());
        binding.childChsLandSituation.spUsagePlaned.setSelection(model.getUseagePlande());
        binding.childChsBuildingSituation.spQualityLevel.setSelection(citySellRent.getQualityLevel());
        binding.childChsBuildingSituation.spStructureType.setSelection(citySellRent.getStructureType());
        binding.childChsTradeSituation.spTradeType.setSelection(model.getTradeType());

    }

    private void initView(StickyMessage message) {
        this.citySellRent = message.getCitySellRent();
        this.isEditable = message.getEditable();
        binding.setCitySellRent(citySellRent);
        binding.setEditable(isEditable);
        if (!isEditable) {
            presenter.loadModel(citySellRent.getId());
        } else {
            model = new CommercialHouseTradeModel();
            model.setId(citySellRent.getId());
            initModel(model);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(StickyMessage stickyMessage) {
        initView(stickyMessage);
        initExpandableLayout();
    }

    @Override
    public void getSpinner() {
        citySellRent.setBuildingDirection(binding.childChsLandSituation.spBuildingDirection.getSelectedItemPosition());
        citySellRent.setCrossRoadSituation(binding.childChsLandSituation.spCrossroadSituation.getSelectedItemPosition());
        citySellRent.setGore(binding.childChsLandSituation.spIsGore.getSelectedItemPosition() == 0);
        citySellRent.setLandDevelopingSituation(binding.childChsLandSituation.spLandDevelopingSituation.getSelectedItemPosition());
        citySellRent.setLandShape(binding.childChsLandSituation.spLandShape.getSelectedItemPosition());
        citySellRent.setNearbyStreetSituation(binding.childChsLandSituation.spNearbyStreetSituation.getSelectedItemPosition());
        model.setUseageActual(binding.childChsLandSituation.spUsageActucal.getSelectedItemPosition());
        model.setUseagePlande(binding.childChsLandSituation.spUsagePlaned.getSelectedItemPosition());
        citySellRent.setQualityLevel(binding.childChsBuildingSituation.spQualityLevel.getSelectedItemPosition());
        citySellRent.setStructureType(binding.childChsBuildingSituation.spStructureType.getSelectedItemPosition());
        model.setTradeType(binding.childChsTradeSituation.spTradeType.getSelectedItemPosition());

    }

    @Override
    public void save() {
        getSpinner();
        binding.setEditable(false);
        presenter.save(citySellRent, model);
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
        }
    }

    @Override
    public void delete() {
        presenter.deleteCity(citySellRent.getId());
        EventBus.getDefault().postSticky(new ResultMessage(true));
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_extra:
                changeELState(binding.childBase.elExtra);
                binding.childChsBuildingSituation.elBuildingSituation.collapse();
                binding.childChsLandSituation.elLandSituation.collapse();
                binding.childChsTradeSituation.elTradeSituation.collapse();
                break;
            case R.id.button_building_situation:
                changeELState(binding.childChsBuildingSituation.elBuildingSituation);
                binding.childBase.elExtra.collapse();
                binding.childChsLandSituation.elLandSituation.collapse();
                binding.childChsTradeSituation.elTradeSituation.collapse();
                break;
            case R.id.button_land_situation:
                changeELState(binding.childChsLandSituation.elLandSituation);
                binding.childChsBuildingSituation.elBuildingSituation.collapse();
                binding.childBase.elExtra.collapse();
                binding.childChsTradeSituation.elTradeSituation.collapse();
                break;
            case R.id.button_trade_situation:
                changeELState(binding.childChsTradeSituation.elTradeSituation);
                binding.childChsBuildingSituation.elBuildingSituation.collapse();
                binding.childChsLandSituation.elLandSituation.collapse();
                binding.childBase.elExtra.collapse();
                break;
            case R.id.button_edit:
                binding.setEditable(true);
                binding.childBase.etReasearcher.requestFocus();
                binding.childBase.elExtra.expand();
                break;


            case R.id.button_delete:
                delete();
                break;
            case R.id.button_save:
                save();
                break;
            case R.id.et_authorized_time:
                setTime(binding.childChsLandSituation.etAuthorizedTime);
                break;
            case R.id.et_trade_time:
                setTime(binding.childChsTradeSituation.etTradeTime);
                break;

            case R.id.locate:
//                startActivityForResult(new Intent(this, MapActivity.class), RESULT_OK);
                locate();
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {
        presenter.dismissProgress();
    }

    @Override
    public void showMessage(String message) {

    }


    //获取位置信息
    private void locate() {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setNeedAddress(true);
        aMapLocationClientOption.setInterval(2000);
        aMapLocationClient = new AMapLocationClient(getApplicationContext());
        aMapLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                binding.childBase.longitude.setText(String.valueOf(aMapLocation.getLongitude()));
                binding.childBase.latitude.setText(String.valueOf(aMapLocation.getLatitude()));
                binding.childChsLandSituation.etLandLocation.setText(aMapLocation.getAddress());
            }
        });
        aMapLocationClient.setLocationOption(aMapLocationClientOption);
        aMapLocationClient.startLocation();
    }

    //加载CommercialHouseTradeModel
    @Override
    public void initModel(String model) {
        this.model = JSON.parseObject(model, CommercialHouseTradeModel.class);
        binding.setCommercialHouseTradeModel(this.model);
        initSpinner();
    }

    public void initModel(CommercialHouseTradeModel model) {
        this.model = model;
        binding.setCommercialHouseTradeModel(model);
        initSpinner();
    }
}
