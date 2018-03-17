package org.chengjian.java.feidian.collectdata.mvp.model;

import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.network.CityApi;
import org.chengjian.java.feidian.collectdata.shared.Constants;

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
import rx.Subscriber;

/**
 * Created by xiang on 2017/12/5.
 */

public class NetModel {

    private static NetModel netModel;

    private CityApi service;

    private NetModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(CityApi.class);
    }

    public static NetModel newInstance() {
        if (netModel == null) {
            return new NetModel();
        } else {
            return netModel;
        }
    }

    public Observable<List<CityCommonAttributes>> getCitySellRents(Long userId, int modelType) {
        // 默认请求20条数据，从第一条数据开始请求
        return service.getCitySellRents(userId, modelType, 0, 20);
    }

    public Observable<String> getModel(final Long id, final String typeUrl) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    subscriber.onNext(getContent(id, "city/get/" + typeUrl));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private String getContent(Long id, String url) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("id", id + "")
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(Constants.BASE_URL + url)
                .build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    private String saveBody(String content, String url) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("content", content)
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(Constants.BASE_URL + url)
                .build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    public Observable<Integer> deleteCity(final Long id) {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                try {
                    subscriber.onNext(deleteBody(id, "city/delete/city"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Observable<String> save(final String content, final String url) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("call");
                try {
                    subscriber.onNext(saveBody(content, url));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Integer deleteBody(Long id, String url) throws IOException {
        System.out.println("savein");
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("id", String.valueOf(id))
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(Constants.BASE_URL + url)
                .build();
        return okHttpClient.newCall(request).execute().code();
    }


//    public CommercialHousingForSaleAdapter getCommercialHouseTradeModelById(Long id) {
//
//    }

}
