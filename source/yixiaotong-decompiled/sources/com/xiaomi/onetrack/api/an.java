package com.xiaomi.onetrack.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class an implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9413a;
    public final /* synthetic */ am b;

    public an(am amVar, int i) {
        this.b = amVar;
        this.f9413a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.xiaomi.onetrack.c.i.b() && this.f9413a == 2) {
            com.xiaomi.onetrack.c.s.a().a(0, true);
            com.xiaomi.onetrack.c.s.a().a(1, true);
            com.xiaomi.onetrack.a.c.b.a().b();
        }
    }
}
