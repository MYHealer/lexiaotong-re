package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class sb extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tb f1418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Exception f721a;

    public sb(tb tbVar, Exception exc) {
        this.f1418a = tbVar;
        this.f721a = exc;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        this.f1418a.f1437a.a(this.f721a);
    }
}
