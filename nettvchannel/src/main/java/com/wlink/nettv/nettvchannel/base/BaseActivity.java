package com.wlink.nettv.nettvchannel.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


import com.wlink.nettv.nettvchannel.di.component.ActivityComponent;
import com.wlink.nettv.nettvchannel.di.component.DaggerActivityComponent;
import com.wlink.nettv.nettvchannel.di.module.AcitivityModule;
import com.wlink.nettv.nettvchannel.main.MainApplication;
import com.wlink.nettv.nettvchannel.utils.NetworkUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    ActivityComponent activityComponent;
    private Unbinder mUnBinder;

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    public void setActivityComponent(ActivityComponent activityComponent) {
        this.activityComponent = activityComponent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        activityComponent = DaggerActivityComponent.builder()
                .acitivityModule(new AcitivityModule(this))
                .applicationComponent(((MainApplication) getApplication()).getApplicationComponent())
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

    }

    @Override
    public void hideLoading() {

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
}
