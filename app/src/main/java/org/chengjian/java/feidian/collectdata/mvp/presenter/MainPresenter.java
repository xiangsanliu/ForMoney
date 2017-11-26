package org.chengjian.java.feidian.collectdata.mvp.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.chengjian.java.feidian.collectdata.beans.Editable;
import org.chengjian.java.feidian.collectdata.beans.RentInfo2Model;
import org.chengjian.java.feidian.collectdata.beans.RentInfo4Model;
import org.chengjian.java.feidian.collectdata.beans.SellRentModel;
import org.chengjian.java.feidian.collectdata.beans.TradeInfo1Model;
import org.chengjian.java.feidian.collectdata.beans.TradeInfo3Model;
import org.chengjian.java.feidian.collectdata.mvp.model.BaseModel;
import org.chengjian.java.feidian.collectdata.mvp.model.LocalDbModel;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.BasePresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.CommercialHouseSellActivity;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.HouseRentActivity;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.HouseSellActivity;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.ShopRentActivity;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.CommercialHouseSellFragment;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.HouseRentFragment;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.HouseSellFragment;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.base.ListFragment;
import org.chengjian.java.feidian.collectdata.mvp.view.base.MainView;
import org.chengjian.java.feidian.collectdata.shared.Constants;
import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by StormPhoenix on 17-2-26.
 * StormPhoenix is a intelligent Android developer.
 */

public class MainPresenter extends BasePresenter<MainView> {
    public static final String TAG = MainPresenter.class.getSimpleName();
    private Activity mContext;
    BaseModel dbModel;

    public MainPresenter(Activity context) {
        mContext = context;
        dbModel = LocalDbModel.getInstance(context);
    }

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
    }

    public void createTable() {
        ListFragment currentFragment = mView.getCurrentFragment();
        SellRentModel model = new SellRentModel();
        Intent intent = null;
        model.setResearcherTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));

        if (currentFragment instanceof CommercialHouseSellFragment) {
            model.setModelType(Constants.COMMERCIAL_HOUSE_SELL_TABLE);
            dbModel.saveSellRentModel(model, dbModel.saveTradeInfo1Model(new TradeInfo1Model()));
            intent = new Intent(mContext, CommercialHouseSellActivity.class);
        } else if (currentFragment instanceof HouseRentFragment) {
            model.setModelType(Constants.HOUSE_RENT_TALBE);
            dbModel.saveSellRentModel(model, dbModel.saveRentInfo4Model(new RentInfo4Model()));
            intent = new Intent(mContext, HouseRentActivity.class);
        } else if (currentFragment instanceof HouseSellFragment) {
            model.setModelType(Constants.HOUSE_SELL_TABLE);
            dbModel.saveSellRentModel(model, dbModel.saveTradeInfo3Model(new TradeInfo3Model()));
            intent = new Intent(mContext, HouseSellActivity.class);
        } else {
            model.setModelType(Constants.SHOP_RENT_TABLE);
            dbModel.saveSellRentModel(model, dbModel.saveRentInfo2Model(new RentInfo2Model()));
            intent = new Intent(mContext, ShopRentActivity.class);
        }

        EventBus.getDefault().postSticky(model);

        mContext.startActivityForResult(intent, 0);
    }
}


