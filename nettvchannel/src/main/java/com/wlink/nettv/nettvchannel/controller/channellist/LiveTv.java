package com.wlink.nettv.nettvchannel.controller.channellist;

import com.wlink.nettv.nettvchannel.base.BaseActivity;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;

import javax.inject.Inject;

public abstract class LiveTv extends BaseActivity implements ChannelListView,LiveTvChannel{

    @Inject
    ChannelListPresenter<ChannelListView> chan;

    LiveTvChannel liveTvChannel;

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

    public void getChannelList(){
        getNettvActivityComponent().inject(this);
        chan.onAttach(this);
        chan.channelList();
    }

    @Override
    public void channelList(ChannelModelResponse channelModelResponses) {
        channelLists(channelModelResponses);

    }


    @Override
    public void OnApiError() {

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
