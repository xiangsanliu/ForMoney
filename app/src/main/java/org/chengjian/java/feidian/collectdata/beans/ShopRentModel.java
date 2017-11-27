package org.chengjian.java.feidian.collectdata.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class ShopRentModel{

    @Id
    Long id;

    private int useageActual;   //实际用途
    private int useagePlande;   //规划用途

    private int nearByLandType;     //周围土地类型

    //房屋情况
    private int decorationType;         //装修标准
    private int lightAirType;           //采光通风状况
    private float houseStandardPrice;    //房屋标准造价
    private float totalArea;            //总占地面积
    private float houseResetTotalPrice;      //房屋重置总价
    private float subbuildingResetPrice;    //其它附属建筑物重置总价
    private float houseTodayValue;      //房屋现值
    private float subbuildingTodayValue;    //其它附属建筑物现值
    private int yearRobust;             //耐用年限
    private int yearUsed;               //已用年限

    //出租情况
    private String rentOut;         //出租人
    private String rentIn;          //承租人
    private String rentTime;        //出租时间
    private String rentMethod;      //出租方式
    private String useage;          //出租用途
    private String rentDeadline;    //出租期限
    private float totalTrdeArea;    //总营业面积
    private float counterTradeArea; //出租柜台营业面积
    private float totalRentPrice;      //出租房地产总费用
    private float fixFee;           //其中维修费
    private float oldFee;               //折旧费
    private float insuranceFee;         //保险费
    private float manageFree;           //管理费
    private float taxFee;               //税费
    private float otherFee;             //其它费用
    private float counterSharedLandArea;    //出租柜台分摊土地面积
    private float counterSharedLandFee;    //出租柜台分摊总费
    private float counterFeeOfYear;         //出租柜台年租金
    private float buildinglandPrice;        //楼面地价
    private float pricePer;                 //单位地价
    @Generated(hash = 1425365101)
    public ShopRentModel(Long id, int useageActual, int useagePlande,
            int nearByLandType, int decorationType, int lightAirType,
            float houseStandardPrice, float totalArea, float houseResetTotalPrice,
            float subbuildingResetPrice, float houseTodayValue,
            float subbuildingTodayValue, int yearRobust, int yearUsed,
            String rentOut, String rentIn, String rentTime, String rentMethod,
            String useage, String rentDeadline, float totalTrdeArea,
            float counterTradeArea, float totalRentPrice, float fixFee,
            float oldFee, float insuranceFee, float manageFree, float taxFee,
            float otherFee, float counterSharedLandArea, float counterSharedLandFee,
            float counterFeeOfYear, float buildinglandPrice, float pricePer) {
        this.id = id;
        this.useageActual = useageActual;
        this.useagePlande = useagePlande;
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
    }
    @Generated(hash = 1545728387)
    public ShopRentModel() {
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
    public float getHouseStandardPrice() {
        return this.houseStandardPrice;
    }
    public void setHouseStandardPrice(float houseStandardPrice) {
        this.houseStandardPrice = houseStandardPrice;
    }
    public float getTotalArea() {
        return this.totalArea;
    }
    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }
    public float getHouseResetTotalPrice() {
        return this.houseResetTotalPrice;
    }
    public void setHouseResetTotalPrice(float houseResetTotalPrice) {
        this.houseResetTotalPrice = houseResetTotalPrice;
    }
    public float getSubbuildingResetPrice() {
        return this.subbuildingResetPrice;
    }
    public void setSubbuildingResetPrice(float subbuildingResetPrice) {
        this.subbuildingResetPrice = subbuildingResetPrice;
    }
    public float getHouseTodayValue() {
        return this.houseTodayValue;
    }
    public void setHouseTodayValue(float houseTodayValue) {
        this.houseTodayValue = houseTodayValue;
    }
    public float getSubbuildingTodayValue() {
        return this.subbuildingTodayValue;
    }
    public void setSubbuildingTodayValue(float subbuildingTodayValue) {
        this.subbuildingTodayValue = subbuildingTodayValue;
    }
    public int getYearRobust() {
        return this.yearRobust;
    }
    public void setYearRobust(int yearRobust) {
        this.yearRobust = yearRobust;
    }
    public int getYearUsed() {
        return this.yearUsed;
    }
    public void setYearUsed(int yearUsed) {
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
    public float getTotalTrdeArea() {
        return this.totalTrdeArea;
    }
    public void setTotalTrdeArea(float totalTrdeArea) {
        this.totalTrdeArea = totalTrdeArea;
    }
    public float getCounterTradeArea() {
        return this.counterTradeArea;
    }
    public void setCounterTradeArea(float counterTradeArea) {
        this.counterTradeArea = counterTradeArea;
    }
    public float getTotalRentPrice() {
        return this.totalRentPrice;
    }
    public void setTotalRentPrice(float totalRentPrice) {
        this.totalRentPrice = totalRentPrice;
    }
    public float getFixFee() {
        return this.fixFee;
    }
    public void setFixFee(float fixFee) {
        this.fixFee = fixFee;
    }
    public float getOldFee() {
        return this.oldFee;
    }
    public void setOldFee(float oldFee) {
        this.oldFee = oldFee;
    }
    public float getInsuranceFee() {
        return this.insuranceFee;
    }
    public void setInsuranceFee(float insuranceFee) {
        this.insuranceFee = insuranceFee;
    }
    public float getManageFree() {
        return this.manageFree;
    }
    public void setManageFree(float manageFree) {
        this.manageFree = manageFree;
    }
    public float getTaxFee() {
        return this.taxFee;
    }
    public void setTaxFee(float taxFee) {
        this.taxFee = taxFee;
    }
    public float getOtherFee() {
        return this.otherFee;
    }
    public void setOtherFee(float otherFee) {
        this.otherFee = otherFee;
    }
    public float getCounterSharedLandArea() {
        return this.counterSharedLandArea;
    }
    public void setCounterSharedLandArea(float counterSharedLandArea) {
        this.counterSharedLandArea = counterSharedLandArea;
    }
    public float getCounterSharedLandFee() {
        return this.counterSharedLandFee;
    }
    public void setCounterSharedLandFee(float counterSharedLandFee) {
        this.counterSharedLandFee = counterSharedLandFee;
    }
    public float getCounterFeeOfYear() {
        return this.counterFeeOfYear;
    }
    public void setCounterFeeOfYear(float counterFeeOfYear) {
        this.counterFeeOfYear = counterFeeOfYear;
    }
    public float getBuildinglandPrice() {
        return this.buildinglandPrice;
    }
    public void setBuildinglandPrice(float buildinglandPrice) {
        this.buildinglandPrice = buildinglandPrice;
    }
    public float getPricePer() {
        return this.pricePer;
    }
    public void setPricePer(float pricePer) {
        this.pricePer = pricePer;
    }

}
