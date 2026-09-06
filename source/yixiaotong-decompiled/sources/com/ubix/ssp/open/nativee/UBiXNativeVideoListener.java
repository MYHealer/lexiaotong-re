package com.ubix.ssp.open.nativee;

import com.ubix.ssp.open.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXNativeVideoListener {
    void onVideoComplete();

    void onVideoError(AdError adError);

    void onVideoPause();

    void onVideoProgressUpdate(long j, long j2);

    void onVideoResume();

    void onVideoStart();
}
