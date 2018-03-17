package org.chengjian.java.feidian.collectdata.mvp.presenter;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.beans.HouseRent;
import org.chengjian.java.feidian.collectdata.mvp.model.LocalDbModel;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.view.base.ListItemView;

import java.util.List;

/**
 * Created by xiang on 2017/9/12.
 */

public class HouseRentPresenter extends ListItemPresenter<HouseRent, ListItemView<HouseRent>> {
    public HouseRentPresenter(Context context) {
        super(context);
    }

    @Override
    protected LocalDbModel<HouseRent> initDbManager() {
        return new LocalDbModel<HouseRent>(mContext) {
            @Override
            public List<HouseRent> queryAllEntities() {
                return daoSession.getHouseRentDao().queryBuilder().list();
            }
        };
    }

}
