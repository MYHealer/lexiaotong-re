package com.baidu.oauth.sdkbqt.auth;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1888a;
    final /* synthetic */ i b;

    p(i iVar, String str) {
        this.b = iVar;
        this.f1888a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.i) {
            return;
        }
        super/*android.webkit.WebView*/.loadUrl(this.f1888a);
    }
}
