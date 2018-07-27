package com.wlink.nettv.nettvchannel.main;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.multidex.MultiDexApplication;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.parse.Parse;
import com.parse.ParseObject;
import com.wlink.nettv.nettvchannel.data.DataManager;
import com.wlink.nettv.nettvchannel.data.network.ApiHelper;
import com.wlink.nettv.nettvchannel.di.component.NettvApplicationComponent;
import com.wlink.nettv.nettvchannel.di.component.DaggerNettvApplicationComponent;
import com.wlink.nettv.nettvchannel.di.module.NettvApplicationModule;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;


public class NettvApp extends MultiDexApplication {

    @Inject
    DataManager mDataManager;
    Context mContext;
    private NettvApplicationComponent nettvApplicationComponent;
    public static String accessToken;
    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = getApplicationContext();
        try {
            Context myContext = createPackageContext("np.com.nettv.launcher", MODE_PRIVATE);
            SharedPreferences pref = myContext.getSharedPreferences("auth_pref", MODE_MULTI_PROCESS);
            accessToken = pref.getString("key_result_refresh", "null");
            Toast.makeText(this, accessToken, Toast.LENGTH_SHORT).show();
            Log.d("CHeckingAcessToken", accessToken);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        nettvApplicationComponent = DaggerNettvApplicationComponent.builder().
                nettvApplicationModule(new NettvApplicationModule(this)).build();

        nettvApplicationComponent.inject(this);

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("oHp9Gc7eiOr5IlABf1gD7u8DfT5WRSIwJILZMae8")
                .clientKey("Dj0HogzdGSUhxwaNXV1SIbZdXraG6E9DzqP0k4ib")
                .server("https://parseapi.back4app.com/")
                .build()
        );

        AndroidNetworking.initialize(getApplicationContext(), okHttpClient);
        AndroidNetworking.enableLogging();
    }

    public static void init() {

    }

    public NettvApplicationComponent getNettvApplicationComponent() {
        return nettvApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setNettvApplicationComponent(NettvApplicationComponent nettvApplicationComponent) {
        this.nettvApplicationComponent = nettvApplicationComponent;
    }
}
