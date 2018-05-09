package com.wlink.nettv.nettvchannel.data.network;

import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;
import com.wlink.nettv.nettvchannel.data.network.model.MovieModelResponse;

import org.json.JSONArray;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public interface  ApiHelper {
    Disposable doServerLoginApiCall();

    Observable<JSONArray> getChannelList();
}
