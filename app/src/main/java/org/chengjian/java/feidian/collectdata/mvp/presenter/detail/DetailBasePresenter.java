package org.chengjian.java.feidian.collectdata.mvp.presenter.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import org.chengjian.java.feidian.collectdata.mvp.view.base.BaseUIView;

/**
 * Created by xiang on 2017/12/6.
 */

public class DetailBasePresenter <T extends BaseUIView> {

    protected T view;

    public void attachView(T view) {
        this.view = view;
    }

    public void onCreate() {

    }

    public void showProgress(){
    }

    public void dismissProgress(){
    }

    @SuppressLint("ShowToast")
    public void showToast(String content) {
        Toast.makeText((Context) view, content, Toast.LENGTH_SHORT).show();
    }

}
