package org.chengjian.java.feidian.collectdata.shared.rx;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xiang on 2017/12/5.
 */

public interface RetrofitService {
    @GET("/city/get/citysellrents")
    Observable<List<CitySellRent>> getCitySellRents(@Query("userId") Long userId);



}
