package com.wlink.nettv.nettvchannel.data;

import android.content.Context;

import com.wlink.nettv.nettvchannel.data.network.ApiHelper;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;
import com.wlink.nettv.nettvchannel.data.network.model.MovieModelResponse;
import com.wlink.nettv.nettvchannel.di.ApplicationContext;

import org.json.JSONArray;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;
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
    public Observable<JSONArray> getChannelList() {
        return mApiHelper.getChannelList();
    }


}
