package com.adprof.sdk.api;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface NativeAdLoadListener {
    void onAdError(AdError adError);

    void onAdLoad(List<NativeAdData> list);
}
