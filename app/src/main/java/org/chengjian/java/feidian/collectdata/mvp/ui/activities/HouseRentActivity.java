package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.app.DatePickerDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.HouseRentModel;
import org.chengjian.java.feidian.collectdata.beans.SellRentModel;
import org.chengjian.java.feidian.collectdata.databinding.ActivityHouseRentBinding;
import org.chengjian.java.feidian.collectdata.mvp.model.BaseModel;
import org.chengjian.java.feidian.collectdata.mvp.model.LocalDbModel;
import org.chengjian.java.feidian.collectdata.mvp.model.ResultMessage;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.DetailBaseActivity;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailHRView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Calendar;

public class HouseRentActivity extends DetailBaseActivity implements View.OnClickListener, DetailHRView {

    private ActivityHouseRentBinding binding;
    private HouseRentModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }



    @Override
    protected int getLayoutId() {
        return R.layout.activity_house_rent;
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(SellRentModel sellRentModel) {
//        initViews(sellRentModel);
        initExpandableLayout();
        initSpinner();
    }

    @Override
    protected void initExpandableLayout() {
        binding.childExtra.buttonExtra.setOnClickListener(this);
        binding.childLandSituation.buttonLandSituation.setOnClickListener(this);
        binding.childBuildingSituation.buttonBuildingSituation.setOnClickListener(this);
        binding.childRent.buttonRentSituation.setOnClickListener(this);
        binding.buttonDelete.setOnClickListener(this);
        binding.buttonEdit.setOnClickListener(this);
        binding.buttonSave.setOnClickListener(this);
        binding.childLandSituation.etAuthorizedTime.setOnClickListener(this);
        binding.childRent.etAppointTime.setOnClickListener(this);

    }

    @Override
    public void initSpinner() {
        binding.childLandSituation.spCrossroadSituation.setSelection(sellRentModel.getCrossRoadSituation());
        binding.childLandSituation.spLandShape.setSelection(sellRentModel.getLandShape());
        binding.childLandSituation.spLandDevelopingSituation.setSelection(sellRentModel.getLandShape());
        binding.childLandSituation.spBuildingDirection.setSelection(sellRentModel.getBuildingDirection());
        binding.childLandSituation.spNearbyStreetSituation.setSelection(sellRentModel.getNearbyStreetSituation());
        binding.childLandSituation.spIsGore.setSelection(sellRentModel.getIsGore()? 1:0);
        binding.childLandSituation.spNearbyLandType.setSelection(sellRentModel.getNearbyLandType());
        binding.childLandSituation.spUsagePlaned.setSelection(sellRentModel.getUsagePlaned());
        binding.childLandSituation.spUsageActucal.setSelection(sellRentModel.getUsageActual());
        binding.childBuildingSituation.spDecorationType.setSelection(sellRentModel.getDecorationType());
        binding.childBuildingSituation.spStructureType.setSelection(sellRentModel.getStructureType());
        binding.childBuildingSituation.spQualityLevel.setSelection(sellRentModel.getQualityLevel());
        binding.childBuildingSituation.spLightAirType.setSelection(sellRentModel.getLightAirType());

    }


    @Override
    public void getSpinner() {
        SellRentModel sellRentModel = binding.getSellRentModel();
        sellRentModel.setCrossRoadSituation(binding.childLandSituation.spCrossroadSituation.getSelectedItemPosition());
        sellRentModel.setLandShape(binding.childLandSituation.spLandShape.getSelectedItemPosition());
        sellRentModel.setLandDevelopingSituation(binding.childLandSituation.spLandDevelopingSituation.getSelectedItemPosition());
        sellRentModel.setBuildingDirection(binding.childLandSituation.spBuildingDirection.getSelectedItemPosition());
        sellRentModel.setNearbyStreetSituation(binding.childLandSituation.spNearbyStreetSituation.getSelectedItemPosition());
        sellRentModel.setIsGore(binding.childLandSituation.spIsGore.getSelectedItemPosition() == 1);
        sellRentModel.setUsagePlaned(binding.childLandSituation.spUsagePlaned.getSelectedItemPosition());
        sellRentModel.setUsageActual(binding.childLandSituation.spUsageActucal.getSelectedItemPosition());
        sellRentModel.setDecorationType(binding.childBuildingSituation.spDecorationType.getSelectedItemPosition());
        sellRentModel.setStructureType(binding.childBuildingSituation.spStructureType.getSelectedItemPosition());
        sellRentModel.setQualityLevel(binding.childBuildingSituation.spQualityLevel.getSelectedItemPosition());
        sellRentModel.setLightAirType(binding.childBuildingSituation.spLightAirType.getSelectedItemPosition());
    }

    @Override
    public void save() {
//        editable.isEditable.set("false");
        getSpinner();
    }

    @Override
    public void delete() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_extra:
                changeELState(binding.childExtra.elExtra);
                break;
            case R.id.button_land_situation:
                changeELState(binding.childLandSituation.elLandSituation);
                break;
            case R.id.button_building_situation:
                changeELState(binding.childBuildingSituation.elBuildingSituation);
                break;
            case R.id.button_rent_situation:
                changeELState(binding.childRent.elRentSituation);
                break;
            case R.id.button_edit:
//                editable.isEditable.set("true");
                binding.childExtra.etReasearcher.requestFocus();
                binding.childExtra.elExtra.expand();
                showInputMethod();
                break;
            case R.id.button_save:
                save();
                break;
            case R.id.button_delete:
                showDeleteConfirm();
                break;
            case R.id.et_authorized_time:
                setTime(binding.childLandSituation.etAuthorizedTime);
                break;
            case R.id.et_appoint_time:
                setTime(binding.childRent.etAppointTime);
                break;
        }
    }

    @Override
    public void initModel(String model) {

    }

    @Override
    public void initModel(HouseRentModel model) {

    }
}
