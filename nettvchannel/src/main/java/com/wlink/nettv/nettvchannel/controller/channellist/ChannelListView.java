package com.wlink.nettv.nettvchannel.controller.channellist;

import com.wlink.nettv.nettvchannel.base.MvpView;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;

import java.util.List;

public interface ChannelListView extends MvpView {

    void OnApiError();

    void channelList(List<ChannelModelResponse> channelModelResponses);
}
