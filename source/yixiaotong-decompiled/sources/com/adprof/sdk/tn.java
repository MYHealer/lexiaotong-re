package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class tn implements wn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wn f1445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ xn f748a;

    public tn(xn xnVar, wn wnVar) {
        this.f748a = xnVar;
        this.f1445a = wnVar;
    }

    @Override // com.adprof.sdk.wn
    public void a(o2 o2Var, jp jpVar) {
        wn wnVar = this.f1445a;
        if (wnVar != null) {
            wnVar.a(o2Var, jpVar);
        }
        this.f748a.f843a.post(new sn(this));
    }

    @Override // com.adprof.sdk.wn
    public void a(o2 o2Var, fg fgVar) {
        wn wnVar = this.f1445a;
        if (wnVar != null) {
            wnVar.a(o2Var, fgVar);
        }
        this.f748a.f843a.post(new rn(this));
    }
}
