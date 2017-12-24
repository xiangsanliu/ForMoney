package org.chengjian.java.feidian.collectdata.beans.message;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by xiang on 2017/9/29.
 *
 */

@Setter
@Getter
public class ResultMessage {
    private boolean isThatOk;

    public ResultMessage(boolean isThatOk) {
        this.isThatOk = isThatOk;
    }
}
