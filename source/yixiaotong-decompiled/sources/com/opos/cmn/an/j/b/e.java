package com.opos.cmn.an.j.b;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f5955a = new c();
    private static final b b = new b();
    private Runnable c;
    private Callable<T> d;
    private d<T, Throwable> e;

    public e(f<T, Throwable> fVar) {
        this.c = fVar.e;
        this.d = fVar.f;
        this.e = new d<>(fVar.d == com.opos.cmn.an.j.a.a.MAIN ? f5955a : b, fVar.c, fVar.f5956a, fVar.b);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
            } else {
                Callable<T> callable = this.d;
                if (callable != null) {
                    this.e.b(callable.call());
                }
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("RunnableWrapper", "threadpool execute error:", th);
            this.e.a(th);
        }
        this.e.a();
    }
}
