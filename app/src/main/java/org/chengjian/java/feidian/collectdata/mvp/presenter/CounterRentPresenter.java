package org.chengjian.java.feidian.collectdata.mvp.presenter;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.beans.CounterRent;
import org.chengjian.java.feidian.collectdata.db.DbManager;
import org.chengjian.java.feidian.collectdata.mvp.model.LocalDbModel;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.view.base.ListItemView;

import java.util.List;

/**
 * Created by xiang on 2017/9/12.
 * <p>
 * {@link org.chengjian.java.feidian.collectdata.beans.CounterRent}
 * 这个是柜台/商铺租金表
 */

public class CounterRentPresenter extends ListItemPresenter<CounterRent, ListItemView<CounterRent>> {

    public CounterRentPresenter(Context context) {
        super(context);
    }

    @Override
    protected LocalDbModel<CounterRent> initDbManager() {
        return new LocalDbModel<CounterRent>(mContext) {
            @Override
            public List<CounterRent> queryAllEntities() {
                return DbManager.getInstance().queryAllCounterRents();
            }
        };
    }
}
