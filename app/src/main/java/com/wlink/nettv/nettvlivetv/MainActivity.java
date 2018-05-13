package com.wlink.nettv.nettvlivetv;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import com.wlink.nettv.nettvchannel.controller.channellist.LiveTvActivity;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends LiveTvActivity {


    @BindView(R.id.rv_category_list)
    RecyclerView categoryList;


    @Override
    protected int getResLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initAll() {
        getChannelList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        categoryList.setLayoutManager(linearLayoutManager);

        playChannel();
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

    @Override
    protected void channelLists(List<ChannelModelResponse> channelModelResponses) {
        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(channelModelResponses,MainActivity.this);
        categoryList.setAdapter(categoryListAdapter);
    }

    @Override
    public void OnApiError() {
        super.OnApiError();
    }



    public void playChannel(){
    }


}
