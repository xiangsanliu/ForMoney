package org.chengjian.java.feidian.collectdata.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class HouseRentModel{

    @Id
    Long id;

    private int nearByLandType;     //周围土地类型

    //房屋情况
    private int floorNum;               //楼层数
    private String rentLevel;          //买卖层次
    private int lightAirType;           //采光通风状况
    private float houseStandardPrice;    //房屋标准造价
    private float totalArea;            //总占地面积
    private float houseResetToalPrice;      //房屋重置总价
    private float houseResetPerPrice;      //房屋重置单价
    private float houseTodayValue;      //房屋现值
    private float subbuildingTodayValue;    //其它附属建筑物现值
    private int yearRobust;             //耐用年限
    private int yearUsed;               //已用年限

    //出租情况
    private String rentOut;         //出租人
    private String rentIn;          //承租人
    private String rentTime;        //出租时间
    private String rentMethod;      //出租方式
    private String houseNomalProfit;    //房屋正常收益
    private String houseNomalTotalFee;  //房屋正常总费用
    private float priceOfYear;      //其中年租金
    private float fixFee;       //其中维修费
    private float interestOfDeposit;        //押金利息
    private float oldFee;               //折旧费
    private float insuranceFee;         //保险费
    private float otherProfit;          //其它收益
    private float manageFree;           //管理费
    private float taxFee;               //税费
    private float housePureProfit;      //房地纯收益
    private float landNormalPrice;      //土地正常价格
    @Generated(hash = 1197298489)
    public HouseRentModel(Long id, int nearByLandType, int floorNum,
            String rentLevel, int lightAirType, float houseStandardPrice,
            float totalArea, float houseResetToalPrice, float houseResetPerPrice,
            float houseTodayValue, float subbuildingTodayValue, int yearRobust,
            int yearUsed, String rentOut, String rentIn, String rentTime,
            String rentMethod, String houseNomalProfit, String houseNomalTotalFee,
            float priceOfYear, float fixFee, float interestOfDeposit, float oldFee,
            float insuranceFee, float otherProfit, float manageFree, float taxFee,
            float housePureProfit, float landNormalPrice) {
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
        this.houseNomalProfit = houseNomalProfit;
        this.houseNomalTotalFee = houseNomalTotalFee;
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
    }
    @Generated(hash = 274366567)
    public HouseRentModel() {
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
    public int getFloorNum() {
        return this.floorNum;
    }
    public void setFloorNum(int floorNum) {
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
    public float getHouseResetToalPrice() {
        return this.houseResetToalPrice;
    }
    public void setHouseResetToalPrice(float houseResetToalPrice) {
        this.houseResetToalPrice = houseResetToalPrice;
    }
    public float getHouseResetPerPrice() {
        return this.houseResetPerPrice;
    }
    public void setHouseResetPerPrice(float houseResetPerPrice) {
        this.houseResetPerPrice = houseResetPerPrice;
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
    public String getHouseNomalProfit() {
        return this.houseNomalProfit;
    }
    public void setHouseNomalProfit(String houseNomalProfit) {
        this.houseNomalProfit = houseNomalProfit;
    }
    public String getHouseNomalTotalFee() {
        return this.houseNomalTotalFee;
    }
    public void setHouseNomalTotalFee(String houseNomalTotalFee) {
        this.houseNomalTotalFee = houseNomalTotalFee;
    }
    public float getPriceOfYear() {
        return this.priceOfYear;
    }
    public void setPriceOfYear(float priceOfYear) {
        this.priceOfYear = priceOfYear;
    }
    public float getFixFee() {
        return this.fixFee;
    }
    public void setFixFee(float fixFee) {
        this.fixFee = fixFee;
    }
    public float getInterestOfDeposit() {
        return this.interestOfDeposit;
    }
    public void setInterestOfDeposit(float interestOfDeposit) {
        this.interestOfDeposit = interestOfDeposit;
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
    public float getOtherProfit() {
        return this.otherProfit;
    }
    public void setOtherProfit(float otherProfit) {
        this.otherProfit = otherProfit;
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
    public float getHousePureProfit() {
        return this.housePureProfit;
    }
    public void setHousePureProfit(float housePureProfit) {
        this.housePureProfit = housePureProfit;
    }
    public float getLandNormalPrice() {
        return this.landNormalPrice;
    }
    public void setLandNormalPrice(float landNormalPrice) {
        this.landNormalPrice = landNormalPrice;
    }
}
