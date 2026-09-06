package com.kwad.sdk.service;

import com.kwad.sdk.api.SdkConfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    private static SdkConfig mSdkConfig;

    public static SdkConfig getSDKConfig() {
        return mSdkConfig;
    }

    public static void holderSdkConfig(SdkConfig sdkConfig) {
        mSdkConfig = sdkConfig;
    }

    public static String getAppId() {
        return mSdkConfig.appId;
    }

    public static String getAppName() {
        return mSdkConfig.appName;
    }
}
