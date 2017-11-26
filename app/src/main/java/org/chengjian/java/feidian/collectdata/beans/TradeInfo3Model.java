package org.chengjian.java.feidian.collectdata.beans;

import android.support.annotation.Nullable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by xiang on 2017/9/9.
 * 房屋买卖价格调查表 中的买卖情况
 */

@Entity
public class TradeInfo3Model {

    @Id
    Long id;
    @Nullable
    String tradeIn;       //买方
    @Nullable
    String tradeOut;       //卖方
    @Nullable
    int tradeType;      //买卖方式
    @Nullable
    String tradeTime;       //买卖时间
    @Nullable
    String tradeLevel;      //买卖层次
    @Nullable
    float area;             //卖建面积
    @Nullable
    float shareLandArea;//分摊土地面积
    @Nullable
    String usageBefore;           //买卖前用途
    @Nullable
    String usageAfter;          //买卖后用途
    @Nullable
    float tax;              //房屋交易税费
    @Nullable
    float price;        //房屋交易总价格
    @Generated(hash = 2066896016)
    public TradeInfo3Model(Long id, String tradeIn, String tradeOut, int tradeType,
            String tradeTime, String tradeLevel, float area, float shareLandArea,
            String usageBefore, String usageAfter, float tax, float price) {
        this.id = id;
        this.tradeIn = tradeIn;
        this.tradeOut = tradeOut;
        this.tradeType = tradeType;
        this.tradeTime = tradeTime;
        this.tradeLevel = tradeLevel;
        this.area = area;
        this.shareLandArea = shareLandArea;
        this.usageBefore = usageBefore;
        this.usageAfter = usageAfter;
        this.tax = tax;
        this.price = price;
    }
    @Generated(hash = 1853352557)
    public TradeInfo3Model() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTradeIn() {
        return this.tradeIn;
    }
    public void setTradeIn(String tradeIn) {
        this.tradeIn = tradeIn;
    }
    public String getTradeOut() {
        return this.tradeOut;
    }
    public void setTradeOut(String tradeOut) {
        this.tradeOut = tradeOut;
    }
    public int getTradeType() {
        return this.tradeType;
    }
    public void setTradeType(int tradeType) {
        this.tradeType = tradeType;
    }
    public String getTradeTime() {
        return this.tradeTime;
    }
    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }
    public String getTradeLevel() {
        return this.tradeLevel;
    }
    public void setTradeLevel(String tradeLevel) {
        this.tradeLevel = tradeLevel;
    }
    public float getArea() {
        return this.area;
    }
    public void setArea(float area) {
        this.area = area;
    }
    public float getShareLandArea() {
        return this.shareLandArea;
    }
    public void setShareLandArea(float shareLandArea) {
        this.shareLandArea = shareLandArea;
    }
    public String getUsageBefore() {
        return this.usageBefore;
    }
    public void setUsageBefore(String usageBefore) {
        this.usageBefore = usageBefore;
    }
    public String getUsageAfter() {
        return this.usageAfter;
    }
    public void setUsageAfter(String usageAfter) {
        this.usageAfter = usageAfter;
    }
    public float getTax() {
        return this.tax;
    }
    public void setTax(float tax) {
        this.tax = tax;
    }
    public float getPrice() {
        return this.price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}

