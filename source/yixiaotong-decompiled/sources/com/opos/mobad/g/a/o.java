package com.opos.mobad.g.a;

import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile T f7004a;
    private a<T> b;
    private volatile long c = Long.MAX_VALUE;

    public interface a<T> {
        void a(T t);
    }

    public o(a<T> aVar) {
        this.b = aVar;
    }

    public void a() {
        this.c = Long.MAX_VALUE;
        this.f7004a = null;
    }

    public void a(long j, T t) {
        long jMax = Math.max(0L, j);
        this.c = SystemClock.uptimeMillis() + jMax;
        this.f7004a = t;
        com.opos.mobad.service.c.a(this, jMax);
    }

    public void b() {
        com.opos.mobad.service.c.b(this);
        this.f7004a = null;
    }

    @Override // java.lang.Runnable
    public void run() {
        a<T> aVar;
        if (SystemClock.uptimeMillis() >= this.c && (aVar = this.b) != null) {
            aVar.a(this.f7004a);
        }
    }
}
