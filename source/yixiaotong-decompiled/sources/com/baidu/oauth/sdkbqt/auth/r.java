package com.baidu.oauth.sdkbqt.auth;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f1890a;

    r(i iVar) {
        this.f1890a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1890a.l != null) {
            this.f1890a.l.setVisibility(8);
        }
        this.f1890a.f.f1880a = this.f1890a.o.b;
        if (this.f1890a.h != null) {
            this.f1890a.h.setVisibility(0);
        }
    }
}
