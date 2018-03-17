package org.chengjian.java.feidian.collectdata.mvp.view.base;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by xiang on 2017/12/8.
 *
 */

public interface DetailBaseView<T> {
    void initModel(T model);
}
