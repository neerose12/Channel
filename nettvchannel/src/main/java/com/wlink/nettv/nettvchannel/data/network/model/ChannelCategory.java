package com.wlink.nettv.nettvchannel.data.network.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ChannelCategory extends ChannelModelResponse{

    @SerializedName("id")
    int id;
    @SerializedName("category")
    String category;
    @SerializedName("logo")
    String logo;
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

    public String getLogo() {
        return logo;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof ChannelCategory))
            return false;
        if (obj == this)
            return true;
        return this.getId() == ((ChannelCategory) obj).getId();
    }


}
