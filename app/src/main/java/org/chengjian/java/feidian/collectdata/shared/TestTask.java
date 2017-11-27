package org.chengjian.java.feidian.collectdata.shared;

import android.os.AsyncTask;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;

import java.io.IOException;

import okhttp3.*;


/**
 * Created by xiang on 2017/11/27.
 *
 */

public class TestTask  extends AsyncTask<String , Void, Void>{

    @Override
    protected Void doInBackground(String... strings) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody body = new FormBody.Builder()
                    .add("content", strings[0])
                    .build();
            Request request = new Request.Builder()
                    .post(body)
                    .url(Constants.BASE_RUL+"save/city")
                    .build();
            okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
