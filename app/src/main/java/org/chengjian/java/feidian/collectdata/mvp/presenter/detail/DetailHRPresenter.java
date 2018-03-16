package org.chengjian.java.feidian.collectdata.mvp.presenter.detail;

import android.app.Activity;

import com.alibaba.fastjson.JSON;

import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.beans.HouseRent;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailHRView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 2017/12/8.
 *
 */

public class DetailHRPresenter extends DetailBasePresenter<DetailHRView> {

    public DetailHRPresenter(Activity activity) {
        this.activity = activity;
    }

    public void save(CityCommonAttributes cityCommonAttributes, HouseRent model) {
        progressDialog = createProgress("上传中");
        progressDialog.show();
        saveCity(cityCommonAttributes);
        netModel.save(JSON.toJSONString(model), "city/save/houserent")
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

}
