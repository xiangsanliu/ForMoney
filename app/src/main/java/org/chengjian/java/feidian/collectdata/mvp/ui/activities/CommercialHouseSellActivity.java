package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.CommercialHousingForSale;
import org.chengjian.java.feidian.collectdata.beans.message.LocationMessage;
import org.chengjian.java.feidian.collectdata.beans.message.StickyMessage;
import org.chengjian.java.feidian.collectdata.databinding.ActivityCommercialHouseTradeBinding;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailBasePresenter;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailCHSPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.DetailBaseActivity;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailBaseView;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class CommercialHouseSellActivity extends DetailBaseActivity implements View.OnClickListener, DetailBaseView<CommercialHousingForSale> {
    private ActivityCommercialHouseTradeBinding binding;
    private CommercialHousingForSale model;
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
        binding.buttonUpload.setOnClickListener(this);
        binding.buttonEdit.setOnClickListener(this);
        binding.buttonSave.setOnClickListener(this);
        binding.childChsLandSituation.etAuthorizedTime.setOnClickListener(this);
        binding.childChsTradeSituation.etTradeTime.setOnClickListener(this);
        binding.childBase.locate.setOnClickListener(this);
    }

    @Override
    public void initSpinner() {
        binding.childChsLandSituation.spBuildingDirection.setSelection(cityCommonAttributes.getBuildingDirection());
        binding.childChsLandSituation.spCrossroadSituation.setSelection(cityCommonAttributes.getCrossRoadSituation());
        binding.childChsLandSituation.spIsGore.setSelection(cityCommonAttributes.getGore() ? 0 : 1);
        binding.childChsLandSituation.spLandDevelopingSituation.setSelection(cityCommonAttributes.getLandDevelopingSituation());
        binding.childChsLandSituation.spLandShape.setSelection(cityCommonAttributes.getLandShape());
        binding.childChsLandSituation.spNearbyStreetSituation.setSelection(cityCommonAttributes.getNearbyStreetSituation());
        binding.childChsLandSituation.spUsageActucal.setSelection(model.getUseageActual());
        binding.childChsLandSituation.spUsagePlaned.setSelection(model.getUseagePlande());
        binding.childChsBuildingSituation.spQualityLevel.setSelection(cityCommonAttributes.getQualityLevel());
        binding.childChsBuildingSituation.spStructureType.setSelection(cityCommonAttributes.getStructureType());
        binding.childChsTradeSituation.spTradeType.setSelection(model.getTradeType());
    }

    private void initView(StickyMessage message) {
        this.cityCommonAttributes = message.getCityCommonAttributes();
        binding.setCitySellRent(cityCommonAttributes);
        binding.setEditable(message.getIsEditable());
        setSpinnerIsEnable(getIsEditable());
        if (!message.getIsEditable()) {
            // 无法编辑
            presenter.loadModel(cityCommonAttributes.getId());
        } else {
            // 可以编辑
            model = new CommercialHousingForSale();
            initModel(model);
        }
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
        binding.childChsLandSituation.etLandLocation.setText(String.valueOf(locationMessage.getAddress()));
    }

    @Override
    public void getSpinner() {
        cityCommonAttributes.setBuildingDirection(binding.childChsLandSituation.spBuildingDirection.getSelectedItemPosition());
        cityCommonAttributes.setCrossRoadSituation(binding.childChsLandSituation.spCrossroadSituation.getSelectedItemPosition());
        cityCommonAttributes.setGore(binding.childChsLandSituation.spIsGore.getSelectedItemPosition() == 0);
        cityCommonAttributes.setLandDevelopingSituation(binding.childChsLandSituation.spLandDevelopingSituation.getSelectedItemPosition());
        cityCommonAttributes.setLandShape(binding.childChsLandSituation.spLandShape.getSelectedItemPosition());
        cityCommonAttributes.setNearbyStreetSituation(binding.childChsLandSituation.spNearbyStreetSituation.getSelectedItemPosition());
        model.setUseageActual(binding.childChsLandSituation.spUsageActucal.getSelectedItemPosition());
        model.setUseagePlande(binding.childChsLandSituation.spUsagePlaned.getSelectedItemPosition());
        cityCommonAttributes.setQualityLevel(binding.childChsBuildingSituation.spQualityLevel.getSelectedItemPosition());
        cityCommonAttributes.setStructureType(binding.childChsBuildingSituation.spStructureType.getSelectedItemPosition());
        model.setTradeType(binding.childChsTradeSituation.spTradeType.getSelectedItemPosition());
    }

    @Override
    public void save() {
        getSpinner();
        binding.setEditable(false);
        setSpinnerIsEnable(getIsEditable());
        presenter.save(cityCommonAttributes, model);
    }

    @Override
    public void upload() {
        presenter.upload(model);
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
            case R.id.button_upload:
                upload();
                break;
            case R.id.et_authorized_time:
                setTime(binding.childChsLandSituation.etAuthorizedTime);
                break;
            case R.id.et_trade_time:
                setTime(binding.childChsTradeSituation.etTradeTime);
                break;

            case R.id.locate:
                locate();
                break;
        }
    }

    @Override
    public void initModel(CommercialHousingForSale model) {
        this.model = model;
        binding.setCommercialHousingForSale(this.model);
        initSpinner();
    }
}
