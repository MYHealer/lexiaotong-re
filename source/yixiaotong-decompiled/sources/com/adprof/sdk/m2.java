package com.adprof.sdk;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class m2 implements rk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o2 f1298a;

    public m2(o2 o2Var) {
        this.f1298a = o2Var;
    }

    @Override // com.adprof.sdk.rk
    public void a(Error error) {
        pk.b(" deleteDB  onFailed e = " + error.getMessage());
    }

    @Override // com.adprof.sdk.rk
    public void a(List list) {
        pk.a("deleteDB  onSuccess id= " + this.f1298a.f529a);
    }
}
