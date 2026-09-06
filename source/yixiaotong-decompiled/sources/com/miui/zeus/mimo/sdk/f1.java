package com.miui.zeus.mimo.sdk;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f1 implements y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeAd.NativeAdLoadListener f5420a;

    public f1(NativeAd.NativeAdLoadListener nativeAdLoadListener) {
        this.f5420a = nativeAdLoadListener;
    }

    @Override // com.miui.zeus.mimo.sdk.y1
    public void onAdLoadFailed(int i, String str) {
        NativeAd.NativeAdLoadListener nativeAdLoadListener = this.f5420a;
        if (nativeAdLoadListener != null) {
            nativeAdLoadListener.onAdLoadFailed(i, str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.y1
    public void onAdLoadSuccess(List<NativeAdData> list) {
        if (this.f5420a == null || list.isEmpty()) {
            return;
        }
        this.f5420a.onAdLoadSuccess(list.get(0));
    }
}
