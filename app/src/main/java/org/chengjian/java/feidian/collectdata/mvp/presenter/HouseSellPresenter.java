package org.chengjian.java.feidian.collectdata.mvp.presenter;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.beans.HouseSalePrice;
import org.chengjian.java.feidian.collectdata.mvp.model.LocalDbModel;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.view.base.ListItemView;

import java.util.List;

/**
 * Created by xiang on 2017/9/12.
 *
 * 房屋买卖价格调查调查表
 */

public class HouseSellPresenter extends ListItemPresenter<HouseSalePrice, ListItemView<HouseSalePrice>> {


    public HouseSellPresenter(Context context) {
        super(context);
    }

    @Override
    protected LocalDbModel<HouseSalePrice> initDbManager() {
        return new LocalDbModel<HouseSalePrice>(mContext) {
            @Override
            public List<HouseSalePrice> queryAllEntities() {
                return daoSession.getHouseSalePriceDao().queryBuilder().list();
            }
        };
    }
}
