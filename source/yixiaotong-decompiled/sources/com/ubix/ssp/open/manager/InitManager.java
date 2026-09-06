package com.ubix.ssp.open.manager;

import com.ubix.ssp.open.AdLoadCallbackListener;
import com.ubix.ssp.open.UBiXAdSetting;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface InitManager {
    String getSdkVersion();

    void launchSDK(String str);

    void launchSDK(String str, UBiXAdSetting uBiXAdSetting);

    void launchSDK(String str, UBiXAdSetting uBiXAdSetting, AdLoadCallbackListener adLoadCallbackListener);

    void setDebugLog(boolean z);
}
