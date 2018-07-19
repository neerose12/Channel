package com.wlink.nettv.nettvchannel.di.module;

import android.app.Application;
import android.content.Context;


import com.wlink.nettv.nettvchannel.data.AppDataManger;
import com.wlink.nettv.nettvchannel.data.DataManager;
import com.wlink.nettv.nettvchannel.data.network.ApiHeader;
import com.wlink.nettv.nettvchannel.data.network.ApiHelper;
import com.wlink.nettv.nettvchannel.data.network.AppApiHelper;
import com.wlink.nettv.nettvchannel.di.ApiInfo;
import com.wlink.nettv.nettvchannel.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class NettvApplicationModule {

    private final Application mApplication;

    public NettvApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    Application provideApplication(){
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provoideContext(){
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager providesDatamanager(AppDataManger appDataManger){
        return appDataManger;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return "Hello";
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHelper(@ApiInfo String mApiKey){
        return new ApiHeader.ProtectedApiHeader(mApiKey);
    }
}
