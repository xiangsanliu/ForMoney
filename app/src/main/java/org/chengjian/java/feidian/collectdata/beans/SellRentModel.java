package org.chengjian.java.feidian.collectdata.beans;

import android.support.annotation.Nullable;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by StormPhoenix on 17-9-11.
 * StormPhoenix is a intelligent Android developer.
 */

@Entity
public class SellRentModel {

    // 主键 id
    @Id
    Long id;

    // 表类型，定义在constant里面
    @NotNull
    int modelType;

    @Nullable
    int nearbyLandType;             //周围土地类型
    @Nullable
    String landLoacation;       //宗地位置
    @Nullable
    String landRange;           //土地四至
    @Nullable
    String nearbyStreetName;    //所临道路名称
    @Nullable
    int crossRoadSituation;  //交叉路口形式
    @Nullable
    int landShape;           //宗地形状
    @Nullable
    String landLength;          //宗地长度
    @Nullable
    String landDepth;           //宗地宽度
    @Nullable
    int landDevelopingSituation; //土地开发状况
    @Nullable
    int buildingDirection;       //建筑朝向
    @Nullable
    int nearbyStreetSituation;      //临界状况
    @Nullable
    float distToCornor;             //至拐角距离
    @Nullable
    float widthToStreet;             //临街宽度
    @Nullable
    float depthToStreet;            //临街深度
    @Nullable
    boolean isGore;                 //是否是畸零地
    @Nullable
    float buildingPlotRate;         //建筑容积率
    @Nullable
    int usagePlaned;                //规划用途
    @Nullable
    int usageActual;              //实际用途
    @Nullable
    String authorizedTime;          //使用权限取得时间
    @Nullable
    String landServiceableLife;         //土地使用年限
    @Nullable
    String buildingNum;     //楼宇编号
    @Nullable
    String buildingName;    //楼宇名称
    @Nullable
    int decorationType;     //装修标准
    @Nullable
    int structureType;      //房屋结构
    @Nullable
    int qualityLevel;       //质量等级
    @Nullable
    int lightAirType;       //采光通风状况
    @Nullable
    float buildingArea;     //总建筑面积
    @Nullable
    float coverArea;        //总占地面积
    @Nullable
    int floorNum;           //楼层数
    @Nullable
    int yearUsed;           //已使用年限
    @Nullable
    String detail;              //详细说明
    @Nullable
    float longitude;        //经度
    @Nullable
    float latitude;         //维度
    @Nullable
    String researcher;      //调查人
    @Nullable
    String researcherTime;  //调查时间

    // 以下四个model根据 modelType 字段确定
    @Nullable
    @ToOne(joinProperty = "ri2ForeignKey")
    RentInfo2Model rentInfo2Model;
    Long ri2ForeignKey;

    @Nullable
    @ToOne(joinProperty = "ri4ForeignKey")
    RentInfo4Model rentInfo4Model;
    Long ri4ForeignKey;

    @Nullable
    @ToOne(joinProperty = "ti1ForeignKey")
    TradeInfo1Model tradeInfo1Model;
    Long ti1ForeignKey;

    @Nullable
    @ToOne(joinProperty = "ti3ForeignKey")
    TradeInfo3Model tradeInfo3Model;
    Long ti3ForeignKey;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 499981371)
    private transient SellRentModelDao myDao;
    @Generated(hash = 1243582701)
    public SellRentModel(Long id, int modelType, int nearbyLandType,
            String landLoacation, String landRange, String nearbyStreetName,
            int crossRoadSituation, int landShape, String landLength,
            String landDepth, int landDevelopingSituation, int buildingDirection,
            int nearbyStreetSituation, float distToCornor, float widthToStreet,
            float depthToStreet, boolean isGore, float buildingPlotRate,
            int usagePlaned, int usageActual, String authorizedTime,
            String landServiceableLife, String buildingNum, String buildingName,
            int decorationType, int structureType, int qualityLevel,
            int lightAirType, float buildingArea, float coverArea, int floorNum,
            int yearUsed, String detail, float longitude, float latitude,
            String researcher, String researcherTime, Long ri2ForeignKey,
            Long ri4ForeignKey, Long ti1ForeignKey, Long ti3ForeignKey) {
        this.id = id;
        this.modelType = modelType;
        this.nearbyLandType = nearbyLandType;
        this.landLoacation = landLoacation;
        this.landRange = landRange;
        this.nearbyStreetName = nearbyStreetName;
        this.crossRoadSituation = crossRoadSituation;
        this.landShape = landShape;
        this.landLength = landLength;
        this.landDepth = landDepth;
        this.landDevelopingSituation = landDevelopingSituation;
        this.buildingDirection = buildingDirection;
        this.nearbyStreetSituation = nearbyStreetSituation;
        this.distToCornor = distToCornor;
        this.widthToStreet = widthToStreet;
        this.depthToStreet = depthToStreet;
        this.isGore = isGore;
        this.buildingPlotRate = buildingPlotRate;
        this.usagePlaned = usagePlaned;
        this.usageActual = usageActual;
        this.authorizedTime = authorizedTime;
        this.landServiceableLife = landServiceableLife;
        this.buildingNum = buildingNum;
        this.buildingName = buildingName;
        this.decorationType = decorationType;
        this.structureType = structureType;
        this.qualityLevel = qualityLevel;
        this.lightAirType = lightAirType;
        this.buildingArea = buildingArea;
        this.coverArea = coverArea;
        this.floorNum = floorNum;
        this.yearUsed = yearUsed;
        this.detail = detail;
        this.longitude = longitude;
        this.latitude = latitude;
        this.researcher = researcher;
        this.researcherTime = researcherTime;
        this.ri2ForeignKey = ri2ForeignKey;
        this.ri4ForeignKey = ri4ForeignKey;
        this.ti1ForeignKey = ti1ForeignKey;
        this.ti3ForeignKey = ti3ForeignKey;
    }
    @Generated(hash = 1049757996)
    public SellRentModel() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getModelType() {
        return this.modelType;
    }
    public void setModelType(int modelType) {
        this.modelType = modelType;
    }
    public int getNearbyLandType() {
        return this.nearbyLandType;
    }
    public void setNearbyLandType(int nearbyLandType) {
        this.nearbyLandType = nearbyLandType;
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
    public String getLandDepth() {
        return this.landDepth;
    }
    public void setLandDepth(String landDepth) {
        this.landDepth = landDepth;
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
    public boolean getIsGore() {
        return this.isGore;
    }
    public void setIsGore(boolean isGore) {
        this.isGore = isGore;
    }
    public float getBuildingPlotRate() {
        return this.buildingPlotRate;
    }
    public void setBuildingPlotRate(float buildingPlotRate) {
        this.buildingPlotRate = buildingPlotRate;
    }
    public int getUsagePlaned() {
        return this.usagePlaned;
    }
    public void setUsagePlaned(int usagePlaned) {
        this.usagePlaned = usagePlaned;
    }
    public int getUsageActual() {
        return this.usageActual;
    }
    public void setUsageActual(int usageActual) {
        this.usageActual = usageActual;
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
    public String getBuildingNum() {
        return this.buildingNum;
    }
    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }
    public String getBuildingName() {
        return this.buildingName;
    }
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
    public int getDecorationType() {
        return this.decorationType;
    }
    public void setDecorationType(int decorationType) {
        this.decorationType = decorationType;
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
    public int getLightAirType() {
        return this.lightAirType;
    }
    public void setLightAirType(int lightAirType) {
        this.lightAirType = lightAirType;
    }
    public float getBuildingArea() {
        return this.buildingArea;
    }
    public void setBuildingArea(float buildingArea) {
        this.buildingArea = buildingArea;
    }
    public float getCoverArea() {
        return this.coverArea;
    }
    public void setCoverArea(float coverArea) {
        this.coverArea = coverArea;
    }
    public int getFloorNum() {
        return this.floorNum;
    }
    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }
    public int getYearUsed() {
        return this.yearUsed;
    }
    public void setYearUsed(int yearUsed) {
        this.yearUsed = yearUsed;
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
    public Long getRi2ForeignKey() {
        return this.ri2ForeignKey;
    }
    public void setRi2ForeignKey(Long ri2ForeignKey) {
        this.ri2ForeignKey = ri2ForeignKey;
    }
    public Long getRi4ForeignKey() {
        return this.ri4ForeignKey;
    }
    public void setRi4ForeignKey(Long ri4ForeignKey) {
        this.ri4ForeignKey = ri4ForeignKey;
    }
    public Long getTi1ForeignKey() {
        return this.ti1ForeignKey;
    }
    public void setTi1ForeignKey(Long ti1ForeignKey) {
        this.ti1ForeignKey = ti1ForeignKey;
    }
    public Long getTi3ForeignKey() {
        return this.ti3ForeignKey;
    }
    public void setTi3ForeignKey(Long ti3ForeignKey) {
        this.ti3ForeignKey = ti3ForeignKey;
    }
    @Generated(hash = 1027010847)
    private transient Long rentInfo2Model__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1796680947)
    public RentInfo2Model getRentInfo2Model() {
        Long __key = this.ri2ForeignKey;
        if (rentInfo2Model__resolvedKey == null
                || !rentInfo2Model__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RentInfo2ModelDao targetDao = daoSession.getRentInfo2ModelDao();
            RentInfo2Model rentInfo2ModelNew = targetDao.load(__key);
            synchronized (this) {
                rentInfo2Model = rentInfo2ModelNew;
                rentInfo2Model__resolvedKey = __key;
            }
        }
        return rentInfo2Model;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 939065031)
    public void setRentInfo2Model(RentInfo2Model rentInfo2Model) {
        synchronized (this) {
            this.rentInfo2Model = rentInfo2Model;
            ri2ForeignKey = rentInfo2Model == null ? null : rentInfo2Model.getId();
            rentInfo2Model__resolvedKey = ri2ForeignKey;
        }
    }
    @Generated(hash = 1118088259)
    private transient Long rentInfo4Model__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 835411441)
    public RentInfo4Model getRentInfo4Model() {
        Long __key = this.ri4ForeignKey;
        if (rentInfo4Model__resolvedKey == null
                || !rentInfo4Model__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RentInfo4ModelDao targetDao = daoSession.getRentInfo4ModelDao();
            RentInfo4Model rentInfo4ModelNew = targetDao.load(__key);
            synchronized (this) {
                rentInfo4Model = rentInfo4ModelNew;
                rentInfo4Model__resolvedKey = __key;
            }
        }
        return rentInfo4Model;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 848528692)
    public void setRentInfo4Model(RentInfo4Model rentInfo4Model) {
        synchronized (this) {
            this.rentInfo4Model = rentInfo4Model;
            ri4ForeignKey = rentInfo4Model == null ? null : rentInfo4Model.getId();
            rentInfo4Model__resolvedKey = ri4ForeignKey;
        }
    }
    @Generated(hash = 1027474893)
    private transient Long tradeInfo1Model__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1533644881)
    public TradeInfo1Model getTradeInfo1Model() {
        Long __key = this.ti1ForeignKey;
        if (tradeInfo1Model__resolvedKey == null
                || !tradeInfo1Model__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TradeInfo1ModelDao targetDao = daoSession.getTradeInfo1ModelDao();
            TradeInfo1Model tradeInfo1ModelNew = targetDao.load(__key);
            synchronized (this) {
                tradeInfo1Model = tradeInfo1ModelNew;
                tradeInfo1Model__resolvedKey = __key;
            }
        }
        return tradeInfo1Model;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 161917913)
    public void setTradeInfo1Model(TradeInfo1Model tradeInfo1Model) {
        synchronized (this) {
            this.tradeInfo1Model = tradeInfo1Model;
            ti1ForeignKey = tradeInfo1Model == null ? null
                    : tradeInfo1Model.getId();
            tradeInfo1Model__resolvedKey = ti1ForeignKey;
        }
    }
    @Generated(hash = 1107410449)
    private transient Long tradeInfo3Model__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1858078212)
    public TradeInfo3Model getTradeInfo3Model() {
        Long __key = this.ti3ForeignKey;
        if (tradeInfo3Model__resolvedKey == null
                || !tradeInfo3Model__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TradeInfo3ModelDao targetDao = daoSession.getTradeInfo3ModelDao();
            TradeInfo3Model tradeInfo3ModelNew = targetDao.load(__key);
            synchronized (this) {
                tradeInfo3Model = tradeInfo3ModelNew;
                tradeInfo3Model__resolvedKey = __key;
            }
        }
        return tradeInfo3Model;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1034604111)
    public void setTradeInfo3Model(TradeInfo3Model tradeInfo3Model) {
        synchronized (this) {
            this.tradeInfo3Model = tradeInfo3Model;
            ti3ForeignKey = tradeInfo3Model == null ? null
                    : tradeInfo3Model.getId();
            tradeInfo3Model__resolvedKey = ti3ForeignKey;
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
    @Generated(hash = 1251169992)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSellRentModelDao() : null;
    }

  
}
