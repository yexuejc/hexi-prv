package com.yexue.android.hexiprv.ui.main;

import android.widget.TextView;

import com.yexue.android.hexiprv.R;
import com.yexue.android.hexiprv.bean.ResultData;
import com.yexue.android.hexiprv.ui.base.MvpActivity;

import butterknife.Bind;

public class MainActivity extends MvpActivity<IMainView, MainPresenter> implements IMainView {

    @Bind(R.id.pptIco_list_all)
    TextView pptIcoListAll;
    @Bind(R.id.pptIco_list)
    TextView pptIcoList;

    @Override
    protected void onInitLayoutBefore() {
        loadUI(this, R.layout.activity_main);
    }

    @Override
    protected void onInitLayoutAfter() {
        showLoadingDialog();//显示加载框
        objBeanPresenter.loadInit();//到presenter去处理逻辑（加载数据）
    }

    @Override
    protected MainPresenter ceatePresenter() {
        return new MainPresenter(subscription);
    }

    @Override
    public void updateInit(String resultStr) {
        hideLoadingDialog();
        pptIcoListAll.setText(resultStr);
    }

    @Override
    public void updateList(String resultStr) {
        hideLoadingDialog();
        pptIcoList.setText(resultStr);
    }
}