package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class ci implements ao.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ cb f1771a;

    ci(cb cbVar) {
        this.f1771a = cbVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ao.a
    public void a() {
        if (this.f1771a.A) {
            this.f1771a.A = false;
            this.f1771a.a(false, "remote update Network access failed");
        }
    }
}
