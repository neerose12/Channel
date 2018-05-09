package com.wlink.nettv.nettvchannel.di.component;

import android.app.Application;
import android.content.Context;

import com.wlink.nettv.nettvchannel.data.DataManager;
import com.wlink.nettv.nettvchannel.di.ApplicationContext;
import com.wlink.nettv.nettvchannel.di.module.ApplicationModule;
import com.wlink.nettv.nettvchannel.main.MainApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainApplication application);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();

}
