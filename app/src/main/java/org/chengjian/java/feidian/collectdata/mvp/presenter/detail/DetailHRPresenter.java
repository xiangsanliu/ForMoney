package org.chengjian.java.feidian.collectdata.mvp.presenter.detail;

import android.app.Activity;

import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.beans.HouseRent;
import org.chengjian.java.feidian.collectdata.db.DbManager;

/**
 * Created by xiang on 2017/12/8.
 */

public class DetailHRPresenter extends DetailBasePresenter<HouseRent> {

    public DetailHRPresenter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void realLoadModel(Long id) {
        HouseRent model = DbManager.getInstance().queryHouseRentByForeignKey(id);
        view.initModel(model);
    }

    @Override
    public void save(CityCommonAttributes commonAttrs, HouseRent entity) {
        DbManager.getInstance().saveCityCommonAttributes(commonAttrs);
        entity.setCommonAttributes(commonAttrs);
        DbManager.getInstance().saveHouseRent(entity);
    }
}
