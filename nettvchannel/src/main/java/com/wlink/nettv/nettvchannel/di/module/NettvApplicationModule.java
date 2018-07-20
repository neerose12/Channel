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
        return "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjNhNTk1Mjc0YzYxNWI5OGYxMTc1Y2QzYTFmYTYzZGM2YjI0NWE3MGMwZDdmNjEyNWQyYTQxMjFkMzc1ZTIzNTFiMDRmNGVhMDM2Nzc0MGEzIn0.eyJhdWQiOiIyIiwianRpIjoiM2E1OTUyNzRjNjE1Yjk4ZjExNzVjZDNhMWZhNjNkYzZiMjQ1YTcwYzBkN2Y2MTI1ZDJhNDEyMWQzNzVlMjM1MWIwNGY0ZWEwMzY3NzQwYTMiLCJpYXQiOjE1MzIwNzAzODIsIm5iZiI6MTUzMjA3MDM4MiwiZXhwIjoxNTYzNjA2MzgyLCJzdWIiOiI2Iiwic2NvcGVzIjpbInBlcmZvcm1BZG1pbnNUYXNrIl19.hqI2fW1F_fqVHWELZDjzSGYW-XzHEg4dXzFNeKyKec40nYEtMm6Bd7sTF5uMHXNwlhfpPO7fYp0EDHndvm7tFdaqHBxIx6_M8aX5dGYy88VbXIsAILkUIPXTfWGmKyBH0xsyo76WYGfyuTuJGQiWVd-z4NhwwuFCLxkrEwQ0fBImrBMYsVxPPdyqFf4Ifh8tOgSMGsZoi2-MkDCx4lmH_peqYhQAJnsKTqJayZxN6PU7FkvdOrkGraAnog7TOjYISNTjwzZTuuRVtfGW5UG19KpqbEIBYGs-gzcUnk5WyWBPOe0OVVT1hb4OL_xkks76wP0O8HDd1DF7M3DObY9MKmXjkuHjHGFcSOHvMNflXAIne095FozJC0F7a4oqKgLI4utAEJrWp6jblQGU-JM9KY45Idl6A9K8k3MOB3ANLJ3EoVsX9i9LfEfpaUgfmkfHGF4ssVch5ZSor1gdwkrzrs1HpAWNQRXNLILEmDSWzKnYQd5MOnNrTi2FXHWamHM1bsE2LYuAqmbQ6REj_9Hk-CGEZtzbKuyO5xWapsO4zW494hB3uOExFnVnfSZh344zGeITG9slZI3QgGajE1WdHMSQEPgNrN32VHcsF_SznsgRpq25LDsu_i1QBZL4eHsAtHvihjux0nRE99w4Ylc8zgYfNV0N-A7FM14VjV-rUuw";
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHelper(@ApiInfo String mApiKey){
        return new ApiHeader.ProtectedApiHeader(mApiKey);
    }
}
