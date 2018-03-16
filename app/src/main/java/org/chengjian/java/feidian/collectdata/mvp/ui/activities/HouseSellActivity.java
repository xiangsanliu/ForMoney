package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.alibaba.fastjson.JSON;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.HouseSalePrice;
import org.chengjian.java.feidian.collectdata.databinding.ActivityHouseSellBinding;
import org.chengjian.java.feidian.collectdata.beans.message.LocationMessage;
import org.chengjian.java.feidian.collectdata.beans.message.StickyMessage;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailBasePresenter;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailHSPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.DetailBaseActivity;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailHSView;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class HouseSellActivity extends DetailBaseActivity implements View.OnClickListener, DetailHSView {

    private ActivityHouseSellBinding binding;
    private DetailHSPresenter presenter;
    private HouseSalePrice model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        presenter = new DetailHSPresenter(this);
        presenter.attachView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_house_sell;
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(StickyMessage stickyMessage) {
        initView(stickyMessage);
        initExpandableLayout();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLocateResult(LocationMessage locationMessage) {
        binding.setEditable(locationMessage.isEditable());
        binding.childBase.latitude.setText(String.valueOf(locationMessage.getLatitude()));
        binding.childBase.longitude.setText(String.valueOf(locationMessage.getLongitude()));
        binding.childHsLandSituation.etLandLocation.setText(String.valueOf(locationMessage.getAddress()));
    }

    private void initView(StickyMessage message) {
        this.cityCommonAttributes = message.getCityCommonAttributes();
        binding.setCitySellRent(cityCommonAttributes);
        binding.setEditable(message.getIsEditable());
        setSpinnerIsEnable(getIsEditable());
        if (!message.getIsEditable()) {
            presenter.loadModel(cityCommonAttributes.getId(), "housetrade");
        } else {
            model = new HouseSalePrice();
            model.setId(cityCommonAttributes.getId());
            initModel(model);
        }
    }

    @Override
    protected void initExpandableLayout() {
        binding.childBase.buttonExtra.setOnClickListener(this);
        binding.childHsLandSituation.buttonLandSituation.setOnClickListener(this);
        binding.childHsBuildingSituation.buttonBuildingSituation.setOnClickListener(this);
        binding.childHsTradeSituation.buttonTradeSituation.setOnClickListener(this);
        binding.buttonDelete.setOnClickListener(this);
        binding.buttonEdit.setOnClickListener(this);
        binding.buttonSave.setOnClickListener(this);
        binding.childHsTradeSituation.etTradeTime.setOnClickListener(this);
        binding.childHsLandSituation.etAuthorizedTime.setOnClickListener(this);
        binding.childBase.locate.setOnClickListener(this);
    }

    @Override
    public void initSpinner() {
        binding.childHsLandSituation.spCrossroadSituation.setSelection(cityCommonAttributes.getCrossRoadSituation());
        binding.childHsLandSituation.spLandShape.setSelection(cityCommonAttributes.getLandShape());
        binding.childHsLandSituation.spLandDevelopingSituation.setSelection(cityCommonAttributes.getLandShape());
        binding.childHsLandSituation.spBuildingDirection.setSelection(cityCommonAttributes.getBuildingDirection());
        binding.childHsLandSituation.spNearbyStreetSituation.setSelection(cityCommonAttributes.getNearbyStreetSituation());
        binding.childHsLandSituation.spIsGore.setSelection(cityCommonAttributes.getGore()? 1:0);
        binding.childHsLandSituation.spNearbyLandType.setSelection(model.getNearByLandType());
        binding.childHsLandSituation.spUsagePlaned.setSelection(model.getUseagePlaned());
        binding.childHsLandSituation.spUsageActucal.setSelection(model.getUseageActual());
        binding.childHsBuildingSituation.spDecorationType.setSelection(model.getDecorationType());
        binding.childHsBuildingSituation.spStructureType.setSelection(cityCommonAttributes.getStructureType());
        binding.childHsBuildingSituation.spQualityLevel.setSelection(cityCommonAttributes.getQualityLevel());
        binding.childHsBuildingSituation.spLightAirType.setSelection(model.getLightAirType());
    }

    @Override
    public void setSpinnerIsEnable(boolean isEnable) {
        binding.childHsLandSituation.spCrossroadSituation.setEnabled(isEnable);
        binding.childHsLandSituation.spLandShape.setEnabled(isEnable);
        binding.childHsLandSituation.spLandDevelopingSituation.setEnabled(isEnable);
        binding.childHsLandSituation.spBuildingDirection.setEnabled(isEnable);
        binding.childHsLandSituation.spNearbyStreetSituation.setEnabled(isEnable);
        binding.childHsLandSituation.spIsGore.setEnabled(isEnable);
        binding.childHsLandSituation.spNearbyLandType.setEnabled(isEnable);
        binding.childHsLandSituation.spUsagePlaned.setEnabled(isEnable);
        binding.childHsLandSituation.spUsageActucal.setEnabled(isEnable);
        binding.childHsBuildingSituation.spDecorationType.setEnabled(isEnable);
        binding.childHsBuildingSituation.spStructureType.setEnabled(isEnable);
        binding.childHsBuildingSituation.spQualityLevel.setEnabled(isEnable);
        binding.childHsBuildingSituation.spLightAirType.setEnabled(isEnable);
    }


    @Override
    public void getSpinner() {
        cityCommonAttributes.setCrossRoadSituation(binding.childHsLandSituation.spCrossroadSituation.getSelectedItemPosition());
        cityCommonAttributes.setLandShape(binding.childHsLandSituation.spLandShape.getSelectedItemPosition());
        cityCommonAttributes.setLandDevelopingSituation(binding.childHsLandSituation.spLandDevelopingSituation.getSelectedItemPosition());
        cityCommonAttributes.setBuildingDirection(binding.childHsLandSituation.spBuildingDirection.getSelectedItemPosition());
        cityCommonAttributes.setNearbyStreetSituation(binding.childHsLandSituation.spNearbyStreetSituation.getSelectedItemPosition());
        cityCommonAttributes.setGore(binding.childHsLandSituation.spIsGore.getSelectedItemPosition() == 1);
        model.setUseagePlaned(binding.childHsLandSituation.spUsagePlaned.getSelectedItemPosition());
        model.setUseageActual(binding.childHsLandSituation.spUsageActucal.getSelectedItemPosition());
        model.setDecorationType(binding.childHsBuildingSituation.spDecorationType.getSelectedItemPosition());
        cityCommonAttributes.setStructureType(binding.childHsBuildingSituation.spStructureType.getSelectedItemPosition());
        cityCommonAttributes.setQualityLevel(binding.childHsBuildingSituation.spQualityLevel.getSelectedItemPosition());
        model.setLightAirType(binding.childHsBuildingSituation.spLightAirType.getSelectedItemPosition());
    }

    @Override
    public void save() {
        getSpinner();
        binding.setEditable(false);
        setSpinnerIsEnable(getIsEditable());
        presenter.save(cityCommonAttributes, model);
    }

    @Override
    public Boolean getIsEditable() {
        return binding.getEditable();
    }

    @Override
    public DetailBasePresenter getPresenter() {
        return presenter;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_extra:
                changeELState(binding.childBase.elExtra);
                binding.childHsBuildingSituation.elBuildingSituation.collapse();
                binding.childHsLandSituation.elLandSituation.collapse();
                binding.childHsTradeSituation.elTradeSituation.collapse();
                break;
            case R.id.button_building_situation:
                changeELState(binding.childHsBuildingSituation.elBuildingSituation);
                binding.childBase.elExtra.collapse();
                binding.childHsLandSituation.elLandSituation.collapse();
                binding.childHsTradeSituation.elTradeSituation.collapse();
                break;
            case R.id.button_land_situation:
                changeELState(binding.childHsLandSituation.elLandSituation);
                binding.childHsBuildingSituation.elBuildingSituation.collapse();
                binding.childBase.elExtra.collapse();
                binding.childHsTradeSituation.elTradeSituation.collapse();
                break;
            case R.id.button_trade_situation:
                changeELState(binding.childHsTradeSituation.elTradeSituation);
                binding.childHsBuildingSituation.elBuildingSituation.collapse();
                binding.childHsLandSituation.elLandSituation.collapse();
                binding.childBase.elExtra.collapse();
                break;
            case R.id.button_edit:
                binding.setEditable(true);
                setSpinnerIsEnable(getIsEditable());
                break;
            case R.id.button_save:
                save();
                break;
            case R.id.button_delete:
                showDeleteConfirm();
                break;
            case R.id.et_authorized_time:
                setTime(binding.childHsLandSituation.etAuthorizedTime);
                break;
            case R.id.et_trade_time:
                setTime(binding.childHsTradeSituation.etTradeTime);
                break;
            case R.id.locate:
                locate();
                break;
        }
    }

    @Override
    public void initModel(String model) {
        this.model = JSON.parseObject(model, HouseSalePrice.class);
        binding.setModel(this.model);
        initSpinner();
    }

    @Override
    public void initModel(HouseSalePrice model) {
        this.model = model;
        binding.setModel(this.model);
        initSpinner();
    }

}
