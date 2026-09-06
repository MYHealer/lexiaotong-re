package com.alipay.sdk.widget;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f1685a;
    final /* synthetic */ q b;

    r(q qVar, View view) {
        this.b = qVar;
        this.f1685a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1685a.setEnabled(true);
    }
}
