package com.wlink.nettv.nettvchannel.utils.rx;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;

import static org.junit.Assert.*;

public class AppSchedulerProviderTest implements SchedulerProvider{

    public TestScheduler testScheduler;

    public AppSchedulerProviderTest(TestScheduler testScheduler) {
        this.testScheduler = testScheduler;
    }

    public TestScheduler getTestScheduler() {
        return testScheduler;
    }

    @Override
    public Scheduler ui() {
        return testScheduler;
    }

    @Override
    public Scheduler computation() {
        return testScheduler;
    }

    @Override
    public Scheduler io() {
        return testScheduler;
    }
}