package com.wlink.nettv.nettvchannel.base;

import com.androidnetworking.error.ANError;
import com.wlink.nettv.nettvchannel.data.DataManager;
import com.wlink.nettv.nettvchannel.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V mMvpView;
    private final DataManager mDataManager;
    private final SchedulerProvider schedulerProvider;
    private final CompositeDisposable compositeDisposable;

    @Inject
    public BasePresenter(DataManager mDataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable){
        this.mDataManager = mDataManager;
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    public V getmMvpView() {
        return mMvpView;
    }

    public void setmMvpView(V mMvpView) {
        this.mMvpView = mMvpView;
    }

    @Override
    public void onDetach() {
        compositeDisposable.dispose();
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }


    @Override
    public void handlerApiError(ANError error) {
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

}
