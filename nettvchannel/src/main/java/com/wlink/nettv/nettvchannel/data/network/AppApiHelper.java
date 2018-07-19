package com.wlink.nettv.nettvchannel.data.network;


import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interfaces.AnalyticsListener;
import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;
import com.wlink.nettv.nettvchannel.data.network.model.NimbleToken;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
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

    @Override
    public Observable<ChannelModelResponse> getChannels() {
        Log.d("CHeck9ingAiHerader", mApiHeader.getProtectedApiHeader().getAccessToken());
        return Rx2AndroidNetworking.get(ApiEndPoints.CHANNEL)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .setAnalyticsListener(new AnalyticsListener() {
                    @Override
                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {

                    }
                })
                .getObjectObservable(ChannelModelResponse.class);
    }

    @Override
    public Observable<NimbleToken> getNimbleToken() {
        return Rx2AndroidNetworking.get(ApiEndPoints.NIMBLE)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .setAnalyticsListener(new AnalyticsListener() {
                    @Override
                    public void onReceived(long timeTakenInMillis, long bytesSent, long bytesReceived, boolean isFromCache) {

                    }
                })
                .getObjectObservable(NimbleToken.class);    }


}
