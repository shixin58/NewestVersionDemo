package com.bride.thirdparty;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bride.baselib.CompatUtils;
import com.bride.baselib.PreferenceUtils;
import com.bride.baselib.ResUtils;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

/**
 * <p>Created by shixin on 2018/9/20.
 */
public class ThirdPartyApplication extends Application {
    private static ThirdPartyApplication application;
    private RequestQueue mRequestQueue;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public static ThirdPartyApplication getInstance() {
        return application;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        CompatUtils.detectNonSdkApi();
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

        Stetho.initializeWithDefaults(this);
        application = this;

        ResUtils.setContext(this);

        PreferenceUtils.initialize(this, "thirdparty_prefs");

        mRequestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    public Handler getHandler() {
        return mHandler;
    }
}
