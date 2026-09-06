package com.opos.cmn.func.dl.base.a.b;

import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6109a;
    private long b;

    @Override // com.opos.cmn.func.dl.base.a.b.a
    public final long a(long j, long j2, long j3, long j4, float f, int i, float f2) {
        if ((SystemClock.uptimeMillis() - this.b > i || j4 - this.f6109a > Math.max(0.0f, Math.min(f * j, f2))) && SystemClock.uptimeMillis() - this.b > 50) {
            long jUptimeMillis = SystemClock.uptimeMillis() - j3;
            this.f6109a = j4;
            this.b = SystemClock.uptimeMillis();
            long j5 = 0 != jUptimeMillis ? (j4 - j2) / jUptimeMillis : 0L;
            if (j5 >= 0) {
                return j5;
            }
        }
        return 0L;
    }
}
