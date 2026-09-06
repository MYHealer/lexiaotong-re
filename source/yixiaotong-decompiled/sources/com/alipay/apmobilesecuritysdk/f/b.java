package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f1600a = new b();
    private Thread b = null;
    private LinkedList<Runnable> c = new LinkedList<>();

    public static b a() {
        return f1600a;
    }

    static /* synthetic */ Thread b(b bVar) {
        bVar.b = null;
        return null;
    }

    public final synchronized void a(Runnable runnable) {
        this.c.add(runnable);
        if (this.b == null) {
            Thread thread = new Thread(new c(this));
            this.b = thread;
            thread.start();
        }
    }
}
