package org.chengjian.java.feidian.collectdata.network;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by StormPhoenix on 17-12-27.
 * StormPhoenix is a intelligent Android developer.
 */

public interface UserApi {
    @GET("/user/login")
    Observable<HttpResult<Void>> login(@Query("imei") String imei);
}
