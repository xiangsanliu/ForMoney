package org.chengjian.java.feidian.collectdata.db;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.FMApplication;
import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributesDao;
import org.chengjian.java.feidian.collectdata.beans.CommercialHousingForSale;
import org.chengjian.java.feidian.collectdata.beans.CommercialHousingForSaleDao;
import org.chengjian.java.feidian.collectdata.beans.CounterRent;
import org.chengjian.java.feidian.collectdata.beans.CounterRentDao;
import org.chengjian.java.feidian.collectdata.beans.DaoMaster;
import org.chengjian.java.feidian.collectdata.beans.DaoSession;
import org.chengjian.java.feidian.collectdata.beans.HouseRent;
import org.chengjian.java.feidian.collectdata.beans.HouseRentDao;
import org.chengjian.java.feidian.collectdata.beans.HouseSalePrice;
import org.chengjian.java.feidian.collectdata.beans.HouseSalePriceDao;

import java.util.List;

/**
 * Created by StormPhoenix on 18-3-17.
 * StormPhoenix is a intelligent Android developer.
 */

public class DbManager {
    private DaoMaster.DevOpenHelper devOpenHelper = null;
    private DaoSession daoSession = null;
    private static DbManager dbManager = null;

    private DbManager(Context context) {
        devOpenHelper = new DaoMaster.DevOpenHelper(context, "sell-db");
        daoSession = new DaoMaster(devOpenHelper.getWritableDb()).newSession();
    }

    public static DbManager getInstance() {
        if (dbManager == null) {
            synchronized (FMApplication.getInstance()) {
                if (dbManager == null) {
                    dbManager = new DbManager(FMApplication.getInstance());
                }
            }
        }
        return dbManager;
    }

    public List<CounterRent> queryAllCounterRents() {
        CounterRentDao counterRentDao = daoSession.getCounterRentDao();
        return counterRentDao.queryBuilder()
                .list();
    }

    public List<HouseRent> queryAllHouseRents() {
        HouseRentDao dao = daoSession.getHouseRentDao();
        return dao.queryBuilder()
                .list();
    }

    public List<HouseSalePrice> queryAllHouseSalePrices() {
        HouseSalePriceDao dao = daoSession.getHouseSalePriceDao();
        return dao.queryBuilder()
                .list();
    }

    public List<CommercialHousingForSale> queryAllCommercialHousingForSale() {
        CommercialHousingForSaleDao dao = daoSession.getCommercialHousingForSaleDao();
        return dao.queryBuilder()
                .list();
    }

    /**
     * 通过CounterRent的foreignKey属性查询数据
     *
     * @param foreignKey
     * @return
     */
    public CounterRent queryCounterRentByForeignKey(Long foreignKey) {
        CounterRentDao dao = daoSession.getCounterRentDao();
        List<CounterRent> list = dao.queryBuilder()
                .where(CounterRentDao.Properties.ForeignKey.eq(foreignKey))
                .list();
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * 用法同{@link #queryCounterRentByForeignKey}
     * 但是返回的是 {@link CommercialHousingForSale}
     *
     * @param foreignKey
     * @return
     */
    public CommercialHousingForSale queryCommercialHousingForSaleByForeignKey(Long foreignKey) {
        CommercialHousingForSaleDao dao = daoSession.getCommercialHousingForSaleDao();
        List<CommercialHousingForSale> list = dao.queryBuilder()
                .where(CommercialHousingForSaleDao.Properties.ForeignKey.eq(foreignKey))
                .list();
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * 用法同{@link #queryCounterRentByForeignKey}
     * 但是返回的是 {@link HouseRent}
     *
     * @param foreignKey
     * @return
     */
    public HouseRent queryHouseRentByForeignKey(Long foreignKey) {
        HouseRentDao dao = daoSession.getHouseRentDao();
        List<HouseRent> list = dao.queryBuilder()
                .where(HouseRentDao.Properties.ForeignKey.eq(foreignKey))
                .list();
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * 用法同{@link #queryCounterRentByForeignKey}
     * 但是返回的是 {@link HouseSalePrice}
     *
     * @param foreignKey
     * @return
     */
    public HouseSalePrice queryHouseSalePriceByForeignKey(Long foreignKey) {
        HouseSalePriceDao dao = daoSession.getHouseSalePriceDao();
        List<HouseSalePrice> list = dao.queryBuilder()
                .where(HouseSalePriceDao.Properties.ForeignKey.eq(foreignKey))
                .list();
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public void saveHouseSalePrice(HouseSalePrice entity) {
        HouseSalePriceDao dao = daoSession.getHouseSalePriceDao();
        dao.save(entity);
    }

    public void saveCommercialHousingForSale(CommercialHousingForSale entity) {
        CommercialHousingForSaleDao dao = daoSession.getCommercialHousingForSaleDao();
        dao.save(entity);
        System.out.println();
    }

    public void saveCounterRent(CounterRent entity) {
        CounterRentDao dao = daoSession.getCounterRentDao();
        dao.save(entity);
    }

    public void saveCityCommonAttributes(CityCommonAttributes commonAttrs) {
        CityCommonAttributesDao dao = daoSession.getCityCommonAttributesDao();
        dao.save(commonAttrs);
    }

    public void saveHouseRent(HouseRent entity) {
        HouseRentDao dao = daoSession.getHouseRentDao();
        dao.save(entity);
    }
// dddd

    public List<CityCommonAttributes> queryCCA() {
        return daoSession.getCityCommonAttributesDao().queryBuilder().list();
    }

    public List<CommercialHousingForSale> queryCFS() {
        return daoSession.getCommercialHousingForSaleDao().queryBuilder().list();
    }
//    public Long queryKeyByModelId(String modelId, String modelClassName) {
//        Long result = null;
//        String simpleName = modelClassName.substring(modelClassName.lastIndexOf('.') + 1);
//        try {
//            AbstractDao dao = getModelDao(simpleName);
//            if (dao != null) {
//                Class<?> modelClassInstance = Class.forName(modelClassName + "$Properties");
//                Field modelIdField = modelClassInstance.getDeclaredField("ModelId");
//                Property property = (Property) modelIdField.get(null);
//
//                List<BaseModel> list = dao.queryBuilder()
//                        .where(property.eq(modelId))
//                        .list();
//                if (list != null && !list.isEmpty()) {
//                    BaseModel objResult = list.get(0);
//                    result = objResult.getId();
//                }
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } finally {
//            return result;
//        }
//    }

//    private AbstractDao getModelDao(String simpleName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        String methodName = "get" + simpleName + "Dao";
//        if (DaoSession.class.getDeclaredMethod(methodName, (Class<?>[]) null) != null) {
//            Method method = DaoSession.class.getDeclaredMethod(methodName, (Class<?>[]) null);
//            DaoSession daoSession = new DaoMaster(devOpenHelper.getWritableDatabase()).newSession();
//            AbstractDao dao = (AbstractDao) method.invoke(daoSession);
//            return dao;
//        } else {
//            return null;
//        }
//    }

//    public void deleteAll() {
//        DaoSession daoSession = new DaoMaster(devOpenHelper.getWritableDb()).newSession();
//        daoSession.deleteAll(DominantBenthosSpecies.class);
//        daoSession.deleteAll(DominantPhytoplanktonSpecies.class);
//        daoSession.deleteAll(DominantZooplanktonSpecies.class);
//        daoSession.deleteAll(Benthos.class);
//        daoSession.deleteAll(Zooplankton.class);
//        daoSession.deleteAll(Phytoplankton.class);
//        daoSession.deleteAll(Sediment.class);
//        daoSession.deleteAll(FishEggs.class);
//        daoSession.deleteAll(Fishes.class);
//        daoSession.deleteAll(Catches.class);
//        daoSession.deleteAll(CatchTools.class);
//        daoSession.deleteAll(WaterLayer.class);
//        daoSession.deleteAll(MeasurePoint.class);
//        daoSession.deleteAll(MeasuringLine.class);
//        daoSession.deleteAll(FractureSurface.class);
//        daoSession.deleteAll(MonitoringSite.class);
//    }

//    public void delete(BaseModel obj) {
//        String simpleName = obj.getClass().getSimpleName();
//        String modelClassName = obj.getClass().getName();
//        Long result = null;
//        try {
//            Log.e(TAG, "save: " + modelClassName);
//            AbstractDao modelDao = getModelDao(simpleName);
//            if (modelDao != null) {
//                Log.e(TAG, "save: not null");
//                modelDao.delete(obj);
//                Log.e(TAG, "delete ");
//            }
//        } catch (NoSuchMethodException e) {
//            Log.e(TAG, "save: " + e.toString());
//        } catch (InvocationTargetException e) {
//            Log.e(TAG, "save: " + e.toString());
//        } catch (IllegalAccessException e) {
//            Log.e(TAG, "save: " + e.toString());
//        }
//    }

    /**
     * 存储一个 Model对象，并返回该对象的id值
     *
     * @param obj
     * @return
     */
//    public Long save(BaseModel obj) {
//        String simpleName = obj.getClass().getSimpleName();
//        String modelClassName = obj.getClass().getName();
//        Long result = null;
//        try {
//            Log.e(TAG, "save: " + modelClassName);
//            AbstractDao modelDao = getModelDao(simpleName);
//            if (modelDao != null) {
//                Log.e(TAG, "save: not null");
//                modelDao.save(obj);
//                Log.e(TAG, "hello ");
//                Log.e(TAG, "hello " + obj.getId());
//                Log.e(TAG, "hello ");
//                result = obj.getId();
//            }
//        } catch (NoSuchMethodException e) {
//            Log.e(TAG, "save: " + e.toString());
//        } catch (InvocationTargetException e) {
//            Log.e(TAG, "save: " + e.toString());
//        } catch (IllegalAccessException e) {
//            Log.e(TAG, "save: " + e.toString());
//        } finally {
//            return result;
//        }
//    }

//    public void saveModels(List<MonitoringSite> models) {
//        for (MonitoringSite monitoringSite : models) {
//            saveMonitoringSite(monitoringSite);
//            List<List<BaseModel>> childrenModelsList = getChildrenModels(monitoringSite);
//            for (List<BaseModel> childrendModels : childrenModelsList) {
//                saveByDepthFirst(monitoringSite, childrendModels);
//            }
//        }
//    }
//
//    private void saveByDepthFirst(BaseModel baseModel, List<BaseModel> childrenModel) {
//        for (BaseModel childModel : childrenModel) {
//            childModel.setForeignKey(baseModel.getId());
//            save(childModel);
//
//            List<List<BaseModel>> childrenModelsList = getChildrenModels(childModel);
//            for (List<BaseModel> childrenModels : childrenModelsList) {
//                saveByDepthFirst(childModel, childrenModels);
//            }
//        }
//    }
//
//    private List<List<BaseModel>> getChildrenModels(BaseModel baseModel) {
//        List<List<BaseModel>> modelsList = new ArrayList<>();
//        Field[] declaredFields = baseModel.getClass().getDeclaredFields();
//        for (Field field : declaredFields) {
//            if (field.getType() == List.class) {
//                field.setAccessible(true);
//                try {
//                    List<BaseModel> baseModels = (List<BaseModel>) field.get(baseModel);
//                    if (baseModels == null || baseModels.size() == 0) {
//                        continue;
//                    } else {
//                        modelsList.add(baseModels);
//                    }
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return modelsList;
//    }
//
//    public MonitoringSite queryMSiteByKey(String key) {
//        DaoSession daoSession = new DaoMaster(devOpenHelper.getReadableDatabase()).newSession();
//        MonitoringSiteDao dao = daoSession.getMonitoringSiteDao();
//        List<MonitoringSite> sites = dao.queryBuilder()
//                .where(MonitoringSiteDao.Properties.ModelId.eq(key))
//                .build().list();
//        if (sites == null || sites.size() == 0) {
//            return null;
//        } else {
//            return sites.get(0);
//        }
//    }
//
//    public List<MonitoringSite> queryAllMonitoringSite() {
//        DaoSession daoSession = new DaoMaster(devOpenHelper.getReadableDatabase()).newSession();
//        MonitoringSiteDao dao = daoSession.getMonitoringSiteDao();
//        return dao.queryBuilder().build().list();
//    }
}
