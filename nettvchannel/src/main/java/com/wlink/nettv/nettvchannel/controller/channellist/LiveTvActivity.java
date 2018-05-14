package com.wlink.nettv.nettvchannel.controller.channellist;

import com.wlink.nettv.nettvchannel.base.BaseActivity;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;

import java.util.List;

import javax.inject.Inject;

public abstract class LiveTvActivity extends BaseActivity implements ChannelListView{

    @Inject
    ChannelListPresenter<ChannelListView> chan;

    @Override
    protected int getLayout() {
        return getResLayout();
    }


    @Override
    protected void init() {
        initAll();

    }

    protected abstract int getResLayout();
    protected abstract void initAll();

    public void getChannelList(){
        getActivityComponent().inject(this);
        chan.onAttach(this);
        chan.channelList();
    }

    @Override
    public void channelList(List<ChannelModelResponse> channelModelResponses) {
        channelLists(channelModelResponses);
    }

    protected abstract void channelLists(List<ChannelModelResponse> channelModelResponses);

    @Override
    public void OnApiError() {

    }
}
