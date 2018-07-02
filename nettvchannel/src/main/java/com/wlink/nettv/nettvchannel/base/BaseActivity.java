package com.wlink.nettv.nettvchannel.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


import com.wlink.nettv.nettvchannel.di.component.DaggerNettvActivityComponent;
import com.wlink.nettv.nettvchannel.di.component.NettvActivityComponent;
import com.wlink.nettv.nettvchannel.di.module.NettvAcitivityModule;
import com.wlink.nettv.nettvchannel.main.NettvApp;
import com.wlink.nettv.nettvchannel.utils.CommonUtils;
import com.wlink.nettv.nettvchannel.utils.NetworkUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    NettvActivityComponent nettvActivityComponent;
    private Unbinder mUnBinder;
    private ProgressDialog mProgressDialog;

    public NettvActivityComponent getNettvActivityComponent() {
        return nettvActivityComponent;
    }

    public void setNettvActivityComponent(NettvActivityComponent nettvActivityComponent) {
        this.nettvActivityComponent = nettvActivityComponent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        nettvActivityComponent = DaggerNettvActivityComponent.builder()
                .nettvAcitivityModule(new NettvAcitivityModule(this))
                .nettvApplicationComponent(((NettvApp) getApplication()).getNettvApplicationComponent())
                .build();
        setUnBinder(ButterKnife.bind(this));
        init();
    }

    private void setUnBinder(Unbinder bind) {
        mUnBinder = bind;
    }

    protected abstract int getLayout();
    protected abstract void init();



    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());

    }



    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public boolean isShowing() {
        return mProgressDialog.isShowing();
    }

    @Override
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void onFragmentAttached() {
    }


    public void onFragmentDetached(String tag) {
    }
}
