package org.chengjian.java.feidian.collectdata.mvp.presenter;

import android.content.Context;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.view.base.ListItemView;
import org.chengjian.java.feidian.collectdata.shared.Constants;
import org.chengjian.java.feidian.collectdata.shared.rx.RetrofitService;
import org.chengjian.java.feidian.collectdata.shared.rx.converter.StringConverterFactory;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Observer;

/**
 * Created by xiang on 2017/12/5.
 */

public class CommercialHouseTradePresenter {



    protected Observable<List<CitySellRent>> load(int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_RUL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(StringConverterFactory.create())
                .build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        return service.getCitySellRents(Constants.userId);
    }
}
