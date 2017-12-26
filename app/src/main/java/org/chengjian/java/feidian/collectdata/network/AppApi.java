package org.chengjian.java.feidian.collectdata.network;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by StormPhoenix on 17-12-25.
 * StormPhoenix is a intelligent Android developer.
 */

public interface AppApi {
    @GET("/update/version_name")
    Observable<String> getApkVersionName();

    @GET("/update/version_code")
    Observable<String> getApkVersionCode();

    @GET("/user/login")
    Observable<HttpResult<Void>> login(String imei);
}
