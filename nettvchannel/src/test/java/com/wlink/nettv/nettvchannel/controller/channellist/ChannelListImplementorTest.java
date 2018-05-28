package com.wlink.nettv.nettvchannel.controller.channellist;

import android.util.Log;

import com.wlink.nettv.nettvchannel.data.DataManager;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModel;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;
import com.wlink.nettv.nettvchannel.utils.rx.AppSchedulerProvider;
import com.wlink.nettv.nettvchannel.utils.rx.AppSchedulerProviderTest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.TestScheduler;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ChannelListImplementorTest {

    @Mock
    ChannelListView mMockLoginMvpView;

    ChannelListView channelListView;

    @Mock
    DataManager mMockDataManager;

    private ChannelListImplementor<ChannelListView> mLoginPresenter;
    private TestScheduler mTestScheduler;

    @BeforeClass
    public static void onlyOnce() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mTestScheduler = new TestScheduler();
        AppSchedulerProviderTest testSchedulerProvider = new AppSchedulerProviderTest(mTestScheduler);
        mLoginPresenter = new ChannelListImplementor<>(
                mMockDataManager,
                testSchedulerProvider,
                compositeDisposable);

        mLoginPresenter.onAttach(mMockLoginMvpView);
    }

    @Test
    public void testChannelApi(){
        List<ChannelModelResponse> channelModelResponse = new ArrayList<>();
        when(mMockDataManager.getChannels())
                .thenReturn(Observable.just(channelModelResponse));
//        doReturn(Observable.just(channelModelResponse))
//                .when(mMockDataManager)
//                .getChannels();
        mLoginPresenter.channelList();
        mTestScheduler.triggerActions();
        verify(mMockLoginMvpView,times(1)).OnApiError();
//        verify(mMockLoginMvpView).channelList(channelModelResponses);
    }
}