package org.chengjian.java.feidian.collectdata.beans;

import android.support.annotation.Nullable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by xiang on 17-9-8.
 * 房屋出租租金调查表中的出租情况
 */
@Entity
public class RentInfo4Model {

    @Id
    Long id;
    @Nullable
    String rentOut;     //出租人
    @Nullable
    String rentIn;      //承租人
    @Nullable
    String rentType;    //出租方式
    @Nullable
    String appointTime; //定约时间
    @Nullable
    String rentDeadline;//出租期限
    @Nullable
    String useage;         //出租用途
    @Nullable
    String rentLayer;   //出租层次
    float buildingArea; //出租用途
    float tradeArea;    //营业面积
    float shareLandArea;//分摊土地面积
    float feeOfMoney;   //月租金
    @Generated(hash = 20337506)
    public RentInfo4Model(Long id, String rentOut, String rentIn, String rentType,
            String appointTime, String rentDeadline, String useage,
            String rentLayer, float buildingArea, float tradeArea,
            float shareLandArea, float feeOfMoney) {
        this.id = id;
        this.rentOut = rentOut;
        this.rentIn = rentIn;
        this.rentType = rentType;
        this.appointTime = appointTime;
        this.rentDeadline = rentDeadline;
        this.useage = useage;
        this.rentLayer = rentLayer;
        this.buildingArea = buildingArea;
        this.tradeArea = tradeArea;
        this.shareLandArea = shareLandArea;
        this.feeOfMoney = feeOfMoney;
    }
    @Generated(hash = 1253410206)
    public RentInfo4Model() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getRentType() {
        return this.rentType;
    }
    public void setRentType(String rentType) {
        this.rentType = rentType;
    }
    public String getAppointTime() {
        return this.appointTime;
    }
    public void setAppointTime(String appointTime) {
        this.appointTime = appointTime;
    }
    public String getRentDeadline() {
        return this.rentDeadline;
    }
    public void setRentDeadline(String rentDeadline) {
        this.rentDeadline = rentDeadline;
    }
    public String getUseage() {
        return this.useage;
    }
    public void setUseage(String useage) {
        this.useage = useage;
    }
    public String getRentLayer() {
        return this.rentLayer;
    }
    public void setRentLayer(String rentLayer) {
        this.rentLayer = rentLayer;
    }
    public float getBuildingArea() {
        return this.buildingArea;
    }
    public void setBuildingArea(float buildingArea) {
        this.buildingArea = buildingArea;
    }
    public float getTradeArea() {
        return this.tradeArea;
    }
    public void setTradeArea(float tradeArea) {
        this.tradeArea = tradeArea;
    }
    public float getShareLandArea() {
        return this.shareLandArea;
    }
    public void setShareLandArea(float shareLandArea) {
        this.shareLandArea = shareLandArea;
    }
    public float getFeeOfMoney() {
        return this.feeOfMoney;
    }
    public void setFeeOfMoney(float feeOfMoney) {
        this.feeOfMoney = feeOfMoney;
    }
}

