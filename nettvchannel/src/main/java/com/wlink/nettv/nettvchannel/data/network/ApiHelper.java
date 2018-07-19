package com.wlink.nettv.nettvchannel.data.network;

import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;
import com.wlink.nettv.nettvchannel.data.network.model.NimbleToken;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public interface  ApiHelper {
    Disposable doServerLoginApiCall();
    Observable<ChannelModelResponse> getChannels();
    Observable<NimbleToken> getNimbleToken();
}
