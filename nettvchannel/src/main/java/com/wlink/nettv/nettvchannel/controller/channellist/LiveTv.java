package com.wlink.nettv.nettvchannel.controller.channellist;

import android.util.Log;

import com.wlink.nettv.nettvchannel.base.BaseActivity;
import com.wlink.nettv.nettvchannel.data.network.ApiHeader;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;
import com.wlink.nettv.nettvchannel.data.network.model.NimbleToken;

import javax.inject.Inject;

public abstract class LiveTv extends BaseActivity implements ChannelListView,LiveTvChannel{

    @Inject
    ChannelListPresenter<ChannelListView> chan;

    LiveTvChannel liveTvChannel;
    boolean firstAppOpen = true;
    ChannelModelResponse channelModelResponses;

    @Override
    protected int getLayout() {
        return getResLayout();
    }


    public void setCallback(LiveTvChannel liveTvChannel){
        this.liveTvChannel = liveTvChannel;
    }

    @Override
    protected void init() {
        initAll();

    }

    protected abstract int getResLayout();
    protected abstract void initAll();
    public abstract void channelLists(ChannelModelResponse channelModelResponses);
    public abstract void nimbleToken(NimbleToken nimbleToken);

    public void getChannelList(){
        getNettvActivityComponent().inject(this);
        chan.onAttach(this);
        chan.channelList();
    }

    public void refreshToken(){
        chan.getNimbleToken();
    }

    @Override
    public void nimbleTokenValue(NimbleToken nimbleToken) {
        if(firstAppOpen){
            firstAppOpen  = false;
            channelLists(channelModelResponses);
        }
        nimbleToken(nimbleToken);
    }

    @Override
    public void channelList(ChannelModelResponse channelModelResponses) {
        this.channelModelResponses = channelModelResponses;
        chan.getNimbleToken();
    }


    @Override
    public void OnApiError(String msg) {

    }


    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

}
