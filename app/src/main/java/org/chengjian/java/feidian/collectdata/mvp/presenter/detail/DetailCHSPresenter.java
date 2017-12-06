package org.chengjian.java.feidian.collectdata.mvp.presenter.detail;

import android.app.ProgressDialog;
import android.content.Context;

import org.chengjian.java.feidian.collectdata.beans.CitySellRentDao;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModel;
import org.chengjian.java.feidian.collectdata.mvp.model.NetModel;
import org.chengjian.java.feidian.collectdata.mvp.ui.dialog.ProgressDialogGenerator;
import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailCHSView;
import org.chengjian.java.feidian.collectdata.shared.Constants;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by xiang on 2017/12/6.
 */

public class DetailCHSPresenter extends DetailBasePresenter<DetailCHSView> {

    private NetModel netModel;
    private Context context;

    private ProgressDialog progressDialog;

    public DetailCHSPresenter(Context context) {
        this.context = context;
        progressDialog = createProgress();
        netModel = NetModel.newInstance();
    }

    private ProgressDialog createProgress() {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("加载中");
        progressDialog.create();
        return progressDialog;
    }

    public void loadModel(Long id) {
        progressDialog.show();
        netModel.getCommercialHouseTradeModel(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommercialHouseTradeModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showMessage("请求出错");
                    }

                    @Override
                    public void onNext(CommercialHouseTradeModel model) {
                        view.initCommercialHouseTradeModel(model);
                        progressDialog.dismiss();
                    }
                });

    }

}
