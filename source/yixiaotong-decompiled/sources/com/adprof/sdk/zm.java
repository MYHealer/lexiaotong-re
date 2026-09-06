package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class zm implements ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ an f1561a;

    public zm(an anVar) {
        this.f1561a = anVar;
    }

    @Override // com.adprof.sdk.ao
    public void a(int i, int i2, int i3, long j) {
        d dVar = ((x0) this.f1561a).f821a;
        if (dVar != null) {
            dVar.m591a().a(i, i2, i3, j);
        }
        an anVar = this.f1561a;
        if (((x0) anVar).f821a == null) {
            pk.b("---handleClick adUnit exception");
        } else {
            anVar.c("4");
        }
    }
}
