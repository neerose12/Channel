package com.wlink.nettv.nettvchannel.data;

import android.content.Context;

import com.wlink.nettv.nettvchannel.data.network.ApiHelper;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;
import com.wlink.nettv.nettvchannel.data.network.model.NimbleToken;
import com.wlink.nettv.nettvchannel.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

@Singleton
public class AppDataManger implements DataManager {

    Context mContext;
    ApiHelper mApiHelper;

    @Inject
    public AppDataManger(@ApplicationContext Context context,
                          ApiHelper apiHelper) {
        mContext = context;
        mApiHelper = apiHelper;
    }

    @Override
    public Disposable doServerLoginApiCall() {
        return null;
    }

    @Override
    public Observable<ChannelModelResponse> getChannels() {
        return mApiHelper.getChannels();
    }

    @Override
    public Observable<NimbleToken> getNimbleToken() {
        return mApiHelper.getNimbleToken();
    }


}
