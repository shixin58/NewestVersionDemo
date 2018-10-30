package com.bride.widget;

import android.app.Application;

import com.bride.baselib.PreferenceUtils;
import com.bride.baselib.ResUtils;

/**
 * <p>Created by shixin on 2018/10/30.
 */
public class WidgetApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ResUtils.setContext(this);

        PreferenceUtils.initialize(this, "widget_prefs");
    }
}
