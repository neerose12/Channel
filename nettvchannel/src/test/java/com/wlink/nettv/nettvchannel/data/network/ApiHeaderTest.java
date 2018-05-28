package com.wlink.nettv.nettvchannel.data.network;

import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import static org.junit.Assert.*;

public class ApiHeaderTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testConstructor(){
        ApiHeader.ProtectedApiHeader protectedApiHeader = new ApiHeader.ProtectedApiHeader(
                "ApiKey",23L,"AccessToken"
        );
        assertTrue(protectedApiHeader instanceof ApiHeader.ProtectedApiHeader);
    }
}