package com.wlink.nettv.nettvchannel.data.network;


import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interfaces.AnalyticsListener;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import org.json.JSONArray;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class AppApiHelper implements ApiHelper {


    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }


    @Override
    public Disposable doServerLoginApiCall() {
        return null;
    }

    public Observable<JSONArray> getChannelList() {

        AndroidNetworking.enableLogging();
        return Rx2AndroidNetworking.get(ApiEndPoints.CHANNEL)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .setAnalyticsListener(new AnalyticsListener() {
                    @Override
                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {

                    }
                })
                .getJSONArrayObservable();
    }
}
