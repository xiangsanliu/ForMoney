package org.chengjian.java.feidian.collectdata.shared;

import android.content.Context;
import android.content.SharedPreferences;

import org.chengjian.java.feidian.collectdata.FMApplication;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by StormPhoenix on 17-2-17.
 * StormPhoenix is a intelligent Android developer.
 */

public class ConfigUtils {
    private static ConfigUtils INSTANCE = null;

    private SharedPreferences userInfoSp = null;
    private SharedPreferences taskDispatch = null;

    private ConfigUtils(Context context) {
        userInfoSp = context.getSharedPreferences("user_info", MODE_PRIVATE);
        taskDispatch = context.getSharedPreferences("task_dispatch", MODE_PRIVATE);
    }

    public static ConfigUtils getInstance() {
        if (INSTANCE == null) {
            synchronized (ConfigUtils.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConfigUtils(FMApplication.getInstance());
                }
            }
        }
        return INSTANCE;
    }

    public boolean isUserLogin() {
        return userInfoSp.getBoolean("is_login", false);
    }

    public void setUserLogin() {
        userInfoSp.edit()
                .putBoolean("is_login", true)
                .commit();
    }

    public void setUserLogout() {
        userInfoSp.edit()
                .putBoolean("is_login", false)
                .commit();
    }

    public void setUserInfo(String imeiCode) {
        userInfoSp.edit()
                .putString("imeiCode", imeiCode)
                .commit();
    }

    public String getIMEI() {
        return userInfoSp.getString("imeiCode", null);
    }
}
