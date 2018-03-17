package org.chengjian.java.feidian.collectdata.mvp.presenter.detail;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.beans.message.ResultMessage;
import org.chengjian.java.feidian.collectdata.mvp.model.NetModel;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailBaseView;
import org.greenrobot.eventbus.EventBus;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiang on 2017/12/6.
 */

/**
 * {@link DetailBasePresenter} 用来控制进入的Activity控件如何显示数据。
 *
 * @param <T>
 */
public abstract class DetailBasePresenter<T> {

    protected DetailBaseView<T> view;
    ProgressDialog progressDialog;
    NetModel netModel;
    Activity activity;

    DetailBasePresenter() {
        netModel = NetModel.newInstance();
    }

    public void attachView(DetailBaseView<T> view) {
        this.view = view;
    }

    public void dismissProgress() {
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

    void showToast(String content) {
        Toast.makeText((Context) view, content, Toast.LENGTH_SHORT).show();
    }

    private void refreshList() {
        EventBus.getDefault().post(new ResultMessage(true));
    }

    public abstract void realLoadModel(Long id);

    public abstract void save(CityCommonAttributes commonAttrs, T entity);

    /**
     * 将model中的数据加载到控件上显示。
     *
     * @param id 　CicyCommonAttributes的主键
     */
    public void loadModel(Long id) {
        progressDialog = createProgress("加载中");
        progressDialog.show();
        realLoadModel(id);
        progressDialog.dismiss();
//        netModel.getModel(id, typeUrl)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        showToast("请求出错");
//                        progressDialog.dismiss();
//                        activity.finish();
//                    }
//
//                    @Override
//                    public void onNext(String model) {
//                        progressDialog.dismiss();
//                        view.initModel(model);
//                    }
//                });
//
    }
}
