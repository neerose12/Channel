package com.wlink.nettv.nettvchannel.utils;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import static org.junit.Assert.*;

public class NetworkUtilsTest {

    public Context context;

    @Test
    public void checkInternet(){
        context = InstrumentationRegistry.getContext();
        assertTrue(NetworkUtils.isNetworkConnected(context));
    }
}