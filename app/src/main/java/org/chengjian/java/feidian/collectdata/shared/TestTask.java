package org.chengjian.java.feidian.collectdata.shared;

import android.os.AsyncTask;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailCHSView;

import java.io.IOException;

import okhttp3.*;


/**
 * Created by xiang on 2017/11/27.
 *
 */

public class TestTask  extends AsyncTask<String , Void, Void>{

    private DetailCHSView view;

    public TestTask(DetailCHSView view) {
        this.view = view;
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            System.out.println(strings[0]);
            System.out.println(strings[1]);
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody body = new FormBody.Builder()
                    .add("content", strings[0])
                    .build();
            Request request = new Request.Builder()
                    .post(body)
                    .url(Constants.BASE_RUL+"city/save/city")
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            okHttpClient = new OkHttpClient();
            body = new FormBody.Builder()
                    .add("content", strings[1])
                    .build();
            request = new Request.Builder()
                    .post(body)
                    .url(Constants.BASE_RUL+"city/save/commercial")
                    .build();
            okHttpClient.newCall(request).execute();
            System.out.println(response.code()+" "+response.message());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
