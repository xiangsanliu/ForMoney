package org.chengjian.java.feidian.collectdata.mvp.model;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModel;
import org.chengjian.java.feidian.collectdata.beans.Editable;
import org.chengjian.java.feidian.collectdata.beans.HouseRentModel;
import org.chengjian.java.feidian.collectdata.beans.HouseTradeModel;
import org.chengjian.java.feidian.collectdata.beans.ShopRentModel;

/**
 * Created by xiang on 2017/12/6.
 */

public class StickyMessage {

    public StickyMessage(CitySellRent citySellRent, Boolean isEditable) {
        this.citySellRent = citySellRent;
        this.isEditable = isEditable;
    }

    public StickyMessage() {
    }

    private CitySellRent citySellRent;
    private Boolean isEditable;

    public Boolean getEditable() {
        return isEditable;
    }

    public void setEditable(Boolean editable) {
        isEditable = editable;
    }

    public CitySellRent getCitySellRent() {
        return citySellRent;
    }

    public void setCitySellRent(CitySellRent citySellRent) {
        this.citySellRent = citySellRent;
    }
}
