package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class xe extends n5 {
    public int c;
    public int d;

    public xe(d dVar) {
        super(dVar);
        this.c = 50;
        this.d = 1;
        try {
            if (vl.m724a(dVar)) {
                return;
            }
            this.c = Integer.parseInt(((n5) this).f512a.m592a().m708a().a().a());
            pk.d("native  impressionPercent = " + this.c);
        } catch (Throwable th) {
            pk.a(th);
        }
    }

    public boolean b() {
        o1 o1Var = ((n5) this).f512a.f188a.f639a;
        return !(o1Var != null ? o1Var.f523a.booleanValue() : false);
    }
}
