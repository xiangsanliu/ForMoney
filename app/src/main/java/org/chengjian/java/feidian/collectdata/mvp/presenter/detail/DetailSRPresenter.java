package org.chengjian.java.feidian.collectdata.mvp.presenter.detail;

import android.app.Activity;

import org.chengjian.java.feidian.collectdata.mvp.view.base.DetailSRView;

/**
 * Created by xiang on 2017/12/8.
 *
 */

public class DetailSRPresenter extends DetailBasePresenter<DetailSRView> {
    public DetailSRPresenter(Activity activity) {
        this.activity = activity;
    }
}
