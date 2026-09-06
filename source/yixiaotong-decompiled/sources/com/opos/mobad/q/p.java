package com.opos.mobad.q;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f7311a;
    private volatile long b = Long.MAX_VALUE;
    private Handler c;

    public p(Handler handler, Runnable runnable) {
        this.c = handler;
        this.f7311a = runnable;
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
        Runnable runnable;
        if (SystemClock.uptimeMillis() >= this.b && (runnable = this.f7311a) != null) {
            runnable.run();
        }
    }
}
