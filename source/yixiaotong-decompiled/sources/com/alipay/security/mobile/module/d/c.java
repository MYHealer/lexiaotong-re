package com.alipay.security.mobile.module.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f1697a;

    c(b bVar) {
        this.f1697a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f1697a.b();
        } catch (Exception e) {
            d.a(e);
        }
    }
}
