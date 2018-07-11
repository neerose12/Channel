package com.wlink.nettv.nettvchannel.controller.channellist;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.wlink.nettv.nettvchannel.base.BasePresenter;
import com.wlink.nettv.nettvchannel.data.DataManager;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;
import com.wlink.nettv.nettvchannel.utils.rx.SchedulerProvider;

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
        getCompositeDisposable().add(getDataManager()
                .getChannels()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<ChannelModelResponse>() {
                    @Override
                    public void accept(ChannelModelResponse channelModelResponses) {
                        getmMvpView().channelList(channelModelResponses);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        ANError anError = (ANError)throwable;
                        Log.d("CheckingError",anError.getErrrMessage());
                        getmMvpView().OnApiError(anError.getErrrMessage());
                    }
                }));
    }
}
