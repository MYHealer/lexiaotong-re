package com.alipay.sdk.app;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1622a;
    final /* synthetic */ boolean b;
    final /* synthetic */ H5PayCallback c;
    final /* synthetic */ PayTask d;

    g(PayTask payTask, String str, boolean z, H5PayCallback h5PayCallback) {
        this.d = payTask;
        this.f1622a = str;
        this.b = z;
        this.c = h5PayCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.onPayResult(this.d.h5Pay(this.f1622a, this.b));
    }
}
