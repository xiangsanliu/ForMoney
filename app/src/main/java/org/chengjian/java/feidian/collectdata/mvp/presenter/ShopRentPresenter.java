package org.chengjian.java.feidian.collectdata.mvp.presenter;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.mvp.model.LocalDbModel;
import org.chengjian.java.feidian.collectdata.mvp.model.NetModel;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.view.base.ListItemView;
import org.chengjian.java.feidian.collectdata.shared.Constants;

import java.util.List;

import rx.Observable;

/**
 * Created by xiang on 2017/9/12.
 *
 * {@link org.chengjian.java.feidian.collectdata.beans.CounterRent}
 * 这个是商铺租金表
 */

public class ShopRentPresenter extends ListItemPresenter<CityCommonAttributes, List<CityCommonAttributes>, ListItemView<CityCommonAttributes>> {

    public ShopRentPresenter(Context context) {
        super(context);
    }

    @Override
    protected LocalDbModel<CityCommonAttributes> initDbManager() {
        return new LocalDbModel<CityCommonAttributes>(mContext) {
            @Override
            public List<CityCommonAttributes> queryAllEntities() {
                return
            }
        };
    }

    @Override
    protected List<CityCommonAttributes> transformBody(List<CityCommonAttributes> body) {
        return body;
    }

    @Override
    protected Observable<List<CityCommonAttributes>> load(int page) {
        return NetModel.newInstance().getCitySellRents(Constants.userId, Constants.SHOP_RENT);
    }
}
