package org.chengjian.java.feidian.collectdata.mvp.presenter;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.mvp.model.NetModel;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.view.base.ListItemView;
import org.chengjian.java.feidian.collectdata.shared.Constants;

import java.util.List;

import rx.Observable;

/**
 * Created by xiang on 2017/9/12.
 *
 */

public class ShopRentPresenter extends ListItemPresenter<CitySellRent, List<CitySellRent>, ListItemView<CitySellRent>> {


    public ShopRentPresenter(Context context) {
        super(context);
    }

    @Override
    protected List<CitySellRent> transformBody(List<CitySellRent> body) {
        return body;
    }

    @Override
    protected Observable<List<CitySellRent>> load(int page) {
        return NetModel.newInstance().getCitySellRents(Constants.userId, Constants.SHOP_RENT);
    }
}
