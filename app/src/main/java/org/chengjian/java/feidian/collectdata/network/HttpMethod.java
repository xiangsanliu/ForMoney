package org.chengjian.java.feidian.collectdata.network;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.shared.Constants;
import org.chengjian.java.feidian.collectdata.shared.ApkDownloadUtils;
import org.chengjian.java.feidian.collectdata.shared.JsonParser;
import org.chengjian.java.feidian.collectdata.shared.rx.RxJavaCustomTransformer;
import org.chengjian.java.feidian.collectdata.shared.rx.converter.StringConverterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Developer on 17-1-19.
 * Wang Cheng is a intelligent Android developer.
 */

public class HttpMethod {

    private static final String TAG = "HttpMethod";
    private static HttpMethod instance = null;

    private OkHttpClient client = null;
    private AppApi appApi = null;

    private HttpMethod() {
        client = new OkHttpClient.Builder()
                .readTimeout(5000, java.util.concurrent.TimeUnit.MILLISECONDS)
                .connectTimeout(5000, java.util.concurrent.TimeUnit.MILLISECONDS)
                .build();

        Retrofit objRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(JsonParser.getInstance().getGson()))
                .build();

        Retrofit strRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(new StringConverterFactory())
                .build();

        appApi = strRetrofit.create(AppApi.class);
    }

    public static HttpMethod getInstance() {
        if (instance == null) {
            synchronized (HttpMethod.class) {
                if (instance == null) {
                    instance = new HttpMethod();
                }
            }
        }
        return instance;
    }

    public Subscription getApkVersionCode(final RequestCallback<String> callback) {
        callback.beforeRequest();
        return appApi.getApkVersionCode()
                .compose(RxJavaCustomTransformer.<String>defaultSchedulers())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        callback.success(s);
                    }
                });
    }

    public Subscription getApkVersionName(final RequestCallback<String> callback) {
        callback.beforeRequest();
        return appApi.getApkVersionName()
                .compose(RxJavaCustomTransformer.<String>defaultSchedulers())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        callback.success(s);
                    }
                });
    }

    public void downloadApk(Context context) {
        ApkDownloadUtils.download(context, Constants.BASE_URL + "update/download_apk", "正在下载更新", context.getString(R.string.app_name));
    }
}
