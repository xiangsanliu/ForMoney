package org.chengjian.java.feidian.collectdata.mvp.model;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.beans.DaoSession;
import org.chengjian.java.feidian.collectdata.beans.RentInfo2Model;
import org.chengjian.java.feidian.collectdata.beans.RentInfo4Model;
import org.chengjian.java.feidian.collectdata.beans.SellRentModel;
import org.chengjian.java.feidian.collectdata.beans.TradeInfo1Model;
import org.chengjian.java.feidian.collectdata.beans.TradeInfo3Model;
import org.chengjian.java.feidian.collectdata.mvp.contract.BaseContract;

import java.util.List;

/**
 * Created by StormPhoenix on 17-9-11.
 * StormPhoenix is a intelligent Android developer.
 */

public abstract class BaseModel implements BaseContract.Model {

    public BaseModel(Context context) {
    }

    public abstract List<SellRentModel> queryCommercialHouseSellTable();

    public abstract RentInfo2Model queryRentInfo2ModelById(Long id);

    public abstract RentInfo4Model queryRentInfo4ModelById(Long id);

    public abstract TradeInfo1Model queryTradeInfo1ModelById(Long id);

    public abstract TradeInfo3Model queryTradeInfo3ModelById(Long id);

    public abstract SellRentModel querySellRentModelById(Long id);

    public abstract List<SellRentModel> queryShopRentTable();

    public abstract List<SellRentModel> queryHouseSellTable();

    public abstract List<SellRentModel> queryHouseRentTable();

    public abstract void saveSellRentModel(SellRentModel sellRentModel, Long id);

    public abstract Long saveRentInfo2Model(RentInfo2Model rentInfo2Model);
    public abstract Long saveRentInfo4Model(RentInfo4Model rentInfo4Model);
    public abstract Long saveTradeInfo1Model(TradeInfo1Model tradeInfo1Model);
    public abstract Long saveTradeInfo3Model(TradeInfo3Model tradeInfo3Model);
    public abstract DaoSession getDaoSession();


}
