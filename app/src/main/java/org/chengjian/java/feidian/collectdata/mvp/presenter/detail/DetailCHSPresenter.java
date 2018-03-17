package org.chengjian.java.feidian.collectdata.mvp.presenter.detail;

import android.app.Activity;

import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.beans.CommercialHousingForSale;
import org.chengjian.java.feidian.collectdata.db.DbManager;

import java.util.List;

/**
 * Created by xiang on 2017/12/6.
 */

public class DetailCHSPresenter extends DetailBasePresenter<CommercialHousingForSale> {

    public DetailCHSPresenter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void realLoadModel(Long id) {
        CommercialHousingForSale model = DbManager.getInstance().queryCommercialHousingForSaleByForeignKey(id);
        view.initModel(model);
    }

    @Override
    public void save(CityCommonAttributes commonAttrs, CommercialHousingForSale entity) {
        DbManager.getInstance().saveCityCommonAttributes(commonAttrs);
        entity.setCommonAttributes(commonAttrs);
        DbManager.getInstance().saveCommercialHousingForSale(entity);
    }
}
