package com.yexue.android.hexiprv.ui.main;

import android.content.Context;
import android.util.Log;

import com.yexue.android.hexiprv.R;
import com.yexue.android.hexiprv.bean.ResultData;
import com.yexue.android.hexiprv.model.impl.PptIcoImpl;
import com.yexue.android.hexiprv.sys.BaseObserver;
import com.yexue.android.hexiprv.ui.base.BasePresenter;
import com.yexue.android.hexiprv.utils.T;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.main
 * @explain
 * @time 2017/7/11 11:50
 */
public class MainPresenter extends BasePresenter<IMainView> {
    Subscription subscription;

    public MainPresenter(Subscription subscription) {
        super();
        this.subscription = subscription;
    }

    /**
     * <pre>
     *  进入app初始化
     *      https://shop.globalhexi.cn/shop/pptIco/listAll
     * </pre>
     */
    public void loadInit() {
        subscription = PptIcoImpl.getPptIco()
                .listALL()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getInitObservable());
    }

    private BaseObserver getInitObservable() {
        return new BaseObserver<ResultData>(new BaseObserver.HttpCallBack<ResultData>() {
            @Override
            public void onComplete(int code, ResultData resultData) {
                switch (code) {
                    case 0:
                        break;
                    case 200:
                        Log.e("resule",resultData.toString());
                        break;
                    case 500:
                        T.showShort(getContext(), getContext().getString(R.string.error_code_500));
                        break;
                }
            }
        });
    }
}
