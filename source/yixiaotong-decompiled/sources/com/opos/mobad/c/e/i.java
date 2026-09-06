package com.opos.mobad.c.e;

import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6721a = 0;
    private int b;

    public i(int i) {
        this.b = i;
    }

    @Override // com.opos.mobad.c.e.d
    public boolean a(Object obj) {
        long j = this.f6721a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (j <= 0) {
            this.f6721a = jElapsedRealtime;
            return false;
        }
        if (jElapsedRealtime - this.f6721a < this.b) {
            return false;
        }
        this.f6721a = SystemClock.elapsedRealtime();
        return true;
    }
}
