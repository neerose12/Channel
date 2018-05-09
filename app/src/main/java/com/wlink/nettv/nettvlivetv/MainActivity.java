package com.wlink.nettv.nettvlivetv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wlink.nettv.nettvchannel.base.BaseActivity;
import com.wlink.nettv.nettvchannel.controller.channellist.ChannelListImplementor;
import com.wlink.nettv.nettvchannel.controller.channellist.ChannelListPresenter;
import com.wlink.nettv.nettvchannel.controller.channellist.ChannelListView;
import com.wlink.nettv.nettvchannel.controller.channellist.LiveTvActivity;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;
import com.wlink.nettv.nettvchannel.data.network.model.MovieModelResponse;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends LiveTvActivity{




    @Override
    protected int getResLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initAll() {
        getChannelList();
    }



    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void hideKeyboard() {

    }

//    @Override
//    public void channelList(List<MovieModelResponse.MovieModel> channelModelResponseList) {
//
//    }


    @Override
    public void OnApiError() {
        super.OnApiError();
    }
}
