package com.hihonor.adsdk.base.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface CustomVideo {
    String getVideoUrl();

    void reportVideoEnd();

    void reportVideoError(int i, String str);

    void reportVideoPause();

    void reportVideoResume();

    void reportVideoStart();
}
