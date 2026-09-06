package com.meishu.sdk.core.ad.recycler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ExpressMediaListener {
    void onVideoCompleted();

    void onVideoError(int i, String str);

    void onVideoLoaded();

    void onVideoPause();

    void onVideoResume();

    void onVideoStart();
}
