package com.wlink.nettv.nettvchannel.controller.channellist;

import android.util.Log;

import com.androidnetworking.common.ANResponse;
import com.androidnetworking.error.ANError;
import com.wlink.nettv.nettvchannel.base.BasePresenter;
import com.wlink.nettv.nettvchannel.data.DataManager;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;
import com.wlink.nettv.nettvchannel.data.network.model.MovieModelResponse;
import com.wlink.nettv.nettvchannel.utils.rx.SchedulerProvider;

import org.json.JSONArray;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class ChannelListImplementor<V extends ChannelListView> extends BasePresenter<V> implements ChannelListPresenter<V> {

    @Inject
    public ChannelListImplementor(DataManager mDataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(mDataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void channelList() {
        Log.d("checkingApiLog", "look i am here");
        getCompositeDisposable().add(getDataManager()
                .getChannelList()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<ChannelModelResponse>>() {
                    @Override
                    public void accept(List<ChannelModelResponse> channelModelResponses) throws Exception {
                        Log.d("checkingApiLog", channelModelResponses.size()+" ");
                        getmMvpView().channelList(channelModelResponses);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));
    }
}
