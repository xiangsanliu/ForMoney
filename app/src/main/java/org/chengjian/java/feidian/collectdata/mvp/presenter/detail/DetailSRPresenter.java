package org.chengjian.java.feidian.collectdata.mvp.presenter.detail;

import android.app.Activity;

import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.beans.CounterRent;
import org.chengjian.java.feidian.collectdata.db.DbManager;

/**
 * Created by xiang on 2017/12/8.
 * <p>
 * 控制 {@link CounterRent}
 */

public class DetailSRPresenter extends DetailBasePresenter<CounterRent> {
    public DetailSRPresenter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void realLoadModel(Long id) {
        CounterRent model = DbManager.getInstance().queryCounterRentByForeignKey(id);
        view.initModel(model);
    }

    @Override
    public void save(CityCommonAttributes commonAttrs, CounterRent entity) {
        DbManager.getInstance().saveCityCommonAttributes(commonAttrs);
        entity.setCommonAttributes(commonAttrs);
        DbManager.getInstance().saveCounterRent(entity);
    }
}
