package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.alibaba.fastjson.JSON;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.ShopRentModel;
import org.chengjian.java.feidian.collectdata.databinding.ActivityShopRentBinding;
import org.chengjian.java.feidian.collectdata.beans.message.LocationMessage;
import org.chengjian.java.feidian.collectdata.beans.message.StickyMessage;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailBasePresenter;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailSRPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.DetailBaseActivity;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailSRView;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class ShopRentActivity extends DetailBaseActivity implements View.OnClickListener, DetailSRView {

    private ActivityShopRentBinding binding;
    private ShopRentModel model;
    private DetailSRPresenter presenter;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        presenter = new DetailSRPresenter(this);
        presenter.attachView(this);
    }

    private void initView(StickyMessage message) {
        this.citySellRent = message.getCitySellRent();
        binding.setCitySellRent(citySellRent);
        binding.setEditable(message.getIsEditable());
        setSpinnerIsEnable(getIsEditable());
        if (!message.getIsEditable()) {
            presenter.loadModel(citySellRent.getId(), "shoprent");
        } else {
            model = new ShopRentModel();
            model.setId(citySellRent.getId());
            initModel(model);
        }
    }
    
    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_rent;
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
        binding.childSrLandSituation.etLandLocation.setText(String.valueOf(locationMessage.getAddress()));
    }

    @Override
    protected void initExpandableLayout() {
        binding.childBase.buttonExtra.setOnClickListener(this);
        binding.childSrLandSituation.buttonLandSituation.setOnClickListener(this);
        binding.childSrBuildingSituation.buttonBuildingSituation.setOnClickListener(this);
        binding.childSrRentSituation.buttonRentSituation.setOnClickListener(this);
        binding.childSrLandSituation.etAuthorizedTime.setOnClickListener(this);
        binding.childSrRentSituation.etRentTime.setOnClickListener(this);
        binding.buttonDelete.setOnClickListener(this);
        binding.buttonEdit.setOnClickListener(this);
        binding.buttonSave.setOnClickListener(this);
        binding.childBase.locate.setOnClickListener(this);
    }

    @Override
    public void initSpinner() {
        binding.childSrLandSituation.spCrossroadSituation.setSelection(citySellRent.getCrossRoadSituation());
        binding.childSrLandSituation.spLandShape.setSelection(citySellRent.getLandShape());
        binding.childSrLandSituation.spLandDevelopingSituation.setSelection(citySellRent.getLandShape());
        binding.childSrLandSituation.spBuildingDirection.setSelection(citySellRent.getBuildingDirection());
        binding.childSrLandSituation.spNearbyStreetSituation.setSelection(citySellRent.getNearbyStreetSituation());
        binding.childSrLandSituation.spIsGore.setSelection(citySellRent.isGore()? 1:0);
        binding.childSrLandSituation.spNearbyLandType.setSelection(model.getNearByLandType());
        binding.childSrLandSituation.spUsagePlaned.setSelection(model.getUseagePlaned());
        binding.childSrLandSituation.spUsageActucal.setSelection(model.getUseageActual());
        binding.childSrBuildingSituation.spDecorationType.setSelection(model.getDecorationType());
        binding.childSrBuildingSituation.spStructureType.setSelection(citySellRent.getStructureType());
        binding.childSrBuildingSituation.spQualityLevel.setSelection(citySellRent.getQualityLevel());
        binding.childSrBuildingSituation.spLightAirType.setSelection(model.getLightAirType());
    }


    @Override
    public void getSpinner() {
        citySellRent.setCrossRoadSituation(binding.childSrLandSituation.spCrossroadSituation.getSelectedItemPosition());
        citySellRent.setLandShape(binding.childSrLandSituation.spLandShape.getSelectedItemPosition());
        citySellRent.setLandDevelopingSituation(binding.childSrLandSituation.spLandDevelopingSituation.getSelectedItemPosition());
        citySellRent.setBuildingDirection(binding.childSrLandSituation.spBuildingDirection.getSelectedItemPosition());
        citySellRent.setNearbyStreetSituation(binding.childSrLandSituation.spNearbyStreetSituation.getSelectedItemPosition());
        citySellRent.setGore(binding.childSrLandSituation.spIsGore.getSelectedItemPosition() == 1);
        model.setUseagePlaned(binding.childSrLandSituation.spUsagePlaned.getSelectedItemPosition());
        model.setUseageActual(binding.childSrLandSituation.spUsageActucal.getSelectedItemPosition());
        model.setDecorationType(binding.childSrBuildingSituation.spDecorationType.getSelectedItemPosition());
        citySellRent.setStructureType(binding.childSrBuildingSituation.spStructureType.getSelectedItemPosition());
        citySellRent.setQualityLevel(binding.childSrBuildingSituation.spQualityLevel.getSelectedItemPosition());
        model.setLightAirType(binding.childSrBuildingSituation.spLightAirType.getSelectedItemPosition());
    }

    @Override
    public void save() {
        getSpinner();
        binding.setEditable(false);
        setSpinnerIsEnable(getIsEditable());
        presenter.save(citySellRent, model);
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
    public void setSpinnerIsEnable(boolean isEnable) {
        binding.childSrLandSituation.spCrossroadSituation.setEnabled(isEnable);
        binding.childSrLandSituation.spLandShape.setEnabled(isEnable);
        binding.childSrLandSituation.spLandDevelopingSituation.setEnabled(isEnable);
        binding.childSrLandSituation.spBuildingDirection.setEnabled(isEnable);
        binding.childSrLandSituation.spNearbyStreetSituation.setEnabled(isEnable);
        binding.childSrLandSituation.spIsGore.setEnabled(isEnable);
        binding.childSrLandSituation.spNearbyLandType.setEnabled(isEnable);
        binding.childSrLandSituation.spUsagePlaned.setEnabled(isEnable);
        binding.childSrLandSituation.spUsageActucal.setEnabled(isEnable);
        binding.childSrBuildingSituation.spDecorationType.setEnabled(isEnable);
        binding.childSrBuildingSituation.spStructureType.setEnabled(isEnable);
        binding.childSrBuildingSituation.spQualityLevel.setEnabled(isEnable);
        binding.childSrBuildingSituation.spLightAirType.setEnabled(isEnable);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_extra:
                changeELState(binding.childBase.elExtra);
                binding.childSrBuildingSituation.elBuildingSituation.collapse();
                binding.childSrLandSituation.elLandSituation.collapse();
                binding.childSrRentSituation.elRentSituation.collapse();
                break;
            case R.id.button_building_situation:
                changeELState(binding.childSrBuildingSituation.elBuildingSituation);
                binding.childBase.elExtra.collapse();
                binding.childSrLandSituation.elLandSituation.collapse();
                binding.childSrRentSituation.elRentSituation.collapse();
                break;
            case R.id.button_land_situation:
                changeELState(binding.childSrLandSituation.elLandSituation);
                binding.childSrBuildingSituation.elBuildingSituation.collapse();
                binding.childBase.elExtra.collapse();
                binding.childSrRentSituation.elRentSituation.collapse();
                break;
            case R.id.button_rent_situation:
                changeELState(binding.childSrRentSituation.elRentSituation);
                binding.childSrBuildingSituation.elBuildingSituation.collapse();
                binding.childSrLandSituation.elLandSituation.collapse();
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
                setTime(binding.childSrLandSituation.etAuthorizedTime);
                break;
            case R.id.et_rent_time:
                setTime(binding.childSrRentSituation.etRentTime);
                break;
            case R.id.locate:
                locate();
                break;
        }
    }

    @Override
    public void initModel(String model) {
        this.model = JSON.parseObject(model, ShopRentModel.class);
        binding.setModel(this.model);
        initSpinner();
    }

    @Override
    public void initModel(ShopRentModel model) {
        this.model = model;
        binding.setModel(this.model);
        initSpinner();
    }
}
