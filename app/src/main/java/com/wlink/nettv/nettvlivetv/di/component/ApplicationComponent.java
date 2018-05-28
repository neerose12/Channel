package com.wlink.nettv.nettvlivetv.di.component;

import com.wlink.nettv.nettvlivetv.MainApplication;
import com.wlink.nettv.nettvlivetv.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
//    void inject(MainApplication mainApplication);

}
