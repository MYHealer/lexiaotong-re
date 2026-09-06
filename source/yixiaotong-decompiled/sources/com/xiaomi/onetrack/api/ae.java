package com.xiaomi.onetrack.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class ae implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f9404a;
    public final /* synthetic */ m b;

    public ae(m mVar, boolean z) {
        this.b = mVar;
        this.f9404a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.i.a(this.f9404a);
        com.xiaomi.onetrack.util.aa.a(com.xiaomi.onetrack.util.r.a(this.b.f), this.f9404a);
    }
}
