package com.wlink.nettv.nettvlivetv.ui.playchannel;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import com.example.logapp.logger.Lg;
import com.example.logapp.logger.StartLogging;
import com.wlink.nettv.nettvchannel.controller.channellist.LiveTv;
import com.wlink.nettv.nettvchannel.controller.channellist.LiveTvChannel;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelCategory;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModel;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;
import com.wlink.nettv.nettvlivetv.base.BaseActivity;
import com.wlink.nettv.nettvlivetv.ui.displaychannel.CategoryListAdapter;
import com.wlink.nettv.nettvlivetv.R;
import com.wlink.nettv.nettvlivetv.ui.displaychannel.ChannelAndCategoryListFragment;
import com.wlink.nettv.nettvlivetv.util.KeyEvents;
import com.wlink.nettv.nettvlivetv.util.KeyEventsInterface;
import com.wlink.nettv.nettvlivetv.util.exception.MediaPlayerException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Main extends LiveTv implements LiveTvChannel,
        ChannelAndCategoryListFragment.FragmentCallback, KeyEventsInterface, SurfaceHolder.Callback {

    public ChannelModelResponse channelModelResponse;
    public List<ChannelCategory> channelCategories;
    public List<ChannelModel> channelModels;


    private MediaPlayer mediaPlayer;
    @BindView(R.id.surfaceview)
    SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;

    @Override
    protected int getResLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initAll() {
        showLoading();
        mediaPlayer = new MediaPlayer();
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        getChannelList();
    }

    @Override
    public void channelLists(ChannelModelResponse channelModelResponses) {
        this.channelModelResponse = channelModelResponses;
        this.channelCategories = channelModelResponses.getAllCategories();
        getChannelList(0);
        playChannel(0);
        openFragment();
    }

    private void openFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_main_class, new ChannelAndCategoryListFragment()).commit();
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mediaPlayer.setDisplay(holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }


    @Override
    public List<ChannelModel> getChannelList(int position) {
        this.channelModels = channelModelResponse.getChannels(channelCategories.get(position).getId());
        return channelModels;
    }

    @Override
    public void playChannel(int position) {
        Lg.d("CheckingHowFast");

        if (!isShowing()) {
            showLoading();
        }

        Lg.d("CheckingHowFast");
        String url = channelModels.get(position).getPath();
        mediaPlayer.reset();
        try {
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this,
                    "something wrong!\n" + e.toString(),
                    Toast.LENGTH_LONG).show();
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                if(isShowing()){
                    hideLoading();
                }
                mediaPlayer.start();
            }
        });

    }


}
