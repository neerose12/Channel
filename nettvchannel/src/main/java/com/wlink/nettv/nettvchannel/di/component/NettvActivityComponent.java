package com.wlink.nettv.nettvchannel.di.component;

import android.content.Context;


import com.wlink.nettv.nettvchannel.controller.channellist.LiveTv;
import com.wlink.nettv.nettvchannel.di.PerActivity;
import com.wlink.nettv.nettvchannel.di.module.NettvAcitivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = NettvApplicationComponent.class,modules = NettvAcitivityModule.class)
public interface NettvActivityComponent {

//    void inject(MainActivity activity);

    Context context();

    void inject(LiveTv liveTv);

//    void inject(MainActivity );

//    void inject(Splash splash);
//
//    void inject(LoginActivity loginActivity);
}
