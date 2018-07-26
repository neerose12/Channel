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
        return "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjE3Y2U1MjVlNDIxYmNjMTQ4MDViMzZlYzAyZDk5NzhiNDY5NDIwYTExOWZjZmY4OWY0ZjNmNGZlOTNmNTAzYzExYjMzMDdhOWE1MDBkYTZiIn0.eyJhdWQiOiI2IiwianRpIjoiMTdjZTUyNWU0MjFiY2MxNDgwNWIzNmVjMDJkOTk3OGI0Njk0MjBhMTE5ZmNmZjg5ZjRmM2Y0ZmU5M2Y1MDNjMTFiMzMwN2E5YTUwMGRhNmIiLCJpYXQiOjE1MzI2MDA2MjYsIm5iZiI6MTUzMjYwMDYyNiwiZXhwIjoxNTY0MTM2NjI2LCJzdWIiOiI4Iiwic2NvcGVzIjpbInN1YnNjcmliZXIiXX0.MUALeeHs-Z6T8czSMKtrFr7kii2pf6cZQ-DOR-mesymaOUCt1PTLtduiqgkE8eh7MQLX_4R7p5ae0DtxUIapOOSUCzddjPI57h71iVeFRqXVVo4EQe8tQrJ6JWzfkc0JttqC6ImzKK3D1RR4OcLB_NnoZWWEwtXBo7LP7zVO_jLVLjg3NOau8Cri0pLmecT9aKaR5K1rHyXEinqWcaFxIuiu0yrMg7_ASGcngZydG__hSCCPNyOa-7imfLRDcXJ4T397x-aHXA7ABzQPXCCRta_NCMndUse_nmCWlRjlLLNXABD8-kMBXt73ueza-65PjNV0r6q3JKNmo2jDnSaaOvMjp6i0BN5KXzrQZyM8PZwaLOnrZs9wqWSGjOtfzUwQiuTo69MAuUvVrVxgpoo5WeJ0iFxYaUT0dpyj-g9lQeRE-zLYyp2gqZqXHW3KG2FTlYaRmycB4ahf71wfnoiPA6Y67-m8oBDn2MgUkE1J50oRR4bTzbQYtDqa3Ksepj8Pl2t_vcA0rk_G42rhBMkb5Lq2twV78OZzOlaqZ501XXNFCxk7-UTJEPQkv0KpXgJnwu63x1v64gmjRaEYCFGkqlarwHBGGISKLPVQBsF5Ng135pgli6i8TMpDDJ7bbD_KODRheR68Taptns_hJxznkGPOyxaIE19J8Qu7Z4jiZ04";
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHelper(@ApiInfo String mApiKey){
        return new ApiHeader.ProtectedApiHeader(mApiKey);
    }
}
