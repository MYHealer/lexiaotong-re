package com.opos.mobad.f.a;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h implements Runnable {
    private static Handler c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f6895a;
    private volatile long b = Long.MAX_VALUE;
    private int d;

    public h(d.a aVar) {
        this.d = aVar.a();
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j) {
        if (this.f6895a != null) {
            com.opos.cmn.an.f.a.b("TimeoutController", "start but is running");
            return;
        }
        this.f6895a = runnable;
        long jMax = Math.max(0L, j);
        this.b = SystemClock.elapsedRealtime() + jMax;
        c.postDelayed(this, jMax);
    }

    public boolean a() {
        return this.f6895a != null;
    }

    public int b() {
        return this.d;
    }

    public void c() {
        this.b = Long.MAX_VALUE;
    }

    public void d() {
        c.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        if (SystemClock.elapsedRealtime() >= this.b && (runnable = this.f6895a) != null) {
            runnable.run();
            this.f6895a = null;
        }
    }
}
