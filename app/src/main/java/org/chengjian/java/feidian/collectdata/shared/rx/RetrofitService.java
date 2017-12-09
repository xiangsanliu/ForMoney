package org.chengjian.java.feidian.collectdata.shared.rx;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModel;

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
    Observable<List<CitySellRent>> getCitySellRents(@Query("userId") Long userId, @Query("modelType") int modelType);

    @GET("/city/get/commercial")
    Observable<CommercialHouseTradeModel> getCommercialHouseTradeModel(@Query("id") Long id);

    @GET("/city/delete/city")
    Observable<String> deleteCitySellRent(@Query("id") Long id);

    @GET("/city/save/city")
    Observable<String> saveCitySellRent(@Query("content") String content) ;

    @GET("/city/save/commercial")
    Observable<String> saveCommercial(@Query("content") String content);

}
