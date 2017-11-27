package org.chengjian.java.feidian.collectdata.beans;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by StormPhoenix on 17-9-11.
 * StormPhoenix is a intelligent Android developer.
 */
@Entity
public class CitySellRent {

    // 主键 id
    @Id
    private Long id;

    //土地基本信息
    private String landLoacation;       //宗地位置

    private String landRange;           //土地四至

    private String nearbyStreetName;    //所临道路名称

    private int crossRoadSituation;  //交叉路口形式

    private int landShape;           //宗地形状

    private String landLength;          //宗地长度

    private String landWidth;           //宗地宽度

    private int landDevelopingSituation; //土地开发状况

    private int buildingDirection;       //建筑朝向

    private int nearbyStreetSituation;      //临界状况

    private float distToCornor;             //至拐角距离

    private float widthToStreet;             //临街宽度

    private float depthToStreet;            //临街深度

    private boolean gore;                 //是否是畸零地

    private float buildingPlotRate;         //建筑容积率

    private String authorizedTime;          //使用权限取得时间

    private float landServiceableLife;         //土地使用年限

    //房屋信息
    private String houseLocation;        //房屋位置/柜台具体位置

    private int structureType;      //房屋结构

    private int qualityLevel;       //质量等级

    private float buindingArea;     //建筑面积

    private float houseArea;             //房屋建筑面积

    private String detail;              //详细说明

    private float longitude;        //经度

    private float latitude;         //维度

    private String researcher;      //调查人

    private String researcherTime;  //调查时间

    @NotNull
    private Long userId;

    @NotNull
    private int modelType;

    @Generated(hash = 2021521674)
    public CitySellRent(Long id, String landLoacation, String landRange,
            String nearbyStreetName, int crossRoadSituation, int landShape,
            String landLength, String landWidth, int landDevelopingSituation,
            int buildingDirection, int nearbyStreetSituation, float distToCornor,
            float widthToStreet, float depthToStreet, boolean gore,
            float buildingPlotRate, String authorizedTime,
            float landServiceableLife, String houseLocation, int structureType,
            int qualityLevel, float buindingArea, float houseArea, String detail,
            float longitude, float latitude, String researcher,
            String researcherTime, @NotNull Long userId, int modelType) {
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
        this.buindingArea = buindingArea;
        this.houseArea = houseArea;
        this.detail = detail;
        this.longitude = longitude;
        this.latitude = latitude;
        this.researcher = researcher;
        this.researcherTime = researcherTime;
        this.userId = userId;
        this.modelType = modelType;
    }

    @Generated(hash = 1815451546)
    public CitySellRent() {
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

    public float getDistToCornor() {
        return this.distToCornor;
    }

    public void setDistToCornor(float distToCornor) {
        this.distToCornor = distToCornor;
    }

    public float getWidthToStreet() {
        return this.widthToStreet;
    }

    public void setWidthToStreet(float widthToStreet) {
        this.widthToStreet = widthToStreet;
    }

    public float getDepthToStreet() {
        return this.depthToStreet;
    }

    public void setDepthToStreet(float depthToStreet) {
        this.depthToStreet = depthToStreet;
    }

    public boolean getGore() {
        return this.gore;
    }

    public void setGore(boolean gore) {
        this.gore = gore;
    }

    public float getBuildingPlotRate() {
        return this.buildingPlotRate;
    }

    public void setBuildingPlotRate(float buildingPlotRate) {
        this.buildingPlotRate = buildingPlotRate;
    }

    public String getAuthorizedTime() {
        return this.authorizedTime;
    }

    public void setAuthorizedTime(String authorizedTime) {
        this.authorizedTime = authorizedTime;
    }

    public float getLandServiceableLife() {
        return this.landServiceableLife;
    }

    public void setLandServiceableLife(float landServiceableLife) {
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

    public float getBuindingArea() {
        return this.buindingArea;
    }

    public void setBuindingArea(float buindingArea) {
        this.buindingArea = buindingArea;
    }

    public float getHouseArea() {
        return this.houseArea;
    }

    public void setHouseArea(float houseArea) {
        this.houseArea = houseArea;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return this.latitude;
    }

    public void setLatitude(float latitude) {
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

    public int getModelType() {
        return this.modelType;
    }

    public void setModelType(int modelType) {
        this.modelType = modelType;
    }
}
