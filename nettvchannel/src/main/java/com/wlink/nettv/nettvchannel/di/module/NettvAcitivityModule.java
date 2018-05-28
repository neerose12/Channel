package com.wlink.nettv.nettvchannel.di.module;


import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.wlink.nettv.nettvchannel.controller.channellist.ChannelListImplementor;
import com.wlink.nettv.nettvchannel.controller.channellist.ChannelListPresenter;
import com.wlink.nettv.nettvchannel.controller.channellist.ChannelListView;
import com.wlink.nettv.nettvchannel.di.PerActivity;
import com.wlink.nettv.nettvchannel.utils.rx.AppSchedulerProvider;
import com.wlink.nettv.nettvchannel.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class NettvAcitivityModule {

    Activity appCompatActivity;

    public NettvAcitivityModule(Activity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    Context context(){
        return appCompatActivity;
    }

    @Provides
    @PerActivity
    ChannelListPresenter<ChannelListView> provideChannelListPresenter
            (ChannelListImplementor<ChannelListView> channelListImplementor){
        return  channelListImplementor;
    }



    @Provides
    SchedulerProvider schedulerProvider(){
        return new AppSchedulerProvider();
    }

    @Provides
    CompositeDisposable compositeDisposable(){
        return new CompositeDisposable();
    }


}
