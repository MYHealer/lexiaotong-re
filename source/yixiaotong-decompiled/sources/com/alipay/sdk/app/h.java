package com.alipay.sdk.app;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class h implements com.alipay.sdk.util.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PayTask f1623a;

    @Override // com.alipay.sdk.util.e.a
    public void a() {
    }

    h(PayTask payTask) {
        this.f1623a = payTask;
    }

    @Override // com.alipay.sdk.util.e.a
    public void b() {
        this.f1623a.dismissLoading();
    }
}
