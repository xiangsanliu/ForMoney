package org.chengjian.java.feidian.collectdata.mvp.presenter;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.beans.CommercialHousingForSale;
import org.chengjian.java.feidian.collectdata.mvp.model.LocalDbModel;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.view.base.ListItemView;

import java.util.List;

/**
 * Created by xiang on 2017/9/12.
 */

public class CommercialHousingForSalePresenter extends ListItemPresenter<CommercialHousingForSale, ListItemView<CommercialHousingForSale>> {
    public CommercialHousingForSalePresenter(Context context) {
        super(context);
    }

    @Override
    protected LocalDbModel<CommercialHousingForSale> initDbManager() {
        return new LocalDbModel<CommercialHousingForSale>(mContext) {
            @Override
            public List<CommercialHousingForSale> queryAllEntities() {
                return daoSession.getCommercialHousingForSaleDao().queryBuilder().list();
            }
        };
    }

}
