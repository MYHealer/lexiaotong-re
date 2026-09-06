package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class mf implements ke {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pf f1307a;

    public mf(pf pfVar) {
        this.f1307a = pfVar;
    }

    @Override // com.adprof.sdk.ke
    public void a() {
        pf pfVar = this.f1307a;
        d dVar = pfVar.f582a;
        if (dVar != null) {
            dVar.h = 100;
        }
        if (dVar == null || dVar.m590a() == null) {
            return;
        }
        pfVar.f582a.m590a().a(pfVar.f582a, "6");
    }
}
