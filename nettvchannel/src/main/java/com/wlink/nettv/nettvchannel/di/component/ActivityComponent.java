package com.wlink.nettv.nettvchannel.di.component;

import android.content.Context;


import com.wlink.nettv.nettvchannel.controller.channellist.LiveTvActivity;
import com.wlink.nettv.nettvchannel.di.PerActivity;
import com.wlink.nettv.nettvchannel.di.module.AcitivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = AcitivityModule.class)
public interface ActivityComponent {

//    void inject(MainActivity activity);

    Context context();

    void inject(LiveTvActivity liveTvActivity);

//    void inject(MainActivity );

//    void inject(Splash splash);
//
//    void inject(LoginActivity loginActivity);
}
