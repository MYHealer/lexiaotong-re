package com.alipay.sdk.data;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f1635a;
    final /* synthetic */ a b;

    b(a aVar, Context context) {
        this.b = aVar;
        this.f1635a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.alipay.sdk.packet.b bVarA = new com.alipay.sdk.packet.impl.b().a(this.f1635a);
            if (bVarA != null) {
                this.b.b(bVarA.b());
                this.b.i();
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }
}
