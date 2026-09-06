package com.facebook.common.time;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class CurrentThreadTimeClock implements Clock {
    @Override // com.facebook.common.time.Clock
    public long now() {
        return android.os.SystemClock.currentThreadTimeMillis();
    }
}
