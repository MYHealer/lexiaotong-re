package com.kwad.sdk.liteapi;

import com.kwad.sdk.api.SdkConfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class InputParamHolder {
    private static SdkConfig mSdkConfig;

    public static SdkConfig getSDKConfig() {
        return mSdkConfig;
    }

    public static void holderSdkConfig(SdkConfig sdkConfig) {
        mSdkConfig = sdkConfig;
    }

    public static String getAppId() {
        SdkConfig sdkConfig = mSdkConfig;
        return sdkConfig == null ? "" : sdkConfig.appId;
    }

    public static String getAppName() {
        SdkConfig sdkConfig = mSdkConfig;
        return sdkConfig == null ? "" : sdkConfig.appName;
    }
}
