package com.adprof.sdk;

import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class k4 implements ne {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n4 f1259a;

    public k4(n4 n4Var) {
        this.f1259a = n4Var;
    }

    @Override // com.adprof.sdk.ne
    public void a() {
        q qVar;
        try {
            n4 n4Var = this.f1259a;
            if (((p5) n4Var).f546a == null || (qVar = n4Var.f501a) == null || qVar.getVisibility() != 0) {
                return;
            }
            n4 n4Var2 = this.f1259a;
            ((p5) n4Var2).f546a.f206h = "1";
            n4Var2.mo698a().a(((p5) n4Var2).f546a, "click", new HashMap());
            r4.a(((p5) this.f1259a).f546a);
            this.f1259a.b();
        } catch (Throwable th) {
            pk.a(th);
        }
    }
}
