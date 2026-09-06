package com.opos.exoplayer.core.i;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class aa implements e {
    aa() {
    }

    @Override // com.opos.exoplayer.core.i.e
    public long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.opos.exoplayer.core.i.e
    public j a(Looper looper, Handler.Callback callback) {
        return new ab(new Handler(looper, callback));
    }

    @Override // com.opos.exoplayer.core.i.e
    public long b() {
        return SystemClock.uptimeMillis();
    }
}
