package com.alipay.sdk.widget;

import android.webkit.SslErrorHandler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SslErrorHandler f1681a;
    final /* synthetic */ j b;

    n(j jVar, SslErrorHandler sslErrorHandler) {
        this.b = jVar;
        this.f1681a = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        e.a(this.b.f1676a, "安全警告", "安全連接證書校驗無效，將無法保證訪問資料的安全性，可能存在風險，請選擇是否繼續？", "繼續", new o(this), "退出", new p(this));
    }
}
