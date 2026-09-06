package com.ubix.ssp.open.nativee.express;

import com.ubix.ssp.open.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UBiXNativeExpressVideoListener {
    void onVideoComplete();

    void onVideoError(AdError adError);

    void onVideoPause();

    void onVideoProgressUpdate(long j, long j2);

    void onVideoResume();

    void onVideoStart();
}
