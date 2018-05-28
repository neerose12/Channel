package com.wlink.nettv.nettvchannel.base;

import android.support.annotation.StringRes;

public interface MvpView {

    boolean isNetworkConnected();
    void showLoading();
    void hideLoading();
    void hideKeyboard();
    boolean isShowing();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);
}
