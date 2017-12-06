package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.app.DatePickerDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import net.cachapa.expandablelayout.ExpandableLayout;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.SellRentModel;
import org.chengjian.java.feidian.collectdata.databinding.ActivityShopRentBinding;
import org.chengjian.java.feidian.collectdata.mvp.model.BaseModel;
import org.chengjian.java.feidian.collectdata.mvp.model.LocalDbModel;
import org.chengjian.java.feidian.collectdata.mvp.model.ResultMessage;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.DetailBaseActivity;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;

public class ShopRentActivity extends DetailBaseActivity implements View.OnClickListener {

    ActivityShopRentBinding binding;
    BaseModel dbModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        dbModel = LocalDbModel.getInstance(this);
    }

//    private void initViews(SellRentModel sellRentModel) {
//        if (sellRentModel.getResearcher() == null || sellRentModel.getResearcher().length()<=0 ) {
//            editable.isEditable.set("true");
//        } else {
//            editable.isEditable.set("false");
//        }
//        binding.setSellRentModel(sellRentModel);
//        binding.setEditable(editable);
//    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_rent;
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(SellRentModel sellRentModel) {
        this.sellRentModel = dbModel.querySellRentModelById(sellRentModel.getId());
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
        binding.childLandSituation.etAuthorizedTime.setOnClickListener(this);
        binding.childRent.etAppointTime.setOnClickListener(this);
        binding.buttonDelete.setOnClickListener(this);
        binding.buttonEdit.setOnClickListener(this);
        binding.buttonSave.setOnClickListener(this);
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
        dbModel.getDaoSession().getSellRentModelDao().update(binding.getSellRentModel());
        dbModel.getDaoSession().getRentInfo2ModelDao().update(binding.childRent.getRentModel());
        EventBus.getDefault().post(new ResultMessage(true));
    }

    @Override
    public void delete() {
        dbModel.getDaoSession().getSellRentModelDao().delete(sellRentModel);
        EventBus.getDefault().postSticky(new ResultMessage(true));
        finish();
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
}
