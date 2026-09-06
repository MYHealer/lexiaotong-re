package com.alipay.sdk.app;

import android.app.Activity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f1621a;

    f(Activity activity) {
        this.f1621a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1621a.finish();
    }
}
