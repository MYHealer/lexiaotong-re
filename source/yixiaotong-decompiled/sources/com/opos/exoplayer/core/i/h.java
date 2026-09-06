package com.opos.exoplayer.core.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6503a;

    public synchronized boolean a() {
        if (this.f6503a) {
            return false;
        }
        this.f6503a = true;
        notifyAll();
        return true;
    }

    public synchronized boolean b() {
        boolean z;
        z = this.f6503a;
        this.f6503a = false;
        return z;
    }

    public synchronized void c() {
        while (!this.f6503a) {
            wait();
        }
    }
}
