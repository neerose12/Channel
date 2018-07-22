package com.wlink.nettv.nettvlivetv;

import android.app.Application;

import com.example.logapp.logger.StartLogging;
import com.example.logapp.utils.LogFile;
import com.wlink.nettv.nettvchannel.di.component.NettvActivityComponent;
import com.wlink.nettv.nettvchannel.injector.Injector;
import com.wlink.nettv.nettvchannel.main.NettvApp;
import com.wlink.nettv.nettvlivetv.di.component.ApplicationComponent;
import com.wlink.nettv.nettvlivetv.di.component.DaggerApplicationComponent;
import com.wlink.nettv.nettvlivetv.di.module.ApplicationModule;

import javax.inject.Inject;

public class MainApplication extends NettvApp {


    @Inject
    ApplicationComponent applicationComponent;

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        StartLogging.init(this);
//        AndroidNetworking.enableLogging();

        applicationComponent = DaggerApplicationComponent.builder().applicationModule(
               new ApplicationModule(this)).build();

//       applicationComponent.inject(this);
    }

    public void setApplicationComponent(ApplicationComponent applicationComponent){
        this.applicationComponent = applicationComponent;
    }
}
