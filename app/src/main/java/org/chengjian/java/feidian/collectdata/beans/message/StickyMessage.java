package org.chengjian.java.feidian.collectdata.beans.message;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by xiang on 2017/12/6.
 *
 */
@NoArgsConstructor
@Setter
@Getter
public class StickyMessage {

    private CitySellRent citySellRent;
    private Boolean isEditable;

    public StickyMessage(CitySellRent citySellRent, Boolean isEditable) {
        this.citySellRent = citySellRent;
        this.isEditable = isEditable;
    }
}
