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
            accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjI1Zjc2OWVhNzRlYjdlM2FmMjg2ZmIyOTc3OGViZjZmNzg2MTA3ZWU2YWU5NjE0NTA5OWZlMDZmNmI2ZGI0NGYyYjg0OGIyY2UxMWIzZDVkIn0.eyJhdWQiOiI4IiwianRpIjoiMjVmNzY5ZWE3NGViN2UzYWYyODZmYjI5Nzc4ZWJmNmY3ODYxMDdlZTZhZTk2MTQ1MDk5ZmUwNmY2YjZkYjQ0ZjJiODQ4YjJjZTExYjNkNWQiLCJpYXQiOjE1MzI4NDEwMjYsIm5iZiI6MTUzMjg0MTAyNiwiZXhwIjoxNTY0Mzc3MDI2LCJzdWIiOiI5Iiwic2NvcGVzIjpbInN1YnNjcmliZXIiXX0.rXPTXvojfGM1hPEzjx2msVOZhPpzOY7cEbMXY29EsBPVVz3ZbuVaN87pTELicsfYpEKGHu_6AYvFGcBNmD15pBr4plEGcw0vpN_Vu_gUXwcNE3AhGoL85BKQZ5WVlGOTl6Tk7IvM9k0Jt4dF4Ee5t7W4qtDciNAWCR12BKjOztsx42b1bSXkxvnkkttqzKAqJO5fElaxiqGYRh3NTMwWlp3DaeGpBeuGDi2cpfbKwvBYrPGV29QeHgB4aHFT5iu-HnTEbC27o2mMjhbZbVfF06gLUjoEWBhcnMrN-q6_0H25Hia7FIIjXHMrI_Bm6y80rtgLhl1CyRndHgQYoMwlIdsbI7ha9uPouGAvqFhdBmEDswW1A0Jg-UlmzDNgD_wRkTWji0ZDDQJJaWR8vryYKCW28-hfxp1k_tNWAepzlIMAt9V3-L9IaU6gQ9-kn_ZWejF5ER2fZCF4OYQCpxfRV6oY5OE0etHa1aVZnwLCk24Zll0b5yW5hhZtX4xlKZf6kSepnoNBzLev_I7cBWYQSZdeuvOjbwaSZPLm35NwIUc_zMXgCP26zLgYG62bTXpk5-PfNS1ipCeztt5uFjADfi841UlLokALEAucx6_7YbZ8k2zkEYkRk35JyprWjgQwToao5Up0CeApP6JOXvgJY3tYrJ2ewiSiSv2C9Cd7gfQ";
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
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
                .applicationId("t0U9u01szKbK9OZh")
                .clientKey("69717fcd03b42bd9a38b0f2c8694728e4d7870ed")
                .server("http://parse.dev.nettv.com.np:1337/parse")
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
