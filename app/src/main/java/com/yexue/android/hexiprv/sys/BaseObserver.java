package com.yexue.android.hexiprv.sys;

import android.util.Log;

import com.yexue.android.hexiprv.bean.ResultData;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.sys
 * @explain 完整BaseObserver
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
        //callBack.onComplete(0, null);
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

    /**
     * 创建观察者
     * @param callBack
     * @return
     */
    public static <T> BaseObserver newObservable(HttpCallBack<? super T> callBack) {
        return new BaseObserver<T>(callBack);
    }
    /**
     * 创建观察者
     *
     * @param onNext
     * @param <T>
     * @return
     */
    public static <T> Subscriber newSubscriber(final Subscription subscription, final Action1<? super T> onNext) {
        return new Subscriber<T>() {


            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(T t) {
                //TODO subscription.isUnsubscribed()=true
                if (!subscription.isUnsubscribed()) {
                    onNext.call(t);
                }
            }

        };
    }
}
