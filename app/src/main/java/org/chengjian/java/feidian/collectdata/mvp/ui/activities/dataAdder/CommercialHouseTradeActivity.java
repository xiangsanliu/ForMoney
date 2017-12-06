package org.chengjian.java.feidian.collectdata.mvp.ui.activities.dataAdder;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import net.cachapa.expandablelayout.ExpandableLayout;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModel;
import org.chengjian.java.feidian.collectdata.beans.SellRentModel;
import org.chengjian.java.feidian.collectdata.databinding.ActivityCommercialHouseTradeBinding;
import org.chengjian.java.feidian.collectdata.databinding.ChildBaseBinding;
import org.chengjian.java.feidian.collectdata.mvp.model.StickyMessage;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.DetailBaseActivity;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class CommercialHouseTradeActivity extends DetailBaseActivity implements View.OnClickListener {

    ActivityCommercialHouseTradeBinding binding;
    private CommercialHouseTradeModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        initExpandableLayout();
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
        binding.setCommercialHouseTradeModel(model);
        binding.setEditable(isEditable);

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventMainThread(StickyMessage stickyMessage) {
        initView(stickyMessage);
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
}
