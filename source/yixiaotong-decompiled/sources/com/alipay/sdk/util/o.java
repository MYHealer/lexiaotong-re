package com.alipay.sdk.util;

import android.app.Activity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f1668a;

    o(Activity activity) {
        this.f1668a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1668a.finish();
    }
}
