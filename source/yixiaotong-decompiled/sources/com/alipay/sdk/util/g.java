package com.alipay.sdk.util;

import com.alipay.sdk.app.AlipayResultActivity;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class g implements AlipayResultActivity.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f1659a;
    final /* synthetic */ e b;

    g(e eVar, CountDownLatch countDownLatch) {
        this.b = eVar;
        this.f1659a = countDownLatch;
    }

    @Override // com.alipay.sdk.app.AlipayResultActivity.a
    public void a(int i, String str, String str2) {
        this.b.i = com.alipay.sdk.app.j.a(i, str, str2);
        this.f1659a.countDown();
    }
}
