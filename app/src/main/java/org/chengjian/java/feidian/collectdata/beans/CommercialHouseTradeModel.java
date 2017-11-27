package org.chengjian.java.feidian.collectdata.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class CommercialHouseTradeModel{

    @Id
    Long id;

    private int useageActual;   //实际用途
    private int useagePlande;   //规划用途

    //房屋情况
    private int floorNum;               //楼层数
//    private String tradeLevel;          //买卖层次
    private float houseStandardPrice;    //房屋标准造价
    private float buildingProjectPrice;     //建筑工程造价
    private float serviceFee;               //小区公共设施配套费
    private float otherDirectFee;           //其他建房直接费用
    private float manageFeeAndProfit;       //管理费和利润
    private float unPredictedFee;           //不可预见费
    private float landCompensateFee;        //土地征收补偿费
    private float agentFee;                 //代收费用
    private float cityBigSuiteFee;          //城市大配套费用
    private float otherFee;                     //其他费用

    //买卖情况
    private String developer;           //商品房开发单位
    private String tradeIn;             //买方
    private int tradeType;              //买卖方式
    private int loanYear;       //按揭年限
    private String tradeLevel;      //买卖层次
    private String tradeTime;       //商品房出售时间
    private String useage;           //房屋用途
    private float plotRatePlaned;  //规划容积率
    private float buildingDensity;  //建筑面积
    private float wholeBuildingPrice;   //整栋商品楼总售价
    private float wholeBuildingFee;     //整栋商品楼总造价
    private float interest;             //占用资金应付利息
    private float profitOfDeveloper;    //开发公司利润
    private float price;        //房屋交易总价格
    private float tax;          //房屋交易税费
    private float landPricePerSquare;   //单位面积地价
    private float shareLandArea;//分摊土地面积
    @Generated(hash = 58942830)
    public CommercialHouseTradeModel(Long id, int useageActual, int useagePlande,
            int floorNum, float houseStandardPrice, float buildingProjectPrice,
            float serviceFee, float otherDirectFee, float manageFeeAndProfit,
            float unPredictedFee, float landCompensateFee, float agentFee,
            float cityBigSuiteFee, float otherFee, String developer, String tradeIn,
            int tradeType, int loanYear, String tradeLevel, String tradeTime,
            String useage, float plotRatePlaned, float buildingDensity,
            float wholeBuildingPrice, float wholeBuildingFee, float interest,
            float profitOfDeveloper, float price, float tax,
            float landPricePerSquare, float shareLandArea) {
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
    }
    @Generated(hash = 1941502849)
    public CommercialHouseTradeModel() {
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
    public int getFloorNum() {
        return this.floorNum;
    }
    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }
    public float getHouseStandardPrice() {
        return this.houseStandardPrice;
    }
    public void setHouseStandardPrice(float houseStandardPrice) {
        this.houseStandardPrice = houseStandardPrice;
    }
    public float getBuildingProjectPrice() {
        return this.buildingProjectPrice;
    }
    public void setBuildingProjectPrice(float buildingProjectPrice) {
        this.buildingProjectPrice = buildingProjectPrice;
    }
    public float getServiceFee() {
        return this.serviceFee;
    }
    public void setServiceFee(float serviceFee) {
        this.serviceFee = serviceFee;
    }
    public float getOtherDirectFee() {
        return this.otherDirectFee;
    }
    public void setOtherDirectFee(float otherDirectFee) {
        this.otherDirectFee = otherDirectFee;
    }
    public float getManageFeeAndProfit() {
        return this.manageFeeAndProfit;
    }
    public void setManageFeeAndProfit(float manageFeeAndProfit) {
        this.manageFeeAndProfit = manageFeeAndProfit;
    }
    public float getUnPredictedFee() {
        return this.unPredictedFee;
    }
    public void setUnPredictedFee(float unPredictedFee) {
        this.unPredictedFee = unPredictedFee;
    }
    public float getLandCompensateFee() {
        return this.landCompensateFee;
    }
    public void setLandCompensateFee(float landCompensateFee) {
        this.landCompensateFee = landCompensateFee;
    }
    public float getAgentFee() {
        return this.agentFee;
    }
    public void setAgentFee(float agentFee) {
        this.agentFee = agentFee;
    }
    public float getCityBigSuiteFee() {
        return this.cityBigSuiteFee;
    }
    public void setCityBigSuiteFee(float cityBigSuiteFee) {
        this.cityBigSuiteFee = cityBigSuiteFee;
    }
    public float getOtherFee() {
        return this.otherFee;
    }
    public void setOtherFee(float otherFee) {
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
    public int getLoanYear() {
        return this.loanYear;
    }
    public void setLoanYear(int loanYear) {
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
    public float getPlotRatePlaned() {
        return this.plotRatePlaned;
    }
    public void setPlotRatePlaned(float plotRatePlaned) {
        this.plotRatePlaned = plotRatePlaned;
    }
    public float getBuildingDensity() {
        return this.buildingDensity;
    }
    public void setBuildingDensity(float buildingDensity) {
        this.buildingDensity = buildingDensity;
    }
    public float getWholeBuildingPrice() {
        return this.wholeBuildingPrice;
    }
    public void setWholeBuildingPrice(float wholeBuildingPrice) {
        this.wholeBuildingPrice = wholeBuildingPrice;
    }
    public float getWholeBuildingFee() {
        return this.wholeBuildingFee;
    }
    public void setWholeBuildingFee(float wholeBuildingFee) {
        this.wholeBuildingFee = wholeBuildingFee;
    }
    public float getInterest() {
        return this.interest;
    }
    public void setInterest(float interest) {
        this.interest = interest;
    }
    public float getProfitOfDeveloper() {
        return this.profitOfDeveloper;
    }
    public void setProfitOfDeveloper(float profitOfDeveloper) {
        this.profitOfDeveloper = profitOfDeveloper;
    }
    public float getPrice() {
        return this.price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public float getTax() {
        return this.tax;
    }
    public void setTax(float tax) {
        this.tax = tax;
    }
    public float getLandPricePerSquare() {
        return this.landPricePerSquare;
    }
    public void setLandPricePerSquare(float landPricePerSquare) {
        this.landPricePerSquare = landPricePerSquare;
    }
    public float getShareLandArea() {
        return this.shareLandArea;
    }
    public void setShareLandArea(float shareLandArea) {
        this.shareLandArea = shareLandArea;
    }

}
