package com.wlink.nettv.nettvchannel.base;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.wlink.nettv.nettvchannel.di.component.NettvActivityComponent;
import com.wlink.nettv.nettvchannel.utils.NetworkUtils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class BaseActivityTest {
    public NettvActivityComponent nettvActivityComponent;
    public Context context;

    @Rule
    public ActivityTestRule<BaseActivity> activityTestRule = new ActivityTestRule<>(BaseActivity.class);


    @Before
    public void setUp() {
        context = InstrumentationRegistry.getContext();
    }

    @Test
    public void testString() {
        assertEquals(1, 1);
    }

    @Test
    public  void checkNetwork(){
        assertTrue(NetworkUtils.isNetworkConnected(context));
    }

}