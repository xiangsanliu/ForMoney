package org.chengjian.java.feidian.collectdata.mvp.model;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;

import java.util.List;

/**
 * Created by StormPhoenix on 17-9-12.
 * StormPhoenix is a intelligent Android developer.
 */

public class LocalDbModel extends BaseModel {
    public LocalDbModel(Context context) {
        super(context);
    }
//    private DaoMaster.DevOpenHelper devOpenHelper = null;
//    private List<CitySellRent> sellRentModels = null;
//    private DaoSession daoSession;
//
//    private static LocalDbModel localDbModel ;
//
//    public static LocalDbModel getInstance(Context context) {
//        if (localDbModel != null)
//            return localDbModel;
//        else return new LocalDbModel(context);
//    }
//
//    private LocalDbModel(Context context) {
//        super(context);
//        devOpenHelper = new DaoMaster.DevOpenHelper(context, "sell-db");
//        daoSession = new DaoMaster(devOpenHelper.getWritableDatabase()).newSession();
//    }
//

}
