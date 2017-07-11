package com.yexue.android.hexiprv.sys;

import rx.Subscription;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.sys
 * @explain 系统控制处理
 * @time 2017/7/11 11:35
 */
public class AppUtils {

    /**
     * Subscription 销毁
     * @param subscription
     */
    public static void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
