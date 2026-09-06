package com.xiaomi.onetrack.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Thread f9432a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ k c;

    public l(k kVar, Thread thread, Throwable th) {
        this.c = kVar;
        this.f9432a = thread;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        this.c.a(this.f9432a, this.b);
    }
}
