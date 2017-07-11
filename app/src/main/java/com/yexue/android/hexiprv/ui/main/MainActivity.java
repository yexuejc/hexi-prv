package com.yexue.android.hexiprv.ui.main;

import android.os.Bundle;
import android.widget.TextView;

import com.yexue.android.hexiprv.R;
import com.yexue.android.hexiprv.ui.base.MvpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends MvpActivity<IMainView, MainPresenter> implements IMainView {

    @Bind(R.id.pptIco_list)
    TextView pptIcoList;

    @Override
    protected void onInitLayoutBefore() {
        loadUI(this, R.layout.activity_main);
    }

    @Override
    protected void onInitLayoutAfter() {
        objBeanPresenter.loadInit();
    }

    @Override
    protected MainPresenter ceatePresenter() {
        return new MainPresenter(subscription);
    }
}