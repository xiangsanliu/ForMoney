package org.chengjian.java.feidian.collectdata.mvp.presenter;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
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

public class HouseRentPresenter extends ListItemPresenter<CityCommonAttributes, List<CityCommonAttributes>, ListItemView<CityCommonAttributes>> {


    public HouseRentPresenter(Context context) {
        super(context);
    }

    @Override
    protected List<CityCommonAttributes> transformBody(List<CityCommonAttributes> body) {
        return body;
    }

    @Override
    protected Observable<List<CityCommonAttributes>> load(int page) {
        return NetModel.newInstance().getCitySellRents(Constants.userId, Constants.HOUSE_RENT);
    }
}
