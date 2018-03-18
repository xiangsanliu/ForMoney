package org.chengjian.java.feidian.collectdata.beans;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * 商品房出售调查表
 */
@Entity
public class CommercialHousingForSale {
    @Id
    private Long id;
    @Nullable
    @Expose
    private int useageActual;   //实际用途
    @Nullable
    @Expose
    private int useagePlande;   //规划用途
    //房屋情况
    @Nullable
    @Expose
    private String floorNum;               //楼层数
    //    private String tradeLevel;          //买卖层次
    @Nullable
    @Expose
    private String houseStandardPrice;    //房屋标准造价
    @Nullable
    @Expose
    private String buildingProjectPrice;     //建筑工程造价
    @Nullable
    @Expose
    private String serviceFee;               //小区公共设施配套费
    @Nullable
    @Expose
    private String otherDirectFee;           //其他建房直接费用
    @Nullable
    @Expose
    private String manageFeeAndProfit;       //管理费和利润
    @Nullable
    @Expose
    private String unPredictedFee;           //不可预见费
    @Nullable
    @Expose
    private String landCompensateFee;        //土地征收补偿费
    @Nullable
    @Expose
    private String agentFee;                 //代收费用
    @Nullable
    @Expose
    private String cityBigSuiteFee;          //城市大配套费用
    @Nullable
    @Expose
    private String otherFee;                     //其他费用
    //买卖情况
    @Nullable
    @Expose
    private String developer;           //商品房开发单位
    @Nullable
    @Expose
    private String tradeIn;             //买方
    @Nullable
    @Expose
    private int tradeType;              //买卖方式
    @Nullable
    @Expose
    private String loanYear;       //按揭年限
    @Nullable
    @Expose
    private String tradeLevel;      //买卖层次
    @Nullable
    @Expose
    private String tradeTime;       //商品房出售时间
    @Nullable
    @Expose
    private String useage;           //房屋用途
    @Nullable
    @Expose
    private String plotRatePlaned;  //规划容积率
    @Nullable
    @Expose
    private String buildingDensity;  //建筑面积
    @Nullable
    @Expose
    private String wholeBuildingPrice;   //整栋商品楼总售价
    @Nullable
    @Expose
    private String wholeBuildingFee;     //整栋商品楼总造价
    @Nullable
    @Expose
    private String interest;             //占用资金应付利息
    @Nullable
    @Expose
    private String profitOfDeveloper;    //开发公司利润
    @Nullable
    @Expose
    private String price;       //房屋交易总价格
    @Nullable
    @Expose
    private String tax;     //房屋交易税费
    @Nullable
    @Expose
    private String landPricePerSquare;  //单位面积地价
    @Nullable
    @Expose
    private String shareLandArea;   //分摊土地面积
    @ToOne(joinProperty = "foreignKey")
    private CityCommonAttributes commonAttributes;
    private Long foreignKey;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 905283407)
    private transient CommercialHousingForSaleDao myDao;
    @Generated(hash = 1624931708)
    public CommercialHousingForSale(Long id, int useageActual, int useagePlande,
            String floorNum, String houseStandardPrice, String buildingProjectPrice,
            String serviceFee, String otherDirectFee, String manageFeeAndProfit,
            String unPredictedFee, String landCompensateFee, String agentFee,
            String cityBigSuiteFee, String otherFee, String developer,
            String tradeIn, int tradeType, String loanYear, String tradeLevel,
            String tradeTime, String useage, String plotRatePlaned,
            String buildingDensity, String wholeBuildingPrice,
            String wholeBuildingFee, String interest, String profitOfDeveloper,
            String price, String tax, String landPricePerSquare,
            String shareLandArea, Long foreignKey) {
        this.id = id;
        this.useageActual = useageActual;
        this.useagePlande = useagePlande;
        this.floorNum = floorNum;
        this.houseStandardPrice = houseStandardPrice;
        this.buildingProjectPrice = buildingProjectPrice;
        this.serviceFee = serviceFee;
        this.otherDirectFee = otherDirectFee;
        this.manageFeeAndProfit = manageFeeAndProfit;
        this.unPredictedFee = unPredictedFee;
        this.landCompensateFee = landCompensateFee;
        this.agentFee = agentFee;
        this.cityBigSuiteFee = cityBigSuiteFee;
        this.otherFee = otherFee;
        this.developer = developer;
        this.tradeIn = tradeIn;
        this.tradeType = tradeType;
        this.loanYear = loanYear;
        this.tradeLevel = tradeLevel;
        this.tradeTime = tradeTime;
        this.useage = useage;
        this.plotRatePlaned = plotRatePlaned;
        this.buildingDensity = buildingDensity;
        this.wholeBuildingPrice = wholeBuildingPrice;
        this.wholeBuildingFee = wholeBuildingFee;
        this.interest = interest;
        this.profitOfDeveloper = profitOfDeveloper;
        this.price = price;
        this.tax = tax;
        this.landPricePerSquare = landPricePerSquare;
        this.shareLandArea = shareLandArea;
        this.foreignKey = foreignKey;
    }
    @Generated(hash = 1956073595)
    public CommercialHousingForSale() {
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
    public int getUseagePlande() {
        return this.useagePlande;
    }
    public void setUseagePlande(int useagePlande) {
        this.useagePlande = useagePlande;
    }
    public String getFloorNum() {
        return this.floorNum;
    }
    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum;
    }
    public String getHouseStandardPrice() {
        return this.houseStandardPrice;
    }
    public void setHouseStandardPrice(String houseStandardPrice) {
        this.houseStandardPrice = houseStandardPrice;
    }
    public String getBuildingProjectPrice() {
        return this.buildingProjectPrice;
    }
    public void setBuildingProjectPrice(String buildingProjectPrice) {
        this.buildingProjectPrice = buildingProjectPrice;
    }
    public String getServiceFee() {
        return this.serviceFee;
    }
    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }
    public String getOtherDirectFee() {
        return this.otherDirectFee;
    }
    public void setOtherDirectFee(String otherDirectFee) {
        this.otherDirectFee = otherDirectFee;
    }
    public String getManageFeeAndProfit() {
        return this.manageFeeAndProfit;
    }
    public void setManageFeeAndProfit(String manageFeeAndProfit) {
        this.manageFeeAndProfit = manageFeeAndProfit;
    }
    public String getUnPredictedFee() {
        return this.unPredictedFee;
    }
    public void setUnPredictedFee(String unPredictedFee) {
        this.unPredictedFee = unPredictedFee;
    }
    public String getLandCompensateFee() {
        return this.landCompensateFee;
    }
    public void setLandCompensateFee(String landCompensateFee) {
        this.landCompensateFee = landCompensateFee;
    }
    public String getAgentFee() {
        return this.agentFee;
    }
    public void setAgentFee(String agentFee) {
        this.agentFee = agentFee;
    }
    public String getCityBigSuiteFee() {
        return this.cityBigSuiteFee;
    }
    public void setCityBigSuiteFee(String cityBigSuiteFee) {
        this.cityBigSuiteFee = cityBigSuiteFee;
    }
    public String getOtherFee() {
        return this.otherFee;
    }
    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }
    public String getDeveloper() {
        return this.developer;
    }
    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    public String getTradeIn() {
        return this.tradeIn;
    }
    public void setTradeIn(String tradeIn) {
        this.tradeIn = tradeIn;
    }
    public int getTradeType() {
        return this.tradeType;
    }
    public void setTradeType(int tradeType) {
        this.tradeType = tradeType;
    }
    public String getLoanYear() {
        return this.loanYear;
    }
    public void setLoanYear(String loanYear) {
        this.loanYear = loanYear;
    }
    public String getTradeLevel() {
        return this.tradeLevel;
    }
    public void setTradeLevel(String tradeLevel) {
        this.tradeLevel = tradeLevel;
    }
    public String getTradeTime() {
        return this.tradeTime;
    }
    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }
    public String getUseage() {
        return this.useage;
    }
    public void setUseage(String useage) {
        this.useage = useage;
    }
    public String getPlotRatePlaned() {
        return this.plotRatePlaned;
    }
    public void setPlotRatePlaned(String plotRatePlaned) {
        this.plotRatePlaned = plotRatePlaned;
    }
    public String getBuildingDensity() {
        return this.buildingDensity;
    }
    public void setBuildingDensity(String buildingDensity) {
        this.buildingDensity = buildingDensity;
    }
    public String getWholeBuildingPrice() {
        return this.wholeBuildingPrice;
    }
    public void setWholeBuildingPrice(String wholeBuildingPrice) {
        this.wholeBuildingPrice = wholeBuildingPrice;
    }
    public String getWholeBuildingFee() {
        return this.wholeBuildingFee;
    }
    public void setWholeBuildingFee(String wholeBuildingFee) {
        this.wholeBuildingFee = wholeBuildingFee;
    }
    public String getInterest() {
        return this.interest;
    }
    public void setInterest(String interest) {
        this.interest = interest;
    }
    public String getProfitOfDeveloper() {
        return this.profitOfDeveloper;
    }
    public void setProfitOfDeveloper(String profitOfDeveloper) {
        this.profitOfDeveloper = profitOfDeveloper;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getTax() {
        return this.tax;
    }
    public void setTax(String tax) {
        this.tax = tax;
    }
    public String getLandPricePerSquare() {
        return this.landPricePerSquare;
    }
    public void setLandPricePerSquare(String landPricePerSquare) {
        this.landPricePerSquare = landPricePerSquare;
    }
    public String getShareLandArea() {
        return this.shareLandArea;
    }
    public void setShareLandArea(String shareLandArea) {
        this.shareLandArea = shareLandArea;
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
    @Generated(hash = 410176059)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCommercialHousingForSaleDao() : null;
    }
}