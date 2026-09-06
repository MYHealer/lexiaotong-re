package com.miui.zeus.mimo.sdk;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g1 implements y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeCustomAd.NativeCustomMultiAdsLoadListener f5430a;

    public g1(NativeCustomAd.NativeCustomMultiAdsLoadListener nativeCustomMultiAdsLoadListener) {
        this.f5430a = nativeCustomMultiAdsLoadListener;
    }

    @Override // com.miui.zeus.mimo.sdk.y1
    public void onAdLoadFailed(int i, String str) {
        NativeCustomAd.NativeCustomMultiAdsLoadListener nativeCustomMultiAdsLoadListener = this.f5430a;
        if (nativeCustomMultiAdsLoadListener != null) {
            nativeCustomMultiAdsLoadListener.onAdLoadFailed(i, str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.y1
    public void onAdLoadSuccess(List<NativeAdData> list) {
        NativeCustomAd.NativeCustomMultiAdsLoadListener nativeCustomMultiAdsLoadListener = this.f5430a;
        if (nativeCustomMultiAdsLoadListener != null) {
            nativeCustomMultiAdsLoadListener.onAdLoadSuccess(list);
        }
    }
}
