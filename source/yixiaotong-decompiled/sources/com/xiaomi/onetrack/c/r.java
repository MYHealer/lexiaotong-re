package com.xiaomi.onetrack.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f9479a;

    public r(p pVar) {
        this.f9479a = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9479a.i.get()) {
            com.xiaomi.onetrack.b.e.b();
        }
        this.f9479a.i.set(true);
    }
}
