package com.yfanads.android.adx.api;

import android.content.Context;
import com.yfanads.android.adx.AdxSdkConfig;
import com.yfanads.android.adx.core.annotate.AdSdkDynamicApi;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@AdSdkDynamicApi("com.yfanads.android.adx.core.impl.AdxSDKImpl")
public interface IAdxSDK {
    @AdSdkDynamicApi
    LoadManager getAdManager();

    @AdSdkDynamicApi
    void init(Context context, AdxSdkConfig adxSdkConfig);

    @AdSdkDynamicApi
    <T> T newInstance(Class<T> cls);
}
