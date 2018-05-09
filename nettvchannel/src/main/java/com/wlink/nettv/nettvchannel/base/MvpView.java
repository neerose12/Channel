package com.wlink.nettv.nettvchannel.base;

public interface MvpView {

    boolean isNetworkConnected();
    void showLoading();
    void hideLoading();
    void hideKeyboard();
}
