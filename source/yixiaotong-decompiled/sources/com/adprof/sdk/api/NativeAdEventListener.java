package com.adprof.sdk.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface NativeAdEventListener {
    void onAdClicked();

    void onAdExposed();

    void onAdRenderFail(AdError adError);
}
