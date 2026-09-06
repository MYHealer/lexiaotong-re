package com.fancy.adsdk.lib.interf;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface PtgVideoAdListener {
    void onVideoComplete();

    void onVideoError(int i, String str);

    void onVideoPause();

    void onVideoProgressUpdate(long j, long j2);

    void onVideoResume();

    void onVideoStart();
}
