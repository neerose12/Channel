package com.wlink.nettv.nettvlivetv.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wlink.nettv.nettvchannel.controller.channellist.LiveTv;

public abstract class BaseActivity extends LiveTv {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        init();
    }
    protected abstract int getLayout();

    protected abstract void init();

    public void onFragmentAttached(){

    }

}
