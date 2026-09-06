package com.baidu.oauth.sdkbqt.auth;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f1891a;

    s(i iVar) {
        this.f1891a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1891a.l != null) {
            this.f1891a.l.setVisibility(8);
        }
        if (this.f1891a.g != null) {
            this.f1891a.g.setVisibility(0);
        }
    }
}
