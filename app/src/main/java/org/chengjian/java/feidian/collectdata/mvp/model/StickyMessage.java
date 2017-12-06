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

    private CitySellRent citySellRent;
    private CommercialHouseTradeModel commercialHouseTradeModel;
    private HouseTradeModel houseTradeModel;
    private HouseRentModel houseRentModel;
    private ShopRentModel shopRentModel;
    private Editable editable;

    public CitySellRent getCitySellRent() {
        return citySellRent;
    }

    public void setCitySellRent(CitySellRent citySellRent) {
        this.citySellRent = citySellRent;
    }

    public CommercialHouseTradeModel getCommercialHouseTradeModel() {
        return commercialHouseTradeModel;
    }

    public void setCommercialHouseTradeModel(CommercialHouseTradeModel commercialHouseTradeModel) {
        this.commercialHouseTradeModel = commercialHouseTradeModel;
    }

    public HouseTradeModel getHouseTradeModel() {
        return houseTradeModel;
    }

    public void setHouseTradeModel(HouseTradeModel houseTradeModel) {
        this.houseTradeModel = houseTradeModel;
    }

    public HouseRentModel getHouseRentModel() {
        return houseRentModel;
    }

    public void setHouseRentModel(HouseRentModel houseRentModel) {
        this.houseRentModel = houseRentModel;
    }

    public ShopRentModel getShopRentModel() {
        return shopRentModel;
    }

    public void setShopRentModel(ShopRentModel shopRentModel) {
        this.shopRentModel = shopRentModel;
    }

    public Editable getEditable() {
        return editable;
    }

    public void setEditable(Editable editable) {
        this.editable = editable;
    }
}
