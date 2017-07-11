package com.yexue.android.hexiprv.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.yexue.android.hexiprv.sys.AppUtils;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.base
 * @explain
 * @time 2017/7/11 11:29
 */
public abstract class BaseActivity extends Activity {
    protected Activity activity;
    protected Subscription subscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onInitLayoutBefore();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppUtils.unsubscribe(subscription);
    }

    /**
     * <pre>
     * 初始化注解
     * 在实现子类的onInitLayoutBefore()中重载
     * </pre>
     *
     * @param activity
     * @param id
     */
    protected void loadUI(Activity activity, int id) {
        setContentView(id);
        ButterKnife.bind(activity);
        this.activity = activity;
    }

    /**
     * <pre>
     * 初始化之前
     * 在该方法调用loadUI()
     * </pre>
     */
    protected abstract void onInitLayoutBefore();

    /**
     * <pre>
     * 初始化之后
     * 直接继承需要手动调用该方法
     * </pre>
     */
    protected abstract void onInitLayoutAfter();
}
