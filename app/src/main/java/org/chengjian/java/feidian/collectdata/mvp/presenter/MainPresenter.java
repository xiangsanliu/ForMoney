package org.chengjian.java.feidian.collectdata.mvp.presenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModel;
import org.chengjian.java.feidian.collectdata.beans.Editable;
import org.chengjian.java.feidian.collectdata.beans.RentInfo2Model;
import org.chengjian.java.feidian.collectdata.beans.RentInfo4Model;
import org.chengjian.java.feidian.collectdata.beans.SellRentModel;
import org.chengjian.java.feidian.collectdata.beans.TradeInfo1Model;
import org.chengjian.java.feidian.collectdata.beans.TradeInfo3Model;
import org.chengjian.java.feidian.collectdata.mvp.model.BaseModel;
import org.chengjian.java.feidian.collectdata.mvp.model.LocalDbModel;
import org.chengjian.java.feidian.collectdata.mvp.model.StickyMessage;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.BasePresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.CommercialHouseSellActivity;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.CommercialHouseTradeFragment;
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

        StickyMessage stickyMessage = new StickyMessage();
        Intent intent = null;
        Long id = System.currentTimeMillis();
        stickyMessage.setEditable(true);

        if (currentFragment instanceof CommercialHouseTradeFragment) {
            stickyMessage.setCitySellRent(initCitySellRent(id, Constants.COMMERCIAL_HOUSE_TRADE));
            intent = new Intent(mContext, CommercialHouseSellActivity.class);
        } else if (currentFragment instanceof HouseRentFragment) {
            stickyMessage.setCitySellRent(initCitySellRent(id, Constants.HOUSE_RENT));
//            intent = new Intent(mContext, HouseRentActivity.class);
        } else if (currentFragment instanceof HouseSellFragment) {
            stickyMessage.setCitySellRent(initCitySellRent(id, Constants.HOUSE_SELL));
//            intent = new Intent(mContext, HouseSellActivity.class);
        } else {
            stickyMessage.setCitySellRent(initCitySellRent(id, Constants.SHOP_RENT));
//            intent = new Intent(mContext, ShopRentActivity.class);
        }
//

        EventBus.getDefault().postSticky(stickyMessage);

        if (intent !=  null) {
            mContext.startActivityForResult(intent, 0);
        }
    }

    @SuppressLint("SimpleDateFormat")
    private CitySellRent initCitySellRent(Long id, int modelType) {
        CitySellRent model = new CitySellRent();
        model.setResearcherTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        model.setId(id);
        model.setUserId(Constants.userId);
        model.setModelType(modelType);
        return model;
    }

}


