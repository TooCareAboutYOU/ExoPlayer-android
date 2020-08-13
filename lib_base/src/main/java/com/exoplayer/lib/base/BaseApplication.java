package com.exoplayer.lib.base;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

/**
 * Application基类
 * @author zhangshuai
 */
public class BaseApplication extends Application {

    @Override
    protected void attachBaseContext(final Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
