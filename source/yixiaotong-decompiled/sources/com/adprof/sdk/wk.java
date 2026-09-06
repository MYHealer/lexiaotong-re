package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class wk extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ al f1505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ uk f808a;

    public wk(uk ukVar, al alVar) {
        this.f808a = ukVar;
        this.f1505a = alVar;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        uk ukVar = this.f808a;
        if (ukVar != null) {
            ukVar.a(this.f1505a);
        }
    }
}
