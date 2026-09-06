package com.opos.mobad.model.e;

import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class k extends m {
    private boolean d = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f7210a = new l();
    private long b = SystemClock.elapsedRealtime();
    private long c = 0;

    private void d(boolean z) {
        if (z) {
            return;
        }
        this.d = false;
    }

    public void a(boolean z) {
        d(z);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.b;
        this.b = jElapsedRealtime;
        this.f7210a.a("6", String.valueOf(j));
        this.c += j;
    }

    public boolean a() {
        return this.d;
    }

    public long b() {
        return this.c;
    }

    public void b(boolean z) {
        d(z);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.b;
        this.b = jElapsedRealtime;
        this.f7210a.a("7", String.valueOf(j));
        this.c += j;
    }

    public String c() {
        return com.opos.cmn.i.o.a(this.f7210a.a());
    }

    public void c(boolean z) {
        d(z);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.b;
        this.b = jElapsedRealtime;
        this.f7210a.a("8", String.valueOf(j));
        this.c += j;
    }
}
