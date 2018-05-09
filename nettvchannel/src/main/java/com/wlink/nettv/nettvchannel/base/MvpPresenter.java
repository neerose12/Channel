package com.wlink.nettv.nettvchannel.base;

import com.androidnetworking.error.ANError;

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);
    void onDetach();
    void handlerApiError(ANError error);

}
