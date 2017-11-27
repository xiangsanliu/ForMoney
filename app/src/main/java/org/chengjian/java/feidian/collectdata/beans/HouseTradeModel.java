package org.chengjian.java.feidian.collectdata.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class HouseTradeModel{

    @Id
    Long id;

    //土地基本状况
    private int useageActual;   //实际用途
    private int useagePlande;   //规划用途
    private int nearByLandType;     //周围土地类型

    //房屋情况
    private int floorNum;               //楼层数
    private String tradeLevel;          //买卖层次
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

    //买卖情况
    private String tradeOut;            //转让人
    private String tradeIn;             //承让人
    private String tradeTime;           //买卖时间
    private String tradeMethod;         //买卖方式
    private String useageBeforeTrade;    //买卖前用途
    private String useageAfterTrade;    //买卖后用途
    private float tradeBuildingArea;    //出卖建筑面积
    private float buindingTradeSharedLandArea;  //出卖建筑分摊土地面积
    private float houseTradeTotalPrice;      //房屋交易总价
    private float houseTradeTax;             //房屋交易税费
    private float landTradeTotalPirce;         //土地交易总价
    private float landPricePerSquare;           //单位面积地价
    @Generated(hash = 1968205066)
    public HouseTradeModel(Long id, int useageActual, int useagePlande,
            int nearByLandType, int floorNum, String tradeLevel, int decorationType,
            int lightAirType, float houseStandardPrice, float totalArea,
            float houseResetTotalPrice, float subbuildingResetPrice,
            float houseTodayValue, float subbuildingTodayValue, int yearRobust,
            int yearUsed, String tradeOut, String tradeIn, String tradeTime,
            String tradeMethod, String useageBeforeTrade, String useageAfterTrade,
            float tradeBuildingArea, float buindingTradeSharedLandArea,
            float houseTradeTotalPrice, float houseTradeTax,
            float landTradeTotalPirce, float landPricePerSquare) {
        this.id = id;
        this.useageActual = useageActual;
        this.useagePlande = useagePlande;
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
        this.buindingTradeSharedLandArea = buindingTradeSharedLandArea;
        this.houseTradeTotalPrice = houseTradeTotalPrice;
        this.houseTradeTax = houseTradeTax;
        this.landTradeTotalPirce = landTradeTotalPirce;
        this.landPricePerSquare = landPricePerSquare;
    }
    @Generated(hash = 1818476635)
    public HouseTradeModel() {
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
    public int getFloorNum() {
        return this.floorNum;
    }
    public void setFloorNum(int floorNum) {
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
    public float getTradeBuildingArea() {
        return this.tradeBuildingArea;
    }
    public void setTradeBuildingArea(float tradeBuildingArea) {
        this.tradeBuildingArea = tradeBuildingArea;
    }
    public float getBuindingTradeSharedLandArea() {
        return this.buindingTradeSharedLandArea;
    }
    public void setBuindingTradeSharedLandArea(float buindingTradeSharedLandArea) {
        this.buindingTradeSharedLandArea = buindingTradeSharedLandArea;
    }
    public float getHouseTradeTotalPrice() {
        return this.houseTradeTotalPrice;
    }
    public void setHouseTradeTotalPrice(float houseTradeTotalPrice) {
        this.houseTradeTotalPrice = houseTradeTotalPrice;
    }
    public float getHouseTradeTax() {
        return this.houseTradeTax;
    }
    public void setHouseTradeTax(float houseTradeTax) {
        this.houseTradeTax = houseTradeTax;
    }
    public float getLandTradeTotalPirce() {
        return this.landTradeTotalPirce;
    }
    public void setLandTradeTotalPirce(float landTradeTotalPirce) {
        this.landTradeTotalPirce = landTradeTotalPirce;
    }
    public float getLandPricePerSquare() {
        return this.landPricePerSquare;
    }
    public void setLandPricePerSquare(float landPricePerSquare) {
        this.landPricePerSquare = landPricePerSquare;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
