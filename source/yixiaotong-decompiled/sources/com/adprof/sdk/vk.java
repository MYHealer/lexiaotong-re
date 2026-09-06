package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class vk extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ al f1483a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ uk f784a;

    public vk(uk ukVar, al alVar) {
        this.f784a = ukVar;
        this.f1483a = alVar;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        uk ukVar = this.f784a;
        if (ukVar != null) {
            ukVar.a(this.f1483a);
        }
    }
}
