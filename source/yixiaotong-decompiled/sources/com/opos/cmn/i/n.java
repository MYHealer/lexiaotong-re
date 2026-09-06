package com.opos.cmn.i;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f6176a;
    private volatile long b = Long.MAX_VALUE;
    private Handler c;

    public n(Handler handler, Runnable runnable) {
        this.c = handler;
        this.f6176a = runnable;
    }

    public void a() {
        this.b = Long.MAX_VALUE;
    }

    public void a(long j) {
        long jMax = Math.max(0L, j);
        this.b = SystemClock.uptimeMillis() + jMax;
        this.c.postDelayed(this, jMax);
    }

    public void b() {
        this.c.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis < this.b) {
            com.opos.cmn.an.f.a.b("", "run but outline:" + this.b + ",current:" + jUptimeMillis);
            return;
        }
        Runnable runnable = this.f6176a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
