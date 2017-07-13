package com.yexue.android.hexiprv.ui.main;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yexue.android.hexiprv.R;
import com.yexue.android.hexiprv.bean.ResultData;
import com.yexue.android.hexiprv.bean.ResultPptIcoGsonFormat;
import com.yexue.android.hexiprv.bean.ResultPptIcoItem;
import com.yexue.android.hexiprv.model.impl.PptIcoImpl;
import com.yexue.android.hexiprv.sys.BaseObserver;
import com.yexue.android.hexiprv.ui.base.BasePresenter;
import com.yexue.android.hexiprv.utils.T;

import java.io.File;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
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
        /***
         * 请求第一种方式
         */
        subscription = PptIcoImpl.getPptIco()
                .listALL()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getInitObservable(ResultPptIcoGsonFormat.class));
        loadList("SY_BOT_TB");
    }

    private <S> BaseObserver getInitObservable(final Class<S> resultDataClass) {
        return new BaseObserver<ResultData<S>>(new BaseObserver.HttpCallBack<ResultData<S>>() {
            @Override
            public void onComplete(int code, ResultData<S> resultDataClass) {
                onComplete4Init(code, resultDataClass);//okHttp请求网络之后回调
            }
        });
    }

    private <S> void onComplete4Init(int code, ResultData<S> resultDataClass) {
        String resultStr = "";
        switch (code) {
            case 200://请求成功
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(resultDataClass.toString());
                System.out.println(json);
                Log.e("resule", json);
                resultStr = json;
                break;
            case 500://请求失败
                T.showShort(getContext(), getContext().getString(R.string.error_code_500));
                break;
        }
        //返回到UI的处理 *ps: 更改UI数据通过view回调到UI(activity)*
        IMainView view = getView();
        if (view != null) {
            view.updateInit(resultStr);
        }
    }

    /**
     * 获取指定图标
     *
     * @param pptKey
     */
    public void loadList(String pptKey) {
        /**
         * 请求第二种方式
         */
        subscription = PptIcoImpl.getPptIco()
                .list(pptKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(BaseObserver.newSubscriber(subscription,new Action1<ResultPptIcoItem>() {
                    @Override
                    public void call(ResultPptIcoItem resultPptIcoItem) {
                        //TODO 回调失败
                        onComplete4List(resultPptIcoItem);
                    }
                }));
    }

    private void onComplete4List(ResultPptIcoItem resultDataClass) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(resultDataClass.toString());
        Log.e("resule", json);
        IMainView view = getView();
        if (view != null) {
            view.updateList(json);
        }
    }

    public void uploadImg(File file, String method) {


    }
}
