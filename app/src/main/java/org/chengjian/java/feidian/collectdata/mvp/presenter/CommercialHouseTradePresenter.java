package org.chengjian.java.feidian.collectdata.mvp.presenter;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.mvp.model.BaseModel;
import org.chengjian.java.feidian.collectdata.mvp.model.LocalDbModel;
import org.chengjian.java.feidian.collectdata.mvp.model.NetModel;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.view.base.ListItemView;
import org.chengjian.java.feidian.collectdata.shared.Constants;
import org.chengjian.java.feidian.collectdata.shared.rx.RetrofitService;
import org.chengjian.java.feidian.collectdata.shared.rx.converter.StringConverterFactory;

import java.io.IOException;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by xiang on 2017/9/12.
 */

public class CommercialHouseTradePresenter extends ListItemPresenter<CitySellRent, List<CitySellRent>, ListItemView<CitySellRent>> {


    public CommercialHouseTradePresenter(Context context) {
        super(context);
    }

    @Override
    protected List<CitySellRent> transformBody(List<CitySellRent> body) {
        return body;
    }

    @Override
    protected Observable<List<CitySellRent>> load(int page) {
        return NetModel.newInstance().getCitySellRents(Constants.userId);
    }
}
