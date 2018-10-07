package com.bride.thirdparty;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bride.baselib.BaseActivity;
import com.bride.thirdparty.Strategy.RetrofitStrategy;
import com.bride.thirdparty.Strategy.RxJavaStrategy;
import com.bride.thirdparty.Strategy.SystemStrategy;
import com.bride.thirdparty.bean.MessageEvent;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * <p>Created by shixin on 2018/9/7.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{

    Observable<MessageEvent> mObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        findViewById(R.id.tv_volley).setOnClickListener(this);
        findViewById(R.id.tv_eventbus).setOnClickListener(this);
    }

    private void initData() {
        mObservable = RxBus.getInstance().register(MessageEvent.class);
        // Consumer和Observer均可使用
        mObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MessageEvent>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MessageEvent messageEvent) {
                        Log.i("MessageEvent", ""+messageEvent.info);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        RetrofitStrategy retrofitStrategy = new RetrofitStrategy();
//        retrofitStrategy.execute();
//        retrofitStrategy.executeRxJava();
//        retrofitStrategy.testAsyncTask();

        RxJavaStrategy rxJavaStrategy = new RxJavaStrategy();
//        rxJavaStrategy.execute();
//        rxJavaStrategy.executeMap();
//        rxJavaStrategy.executeFlatMap();
//        rxJavaStrategy.executeInterval();
//        rxJavaStrategy.executeTimer();
//        rxJavaStrategy.executeRange();
//        rxJavaStrategy.executeZip();
//        rxJavaStrategy.executeConcat();
//        rxJavaStrategy.executeMerge();
//        rxJavaStrategy.executeCombineLatest();
//        rxJavaStrategy.executeReduce();
//        rxJavaStrategy.executeCollect();
//        rxJavaStrategy.executeStartWith();
//        rxJavaStrategy.executeCount();
//        rxJavaStrategy.executeTake();
//        rxJavaStrategy.executeLift();

        new SystemStrategy().execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_volley:
                VolleyTestActivity.Companion.openActivity(this);
                break;
            case R.id.tv_eventbus:
                EventBusTestActivity.openActivity(this);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unregister(MessageEvent.class, mObservable);
    }
}
