package org.chengjian.java.feidian.collectdata.mvp.presenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.beans.message.StickyMessage;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.BasePresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.CommercialHouseSellActivity;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.CounterActivity;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.HouseRentActivity;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.HouseSellActivity;
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

    public MainPresenter(Activity context) {
        mContext = context;
    }

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
    }

    public void createTable() {
        ListFragment currentFragment = mView.getCurrentFragment();

        StickyMessage stickyMessage = new StickyMessage();
        Intent intent;
        stickyMessage.setIsEditable(true);

        if (currentFragment instanceof CommercialHouseTradeFragment) {
            stickyMessage.setCityCommonAttributes(initCityCommonAttrs());
            intent = new Intent(mContext, CommercialHouseSellActivity.class);

        } else if (currentFragment instanceof HouseRentFragment) {
            stickyMessage.setCityCommonAttributes(initCityCommonAttrs());
            intent = new Intent(mContext, HouseRentActivity.class);

        } else if (currentFragment instanceof HouseSellFragment) {
            stickyMessage.setCityCommonAttributes(initCityCommonAttrs());
            intent = new Intent(mContext, HouseSellActivity.class);

        } else {
            stickyMessage.setCityCommonAttributes(initCityCommonAttrs());
            intent = new Intent(mContext, CounterActivity.class);
        }

        EventBus.getDefault().postSticky(stickyMessage);
        mContext.startActivityForResult(intent, 0);
    }

    @SuppressLint("SimpleDateFormat")
    private CityCommonAttributes initCityCommonAttrs() {
        CityCommonAttributes model = new CityCommonAttributes();
        model.setResearcherTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        model.setUserId(Constants.userId);
        return model;
    }

}


