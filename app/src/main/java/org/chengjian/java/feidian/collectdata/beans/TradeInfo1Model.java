package org.chengjian.java.feidian.collectdata.beans;

import android.support.annotation.Nullable;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by xiang on 2017/9/9.
 * 商品房出售价格调查表 中的买卖情况
 */

@Entity
public class TradeInfo1Model {

    @Id
    Long id;
    @Nullable
    String tradeIn;       //买方
    @Nullable
    String tradeOut;       //卖方
    @Nullable
    int tradeType;      //买卖方式
    @Nullable
    int loanYear;       //按揭年限
    @Nullable
    String tradeLevel;      //买卖层次
    @Nullable
    String tradeTime;       //商品房出售时间
    @Nullable
    String useage;           //房屋用途
    @Nullable
    String plotRatePlaned;  //规划容积率
    @Nullable
    float area;             //卖建面积
    @Nullable
    float price;        //房屋交易总价格
    @Nullable
    float shareLandArea;//分摊土地面积
    @Generated(hash = 938170877)
    public TradeInfo1Model(Long id, String tradeIn, String tradeOut, int tradeType,
            int loanYear, String tradeLevel, String tradeTime, String useage,
            String plotRatePlaned, float area, float price, float shareLandArea) {
        this.id = id;
        this.tradeIn = tradeIn;
        this.tradeOut = tradeOut;
        this.tradeType = tradeType;
        this.loanYear = loanYear;
        this.tradeLevel = tradeLevel;
        this.tradeTime = tradeTime;
        this.useage = useage;
        this.plotRatePlaned = plotRatePlaned;
        this.area = area;
        this.price = price;
        this.shareLandArea = shareLandArea;
    }
    @Generated(hash = 904088013)
    public TradeInfo1Model() {
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
    public String getPlotRatePlaned() {
        return this.plotRatePlaned;
    }
    public void setPlotRatePlaned(String plotRatePlaned) {
        this.plotRatePlaned = plotRatePlaned;
    }
    public float getArea() {
        return this.area;
    }
    public void setArea(float area) {
        this.area = area;
    }
    public float getPrice() {
        return this.price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public float getShareLandArea() {
        return this.shareLandArea;
    }
    public void setShareLandArea(float shareLandArea) {
        this.shareLandArea = shareLandArea;
    }
}

