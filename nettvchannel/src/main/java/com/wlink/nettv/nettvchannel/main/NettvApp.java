package com.wlink.nettv.nettvchannel.main;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.androidnetworking.AndroidNetworking;
import com.wlink.nettv.nettvchannel.data.DataManager;
import com.wlink.nettv.nettvchannel.di.component.NettvApplicationComponent;
import com.wlink.nettv.nettvchannel.di.component.DaggerNettvApplicationComponent;
import com.wlink.nettv.nettvchannel.di.module.NettvApplicationModule;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class NettvApp extends MultiDexApplication{

    @Inject
    DataManager mDataManager;

    private NettvApplicationComponent nettvApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        nettvApplicationComponent = DaggerNettvApplicationComponent.builder().
                nettvApplicationModule(new NettvApplicationModule(this)).build();

        nettvApplicationComponent.inject(this);

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                . writeTimeout(120, TimeUnit.SECONDS)
                .build();

        AndroidNetworking.initialize(getApplicationContext(),okHttpClient);
    }

    public static void init(){

    }

    public NettvApplicationComponent getNettvApplicationComponent() {
        return nettvApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setNettvApplicationComponent(NettvApplicationComponent nettvApplicationComponent) {
        this.nettvApplicationComponent = nettvApplicationComponent;
    }
}
