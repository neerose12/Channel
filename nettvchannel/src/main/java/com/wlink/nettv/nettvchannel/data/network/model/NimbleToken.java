package com.wlink.nettv.nettvchannel.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NimbleToken implements Serializable {

    @SerializedName("wmsauthsign")
    String nimbleToken;

    public String getNimbleToken() {
        return nimbleToken;
    }
}
