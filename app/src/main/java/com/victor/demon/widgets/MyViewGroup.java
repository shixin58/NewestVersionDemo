package com.victor.demon.widgets;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * <p>Created by shixin on 2018/9/13.
 */
public class MyViewGroup extends ViewGroup {
    public MyViewGroup(Context context) {
        super(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // 先调用onTouch，后调用onTouchEvent
        // false未处理，传给上层onTouchEvent
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // true直接onTouchEvent; false子类dispatchTouchEvent
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                // 处理performClick()
                break;
        }
        // true消费不再向上传递
        return super.onTouchEvent(event);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }
}