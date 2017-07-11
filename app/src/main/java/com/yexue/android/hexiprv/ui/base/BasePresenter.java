package com.yexue.android.hexiprv.ui.base;

import android.content.Context;

import com.yexue.android.hexiprv.sys.AppUtils;

import java.lang.ref.WeakReference;

import rx.Subscription;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.base
 * @explain
 * @time 2017/7/11 11:29
 */
public abstract class BasePresenter<T> {

    // View引用
    // IObjBeanView mObjBeanView;
    // 弱引用：只要GC开始，就回收
    protected WeakReference<T> mViewRef;
    protected WeakReference<Context> mContextRef;

    /**
     * 初始化mViewRef
     *
     * @param view
     */
    protected void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    /**
     * 防止发生意外，构建一个备用context
     */
    private Context content;

    protected void attachContext(Context con) {
        this.content = content;
        mContextRef = new WeakReference<Context>(con);
    }

    /**
     * 销毁mViewRef
     */
    protected void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
        }
        if (mContextRef != null) {
            mContextRef.clear();
        }
    }

    /**
     * 获取mViewRef
     *
     * @return
     */
    protected T getView() {
        return mViewRef.get();
    }

    protected Context getContext() {
        if (mContextRef != null) {
            return mContextRef.get();
        } else {
            return this.content;
        }
    }

}
