package org.chengjian.java.feidian.collectdata.mvp.presenter.detail;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModel;
import org.chengjian.java.feidian.collectdata.mvp.model.NetModel;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailCHSView;
import org.chengjian.java.feidian.collectdata.shared.TestTask;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 2017/12/6.
 *
 */

public class DetailCHSPresenter extends DetailBasePresenter<DetailCHSView> {

    public DetailCHSPresenter(Activity activity) {
        this.activity = activity;
        netModel = NetModel.newInstance();
    }

    public void save(CitySellRent citySellRent, CommercialHouseTradeModel model) {
        progressDialog = createProgress("上传中");
        progressDialog.show();
        netModel.saveCity(JSON.toJSONString(citySellRent))
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
                    }
                });
        netModel.saveCommercial(JSON.toJSONString(model))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressDialog.dismiss();
                        showToast("上传失败");
                    }

                    @Override
                    public void onNext(String s) {
                        progressDialog.dismiss();
                        showToast("上传成功");
                    }
                });
    }






    @SuppressLint("ShowToast")
    public void showToast(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

}
