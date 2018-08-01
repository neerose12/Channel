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
        accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjRlZWJjNWY2MjA2NGRmMGUwZmJjYWNiMzdlNDRiNzBiNWVmNjcwYmI2OWI3YWQyMWE3OTZhMzhjMjNkZjA2ZTRhMzMxNTEwZjEwZWNmNmJmIn0.eyJhdWQiOiI4IiwianRpIjoiNGVlYmM1ZjYyMDY0ZGYwZTBmYmNhY2IzN2U0NGI3MGI1ZWY2NzBiYjY5YjdhZDIxYTc5NmEzOGMyM2RmMDZlNGEzMzE1MTBmMTBlY2Y2YmYiLCJpYXQiOjE1MzI4NTc4NjMsIm5iZiI6MTUzMjg1Nzg2MywiZXhwIjoxNTY0MzkzODYzLCJzdWIiOiIzIiwic2NvcGVzIjpbInN1YnNjcmliZXIiXX0.gsuVZCDpefAILkpYGGQcs0EiK5zB0_fh13R5yQcBgxbr4hCECrHMdBV3Gu6llWELB75Py_JRBvercbsihJfXAJdtb6VBds1wbIvfJAT80udcfOhXDjptwdfQ0FLCRDaW_rmGwpVZm6LvJdin4J8BB5MCUG6tuEsqgeG7j4LDSvvyUano9bnbJMRnDx7OW_iJtcqgfxRv1bniBmL_9KVQAVYrlzcQIMWE2sioRoLXeHAzXw7SN9sAqi9rwlc9c-WOcPiPyBIRdyVjSUAtB3g1i0JDBFxe-n6nLLY61YbcwKREIJcpnckl2R_uKiPCc2EkABYlEWeM-1lSfQstr6qp-SbQUIvUAtmpRnEzzcrFqeaQJNgd7hdq3Aryy898P-4p7Uav9u5QMxwds1Gnw2vxyhckqSsO21rZ9k-oJ7qwDv5jeGOhwVtEwyvBXkGecxGWni1yz8pBQJOWCbGG7kWGRo2hTziMduErddKjD8AAYBFacg1Prx7opmhAh6fjtI35VA_Xd5BCEnofFmirU3Huv1OyOMh_x6UQfWD6aBnGbVHGEAtuz_T90d_9D1HWtA_M6NdJEU6ZaO8AWYMZwptmmlbf8BVCjp-_6oIJL8-HmjW3LCc5q1X0VTuUE_4nE_huKzC1iE-JxlSnfAXcY52Maj93Abf4rni1iSFFyMR-x9w";

        try {
            Context myContext = createPackageContext("np.com.nettv.launcher", MODE_PRIVATE);
            SharedPreferences pref = myContext.getSharedPreferences("auth_pref", MODE_MULTI_PROCESS);
            accessToken = pref.getString("key_result_refresh", accessToken);
            Toast.makeText(this, accessToken, Toast.LENGTH_SHORT).show();
            Log.d("CHeckingAcessToken", accessToken);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjRlZWJjNWY2MjA2NGRmMGUwZmJjYWNiMzdlNDRiNzBiNWVmNjcwYmI2OWI3YWQyMWE3OTZhMzhjMjNkZjA2ZTRhMzMxNTEwZjEwZWNmNmJmIn0.eyJhdWQiOiI4IiwianRpIjoiNGVlYmM1ZjYyMDY0ZGYwZTBmYmNhY2IzN2U0NGI3MGI1ZWY2NzBiYjY5YjdhZDIxYTc5NmEzOGMyM2RmMDZlNGEzMzE1MTBmMTBlY2Y2YmYiLCJpYXQiOjE1MzI4NTc4NjMsIm5iZiI6MTUzMjg1Nzg2MywiZXhwIjoxNTY0MzkzODYzLCJzdWIiOiIzIiwic2NvcGVzIjpbInN1YnNjcmliZXIiXX0.gsuVZCDpefAILkpYGGQcs0EiK5zB0_fh13R5yQcBgxbr4hCECrHMdBV3Gu6llWELB75Py_JRBvercbsihJfXAJdtb6VBds1wbIvfJAT80udcfOhXDjptwdfQ0FLCRDaW_rmGwpVZm6LvJdin4J8BB5MCUG6tuEsqgeG7j4LDSvvyUano9bnbJMRnDx7OW_iJtcqgfxRv1bniBmL_9KVQAVYrlzcQIMWE2sioRoLXeHAzXw7SN9sAqi9rwlc9c-WOcPiPyBIRdyVjSUAtB3g1i0JDBFxe-n6nLLY61YbcwKREIJcpnckl2R_uKiPCc2EkABYlEWeM-1lSfQstr6qp-SbQUIvUAtmpRnEzzcrFqeaQJNgd7hdq3Aryy898P-4p7Uav9u5QMxwds1Gnw2vxyhckqSsO21rZ9k-oJ7qwDv5jeGOhwVtEwyvBXkGecxGWni1yz8pBQJOWCbGG7kWGRo2hTziMduErddKjD8AAYBFacg1Prx7opmhAh6fjtI35VA_Xd5BCEnofFmirU3Huv1OyOMh_x6UQfWD6aBnGbVHGEAtuz_T90d_9D1HWtA_M6NdJEU6ZaO8AWYMZwptmmlbf8BVCjp-_6oIJL8-HmjW3LCc5q1X0VTuUE_4nE_huKzC1iE-JxlSnfAXcY52Maj93Abf4rni1iSFFyMR-x9w";
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
