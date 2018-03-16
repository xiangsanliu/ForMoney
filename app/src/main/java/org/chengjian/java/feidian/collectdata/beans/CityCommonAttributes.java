package org.chengjian.java.feidian.collectdata.beans;


import android.support.annotation.Nullable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import lombok.Getter;
import lombok.Setter;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by StormPhoenix on 17-9-11.
 * StormPhoenix is a intelligent Android developer.
 *
 * 目前而言，整个程序只有四种不同类型的数据模型，这些数据模型
 * 的公有属性全部存储在{@link CityCommonAttributes}中。
 *
 * 每一种不同类型的数据模型都有一个外键指向{@link CityCommonAttributes}
 */
@Entity
public class CityCommonAttributes {
    // 主键 id
    @Id
    private Long id;
    //土地基本信息
    @Nullable
    private String landLoacation;       //宗地位置
    @Nullable
    private String landRange;           //土地四至
    @Nullable
    private String nearbyStreetName;    //所临道路名称
    @Nullable
    private int crossRoadSituation;  //交叉路口形式
    @Nullable
    private int landShape;           //宗地形状
    @Nullable
    private String landLength;          //宗地长度
    @Nullable
    private String landWidth;           //宗地宽度
    @Nullable
    private int landDevelopingSituation; //土地开发状况
    @Nullable
    private int buildingDirection;       //建筑朝向
    @Nullable
    private int nearbyStreetSituation;      //临界状况
    @Nullable
    private String distToCornor;             //至拐角距离
    @Nullable
    private String widthToStreet;             //临街宽度
    @Nullable
    private String depthToStreet;            //临街深度
    @Nullable
    private boolean gore;                 //是否是畸零地
    @Nullable
    private String buildingPlotRate;         //建筑容积率
    @Nullable
    private String authorizedTime;          //使用权限取得时间
    @Nullable
    private String landServiceableLife;         //土地使用年限
    //房屋信息
    @Nullable
    private String houseLocation;        //房屋位置/柜台具体位置
    @Nullable
    private int structureType;      //房屋结构
    @Nullable
    private int qualityLevel;       //质量等级
    @Nullable
    private String buildingArea;     //建筑面积
    @Nullable
    private String houseArea;             //房屋建筑面积
    @Nullable
    private String detail;              //详细说明
    @Nullable
    private double longitude;        //经度
    @Nullable
    private double latitude;         //维度
    @Nullable
    private String researcher;      //调查人
    @Nullable
    private String researcherTime;  //调查时间
    @Nullable
    private Long userId;
    @Generated(hash = 1778634517)
    public CityCommonAttributes(Long id, String landLoacation, String landRange,
            String nearbyStreetName, int crossRoadSituation, int landShape,
            String landLength, String landWidth, int landDevelopingSituation,
            int buildingDirection, int nearbyStreetSituation, String distToCornor,
            String widthToStreet, String depthToStreet, boolean gore,
            String buildingPlotRate, String authorizedTime,
            String landServiceableLife, String houseLocation, int structureType,
            int qualityLevel, String buildingArea, String houseArea, String detail,
            double longitude, double latitude, String researcher,
            String researcherTime, Long userId) {
        this.id = id;
        this.landLoacation = landLoacation;
        this.landRange = landRange;
        this.nearbyStreetName = nearbyStreetName;
        this.crossRoadSituation = crossRoadSituation;
        this.landShape = landShape;
        this.landLength = landLength;
        this.landWidth = landWidth;
        this.landDevelopingSituation = landDevelopingSituation;
        this.buildingDirection = buildingDirection;
        this.nearbyStreetSituation = nearbyStreetSituation;
        this.distToCornor = distToCornor;
        this.widthToStreet = widthToStreet;
        this.depthToStreet = depthToStreet;
        this.gore = gore;
        this.buildingPlotRate = buildingPlotRate;
        this.authorizedTime = authorizedTime;
        this.landServiceableLife = landServiceableLife;
        this.houseLocation = houseLocation;
        this.structureType = structureType;
        this.qualityLevel = qualityLevel;
        this.buildingArea = buildingArea;
        this.houseArea = houseArea;
        this.detail = detail;
        this.longitude = longitude;
        this.latitude = latitude;
        this.researcher = researcher;
        this.researcherTime = researcherTime;
        this.userId = userId;
    }
    @Generated(hash = 347337102)
    public CityCommonAttributes() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLandLoacation() {
        return this.landLoacation;
    }
    public void setLandLoacation(String landLoacation) {
        this.landLoacation = landLoacation;
    }
    public String getLandRange() {
        return this.landRange;
    }
    public void setLandRange(String landRange) {
        this.landRange = landRange;
    }
    public String getNearbyStreetName() {
        return this.nearbyStreetName;
    }
    public void setNearbyStreetName(String nearbyStreetName) {
        this.nearbyStreetName = nearbyStreetName;
    }
    public int getCrossRoadSituation() {
        return this.crossRoadSituation;
    }
    public void setCrossRoadSituation(int crossRoadSituation) {
        this.crossRoadSituation = crossRoadSituation;
    }
    public int getLandShape() {
        return this.landShape;
    }
    public void setLandShape(int landShape) {
        this.landShape = landShape;
    }
    public String getLandLength() {
        return this.landLength;
    }
    public void setLandLength(String landLength) {
        this.landLength = landLength;
    }
    public String getLandWidth() {
        return this.landWidth;
    }
    public void setLandWidth(String landWidth) {
        this.landWidth = landWidth;
    }
    public int getLandDevelopingSituation() {
        return this.landDevelopingSituation;
    }
    public void setLandDevelopingSituation(int landDevelopingSituation) {
        this.landDevelopingSituation = landDevelopingSituation;
    }
    public int getBuildingDirection() {
        return this.buildingDirection;
    }
    public void setBuildingDirection(int buildingDirection) {
        this.buildingDirection = buildingDirection;
    }
    public int getNearbyStreetSituation() {
        return this.nearbyStreetSituation;
    }
    public void setNearbyStreetSituation(int nearbyStreetSituation) {
        this.nearbyStreetSituation = nearbyStreetSituation;
    }
    public String getDistToCornor() {
        return this.distToCornor;
    }
    public void setDistToCornor(String distToCornor) {
        this.distToCornor = distToCornor;
    }
    public String getWidthToStreet() {
        return this.widthToStreet;
    }
    public void setWidthToStreet(String widthToStreet) {
        this.widthToStreet = widthToStreet;
    }
    public String getDepthToStreet() {
        return this.depthToStreet;
    }
    public void setDepthToStreet(String depthToStreet) {
        this.depthToStreet = depthToStreet;
    }
    public boolean getGore() {
        return this.gore;
    }
    public void setGore(boolean gore) {
        this.gore = gore;
    }
    public String getBuildingPlotRate() {
        return this.buildingPlotRate;
    }
    public void setBuildingPlotRate(String buildingPlotRate) {
        this.buildingPlotRate = buildingPlotRate;
    }
    public String getAuthorizedTime() {
        return this.authorizedTime;
    }
    public void setAuthorizedTime(String authorizedTime) {
        this.authorizedTime = authorizedTime;
    }
    public String getLandServiceableLife() {
        return this.landServiceableLife;
    }
    public void setLandServiceableLife(String landServiceableLife) {
        this.landServiceableLife = landServiceableLife;
    }
    public String getHouseLocation() {
        return this.houseLocation;
    }
    public void setHouseLocation(String houseLocation) {
        this.houseLocation = houseLocation;
    }
    public int getStructureType() {
        return this.structureType;
    }
    public void setStructureType(int structureType) {
        this.structureType = structureType;
    }
    public int getQualityLevel() {
        return this.qualityLevel;
    }
    public void setQualityLevel(int qualityLevel) {
        this.qualityLevel = qualityLevel;
    }
    public String getBuildingArea() {
        return this.buildingArea;
    }
    public void setBuildingArea(String buildingArea) {
        this.buildingArea = buildingArea;
    }
    public String getHouseArea() {
        return this.houseArea;
    }
    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }
    public String getDetail() {
        return this.detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public double getLongitude() {
        return this.longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() {
        return this.latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public String getResearcher() {
        return this.researcher;
    }
    public void setResearcher(String researcher) {
        this.researcher = researcher;
    }
    public String getResearcherTime() {
        return this.researcherTime;
    }
    public void setResearcherTime(String researcherTime) {
        this.researcherTime = researcherTime;
    }
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
