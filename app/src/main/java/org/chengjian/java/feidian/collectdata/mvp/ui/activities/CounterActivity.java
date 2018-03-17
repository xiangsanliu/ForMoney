package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.CounterRent;
import org.chengjian.java.feidian.collectdata.beans.message.LocationMessage;
import org.chengjian.java.feidian.collectdata.beans.message.StickyMessage;
import org.chengjian.java.feidian.collectdata.databinding.ActivityShopRentBinding;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailBasePresenter;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailSRPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.DetailBaseActivity;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailBaseView;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class CounterActivity extends DetailBaseActivity implements View.OnClickListener, DetailBaseView<CounterRent> {

    private ActivityShopRentBinding binding;
    private CounterRent model;
    private DetailSRPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        presenter = new DetailSRPresenter(this);
        presenter.attachView(this);
    }

    private void initView(StickyMessage message) {
        this.cityCommonAttributes = message.getCityCommonAttributes();
        binding.setCitySellRent(cityCommonAttributes);
        binding.setEditable(message.getIsEditable());
        setSpinnerIsEnable(getIsEditable());
        if (!message.getIsEditable()) {
            presenter.loadModel(cityCommonAttributes.getId());
        } else {
            model = new CounterRent();
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
        binding.childSrLandSituation.spCrossroadSituation.setSelection(cityCommonAttributes.getCrossRoadSituation());
        binding.childSrLandSituation.spLandShape.setSelection(cityCommonAttributes.getLandShape());
        binding.childSrLandSituation.spLandDevelopingSituation.setSelection(cityCommonAttributes.getLandShape());
        binding.childSrLandSituation.spBuildingDirection.setSelection(cityCommonAttributes.getBuildingDirection());
        binding.childSrLandSituation.spNearbyStreetSituation.setSelection(cityCommonAttributes.getNearbyStreetSituation());
        binding.childSrLandSituation.spIsGore.setSelection(cityCommonAttributes.getGore() ? 1 : 0);
        binding.childSrLandSituation.spNearbyLandType.setSelection(model.getNearByLandType());
        binding.childSrLandSituation.spUsagePlaned.setSelection(model.getUseagePlaned());
        binding.childSrLandSituation.spUsageActucal.setSelection(model.getUseageActual());
        binding.childSrBuildingSituation.spDecorationType.setSelection(model.getDecorationType());
        binding.childSrBuildingSituation.spStructureType.setSelection(cityCommonAttributes.getStructureType());
        binding.childSrBuildingSituation.spQualityLevel.setSelection(cityCommonAttributes.getQualityLevel());
        binding.childSrBuildingSituation.spLightAirType.setSelection(model.getLightAirType());
    }


    @Override
    public void getSpinner() {
        cityCommonAttributes.setCrossRoadSituation(binding.childSrLandSituation.spCrossroadSituation.getSelectedItemPosition());
        cityCommonAttributes.setLandShape(binding.childSrLandSituation.spLandShape.getSelectedItemPosition());
        cityCommonAttributes.setLandDevelopingSituation(binding.childSrLandSituation.spLandDevelopingSituation.getSelectedItemPosition());
        cityCommonAttributes.setBuildingDirection(binding.childSrLandSituation.spBuildingDirection.getSelectedItemPosition());
        cityCommonAttributes.setNearbyStreetSituation(binding.childSrLandSituation.spNearbyStreetSituation.getSelectedItemPosition());
        cityCommonAttributes.setGore(binding.childSrLandSituation.spIsGore.getSelectedItemPosition() == 1);
        model.setUseagePlaned(binding.childSrLandSituation.spUsagePlaned.getSelectedItemPosition());
        model.setUseageActual(binding.childSrLandSituation.spUsageActucal.getSelectedItemPosition());
        model.setDecorationType(binding.childSrBuildingSituation.spDecorationType.getSelectedItemPosition());
        cityCommonAttributes.setStructureType(binding.childSrBuildingSituation.spStructureType.getSelectedItemPosition());
        cityCommonAttributes.setQualityLevel(binding.childSrBuildingSituation.spQualityLevel.getSelectedItemPosition());
        model.setLightAirType(binding.childSrBuildingSituation.spLightAirType.getSelectedItemPosition());
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
    public void initModel(CounterRent model) {
        this.model = model;
        binding.setModel(this.model);
        initSpinner();
    }
}
