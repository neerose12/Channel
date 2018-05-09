package com.wlink.nettv.nettvchannel.controller.channellist;

import com.wlink.nettv.nettvchannel.base.MvpPresenter;

public interface ChannelListPresenter<V extends ChannelListView> extends MvpPresenter<V> {

    void channelList();
}
