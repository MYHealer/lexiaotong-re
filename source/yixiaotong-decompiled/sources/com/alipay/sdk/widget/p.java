package com.alipay.sdk.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class p implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f1683a;

    p(n nVar) {
        this.f1683a = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1683a.f1681a.cancel();
        this.f1683a.b.w = false;
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.t, "2");
        com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c());
        this.f1683a.b.f1676a.finish();
    }
}
