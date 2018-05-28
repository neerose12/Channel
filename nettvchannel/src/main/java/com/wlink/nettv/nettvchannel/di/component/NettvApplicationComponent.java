package com.wlink.nettv.nettvchannel.di.component;

import android.app.Application;
import android.content.Context;

import com.wlink.nettv.nettvchannel.data.DataManager;
import com.wlink.nettv.nettvchannel.di.ApplicationContext;
import com.wlink.nettv.nettvchannel.di.module.NettvApplicationModule;
import com.wlink.nettv.nettvchannel.main.NettvApp;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NettvApplicationModule.class)
public interface NettvApplicationComponent {


    void inject(NettvApp application);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();

}
