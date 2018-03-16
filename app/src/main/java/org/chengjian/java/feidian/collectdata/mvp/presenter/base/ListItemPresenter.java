package org.chengjian.java.feidian.collectdata.mvp.presenter.base;

import android.content.Context;
import android.os.Bundle;

import org.chengjian.java.feidian.collectdata.mvp.contract.BaseContract;
import org.chengjian.java.feidian.collectdata.mvp.model.LocalDbModel;
import org.chengjian.java.feidian.collectdata.mvp.view.base.ListItemView;
import org.chengjian.java.feidian.collectdata.shared.rx.RxJavaCustomTransformer;
import org.chengjian.java.feidian.collectdata.shared.rx.subscribers.DefaultUiSubscriber;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by StormPhoenix on 17-2-28.
 * StormPhoenix is a intelligent Android developer.
 */

public abstract class ListItemPresenter<T, V extends ListItemView<T>> extends BasePresenter<V> {
    public static String TAG = ListItemPresenter.class.getClass().getName();

    protected Context mContext = null;
    protected LocalDbModel<T> dbManager = null;

    public ListItemPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        this.dbManager = initDbManager();
        loadNewlyListItem();
    }

    /**
     * 不同的Fragment用不同的dbManager获取本地数据
     */
    protected abstract LocalDbModel<T> initDbManager();

    /**
     * 若Fragment创建页面，那么Presenter会触发
     * {@link #loadNewlyListItem()}，这个方法用于从本地数据库加载最新数据。
     */
    public void loadNewlyListItem() {
        // 这里会进行访问数据库操作
        Observable.create(new Observable.OnSubscribe<List<T>>() {
            @Override
            public void call(Subscriber<? super List<T>> subscriber) {
                List<T> entities = dbManager.queryAllEntities();
                subscriber.onNext(entities);
            }
        }).subscribe(new Observer<List<T>>() {
            @Override
            public void onCompleted() {
                mView.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                mView.hideProgress();
                mView.showMessage("something error happened");
            }

            @Override
            public void onNext(List<T> dataList) {
                mView.clearAllItems();
                mView.loadNewlyListItem(dataList);
                mView.hideProgress();
            }
        });
    }
}

