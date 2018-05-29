package com.wlink.nettv.nettvchannel.data.network.model;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.logapp.logger.Lg;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import io.reactivex.Observable;

public class ChannelModelResponse implements Serializable{


    @SerializedName("categories")
    List<ChannelCategory> categories;
    @SerializedName("channels")
    List<ChannelModel> channelModels;
    @SerializedName("category_channel_map")
    List<ChannelCategoryMap> channelCategoryMaps;

    public List<ChannelCategory> getCategories() {
        return categories;
    }
    public List<ChannelModel> getChannelModels() {
        return channelModels;
    }


    public  List<ChannelCategoryMap> getChannelCategoryMaps() {
        return channelCategoryMaps;
    }


    public List<ChannelCategory> getAllCategories() {
        List<ChannelCategory> channelCategories = new ArrayList<>();
        for (ChannelCategoryMap channelCategoryMap : getChannelCategoryMaps()) {
            if (!channelCategories.contains(getCategoryWithId(channelCategoryMap.getCategoryId()))) {
                channelCategories.add(getCategoryWithId(channelCategoryMap.getCategoryId()));
            }
        }
        return channelCategories;
    }


    private ChannelCategory getCategoryWithId(int categoryId) {
        ChannelCategory channel = null;
        for (ChannelCategory channelCategory : getCategories()) {
            if (channelCategory.getId() == categoryId) {
                channel = channelCategory;
                break;
            }
        }

        return channel;
    }

    public List<ChannelModel> getChannels(int categoryId) {
        List<ChannelModel> channelModels = new ArrayList<>();
        for (ChannelCategoryMap channelCategoryMap : getChannelCategoryMaps()) {
            if (channelCategoryMap.getCategoryId() == categoryId) {
                channelModels.add(getChannelWithCategory(channelCategoryMap.getChannelId()));
            }
        }
        return channelModels;
    }

    private ChannelModel getChannelWithCategory(int channelId) {
        ChannelModel channelModel = null;
        for (ChannelModel channel : getChannelModels()) {
            if (channel.getId() == channelId) {
                channelModel = channel;
                break;
            }
        }
        return channelModel;
    }

}