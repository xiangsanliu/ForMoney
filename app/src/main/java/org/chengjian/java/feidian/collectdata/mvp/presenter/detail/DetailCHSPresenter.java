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

    private NetModel netModel;
    private Activity activity;

    private ProgressDialog progressDialog;

    public DetailCHSPresenter(Activity activity) {
        this.activity = activity;
        progressDialog = createProgress();
        netModel = NetModel.newInstance();
    }

    private ProgressDialog createProgress() {
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("加载中");
        progressDialog.create();
        return progressDialog;
    }
    
    public void deleteCity(Long id) {
        netModel.deleteCity(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(String s) {
                        showToast("删除成功");
                    }
                });
    }

    public void save(CitySellRent citySellRent, CommercialHouseTradeModel model) {
        System.out.println("save");
//        netModel.saveCity(JSON.toJSONString(citySellRent))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//                        progressDialog.dismiss();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                        showToast("保存失败");
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//
//                    }
//                });
//        netModel.saveCommercial(JSON.toJSONString(model))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//                        progressDialog.dismiss();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                        showToast("保存失败");
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        showToast("保存成功");
//                    }
//                });
        TestTask testTask = new TestTask(view);
        testTask.execute(JSON.toJSONString(citySellRent), JSON.toJSONString(model));
    }

    @Override
    public void dismissProgress() {
        if (progressDialog!=null)
            progressDialog.dismiss();
    }

    @Override
    public void showProgress() {
        if (progressDialog!=null)
            progressDialog.show();
    }

    public void loadModel(Long id) {
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
                        e.printStackTrace();
                        activity.finish();
                    }

                    @Override
                    public void onNext(String model) {
                        view.initCommercialHouseTradeModel(JSON.parseObject(model, CommercialHouseTradeModel.class));
                    }
                });

    }
    
    @SuppressLint("ShowToast")
    public void showToast(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

}
