package org.chengjian.java.feidian.collectdata.beans;

import android.support.annotation.Nullable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * 柜台出租租金调查表
 */
@Entity
public class CounterRent {

    @Id
    Long id;
    @Nullable
    private int useageActual;   //实际用途
    @Nullable
    private int useagePlaned;   //规划用途
    @Nullable
    private int nearByLandType;     //周围土地类型

    //房屋情况
    @Nullable
    private int decorationType;         //装修标准
    @Nullable
    private int lightAirType;           //采光通风状况
    @Nullable
    private String houseStandardPrice;    //房屋标准造价
    @Nullable
    private String totalArea;            //总占地面积
    @Nullable
    private String houseResetTotalPrice;      //房屋重置总价
    @Nullable
    private String subbuildingResetPrice;    //其它附属建筑物重置总价
    @Nullable
    private String houseTodayValue;      //房屋现值
    @Nullable
    private String subbuildingTodayValue;    //其它附属建筑物现值
    @Nullable
    private String yearRobust;             //耐用年限
    @Nullable
    private String yearUsed;               //已用年限
    //出租情况
    @Nullable
    private String rentOut;         //出租人
    @Nullable
    private String rentIn;          //承租人
    @Nullable
    private String rentTime;        //出租时间
    @Nullable
    private String rentMethod;      //出租方式
    @Nullable
    private String useage;          //出租用途
    @Nullable
    private String rentDeadline;    //出租期限
    @Nullable
    private String totalTrdeArea;    //总营业面积
    @Nullable
    private String counterTradeArea; //出租柜台营业面积
    @Nullable
    private String totalRentPrice;      //出租房地产总费用
    @Nullable
    private String fixFee;           //其中维修费
    @Nullable
    private String oldFee;               //折旧费
    @Nullable
    private String insuranceFee;         //保险费
    @Nullable
    private String manageFree;           //管理费
    @Nullable
    private String taxFee;               //税费
    @Nullable
    private String otherFee;             //其它费用
    @Nullable
    private String counterSharedLandArea;    //出租柜台分摊土地面积
    @Nullable
    private String counterSharedLandFee;    //出租柜台分摊总费
    @Nullable
    private String counterFeeOfYear;         //出租柜台年租金
    @Nullable
    private String buildinglandPrice;        //楼面地价
    @Nullable
    private String pricePer;                 //单位地价
    @ToOne(joinProperty = "foreignKey")
    private CityCommonAttributes commonAttributes;
    private Long foreignKey;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1498350833)
    private transient CounterRentDao myDao;
    @Generated(hash = 1760028573)
    public CounterRent(Long id, int useageActual, int useagePlaned,
            int nearByLandType, int decorationType, int lightAirType,
            String houseStandardPrice, String totalArea,
            String houseResetTotalPrice, String subbuildingResetPrice,
            String houseTodayValue, String subbuildingTodayValue, String yearRobust,
            String yearUsed, String rentOut, String rentIn, String rentTime,
            String rentMethod, String useage, String rentDeadline,
            String totalTrdeArea, String counterTradeArea, String totalRentPrice,
            String fixFee, String oldFee, String insuranceFee, String manageFree,
            String taxFee, String otherFee, String counterSharedLandArea,
            String counterSharedLandFee, String counterFeeOfYear,
            String buildinglandPrice, String pricePer, Long foreignKey) {
        this.id = id;
        this.useageActual = useageActual;
        this.useagePlaned = useagePlaned;
        this.nearByLandType = nearByLandType;
        this.decorationType = decorationType;
        this.lightAirType = lightAirType;
        this.houseStandardPrice = houseStandardPrice;
        this.totalArea = totalArea;
        this.houseResetTotalPrice = houseResetTotalPrice;
        this.subbuildingResetPrice = subbuildingResetPrice;
        this.houseTodayValue = houseTodayValue;
        this.subbuildingTodayValue = subbuildingTodayValue;
        this.yearRobust = yearRobust;
        this.yearUsed = yearUsed;
        this.rentOut = rentOut;
        this.rentIn = rentIn;
        this.rentTime = rentTime;
        this.rentMethod = rentMethod;
        this.useage = useage;
        this.rentDeadline = rentDeadline;
        this.totalTrdeArea = totalTrdeArea;
        this.counterTradeArea = counterTradeArea;
        this.totalRentPrice = totalRentPrice;
        this.fixFee = fixFee;
        this.oldFee = oldFee;
        this.insuranceFee = insuranceFee;
        this.manageFree = manageFree;
        this.taxFee = taxFee;
        this.otherFee = otherFee;
        this.counterSharedLandArea = counterSharedLandArea;
        this.counterSharedLandFee = counterSharedLandFee;
        this.counterFeeOfYear = counterFeeOfYear;
        this.buildinglandPrice = buildinglandPrice;
        this.pricePer = pricePer;
        this.foreignKey = foreignKey;
    }
    @Generated(hash = 158142138)
    public CounterRent() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getUseageActual() {
        return this.useageActual;
    }
    public void setUseageActual(int useageActual) {
        this.useageActual = useageActual;
    }
    public int getUseagePlaned() {
        return this.useagePlaned;
    }
    public void setUseagePlaned(int useagePlaned) {
        this.useagePlaned = useagePlaned;
    }
    public int getNearByLandType() {
        return this.nearByLandType;
    }
    public void setNearByLandType(int nearByLandType) {
        this.nearByLandType = nearByLandType;
    }
    public int getDecorationType() {
        return this.decorationType;
    }
    public void setDecorationType(int decorationType) {
        this.decorationType = decorationType;
    }
    public int getLightAirType() {
        return this.lightAirType;
    }
    public void setLightAirType(int lightAirType) {
        this.lightAirType = lightAirType;
    }
    public String getHouseStandardPrice() {
        return this.houseStandardPrice;
    }
    public void setHouseStandardPrice(String houseStandardPrice) {
        this.houseStandardPrice = houseStandardPrice;
    }
    public String getTotalArea() {
        return this.totalArea;
    }
    public void setTotalArea(String totalArea) {
        this.totalArea = totalArea;
    }
    public String getHouseResetTotalPrice() {
        return this.houseResetTotalPrice;
    }
    public void setHouseResetTotalPrice(String houseResetTotalPrice) {
        this.houseResetTotalPrice = houseResetTotalPrice;
    }
    public String getSubbuildingResetPrice() {
        return this.subbuildingResetPrice;
    }
    public void setSubbuildingResetPrice(String subbuildingResetPrice) {
        this.subbuildingResetPrice = subbuildingResetPrice;
    }
    public String getHouseTodayValue() {
        return this.houseTodayValue;
    }
    public void setHouseTodayValue(String houseTodayValue) {
        this.houseTodayValue = houseTodayValue;
    }
    public String getSubbuildingTodayValue() {
        return this.subbuildingTodayValue;
    }
    public void setSubbuildingTodayValue(String subbuildingTodayValue) {
        this.subbuildingTodayValue = subbuildingTodayValue;
    }
    public String getYearRobust() {
        return this.yearRobust;
    }
    public void setYearRobust(String yearRobust) {
        this.yearRobust = yearRobust;
    }
    public String getYearUsed() {
        return this.yearUsed;
    }
    public void setYearUsed(String yearUsed) {
        this.yearUsed = yearUsed;
    }
    public String getRentOut() {
        return this.rentOut;
    }
    public void setRentOut(String rentOut) {
        this.rentOut = rentOut;
    }
    public String getRentIn() {
        return this.rentIn;
    }
    public void setRentIn(String rentIn) {
        this.rentIn = rentIn;
    }
    public String getRentTime() {
        return this.rentTime;
    }
    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }
    public String getRentMethod() {
        return this.rentMethod;
    }
    public void setRentMethod(String rentMethod) {
        this.rentMethod = rentMethod;
    }
    public String getUseage() {
        return this.useage;
    }
    public void setUseage(String useage) {
        this.useage = useage;
    }
    public String getRentDeadline() {
        return this.rentDeadline;
    }
    public void setRentDeadline(String rentDeadline) {
        this.rentDeadline = rentDeadline;
    }
    public String getTotalTrdeArea() {
        return this.totalTrdeArea;
    }
    public void setTotalTrdeArea(String totalTrdeArea) {
        this.totalTrdeArea = totalTrdeArea;
    }
    public String getCounterTradeArea() {
        return this.counterTradeArea;
    }
    public void setCounterTradeArea(String counterTradeArea) {
        this.counterTradeArea = counterTradeArea;
    }
    public String getTotalRentPrice() {
        return this.totalRentPrice;
    }
    public void setTotalRentPrice(String totalRentPrice) {
        this.totalRentPrice = totalRentPrice;
    }
    public String getFixFee() {
        return this.fixFee;
    }
    public void setFixFee(String fixFee) {
        this.fixFee = fixFee;
    }
    public String getOldFee() {
        return this.oldFee;
    }
    public void setOldFee(String oldFee) {
        this.oldFee = oldFee;
    }
    public String getInsuranceFee() {
        return this.insuranceFee;
    }
    public void setInsuranceFee(String insuranceFee) {
        this.insuranceFee = insuranceFee;
    }
    public String getManageFree() {
        return this.manageFree;
    }
    public void setManageFree(String manageFree) {
        this.manageFree = manageFree;
    }
    public String getTaxFee() {
        return this.taxFee;
    }
    public void setTaxFee(String taxFee) {
        this.taxFee = taxFee;
    }
    public String getOtherFee() {
        return this.otherFee;
    }
    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }
    public String getCounterSharedLandArea() {
        return this.counterSharedLandArea;
    }
    public void setCounterSharedLandArea(String counterSharedLandArea) {
        this.counterSharedLandArea = counterSharedLandArea;
    }
    public String getCounterSharedLandFee() {
        return this.counterSharedLandFee;
    }
    public void setCounterSharedLandFee(String counterSharedLandFee) {
        this.counterSharedLandFee = counterSharedLandFee;
    }
    public String getCounterFeeOfYear() {
        return this.counterFeeOfYear;
    }
    public void setCounterFeeOfYear(String counterFeeOfYear) {
        this.counterFeeOfYear = counterFeeOfYear;
    }
    public String getBuildinglandPrice() {
        return this.buildinglandPrice;
    }
    public void setBuildinglandPrice(String buildinglandPrice) {
        this.buildinglandPrice = buildinglandPrice;
    }
    public String getPricePer() {
        return this.pricePer;
    }
    public void setPricePer(String pricePer) {
        this.pricePer = pricePer;
    }
    public Long getForeignKey() {
        return this.foreignKey;
    }
    public void setForeignKey(Long foreignKey) {
        this.foreignKey = foreignKey;
    }
    @Generated(hash = 1448176616)
    private transient Long commonAttributes__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1293942842)
    public CityCommonAttributes getCommonAttributes() {
        Long __key = this.foreignKey;
        if (commonAttributes__resolvedKey == null
                || !commonAttributes__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CityCommonAttributesDao targetDao = daoSession
                    .getCityCommonAttributesDao();
            CityCommonAttributes commonAttributesNew = targetDao.load(__key);
            synchronized (this) {
                commonAttributes = commonAttributesNew;
                commonAttributes__resolvedKey = __key;
            }
        }
        return commonAttributes;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1609423695)
    public void setCommonAttributes(CityCommonAttributes commonAttributes) {
        synchronized (this) {
            this.commonAttributes = commonAttributes;
            foreignKey = commonAttributes == null ? null : commonAttributes.getId();
            commonAttributes__resolvedKey = foreignKey;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 218529709)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCounterRentDao() : null;
    }
}