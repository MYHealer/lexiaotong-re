package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class d0 implements ke {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f1120a;

    public d0(f0 f0Var) {
        this.f1120a = f0Var;
    }

    @Override // com.adprof.sdk.ke
    public void a() {
        f0 f0Var = this.f1120a;
        d dVar = f0Var.f277a;
        if (dVar != null) {
            if (dVar.m590a() != null) {
                f0Var.f277a.m590a().a(f0Var.f277a, "6");
            }
            f0Var.f277a.g = 0;
            f0Var.f267a = 100;
        }
    }
}
