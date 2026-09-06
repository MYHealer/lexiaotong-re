package com.baidu.oauth.sdkbqt.view;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f1911a;

    f(e eVar) {
        this.f1911a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1911a.f1910a.setVisibility(4);
        this.f1911a.b.oauthWebView.reload();
    }
}
