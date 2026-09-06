package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class sg extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yg f1421a;

    public sg(yg ygVar) {
        this.f1421a = ygVar;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        this.f1421a.a();
        xg xgVar = this.f1421a.f855a;
        if (xgVar != null) {
            xgVar.mo575a();
        }
    }
}
