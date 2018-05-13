package com.wlink.nettv.nettvchannel.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChannelModelResponse  {
//
//    List<ChannelCategory> categories;
//
//    public List<ChannelCategory> getCategories() {
//        return categories;
//    }


    @SerializedName("id")
    int id;
    @SerializedName("category")
    String category;
    @SerializedName("channels")
    List<ChannelModel> channelModels;


    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public List<ChannelModel> getChannelModels() {
        return channelModels;
    }
}
