package org.chengjian.java.feidian.collectdata.mvp.presenter.detail;

import android.app.Activity;

import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailHSView;

/**
 * Created by xiang on 2017/12/8.
 *
 */

public class DetailHSPresenter extends DetailBasePresenter<DetailHSView> {

    public DetailHSPresenter(Activity activity) {
        this.activity = activity;
    }
}
