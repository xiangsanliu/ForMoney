package org.chengjian.java.feidian.collectdata.beans;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

/**
 * Created by xiang on 2017/9/26.
 *
 */

public class Editable extends BaseObservable {
//    public final ObservableField<Boolean> isEditable = new ObservableField<>() ;

    public Boolean isEditable;

    public Boolean getEditable() {
        return isEditable;
    }

    public void setEditable(Boolean editable) {
        isEditable = editable;
    }
}
