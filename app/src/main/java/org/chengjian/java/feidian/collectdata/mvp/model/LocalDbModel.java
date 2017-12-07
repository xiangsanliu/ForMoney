package org.chengjian.java.feidian.collectdata.mvp.model;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.beans.CitySellRentDao;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModel;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModelDao;
import org.chengjian.java.feidian.collectdata.beans.DaoMaster;
import org.chengjian.java.feidian.collectdata.beans.DaoSession;
import org.chengjian.java.feidian.collectdata.beans.HouseRentModel;
import org.chengjian.java.feidian.collectdata.beans.RentInfo2Model;
import org.chengjian.java.feidian.collectdata.beans.RentInfo2ModelDao;
import org.chengjian.java.feidian.collectdata.beans.RentInfo4Model;
import org.chengjian.java.feidian.collectdata.beans.RentInfo4ModelDao;
import org.chengjian.java.feidian.collectdata.beans.SellRentModel;
import org.chengjian.java.feidian.collectdata.beans.SellRentModelDao;
import org.chengjian.java.feidian.collectdata.beans.TradeInfo1Model;
import org.chengjian.java.feidian.collectdata.beans.TradeInfo1ModelDao;
import org.chengjian.java.feidian.collectdata.beans.TradeInfo3Model;
import org.chengjian.java.feidian.collectdata.beans.TradeInfo3ModelDao;
import org.chengjian.java.feidian.collectdata.shared.Constants;
import org.chengjian.java.feidian.collectdata.shared.TestTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by StormPhoenix on 17-9-12.
 * StormPhoenix is a intelligent Android developer.
 */

public class LocalDbModel extends BaseModel {
    private DaoMaster.DevOpenHelper devOpenHelper = null;
    private List<SellRentModel> sellRentModels = null;
    DaoSession daoSession;

    private static LocalDbModel localDbModel ;

    public static LocalDbModel getInstance(Context context) {
        if (localDbModel != null)
            return localDbModel;
        else return new LocalDbModel(context);
    }


    private LocalDbModel(Context context) {
        super(context);
        devOpenHelper = new DaoMaster.DevOpenHelper(context, "sell-db");
        daoSession = new DaoMaster(devOpenHelper.getWritableDatabase()).newSession();
    }

    @Override
    public List<SellRentModel> queryCommercialHouseSellTable() {
        List<SellRentModel> rentData = getAllSellRentData();
        List<SellRentModel> result = new ArrayList<>();
        for (SellRentModel sellRentModel : rentData) {
            if (sellRentModel.getModelType() == Constants.COMMERCIAL_HOUSE_TRADE) {
                result.add(sellRentModel);
            }
        }
        return result;
    }



    @Override
    public RentInfo2Model queryRentInfo2ModelById(Long id) {
        RentInfo2ModelDao dao = daoSession.getRentInfo2ModelDao();
        List<RentInfo2Model> models = dao.queryBuilder()
                .where(RentInfo2ModelDao.Properties.Id.eq(id))
                .build().list();
        if (models != null && models.size() != 0) {
            return models.get(0);
        }
        return null;
    }

    @Override
    public RentInfo4Model queryRentInfo4ModelById(Long id) {
        RentInfo4ModelDao dao = daoSession.getRentInfo4ModelDao();
        List<RentInfo4Model> models = dao.queryBuilder()
                .where(RentInfo4ModelDao.Properties.Id.eq(id))
                .build().list();
        if (models != null && models.size() != 0) {
            return models.get(0);
        }
        return null;
    }

    @Override
    public TradeInfo1Model queryTradeInfo1ModelById(Long id) {
        TradeInfo1ModelDao tradeInfo1ModelDao = daoSession.getTradeInfo1ModelDao();
        List<TradeInfo1Model> models = tradeInfo1ModelDao.queryBuilder()
                .where(TradeInfo1ModelDao.Properties.Id.eq(id))
                .build().list();
        if (models != null && models.size() != 0) {
            return models.get(0);
        }
        return null;
    }

    @Override
    public TradeInfo3Model queryTradeInfo3ModelById(Long id) {
        TradeInfo3ModelDao tradeInfo3ModelDao = daoSession.getTradeInfo3ModelDao();
        List<TradeInfo3Model> models = tradeInfo3ModelDao.queryBuilder()
                .where(TradeInfo3ModelDao.Properties.Id.eq(id))
                .build().list();
        if (models != null && models.size() != 0) {
            return models.get(0);
        }
        return null;
    }

    @Override
    public SellRentModel querySellRentModelById(Long id) {
        SellRentModelDao sellRentModelDao = daoSession.getSellRentModelDao();
        List<SellRentModel> models = sellRentModelDao.queryBuilder()
                .where(SellRentModelDao.Properties.Id.eq(id))
                .build().list();
        if (models != null && models.size() != 0) {
            return models.get(0);
        }
        return null;
    }

    @Override
    public List<SellRentModel> queryShopRentTable() {
        List<SellRentModel> rentData = getAllSellRentData();
        List<SellRentModel> result = new ArrayList<>();
        for (SellRentModel sellRentModel : rentData) {
            if (sellRentModel.getModelType() == Constants.SHOP_RENT) {
                result.add(sellRentModel);
            }
        }
        return result;
    }

    @Override
    public List<SellRentModel> queryHouseSellTable() {
        List<SellRentModel> rentData = getAllSellRentData();
        List<SellRentModel> result = new ArrayList<>();
        for (SellRentModel sellRentModel : rentData) {
            if (sellRentModel.getModelType() == Constants.HOUSE_SELL) {
                result.add(sellRentModel);
            }
        }
        return result;
    }

    @Override
    public List<SellRentModel> queryHouseRentTable() {
        List<SellRentModel> rentData = getAllSellRentData();
        List<SellRentModel> result = new ArrayList<>();
        for (SellRentModel sellRentModel : rentData) {
            if (sellRentModel.getModelType() == Constants.HOUSE_RENT) {
                result.add(sellRentModel);
            }
        }
        return result;
    }

    @Override
    public void saveSellRentModel(SellRentModel sellRentModel, Long id) {
        switch (sellRentModel.getModelType()) {
            case Constants.COMMERCIAL_HOUSE_TRADE:
                sellRentModel.setTi1ForeignKey(id);
                break;
            case Constants.HOUSE_RENT:
                sellRentModel.setRi4ForeignKey(id);
                break;
            case Constants.HOUSE_SELL:
                sellRentModel.setTi3ForeignKey(id);
                break;
            case Constants.SHOP_RENT:
                sellRentModel.setRi2ForeignKey(id);
                break;
        }
        SellRentModelDao sellRentModelDao = daoSession.getSellRentModelDao();
        sellRentModelDao.save(sellRentModel);
    }

    @Override
    public Long saveRentInfo2Model(RentInfo2Model rentInfo2Model) {
        daoSession.getRentInfo2ModelDao().insert(rentInfo2Model);
        Log.d("id", rentInfo2Model.getId()+"");
        return rentInfo2Model.getId();
    }

    @Override
    public Long saveRentInfo4Model(RentInfo4Model rentInfo4Model) {
        daoSession.getRentInfo4ModelDao().insert(rentInfo4Model);
        return rentInfo4Model.getId();
    }

    @Override
    public Long saveTradeInfo1Model(TradeInfo1Model tradeInfo1Model) {
        daoSession.getTradeInfo1ModelDao().insert(tradeInfo1Model);
        return tradeInfo1Model.getId();
    }

    @Override
    public Long saveTradeInfo3Model(TradeInfo3Model tradeInfo3Model) {
        daoSession.getTradeInfo3ModelDao().insert(tradeInfo3Model);
        return tradeInfo3Model.getId();
    }

    @Override
    public DaoSession getDaoSession() {
        return daoSession;
    }


    private List<SellRentModel> getAllSellRentData() {
        SellRentModelDao sellRentModelDao = daoSession.getSellRentModelDao();
        sellRentModels = sellRentModelDao.queryBuilder().build().list();
        return sellRentModels;
    }

    public void querytest() {
        CitySellRent citySellRent = new CitySellRent();
        CommercialHouseTradeModel commercialHouseTradeModel = new CommercialHouseTradeModel();
        Long id = System.currentTimeMillis();
        commercialHouseTradeModel.setId(id);
        citySellRent.setId(id);
        citySellRent.setUserId((long) 1);
        System.out.println(JSON.toJSONString(citySellRent));
        daoSession.getCitySellRentDao().insert(citySellRent);
    }


}
