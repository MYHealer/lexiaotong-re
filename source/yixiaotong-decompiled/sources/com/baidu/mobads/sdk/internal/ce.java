package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class ce implements cp.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ cb f1769a;

    ce(cb cbVar) {
        this.f1769a = cbVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cp.a
    public void a(String str) {
        try {
            this.f1769a.b();
            this.f1769a.a(str);
        } catch (Throwable th) {
            bv.a().a(th);
        }
    }
}
