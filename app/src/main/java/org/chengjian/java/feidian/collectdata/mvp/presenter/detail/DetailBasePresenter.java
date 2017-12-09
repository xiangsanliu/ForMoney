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
import org.chengjian.java.feidian.collectdata.mvp.model.ResultMessage;
import org.chengjian.java.feidian.collectdata.mvp.view.base.BaseUIView;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailBaseView;
import org.greenrobot.eventbus.EventBus;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 2017/12/6.
 *
 */

public class DetailBasePresenter <T extends DetailBaseView> {

    protected T view;
    ProgressDialog progressDialog;
    NetModel netModel;
    Activity activity;

    DetailBasePresenter() {
        netModel = NetModel.newInstance();
    }

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
                        refreshList();
                        activity.finish();
                    }
                });
    }

    void saveCity(CitySellRent citySellRent) {
        netModel.save(JSON.toJSONString(citySellRent), "city/save/city")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        showToast("上传失败");
                    }

                    @Override
                    public void onNext(String s) {
                        showToast("上传成功");
                        refreshList();
                    }
                });
    }

    public void loadModel(Long id, String typeUrl) {
        progressDialog = createProgress("加载中");
        progressDialog.show();
        netModel.getModel(id, typeUrl)
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

    void showToast(String content) {
        Toast.makeText((Context) view, content, Toast.LENGTH_SHORT).show();
    }

    private void refreshList() {
        EventBus.getDefault().post(new ResultMessage(true));
    }

}
