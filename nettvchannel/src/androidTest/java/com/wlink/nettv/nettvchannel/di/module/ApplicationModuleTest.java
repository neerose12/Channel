package com.wlink.nettv.nettvchannel.di.module;

import android.app.Application;
import android.content.Context;

import com.wlink.nettv.nettvchannel.data.AppDataManger;
import com.wlink.nettv.nettvchannel.data.network.ApiHeader;
import com.wlink.nettv.nettvchannel.data.network.ApiHelper;
import com.wlink.nettv.nettvchannel.di.ApiInfo;
import com.wlink.nettv.nettvchannel.di.ApplicationContext;

import org.junit.Test;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.junit.Assert.*;

@Module
public class ApplicationModuleTest {

    private Application application;

    public ApplicationModuleTest(Application application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @ApplicationContext
    Context provoideContext() {
        return application;
    }

    @Provides
    @Singleton
    AppDataManger providesDatamanager(AppDataManger appDataManger) {
        return appDataManger;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(ApiHelper apiHelper) {
        return apiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return "hello";
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHelper(ApiHeader.ProtectedApiHeader apiHeader) {
        return apiHeader;
    }
}