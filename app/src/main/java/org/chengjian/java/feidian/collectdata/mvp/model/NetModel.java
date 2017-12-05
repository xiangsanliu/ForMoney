package org.chengjian.java.feidian.collectdata.mvp.model;

import android.content.Context;

import com.alibaba.fastjson.JSON;

import net.cachapa.expandablelayout.ExpandableLayout;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModel;
import org.chengjian.java.feidian.collectdata.shared.Constants;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by xiang on 2017/12/5.
 */

public class NetModel {

    private static NetModel netModel;

    OkHttpClient okHttpClient;

    private NetModel() {
        okHttpClient = new OkHttpClient();
    }

    public static NetModel newInstance() {
        if (netModel == null ) {
            return new NetModel();
        } else {
            return netModel;
        }
    }

    public List<CitySellRent> getCitySellRents() throws IOException {
        okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("userId", Constants.userId+"")
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(Constants.BASE_RUL+"get/citysellrents")
                .build();
        String response = okHttpClient.newCall(request).execute().body().string();
        return JSON.parseArray(response, CitySellRent.class);
    }

//    public CommercialHouseTradeModel getCommercialHouseTradeModelById(Long id) {
//
//    }

}
