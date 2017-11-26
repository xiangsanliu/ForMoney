package org.chengjian.java.feidian.collectdata.mvp.presenter.base;

import android.content.Context;
import android.os.Bundle;

import org.chengjian.java.feidian.collectdata.mvp.contract.BaseContract;
import org.chengjian.java.feidian.collectdata.mvp.view.base.ListItemView;
import org.chengjian.java.feidian.collectdata.shared.rx.RxJavaCustomTransformer;
import org.chengjian.java.feidian.collectdata.shared.rx.subscribers.DefaultUiSubscriber;

import java.util.List;

import rx.Observable;

/**
 * Created by StormPhoenix on 17-2-28.
 * StormPhoenix is a intelligent Android developer.
 */

public abstract class ListItemPresenter<T, R, V extends ListItemView<T>> extends BasePresenter<V> {
    public static String TAG = ListItemPresenter.class.getClass().getName();

    protected Context mContext = null;

    public ListItemPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        loadNewlyListItem();
    }

    public void loadNewlyListItem() {
        mView.hideProgress();
        Observable<R> observable = load(0);
        if (observable == null) {
            return;
        }
        mView.clearAllItems();
        observable.compose(RxJavaCustomTransformer.<R>defaultSchedulers())
                .subscribe(new DefaultUiSubscriber<R, BaseContract.View>(mView, "network error") {
                    @Override
                    public void onNext(R response) {
                        List<T> body = transformBody(response);
                        mView.loadNewlyListItem(body);
                        mView.hideProgress();
                    }
                });
    }

    public void loadMoreListItem() {
        mView.showProgress();

        Observable<R> observable = load(mView.getListItemCounts() / 10 + 1);
        if (observable == null) {
            mView.hideProgress();
            return;
        }
        observable.compose(RxJavaCustomTransformer.<R>defaultSchedulers())
                .subscribe(new DefaultUiSubscriber<R, BaseContract.View>(mView, "network error") {
                    @Override
                    public void onNext(R response) {
                        mView.loadMoreListItem(transformBody(response));
                        mView.hideProgress();
                    }
                });
    }

    protected abstract List<T> transformBody(R body);

    protected abstract Observable<R> load(int page);
}

