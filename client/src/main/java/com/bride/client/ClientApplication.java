package com.bride.client;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bride.baselib.CompatUtils;
import com.bride.baselib.PermissionUtils;
import com.bride.baselib.PreferenceUtils;
import com.bride.baselib.ResUtils;
import com.bride.baselib.SystemStrategy;
import com.squareup.leakcanary.LeakCanary;

/**
 * <p>Created by shixin on 2018/10/30.
 */
public class ClientApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        CompatUtils.detectThread();
        CompatUtils.detectVm();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        ResUtils.setContext(this);
        PreferenceUtils.initialize(this, "client_prefs");
        PermissionUtils.setContext(this);
        SystemStrategy.setContext(this);

        initRouter();
    }

    private void initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
