package com.yexue.android.hexiprv.sys;

import android.util.Log;

import rx.Observer;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.sys
 * @explain
 * @time 2017/7/11 15:00
 */
public class BaseObserver<T> implements Observer<T> {
    public HttpCallBack callBack;

    public BaseObserver(HttpCallBack callBack) {
        this.callBack = callBack;
    }

    /**
     * 事件队列完结
     */
    @Override
    public void onCompleted() {
        callBack.onComplete(0, null);
    }

    /**
     * 失败
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        callBack.onComplete(500, null);
        e.printStackTrace();
    }

    /**
     * 本次事件成功
     *
     * @param t
     */
    @Override
    public void onNext(T t) {
        callBack.onComplete(200, t);
    }

    public interface HttpCallBack<T> {
        /**
         * <pre>
         *     code:
         *     200:onNext
         *     500:onError
         *     0:onCompleted
         * </pre>
         *
         * @param code <
         * @param t
         */
        public void onComplete(int code, T t);
    }
}
