package org.chengjian.java.feidian.collectdata.mvp.presenter.detail;

import android.app.Activity;

import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.beans.HouseSalePrice;
import org.chengjian.java.feidian.collectdata.db.DbManager;

/**
 * Created by xiang on 2017/12/8.
 */

public class DetailHSPresenter extends DetailBasePresenter<HouseSalePrice> {

    public DetailHSPresenter(Activity activity) {
        this.activity = activity;
    }


    @Override
    public void realLoadModel(Long id) {
        HouseSalePrice model = DbManager.getInstance().queryHouseSalePriceByForeignKey(id);
        view.initModel(model);
    }

    @Override
    public void save(CityCommonAttributes commonAttrs, HouseSalePrice entity) {
        DbManager.getInstance().saveCityCommonAttributes(commonAttrs);
        entity.setCommonAttributes(commonAttrs);
        DbManager.getInstance().saveHouseSalePrice(entity);
    }
}
