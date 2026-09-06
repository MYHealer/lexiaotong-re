package com.yfanads.android.adx.api;

import com.yfanads.android.adx.core.annotate.AdSdkApi;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@AdSdkApi
public interface LoadManager {

    @AdSdkApi
    public interface NativeAdListener {
        @AdSdkApi
        void onError(int i, String str);

        @AdSdkApi
        void onNativeAdLoad(List<AdxNativeAd> list);
    }

    @AdSdkApi
    void loadNativeAd(AdxScene adxScene, NativeAdListener nativeAdListener);

    @AdSdkApi
    void reportAdInfo(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5);
}
