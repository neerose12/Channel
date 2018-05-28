package com.wlink.nettv.nettvlivetv.di.module;

import android.app.Application;
import android.content.Context;


import com.wlink.nettv.nettvlivetv.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application){
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }


}
