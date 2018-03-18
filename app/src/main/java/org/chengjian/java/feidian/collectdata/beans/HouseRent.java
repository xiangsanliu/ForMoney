package org.chengjian.java.feidian.collectdata.beans;


import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

import lombok.Getter;
import lombok.Setter;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * 房屋出售租金调查表
 */
@Entity
public class HouseRent {
    @Id
    private Long id;
    @Nullable
    @Expose
    private int nearByLandType;     //周围土地类型
    //房屋情况
    @Nullable
    @Expose
    private String floorNum;               //楼层数
    @Nullable
    @Expose
    private String rentLevel;          //买卖层次
    @Nullable
    @Expose
    private int lightAirType;           //采光通风状况
    @Nullable
    @Expose
    private String houseStandardPrice;    //房屋标准造价
    @Nullable
    @Expose
    private String totalArea;            //总占地面积
    @Nullable
    @Expose
    private String houseResetToalPrice;      //房屋重置总价
    @Nullable
    @Expose
    private String houseResetPerPrice;      //房屋重置单价
    @Nullable
    @Expose
    private String houseTodayValue;      //房屋现值
    @Nullable
    @Expose
    private String subbuildingTodayValue;    //其它附属建筑物现值
    @Nullable
    @Expose
    private String yearRobust;             //耐用年限
    @Nullable
    @Expose
    private String yearUsed;               //已用年限
    //出租情况
    @Nullable
    @Expose
    private String rentOut;         //出租人
    @Nullable
    @Expose
    private String rentIn;          //承租人
    @Nullable
    @Expose
    private String rentTime;        //出租时间
    @Nullable
    @Expose
    private String rentMethod;      //出租方式
    @Nullable
    @Expose
    private String houseNormalProfit;    //房屋正常收益
    @Nullable
    @Expose
    private String houseNormalTotalFee;  //房屋正常总费用
    @Nullable
    @Expose
    private String priceOfYear;      //其中年租金
    @Nullable
    @Expose
    private String fixFee;       //其中维修费
    @Nullable
    @Expose
    private String interestOfDeposit;        //押金利息
    @Nullable
    @Expose
    private String oldFee;               //折旧费
    @Nullable
    @Expose
    private String insuranceFee;         //保险费
    @Nullable
    @Expose
    private String otherProfit;          //其它收益
    @Nullable
    @Expose
    private String manageFree;           //管理费
    @Nullable
    @Expose
    private String taxFee;               //税费
    @Nullable
    @Expose
    private String housePureProfit;      //房地纯收益
    @Nullable
    @Expose
    private String landNormalPrice;      //土地正常价格
    @ToOne(joinProperty = "foreignKey")
    private CityCommonAttributes commonAttributes;
    private Long foreignKey;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1183156848)
    private transient HouseRentDao myDao;
    @Generated(hash = 381906243)
    public HouseRent(Long id, int nearByLandType, String floorNum, String rentLevel,
            int lightAirType, String houseStandardPrice, String totalArea,
            String houseResetToalPrice, String houseResetPerPrice,
            String houseTodayValue, String subbuildingTodayValue, String yearRobust,
            String yearUsed, String rentOut, String rentIn, String rentTime,
            String rentMethod, String houseNormalProfit, String houseNormalTotalFee,
            String priceOfYear, String fixFee, String interestOfDeposit,
            String oldFee, String insuranceFee, String otherProfit,
            String manageFree, String taxFee, String housePureProfit,
            String landNormalPrice, Long foreignKey) {
        this.id = id;
        this.nearByLandType = nearByLandType;
        this.floorNum = floorNum;
        this.rentLevel = rentLevel;
        this.lightAirType = lightAirType;
        this.houseStandardPrice = houseStandardPrice;
        this.totalArea = totalArea;
        this.houseResetToalPrice = houseResetToalPrice;
        this.houseResetPerPrice = houseResetPerPrice;
        this.houseTodayValue = houseTodayValue;
        this.subbuildingTodayValue = subbuildingTodayValue;
        this.yearRobust = yearRobust;
        this.yearUsed = yearUsed;
        this.rentOut = rentOut;
        this.rentIn = rentIn;
        this.rentTime = rentTime;
        this.rentMethod = rentMethod;
        this.houseNormalProfit = houseNormalProfit;
        this.houseNormalTotalFee = houseNormalTotalFee;
        this.priceOfYear = priceOfYear;
        this.fixFee = fixFee;
        this.interestOfDeposit = interestOfDeposit;
        this.oldFee = oldFee;
        this.insuranceFee = insuranceFee;
        this.otherProfit = otherProfit;
        this.manageFree = manageFree;
        this.taxFee = taxFee;
        this.housePureProfit = housePureProfit;
        this.landNormalPrice = landNormalPrice;
        this.foreignKey = foreignKey;
    }
    @Generated(hash = 1074676215)
    public HouseRent() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getNearByLandType() {
        return this.nearByLandType;
    }
    public void setNearByLandType(int nearByLandType) {
        this.nearByLandType = nearByLandType;
    }
    public String getFloorNum() {
        return this.floorNum;
    }
    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum;
    }
    public String getRentLevel() {
        return this.rentLevel;
    }
    public void setRentLevel(String rentLevel) {
        this.rentLevel = rentLevel;
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
    public String getHouseResetToalPrice() {
        return this.houseResetToalPrice;
    }
    public void setHouseResetToalPrice(String houseResetToalPrice) {
        this.houseResetToalPrice = houseResetToalPrice;
    }
    public String getHouseResetPerPrice() {
        return this.houseResetPerPrice;
    }
    public void setHouseResetPerPrice(String houseResetPerPrice) {
        this.houseResetPerPrice = houseResetPerPrice;
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
    public String getHouseNormalProfit() {
        return this.houseNormalProfit;
    }
    public void setHouseNormalProfit(String houseNormalProfit) {
        this.houseNormalProfit = houseNormalProfit;
    }
    public String getHouseNormalTotalFee() {
        return this.houseNormalTotalFee;
    }
    public void setHouseNormalTotalFee(String houseNormalTotalFee) {
        this.houseNormalTotalFee = houseNormalTotalFee;
    }
    public String getPriceOfYear() {
        return this.priceOfYear;
    }
    public void setPriceOfYear(String priceOfYear) {
        this.priceOfYear = priceOfYear;
    }
    public String getFixFee() {
        return this.fixFee;
    }
    public void setFixFee(String fixFee) {
        this.fixFee = fixFee;
    }
    public String getInterestOfDeposit() {
        return this.interestOfDeposit;
    }
    public void setInterestOfDeposit(String interestOfDeposit) {
        this.interestOfDeposit = interestOfDeposit;
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
    public String getOtherProfit() {
        return this.otherProfit;
    }
    public void setOtherProfit(String otherProfit) {
        this.otherProfit = otherProfit;
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
    public String getHousePureProfit() {
        return this.housePureProfit;
    }
    public void setHousePureProfit(String housePureProfit) {
        this.housePureProfit = housePureProfit;
    }
    public String getLandNormalPrice() {
        return this.landNormalPrice;
    }
    public void setLandNormalPrice(String landNormalPrice) {
        this.landNormalPrice = landNormalPrice;
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
    @Generated(hash = 83229032)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getHouseRentDao() : null;
    }
}