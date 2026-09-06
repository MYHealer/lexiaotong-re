package com.alipay.sdk.app;

import android.app.Activity;
import android.webkit.SslErrorHandler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f1618a;
    final /* synthetic */ SslErrorHandler b;
    final /* synthetic */ b c;

    c(b bVar, Activity activity, SslErrorHandler sslErrorHandler) {
        this.c = bVar;
        this.f1618a = activity;
        this.b = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alipay.sdk.widget.e.a(this.f1618a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，可能存在风险，请选择是否继续？", "继续", new d(this), "退出", new e(this));
    }
}
