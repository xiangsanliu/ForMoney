package org.chengjian.java.feidian.collectdata.mvp.model;

/**
 * Created by xiang on 2017/9/29.
 */

public class ResultMessage {
    boolean isThatOk;

    public boolean isThatOk() {
        return isThatOk;
    }

    public ResultMessage(boolean isThatOk) {
        this.isThatOk = isThatOk;
    }

    public void setThatOk(boolean thatOk) {
        isThatOk = thatOk;
    }
}
