package com.wlink.nettv.nettvchannel.controller.channellist;

import com.wlink.nettv.nettvchannel.base.MvpView;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;
import com.wlink.nettv.nettvchannel.data.network.model.NimbleToken;

import java.util.List;

public interface ChannelListView extends MvpView {

    void OnApiError(String msg);

    void channelList(ChannelModelResponse channelModelResponses);

    void nimbleTokenValue(NimbleToken nimbleToken);
}
