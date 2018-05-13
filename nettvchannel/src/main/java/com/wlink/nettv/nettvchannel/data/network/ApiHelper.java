package com.wlink.nettv.nettvchannel.data.network;

import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public interface  ApiHelper {
    Disposable doServerLoginApiCall();

    Observable<List<ChannelModelResponse>> getChannelList();
}
