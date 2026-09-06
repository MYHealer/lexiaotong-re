package com.meishu.sdk.core.ad.recycler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface RecyclerAdMediaListener {
    default void onProgressUpdate(long j, long j2) {
    }

    void onVideoCompleted();

    void onVideoError();

    default void onVideoLoaded() {
    }

    void onVideoPause();

    void onVideoResume();

    void onVideoStart();
}
