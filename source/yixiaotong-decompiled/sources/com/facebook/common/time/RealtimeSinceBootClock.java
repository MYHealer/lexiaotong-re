package com.facebook.common.time;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class RealtimeSinceBootClock implements MonotonicClock {
    private static final RealtimeSinceBootClock INSTANCE = new RealtimeSinceBootClock();

    public static RealtimeSinceBootClock get() {
        return INSTANCE;
    }

    private RealtimeSinceBootClock() {
    }

    @Override // com.facebook.common.time.MonotonicClock
    public long now() {
        return android.os.SystemClock.elapsedRealtime();
    }
}
