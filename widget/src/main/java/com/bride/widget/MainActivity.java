package com.bride.widget;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bride.ui_lib.BaseActivity;
import com.bride.widget.activity.BlueprintActivity;
import com.bride.widget.activity.BossActivity;
import com.bride.widget.activity.CustomViewActivity;
import com.bride.widget.activity.JSActivity;
import com.bride.widget.activity.LottieActivity;
import com.bride.widget.activity.RefreshActivity;
import com.bride.widget.activity.ScrollingActivity;
import com.bride.widget.activity.TypefaceActivity;

/**
 * <p>Created by shixin on 2018/10/27.
 */
public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent;
        switch(view.getId()) {
            case R.id.tv_scrolling:
                intent = new Intent(this, ScrollingActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_boss:
                intent = new Intent(this, BossActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_js:
                intent = new Intent(this, JSActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_blueprint:
                intent = new Intent(this, BlueprintActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_custom_view:
                CustomViewActivity.openActivity(this);
                break;
            case R.id.tv_refresh:
                RefreshActivity.openActivity(this);
                break;
            case R.id.tv_lottie:
                LottieActivity.openActivity(this);
                break;
            case R.id.tv_typeface:
                intent = new Intent(this, TypefaceActivity.class);
                startActivity(intent);
                break;
        }
    }
}
