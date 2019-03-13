package com.bride.demon.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.bride.baselib.BaseActivity;
import com.bride.demon.R;
import com.bride.demon.widget.MyViewGroup;

/**
 * <p>Created by shixin on 2018/9/13.
 */
public class TestTouchActivity extends BaseActivity {
    private static final String TAG = TestTouchActivity.class.getSimpleName();
    // 包访问权限
    int type;

    public static void openActivity(Context context, int type) {
        Intent intent = new Intent(context, TestTouchActivity.class);
        // mExtras.putInt(String, int)
        // Intent、ComponentName、Bundle均实现Parcelable接口，bind进程通信传递Parcelable对象
        // intent.getExtras()内部new Bundle(mExtras)为了保护数据吧
        // Intent和Bundle设置的跟获取的均不同
        intent.putExtra("type", type);
        Log.i(TAG, "openActivity-"+intent.hashCode());
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_touch);
        initView();
    }

    private void initView() {
        Log.i(TAG, "onCreate-"+getIntent().hashCode());
        // mExtras.getInt(String, int)
        this.type = getIntent().getIntExtra("type", 0);
        MyViewGroup viewGroup;
        if(type == 1) {
            viewGroup = new MyViewGroup(this);
        }else {
            viewGroup = findViewById(R.id.my_view_group);
        }
        // onTouch -> onTouchEvent -> performClick
        viewGroup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent "+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent "+event.getAction());
        return super.onTouchEvent(event);
    }
}
