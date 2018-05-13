package com.wlink.nettv.nettvchannel.di.component;

import android.support.test.espresso.core.deps.dagger.Component;

import com.wlink.nettv.nettvchannel.di.module.ApplicationModuleTest;

import javax.inject.Singleton;

import static org.junit.Assert.*;

@Singleton
@Component(modules =  ApplicationModuleTest.class)
public interface ApplicationComponentTest {

}