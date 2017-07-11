package com.yexue.android.hexiprv.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.base
 * @explain
 * @time 2017/7/11 11:42
 */
public abstract class MvpActivity<V, T extends BasePresenter<V>> extends BaseActivity {
    protected T objBeanPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        objBeanPresenter = ceatePresenter();
        objBeanPresenter.attachView((V) this);
        objBeanPresenter.attachContext(this);
        onInitLayoutAfter();
    }

    /**
     * 创建Presenter
     *
     * @return
     */
    protected abstract T ceatePresenter();

    @Override
    protected void onDestroy() {
        objBeanPresenter.detachView();
        super.onDestroy();
    }

}
