package org.chengjian.java.feidian.collectdata.mvp.model;

import android.content.Context;

import com.alibaba.fastjson.JSON;

import net.cachapa.expandablelayout.ExpandableLayout;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModel;
import org.chengjian.java.feidian.collectdata.shared.Constants;
import org.chengjian.java.feidian.collectdata.shared.rx.RetrofitService;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by xiang on 2017/12/5.
 */

public class NetModel {

    private static NetModel netModel;

    private RetrofitService service;

    private NetModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_RUL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(RetrofitService.class);
    }

    public static NetModel newInstance() {
        if (netModel == null ) {
            return new NetModel();
        } else {
            return netModel;
        }
    }

    public Observable<List<CitySellRent>> getCitySellRents(Long userId){
        return service.getCitySellRents(userId);
    }

    public Observable<CommercialHouseTradeModel> getCommercialHouseTradeModel(Long id) {
        return service.getCommercialHouseTradeModel(id);
    }


//    public CommercialHouseTradeModel getCommercialHouseTradeModelById(Long id) {
//
//    }

}
