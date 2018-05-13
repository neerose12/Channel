package com.wlink.nettv.nettvlivetv;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import com.wlink.nettv.nettvchannel.base.BaseActivity;

import java.io.IOException;

import butterknife.BindView;

public class MediaPlayActivity extends BaseActivity implements SurfaceHolder.Callback,MediaPlayer.OnPreparedListener{

    private MediaPlayer mediaPlayer;
    @BindView(R.id.surfaceview)
    SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;

    @Override
    protected int getLayout() {
        return R.layout.media_play;
    }

    @Override
    protected void init() {
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDisplay(holder);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setOnPreparedListener(this);
        try {
            mediaPlayer.setDataSource("https://www.w3schools.com/html/mov_bbb.mp4");
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this,
                    "something wrong!\n" + e.toString(),
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        surfaceView.setVisibility(View.VISIBLE);
        mediaPlayer.start();
    }

}
