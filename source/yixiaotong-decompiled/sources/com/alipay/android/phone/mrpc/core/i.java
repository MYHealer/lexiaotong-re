package com.alipay.android.phone.mrpc.core;

import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
final class i implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ aa f1579a;
    final /* synthetic */ h b;

    i(h hVar, aa aaVar) {
        this.b = hVar;
        this.f1579a = aaVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final String a() {
        return this.f1579a.a();
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final ab b() {
        return l.a(StubApp.getOrigApplicationContext(this.b.f1578a.getApplicationContext()));
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final aa c() {
        return this.f1579a;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final boolean d() {
        return this.f1579a.c();
    }
}
