package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class dn implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fn.b f1135a;

    public dn(fn.b bVar) {
        this.f1135a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1135a.callback(null);
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
