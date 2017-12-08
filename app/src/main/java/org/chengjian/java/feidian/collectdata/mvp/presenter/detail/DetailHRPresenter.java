package org.chengjian.java.feidian.collectdata.mvp.presenter.detail;

import android.app.Activity;

import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailHRView;

/**
 * Created by xiang on 2017/12/8.
 *
 */

public class DetailHRPresenter extends DetailBasePresenter<DetailHRView> {

    public DetailHRPresenter(Activity activity) {
        this.activity = activity;
    }
}
