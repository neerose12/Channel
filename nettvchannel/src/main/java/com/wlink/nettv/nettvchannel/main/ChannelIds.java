package com.wlink.nettv.nettvchannel.main;

import com.google.gson.annotations.SerializedName;
import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Channels")
public class ChannelIds extends ParseObject {

    @SerializedName("id")
    int id;
    @SerializedName("type")
    String type;

    public ChannelIds(int id, String type) {
        this.id = id;
        this.type = type;
    }
}
