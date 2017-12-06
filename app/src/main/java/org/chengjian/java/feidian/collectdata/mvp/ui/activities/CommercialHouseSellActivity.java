package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModel;
import org.chengjian.java.feidian.collectdata.databinding.ActivityCommercialHouseTradeBinding;
import org.chengjian.java.feidian.collectdata.mvp.model.StickyMessage;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailCHSPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.DetailBaseActivity;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailCHSView;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class CommercialHouseSellActivity extends DetailBaseActivity implements View.OnClickListener, DetailCHSView {


    ActivityCommercialHouseTradeBinding binding;
    private CommercialHouseTradeModel model;
    private DetailCHSPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        initExpandableLayout();
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
    }

    @Override
    public void initSpinner() {
    }

    private void initView(StickyMessage message) {
        this.citySellRent = message.getCitySellRent();
        this.isEditable = message.getEditable();
        binding.setCitySellRent(citySellRent);
        binding.setEditable(isEditable);
        Log.d("xiang", isEditable+"");
        if (!isEditable) {
            presenter.loadModel(citySellRent.getId());
        } else {
            model = new CommercialHouseTradeModel();
            model.setId(citySellRent.getId());
            initCommercialHouseTradeModel(model);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(StickyMessage stickyMessage) {
        initView(stickyMessage);
        initExpandableLayout();
        initSpinner();
    }

    @Override
    public void getSpinner() {

    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

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

        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void initCommercialHouseTradeModel(CommercialHouseTradeModel model) {
        binding.setCommercialHouseTradeModel(model);
    }
}
