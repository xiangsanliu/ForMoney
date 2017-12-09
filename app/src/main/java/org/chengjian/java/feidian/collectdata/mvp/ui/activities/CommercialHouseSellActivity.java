package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.alibaba.fastjson.JSON;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModel;
import org.chengjian.java.feidian.collectdata.databinding.ActivityCommercialHouseTradeBinding;
import org.chengjian.java.feidian.collectdata.mvp.model.StickyMessage;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailBasePresenter;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailCHSPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.DetailBaseActivity;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailCHSView;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class CommercialHouseSellActivity extends DetailBaseActivity implements View.OnClickListener, DetailCHSView {


    private ActivityCommercialHouseTradeBinding binding;
    private CommercialHouseTradeModel model;
    private DetailCHSPresenter presenter;

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
        binding.setCitySellRent(citySellRent);
        binding.setEditable(message.getEditable());
        setSpinnerIsEnable(getIsEditable());
        if (!message.getEditable()) {
            presenter.loadModel(citySellRent.getId(), "commercial");
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
        binding.childChsLandSituation.spBuildingDirection.setEnabled(isEnable);
        binding.childChsLandSituation.spCrossroadSituation.setEnabled(isEnable);
        binding.childChsLandSituation.spIsGore.setEnabled(isEnable);
        binding.childChsLandSituation.spLandDevelopingSituation.setEnabled(isEnable);
        binding.childChsLandSituation.spLandShape.setEnabled(isEnable);
        binding.childChsLandSituation.spNearbyStreetSituation.setEnabled(isEnable);
        binding.childChsLandSituation.spUsageActucal.setEnabled(isEnable);
        binding.childChsLandSituation.spUsagePlaned.setEnabled(isEnable);
        binding.childChsBuildingSituation.spQualityLevel.setEnabled(isEnable);
        binding.childChsBuildingSituation.spStructureType.setEnabled(isEnable);
        binding.childChsTradeSituation.spTradeType.setEnabled(isEnable);
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
                setSpinnerIsEnable(getIsEditable());
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
                locate(binding.childBase.longitude, binding.childBase.latitude
                        , binding.childChsLandSituation.etLandLocation);
        }
    }

    //加载CommercialHouseTradeModel
    @Override
    public void initModel(String model) {
        this.model = JSON.parseObject(model, CommercialHouseTradeModel.class);
        binding.setCommercialHouseTradeModel(this.model);
        initSpinner();
    }

    @Override
    public void initModel(CommercialHouseTradeModel model) {
        this.model = model;
        binding.setCommercialHouseTradeModel(this.model);
        initSpinner();
    }
}
