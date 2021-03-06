package org.chengjian.java.feidian.collectdata.network;

import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.beans.CommercialHousingForSale;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xiang on 2017/12/5.
 */

public interface UploadApi {
    /**
     * @param userId    用户的IMEI码
     * @param modelType 　数据类型
     * @param index     从第几条数据开始请求
     * @param count     请求多少条数据
     * @return
     */
    @GET("/city/get/citysellrents")
    Observable<List<CityCommonAttributes>> getCitySellRents(@Query("userId") Long userId, @Query("modelType") int modelType, @Query("index") int index, @Query("count") int count);

    @GET("/city/get/commercial")
    Observable<CommercialHousingForSale> getCommercialHouseTradeModel(@Query("id") Long id);

    @GET("/city/delete/city")
    Observable<String> deleteCitySellRent(@Query("id") Long id);

    @GET("/city/save/city")
    Observable<String> saveCitySellRent(@Query("content") String content);

    @GET("/city/save/commercial")
    Observable<String> saveCommercial(@Query("content") String content);

    /**
     * upload data to serve
     *
     * @param IMEI
     * @param modelType it has five types, include {city, commercial, houserent, housetrade, shoprent}
     * @param modelBody
     * @return
     */
    @Multipart
    @POST("/city/save/{modelType}")
    Observable<HttpResult<Void>> uploadModel(
            @Path("modelType") String modelType,
            @Query("IMEI") String IMEI,
            @Part("commonAttrs") RequestBody commonBody,
            @Part("modelAttrs") RequestBody modelBody);
}
