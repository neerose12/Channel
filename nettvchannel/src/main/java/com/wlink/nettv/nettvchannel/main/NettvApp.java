package com.wlink.nettv.nettvchannel.main;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.wlink.nettv.nettvchannel.data.DataManager;
import com.wlink.nettv.nettvchannel.di.component.NettvApplicationComponent;
import com.wlink.nettv.nettvchannel.di.component.DaggerNettvApplicationComponent;
import com.wlink.nettv.nettvchannel.di.module.NettvApplicationModule;

import javax.inject.Inject;

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
