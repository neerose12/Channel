package com.wlink.nettv.nettvchannel.data.network.model;

import com.google.gson.annotations.SerializedName;

public class ChannelCategoryMap {

    @SerializedName("channel_id")
    int channelId;
    @SerializedName("category_id")
    int categoryId;
    @SerializedName("priority")
    int priority;

    public int getChannelId() {
        return channelId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getPriority() {
        return priority;
    }


    @Override
    public String toString() {
        return "ChannelCategoryMap{" +
                "channelId=" + channelId +
                ", categoryId=" + categoryId +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int hashCode() {
        return categoryId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof ChannelCategory))
            return false;
        if (obj == this)
            return true;
        return this.getCategoryId() == ((ChannelCategory) obj).getId();
    }
}
