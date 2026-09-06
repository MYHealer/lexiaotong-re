package com.opos.mobad.g.a;

import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f7005a;
    private volatile long b = Long.MAX_VALUE;

    public p(Runnable runnable) {
        this.f7005a = runnable;
    }

    public void a() {
        this.b = Long.MAX_VALUE;
    }

    public void a(long j) {
        long jMax = Math.max(0L, j);
        this.b = SystemClock.uptimeMillis() + jMax;
        com.opos.mobad.service.c.a(this, jMax);
    }

    public void b() {
        com.opos.mobad.service.c.b(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        if (SystemClock.uptimeMillis() >= this.b && (runnable = this.f7005a) != null) {
            runnable.run();
        }
    }
}
