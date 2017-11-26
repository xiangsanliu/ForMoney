package org.chengjian.java.feidian.collectdata.mvp.view.base;


import org.chengjian.java.feidian.collectdata.mvp.contract.BaseContract;

/**
 * Created by StormPhoenix on 17-3-10.
 * StormPhoenix is a intelligent Android developer.
 */

public interface MessageView extends BaseContract.View {
    void showMessage(String message);
}
