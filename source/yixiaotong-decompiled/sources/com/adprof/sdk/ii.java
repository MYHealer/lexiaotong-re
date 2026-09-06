package com.adprof.sdk;

import android.os.Handler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class ii implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f1232a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f386a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f387a;

    public ii(Handler handler) {
        qh.a(handler);
        this.f386a = handler;
    }

    public abstract void a();

    public void a(long j) {
        rh.a(j > 0, true, "intervalMillis must be greater than 0. Saw: " + j, new Object[]{""});
        this.f1232a = j;
        if (this.f387a) {
            return;
        }
        this.f387a = true;
        this.f386a.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f387a) {
            a();
            this.f386a.postDelayed(this, this.f1232a);
        }
    }
}
