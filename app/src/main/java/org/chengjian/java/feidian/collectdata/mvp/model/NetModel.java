package org.chengjian.java.feidian.collectdata.mvp.model;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
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
import rx.Subscriber;

/**
 * Created by xiang on 2017/12/5.
 *
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

    public Observable<String> getCommercialHouseTradeModel(final Long id) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    subscriber.onNext(getContent(id, "city/get/commercial"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private String getContent(Long id, String url) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("id", id+"")
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(Constants.BASE_RUL+url)
                .build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    private String save(String content, String url) throws IOException {
        System.out.println("savein");
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("content", content)
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(Constants.BASE_RUL+url)
                .build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    public Observable<Integer> deleteCity(final Long id) {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                try {
                    subscriber.onNext(delete(id, "/city/delete/city"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Observable<String> saveCity(final String content) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("call");
                try {
                    subscriber.onNext(save(content, "/city/save/city"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Integer delete(Long id, String url) throws IOException {
        System.out.println("savein");
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("id", String.valueOf(id))
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(Constants.BASE_RUL+url)
                .build();
        return okHttpClient.newCall(request).execute().code();
    }

    public Observable<String> saveCommercial(final String content) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    subscriber.onNext(save(content, "/city/save/commercial"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


//    public CommercialHouseTradeModel getCommercialHouseTradeModelById(Long id) {
//
//    }

}
