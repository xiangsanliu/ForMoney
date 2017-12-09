package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.alibaba.fastjson.JSON;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.HouseRentModel;
import org.chengjian.java.feidian.collectdata.databinding.ActivityHouseRentBinding;
import org.chengjian.java.feidian.collectdata.mvp.model.StickyMessage;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailBasePresenter;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailHRPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.DetailBaseActivity;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailHRView;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Calendar;

public class HouseRentActivity extends DetailBaseActivity implements View.OnClickListener, DetailHRView {

    private ActivityHouseRentBinding binding;
    private HouseRentModel model;
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

    private void initViews(StickyMessage message) {
        this.citySellRent = message.getCitySellRent();
        binding.setCitySellRent(citySellRent);
        binding.setEditable(message.getEditable());
        setSpinnerIsEnable(getIsEditable());
        if (!message.getEditable()) {
            presenter.loadModel(citySellRent.getId(), "houserent");
        } else {
            model = new HouseRentModel();
            model.setId(citySellRent.getId());
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
        binding.childHrLandSituation.spCrossroadSituation.setSelection(citySellRent.getCrossRoadSituation());
        binding.childHrLandSituation.spLandShape.setSelection(citySellRent.getLandShape());
        binding.childHrLandSituation.spLandDevelopingSituation.setSelection(citySellRent.getLandShape());
        binding.childHrLandSituation.spBuildingDirection.setSelection(citySellRent.getBuildingDirection());
        binding.childHrLandSituation.spNearbyStreetSituation.setSelection(citySellRent.getNearbyStreetSituation());
        binding.childHrLandSituation.spIsGore.setSelection(citySellRent.isGore()? 1:0);
        binding.childHrLandSituation.spNearbyLandType.setSelection(model.getNearByLandType());
        binding.childHrBuildingSituation.spStructureType.setSelection(citySellRent.getStructureType());
        binding.childHrBuildingSituation.spQualityLevel.setSelection(citySellRent.getQualityLevel());
        binding.childHrBuildingSituation.spLightAirType.setSelection(model.getLightAirType());

    }


    @Override
    public void getSpinner() {
        citySellRent.setCrossRoadSituation(binding.childHrLandSituation.spCrossroadSituation.getSelectedItemPosition());
        citySellRent.setLandShape(binding.childHrLandSituation.spLandShape.getSelectedItemPosition());
        citySellRent.setLandDevelopingSituation(binding.childHrLandSituation.spLandDevelopingSituation.getSelectedItemPosition());
        citySellRent.setBuildingDirection(binding.childHrLandSituation.spBuildingDirection.getSelectedItemPosition());
        citySellRent.setNearbyStreetSituation(binding.childHrLandSituation.spNearbyStreetSituation.getSelectedItemPosition());
        citySellRent.setGore(binding.childHrLandSituation.spIsGore.getSelectedItemPosition() == 1);
        citySellRent.setStructureType(binding.childHrBuildingSituation.spStructureType.getSelectedItemPosition());
        citySellRent.setQualityLevel(binding.childHrBuildingSituation.spQualityLevel.getSelectedItemPosition());
        model.setLightAirType(binding.childHrBuildingSituation.spLightAirType.getSelectedItemPosition());
    }

    @Override
    public void save() {
//        editable.isEditable.set("false");
        getSpinner();
        binding.setEditable(false);
        setSpinnerIsEnable(getIsEditable());
        presenter.save(citySellRent, model);
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
        }
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
                locate(binding.childBase.longitude, binding.childBase.latitude
                        , binding.childHrLandSituation.etLandLocation);
        }
    }

    @Override
    public void initModel(String model) {
        this.model = JSON.parseObject(model,HouseRentModel.class);
        binding.setModel(this.model);
        initSpinner();
    }

    @Override
    public void initModel(HouseRentModel model) {
        this.model = model;
        binding.setModel(this.model);
        initSpinner();

    }
}
