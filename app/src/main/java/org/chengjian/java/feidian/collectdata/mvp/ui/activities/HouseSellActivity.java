package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.alibaba.fastjson.JSON;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.HouseTradeModel;
import org.chengjian.java.feidian.collectdata.databinding.ActivityHouseSellBinding;
import org.chengjian.java.feidian.collectdata.mvp.model.ResultMessage;
import org.chengjian.java.feidian.collectdata.mvp.model.StickyMessage;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailBasePresenter;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailHSPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.DetailBaseActivity;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailHSView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class HouseSellActivity extends DetailBaseActivity implements View.OnClickListener, DetailHSView {

    private ActivityHouseSellBinding binding;
    private DetailHSPresenter presenter;
    private HouseTradeModel model;

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

    private void initView(StickyMessage message) {
        this.citySellRent = message.getCitySellRent();
        this.isEditable = message.getEditable();
        binding.setCitySellRent(citySellRent);
        binding.setEditable(isEditable);
        if (!isEditable) {
            presenter.loadModel(citySellRent.getId());
        } else {
            model = new HouseTradeModel();
            model.setId(citySellRent.getId());
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
    }

    @Override
    public void initSpinner() {
        binding.childHsLandSituation.spCrossroadSituation.setSelection(citySellRent.getCrossRoadSituation());
        binding.childHsLandSituation.spLandShape.setSelection(citySellRent.getLandShape());
        binding.childHsLandSituation.spLandDevelopingSituation.setSelection(citySellRent.getLandShape());
        binding.childHsLandSituation.spBuildingDirection.setSelection(citySellRent.getBuildingDirection());
        binding.childHsLandSituation.spNearbyStreetSituation.setSelection(citySellRent.getNearbyStreetSituation());
        binding.childHsLandSituation.spIsGore.setSelection(citySellRent.isGore()? 1:0);
        binding.childHsLandSituation.spNearbyLandType.setSelection(model.getNearByLandType());
        binding.childHsLandSituation.spUsagePlaned.setSelection(model.getUseagePlaned());
        binding.childHsLandSituation.spUsageActucal.setSelection(model.getUseageActual());
        binding.childHsBuildingSituation.spDecorationType.setSelection(model.getDecorationType());
        binding.childHsBuildingSituation.spStructureType.setSelection(citySellRent.getStructureType());
        binding.childHsBuildingSituation.spQualityLevel.setSelection(citySellRent.getQualityLevel());
        binding.childHsBuildingSituation.spLightAirType.setSelection(model.getLightAirType());
    }


    @Override
    public void getSpinner() {
        citySellRent.setCrossRoadSituation(binding.childHsLandSituation.spCrossroadSituation.getSelectedItemPosition());
        citySellRent.setLandShape(binding.childHsLandSituation.spLandShape.getSelectedItemPosition());
        citySellRent.setLandDevelopingSituation(binding.childHsLandSituation.spLandDevelopingSituation.getSelectedItemPosition());
        citySellRent.setBuildingDirection(binding.childHsLandSituation.spBuildingDirection.getSelectedItemPosition());
        citySellRent.setNearbyStreetSituation(binding.childHsLandSituation.spNearbyStreetSituation.getSelectedItemPosition());
        citySellRent.setGore(binding.childHsLandSituation.spIsGore.getSelectedItemPosition() == 1);
        model.setUseagePlaned(binding.childHsLandSituation.spUsagePlaned.getSelectedItemPosition());
        model.setUseageActual(binding.childHsLandSituation.spUsageActucal.getSelectedItemPosition());
        model.setDecorationType(binding.childHsBuildingSituation.spDecorationType.getSelectedItemPosition());
        citySellRent.setStructureType(binding.childHsBuildingSituation.spStructureType.getSelectedItemPosition());
        citySellRent.setQualityLevel(binding.childHsBuildingSituation.spQualityLevel.getSelectedItemPosition());
        model.setLightAirType(binding.childHsBuildingSituation.spLightAirType.getSelectedItemPosition());
    }

    @Override
    public void save() {
//        editable.isEditable.set("false");
        getSpinner();
        binding.setEditable(false);
        presenter.save(citySellRent, model);
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
        }
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
                locate(binding.childBase.longitude, binding.childBase.latitude
                        , binding.childHsLandSituation.etLandLocation);
        }
    }

    @Override
    public void initModel(String model) {
        this.model = JSON.parseObject(model, HouseTradeModel.class);
        binding.setModel(this.model);
        initSpinner();
    }


    @Override
    public void initModel(HouseTradeModel model) {
        this.model = model;
        binding.setModel(model);
        initSpinner();
    }
}
