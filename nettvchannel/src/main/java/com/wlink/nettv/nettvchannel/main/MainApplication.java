package com.wlink.nettv.nettvchannel.main;

import android.app.Application;

import com.wlink.nettv.nettvchannel.data.DataManager;
import com.wlink.nettv.nettvchannel.di.component.ApplicationComponent;
import com.wlink.nettv.nettvchannel.di.component.DaggerApplicationComponent;
import com.wlink.nettv.nettvchannel.di.module.ApplicationModule;
import com.wlink.nettv.nettvchannel.utils.AppLogger;

import javax.inject.Inject;

public class MainApplication extends Application{

    @Inject
    DataManager mDataManager;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().
                applicationModule(new ApplicationModule(this)).build();

        applicationComponent.inject(this);

        AppLogger.init();

    }


    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
