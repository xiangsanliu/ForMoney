package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.HouseRent;
import org.chengjian.java.feidian.collectdata.beans.message.LocationMessage;
import org.chengjian.java.feidian.collectdata.beans.message.StickyMessage;
import org.chengjian.java.feidian.collectdata.databinding.ActivityHouseRentBinding;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailBasePresenter;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailHRPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.DetailBaseActivity;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailBaseView;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class HouseRentActivity extends DetailBaseActivity implements View.OnClickListener, DetailBaseView<HouseRent> {

    private ActivityHouseRentBinding binding;
    private HouseRent model;
    private DetailHRPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        presenter = new DetailHRPresenter(this);
        presenter.attachView(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_house_rent;
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(StickyMessage stickyMessage) {
        initViews(stickyMessage);
        initExpandableLayout();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLocateResult(LocationMessage locationMessage) {
        binding.setEditable(locationMessage.isEditable());
        binding.childBase.latitude.setText(String.valueOf(locationMessage.getLatitude()));
        binding.childBase.longitude.setText(String.valueOf(locationMessage.getLongitude()));
        binding.childHrLandSituation.etLandLocation.setText(String.valueOf(locationMessage.getAddress()));
    }

    private void initViews(StickyMessage message) {
        this.cityCommonAttributes = message.getCityCommonAttributes();
        binding.setCitySellRent(cityCommonAttributes);
        binding.setEditable(message.getIsEditable());
        setSpinnerIsEnable(getIsEditable());
        if (!message.getIsEditable()) {
            presenter.loadModel(cityCommonAttributes.getId());
        } else {
            model = new HouseRent();
            initModel(model);
        }
    }

    @Override
    protected void initExpandableLayout() {
        binding.childBase.buttonExtra.setOnClickListener(this);
        binding.childHrLandSituation.buttonLandSituation.setOnClickListener(this);
        binding.childHrBuildingSituation.buttonBuildingSituation.setOnClickListener(this);
        binding.childHrRentSituation.buttonRentSituation.setOnClickListener(this);
        binding.buttonDelete.setOnClickListener(this);
        binding.buttonEdit.setOnClickListener(this);
        binding.buttonSave.setOnClickListener(this);
        binding.childHrLandSituation.etAuthorizedTime.setOnClickListener(this);
        binding.childHrRentSituation.etRentTime.setOnClickListener(this);
        binding.childBase.locate.setOnClickListener(this);

    }

    @Override
    public void initSpinner() {
        binding.childHrLandSituation.spCrossroadSituation.setSelection(cityCommonAttributes.getCrossRoadSituation());
        binding.childHrLandSituation.spLandShape.setSelection(cityCommonAttributes.getLandShape());
        binding.childHrLandSituation.spLandDevelopingSituation.setSelection(cityCommonAttributes.getLandShape());
        binding.childHrLandSituation.spBuildingDirection.setSelection(cityCommonAttributes.getBuildingDirection());
        binding.childHrLandSituation.spNearbyStreetSituation.setSelection(cityCommonAttributes.getNearbyStreetSituation());
        binding.childHrLandSituation.spIsGore.setSelection(cityCommonAttributes.getGore() ? 1 : 0);
        binding.childHrLandSituation.spNearbyLandType.setSelection(model.getNearByLandType());
        binding.childHrBuildingSituation.spStructureType.setSelection(cityCommonAttributes.getStructureType());
        binding.childHrBuildingSituation.spQualityLevel.setSelection(cityCommonAttributes.getQualityLevel());
        binding.childHrBuildingSituation.spLightAirType.setSelection(model.getLightAirType());

    }


    @Override
    public void getSpinner() {
        cityCommonAttributes.setCrossRoadSituation(binding.childHrLandSituation.spCrossroadSituation.getSelectedItemPosition());
        cityCommonAttributes.setLandShape(binding.childHrLandSituation.spLandShape.getSelectedItemPosition());
        cityCommonAttributes.setLandDevelopingSituation(binding.childHrLandSituation.spLandDevelopingSituation.getSelectedItemPosition());
        cityCommonAttributes.setBuildingDirection(binding.childHrLandSituation.spBuildingDirection.getSelectedItemPosition());
        cityCommonAttributes.setNearbyStreetSituation(binding.childHrLandSituation.spNearbyStreetSituation.getSelectedItemPosition());
        cityCommonAttributes.setGore(binding.childHrLandSituation.spIsGore.getSelectedItemPosition() == 1);
        cityCommonAttributes.setStructureType(binding.childHrBuildingSituation.spStructureType.getSelectedItemPosition());
        cityCommonAttributes.setQualityLevel(binding.childHrBuildingSituation.spQualityLevel.getSelectedItemPosition());
        model.setLightAirType(binding.childHrBuildingSituation.spLightAirType.getSelectedItemPosition());
    }

    @Override
    public void save() {
//        editable.isEditable.set("false");
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
        binding.childHrLandSituation.spCrossroadSituation.setEnabled(isEnable);
        binding.childHrLandSituation.spLandShape.setEnabled(isEnable);
        binding.childHrLandSituation.spLandDevelopingSituation.setEnabled(isEnable);
        binding.childHrLandSituation.spBuildingDirection.setEnabled(isEnable);
        binding.childHrLandSituation.spNearbyStreetSituation.setEnabled(isEnable);
        binding.childHrLandSituation.spIsGore.setEnabled(isEnable);
        binding.childHrLandSituation.spNearbyLandType.setEnabled(isEnable);
        binding.childHrBuildingSituation.spStructureType.setEnabled(isEnable);
        binding.childHrBuildingSituation.spQualityLevel.setEnabled(isEnable);
        binding.childHrBuildingSituation.spLightAirType.setEnabled(isEnable);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_extra:
                changeELState(binding.childBase.elExtra);
                binding.childHrBuildingSituation.elBuildingSituation.collapse();
                binding.childHrLandSituation.elLandSituation.collapse();
                binding.childHrRentSituation.elRentSituation.collapse();
                break;
            case R.id.button_building_situation:
                changeELState(binding.childHrBuildingSituation.elBuildingSituation);
                binding.childBase.elExtra.collapse();
                binding.childHrLandSituation.elLandSituation.collapse();
                binding.childHrRentSituation.elRentSituation.collapse();
                break;
            case R.id.button_land_situation:
                changeELState(binding.childHrLandSituation.elLandSituation);
                binding.childHrBuildingSituation.elBuildingSituation.collapse();
                binding.childBase.elExtra.collapse();
                binding.childHrRentSituation.elRentSituation.collapse();
                break;
            case R.id.button_rent_situation:
                changeELState(binding.childHrRentSituation.elRentSituation);
                binding.childHrBuildingSituation.elBuildingSituation.collapse();
                binding.childHrLandSituation.elLandSituation.collapse();
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
                setTime(binding.childHrLandSituation.etAuthorizedTime);
                break;
            case R.id.et_trade_time:
                setTime(binding.childHrRentSituation.etRentTime);
                break;
            case R.id.locate:
                locate();
                break;
        }
    }

    @Override
    public void initModel(HouseRent model) {
        this.model = model;
        binding.setModel(this.model);
        initSpinner();
    }
}
