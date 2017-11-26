package org.chengjian.java.feidian.collectdata.mvp.presenter;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.beans.SellRentModel;
import org.chengjian.java.feidian.collectdata.mvp.model.BaseModel;
import org.chengjian.java.feidian.collectdata.mvp.model.LocalDbModel;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.view.base.ListItemView;

import java.util.List;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by xiang on 2017/9/12.
 */

public class HouseSellPresenter extends ListItemPresenter<SellRentModel, List<SellRentModel>, ListItemView<SellRentModel>> {

    private BaseModel model;

    public HouseSellPresenter(Context context) {
        super(context);
        model = LocalDbModel.getInstance(context);
    }

    @Override
    protected List<SellRentModel> transformBody(List<SellRentModel> body) {
        return body;
    }

    @Override
    protected Observable<List<SellRentModel>> load(int page) {
        return Observable.create(new Observable.OnSubscribe<List<SellRentModel>>() {
            @Override
            public void call(Subscriber<? super List<SellRentModel>> subscriber) {
                subscriber.onNext(model.queryHouseSellTable());
            }
        });
    }
}
