package org.chengjian.java.feidian.collectdata.mvp.presenter;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.view.base.ListItemView;

import java.util.List;

import rx.Observable;

/**
 * Created by xiang on 2017/12/5.
 */

public class CommercialHouseTradePresenter extends ListItemPresenter<CitySellRent, List<CitySellRent>, ListItemView<CitySellRent>> {
    public CommercialHouseTradePresenter(Context context) {
        super(context);
    }

    @Override
    protected List<CitySellRent> transformBody(List<CitySellRent> body) {
        return null;
    }

    @Override
    protected Observable<List<CitySellRent>> load(int page) {
        return null;
    }
}
