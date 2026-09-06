package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class en implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fn.b f1156a;

    public en(fn.b bVar) {
        this.f1156a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1156a.callback(null);
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
