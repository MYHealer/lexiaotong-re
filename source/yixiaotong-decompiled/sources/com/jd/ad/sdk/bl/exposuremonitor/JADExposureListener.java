package com.jd.ad.sdk.bl.exposuremonitor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface JADExposureListener {
    void onDelayExposure(long j, String str, int i);

    void onExposure(String str);

    void onFinishExposure();

    void onPreExposure(String str);
}
