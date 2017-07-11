package com.yexue.android.hexiprv;

import android.support.multidex.MultiDexApplication;

/**
 * @author yexue
 * @version 1.0
 * @name Application
 * @explain
 * @time 2017/7/11 11:24
 */
public class Application extends MultiDexApplication {
    private static Application application;

    public static Application getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
