package com.xiaomi.onetrack.f;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f9497a;
    public final /* synthetic */ g b;

    public h(g gVar, Context context) {
        this.b = gVar;
        this.f9497a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.onetrack.c.a.a();
        com.xiaomi.onetrack.api.c.a().d();
        com.xiaomi.onetrack.api.c.a().f();
        com.xiaomi.onetrack.c.c.a(this.f9497a);
    }
}
