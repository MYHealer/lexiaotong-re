package com.adprof.sdk;

import com.bykv.vk.component.ttvideo.ILivePlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class b2 {
    public final synchronized boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - c2.e;
        if (j < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            if (pk.f594a) {
                pk.d("AdShakeDetector: Global shake lock blocked, timeSinceLastShake=" + j + "ms, need wait " + (ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT - j) + "ms");
            }
            return false;
        }
        c2.e = jCurrentTimeMillis;
        if (pk.f594a) {
            pk.d("AdShakeDetector: Global shake lock acquired, timeSinceLastShake=" + j + "ms");
        }
        return true;
    }
}
