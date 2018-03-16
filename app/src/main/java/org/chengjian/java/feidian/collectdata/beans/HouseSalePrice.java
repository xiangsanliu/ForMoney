package org.chengjian.java.feidian.collectdata.beans;

import android.support.annotation.Nullable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * 房屋买卖价格调查表
 */
@Entity
public class HouseSalePrice {
    @Id
    Long id;
    //土地基本状况
    @Nullable
    private int useageActual;   //实际用途
    @Nullable
    private int useagePlaned;   //规划用途
    @Nullable
    private int nearByLandType;     //周围土地类型
    //房屋情况
    @Nullable
    private String floorNum;               //楼层数
    @Nullable
    private String tradeLevel;          //买卖层次
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
    //买卖情况
    @Nullable
    private String tradeOut;            //转让人
    @Nullable
    private String tradeIn;             //承让人
    @Nullable
    private String tradeTime;           //买卖时间
    @Nullable
    private String tradeMethod;         //买卖方式
    @Nullable
    private String useageBeforeTrade;    //买卖前用途
    @Nullable
    private String useageAfterTrade;    //买卖后用途
    @Nullable
    private String tradeBuildingArea;    //出卖建筑面积
    @Nullable
    private String buildingTradeSharedLandArea;  //出卖建筑分摊土地面积
    @Nullable
    private String houseTradeTotalPrice;      //房屋交易总价
    @Nullable
    private String houseTradeTax;             //房屋交易税费
    @Nullable
    private String landTradeTotalPirce;         //土地交易总价
    @Nullable
    private String landPricePerSquare;           //单位面积地价
    @ToOne(joinProperty = "foreignKey")
    private CityCommonAttributes commonAttributes;
    private Long foreignKey;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1024547272)
    private transient HouseSalePriceDao myDao;
    @Generated(hash = 445871529)
    public HouseSalePrice(Long id, int useageActual, int useagePlaned,
            int nearByLandType, String floorNum, String tradeLevel,
            int decorationType, int lightAirType, String houseStandardPrice,
            String totalArea, String houseResetTotalPrice,
            String subbuildingResetPrice, String houseTodayValue,
            String subbuildingTodayValue, String yearRobust, String yearUsed,
            String tradeOut, String tradeIn, String tradeTime, String tradeMethod,
            String useageBeforeTrade, String useageAfterTrade,
            String tradeBuildingArea, String buildingTradeSharedLandArea,
            String houseTradeTotalPrice, String houseTradeTax,
            String landTradeTotalPirce, String landPricePerSquare,
            Long foreignKey) {
        this.id = id;
        this.useageActual = useageActual;
        this.useagePlaned = useagePlaned;
        this.nearByLandType = nearByLandType;
        this.floorNum = floorNum;
        this.tradeLevel = tradeLevel;
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
        this.tradeOut = tradeOut;
        this.tradeIn = tradeIn;
        this.tradeTime = tradeTime;
        this.tradeMethod = tradeMethod;
        this.useageBeforeTrade = useageBeforeTrade;
        this.useageAfterTrade = useageAfterTrade;
        this.tradeBuildingArea = tradeBuildingArea;
        this.buildingTradeSharedLandArea = buildingTradeSharedLandArea;
        this.houseTradeTotalPrice = houseTradeTotalPrice;
        this.houseTradeTax = houseTradeTax;
        this.landTradeTotalPirce = landTradeTotalPirce;
        this.landPricePerSquare = landPricePerSquare;
        this.foreignKey = foreignKey;
    }
    @Generated(hash = 1213023660)
    public HouseSalePrice() {
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
    public String getFloorNum() {
        return this.floorNum;
    }
    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum;
    }
    public String getTradeLevel() {
        return this.tradeLevel;
    }
    public void setTradeLevel(String tradeLevel) {
        this.tradeLevel = tradeLevel;
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
    public String getTradeOut() {
        return this.tradeOut;
    }
    public void setTradeOut(String tradeOut) {
        this.tradeOut = tradeOut;
    }
    public String getTradeIn() {
        return this.tradeIn;
    }
    public void setTradeIn(String tradeIn) {
        this.tradeIn = tradeIn;
    }
    public String getTradeTime() {
        return this.tradeTime;
    }
    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }
    public String getTradeMethod() {
        return this.tradeMethod;
    }
    public void setTradeMethod(String tradeMethod) {
        this.tradeMethod = tradeMethod;
    }
    public String getUseageBeforeTrade() {
        return this.useageBeforeTrade;
    }
    public void setUseageBeforeTrade(String useageBeforeTrade) {
        this.useageBeforeTrade = useageBeforeTrade;
    }
    public String getUseageAfterTrade() {
        return this.useageAfterTrade;
    }
    public void setUseageAfterTrade(String useageAfterTrade) {
        this.useageAfterTrade = useageAfterTrade;
    }
    public String getTradeBuildingArea() {
        return this.tradeBuildingArea;
    }
    public void setTradeBuildingArea(String tradeBuildingArea) {
        this.tradeBuildingArea = tradeBuildingArea;
    }
    public String getBuildingTradeSharedLandArea() {
        return this.buildingTradeSharedLandArea;
    }
    public void setBuildingTradeSharedLandArea(String buildingTradeSharedLandArea) {
        this.buildingTradeSharedLandArea = buildingTradeSharedLandArea;
    }
    public String getHouseTradeTotalPrice() {
        return this.houseTradeTotalPrice;
    }
    public void setHouseTradeTotalPrice(String houseTradeTotalPrice) {
        this.houseTradeTotalPrice = houseTradeTotalPrice;
    }
    public String getHouseTradeTax() {
        return this.houseTradeTax;
    }
    public void setHouseTradeTax(String houseTradeTax) {
        this.houseTradeTax = houseTradeTax;
    }
    public String getLandTradeTotalPirce() {
        return this.landTradeTotalPirce;
    }
    public void setLandTradeTotalPirce(String landTradeTotalPirce) {
        this.landTradeTotalPirce = landTradeTotalPirce;
    }
    public String getLandPricePerSquare() {
        return this.landPricePerSquare;
    }
    public void setLandPricePerSquare(String landPricePerSquare) {
        this.landPricePerSquare = landPricePerSquare;
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
    @Generated(hash = 1947087624)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getHouseSalePriceDao() : null;
    }
}