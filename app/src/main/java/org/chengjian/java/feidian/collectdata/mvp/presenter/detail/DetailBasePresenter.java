package org.chengjian.java.feidian.collectdata.mvp.presenter.detail;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModel;
import org.chengjian.java.feidian.collectdata.mvp.model.NetModel;
import org.chengjian.java.feidian.collectdata.mvp.view.base.BaseUIView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 2017/12/6.
 *
 */

public class DetailBasePresenter <T extends BaseUIView> {

    protected T view;
    ProgressDialog progressDialog;
    NetModel netModel;
    Activity activity;



    public void attachView(T view) {
        this.view = view;
    }

    public void dismissProgress(){
    }

    ProgressDialog createProgress(String message) {
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.create();
        return progressDialog;
    }

    public void deleteCity(Long id) {
        progressDialog = createProgress("删除中");
        progressDialog.show();
        netModel.deleteCity(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressDialog.dismiss();
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Integer s) {
                        progressDialog.dismiss();
                        showToast("删除成功");
                    }
                });
    }

    public void loadModel(Long id) {
        progressDialog = createProgress("加载中");
        progressDialog.show();
        netModel.getCommercialHouseTradeModel(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        showToast("请求出错");
                        progressDialog.dismiss();
                        activity.finish();
                    }

                    @Override
                    public void onNext(String model) {
                        progressDialog.dismiss();
                        view.initModel(model);
                    }
                });

    }

    @SuppressLint("ShowToast")
    public void showToast(String content) {
        Toast.makeText((Context) view, content, Toast.LENGTH_SHORT).show();
    }

}
