package com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface PbKwaishopResourceLivePendantInfo {
    int getAction();

    String getAreaCode();

    String getCallbackApi();

    String getCallbackPath();

    String getEventData();

    String getPendantCode();

    long getPendantResourceId();

    long getRandomRangeMillis();

    Map<String, String> getThroughInfo();

    boolean isNeedBusinessHandle();

    boolean isNeedRandomCall();

    boolean isNeedServerProcess();

    boolean isNeedSignalFallback();
}
