package org.chengjian.java.feidian.collectdata.mvp.model;

import android.content.Context;

import org.chengjian.java.feidian.collectdata.beans.DaoMaster;
import org.chengjian.java.feidian.collectdata.beans.DaoSession;

import java.util.List;

/**
 * Created by StormPhoenix on 17-9-12.
 * StormPhoenix is a intelligent Android developer.
 * <p>
 * {@link LocalDbModel}用来实现对手机本地数据库表的查询，
 * 这里加了一个泛型T，是为了实现对四种不同的数据模型实现统一的操作。
 */
public abstract class LocalDbModel<T> extends BaseModel {
    private DaoMaster.DevOpenHelper devOpenHelper = null;
    protected DaoSession daoSession = null;

    public LocalDbModel(Context context) {
        super(context);
        devOpenHelper = new DaoMaster.DevOpenHelper(context, "sell-db");
        daoSession = new DaoMaster(devOpenHelper.getReadableDatabase()).newSession();
    }

    abstract public List<T> queryAllEntities();
}
