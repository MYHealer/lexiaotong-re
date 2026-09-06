package com.kwad.components.ad.reward;

import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
@KsAdSdkDynamicImpl(KSRewardLandScapeVideoActivity.class)
public class KSRewardLandScapeVideoActivityProxy extends KSRewardVideoActivityProxy {
    public static void register() {
        com.kwad.sdk.service.c.putComponentProxy(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
    }
}
