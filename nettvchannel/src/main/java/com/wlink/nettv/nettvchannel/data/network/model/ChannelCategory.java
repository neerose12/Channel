package com.wlink.nettv.nettvchannel.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.inject.Singleton;

public class ChannelCategory {


    @SerializedName("id")
    int id;
    @SerializedName("category")
    String category;
    @SerializedName("channels")
    List<ChannelModel> channelModels;
}
