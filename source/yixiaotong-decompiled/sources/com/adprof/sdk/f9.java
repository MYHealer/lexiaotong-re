package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class f9 implements d9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g9 f1167a;

    public f9(g9 g9Var) {
        this.f1167a = g9Var;
    }

    @Override // com.adprof.sdk.d9
    public void a(q8 q8Var) {
        d9 d9Var = this.f1167a.f315a;
        if (d9Var != null) {
            d9Var.a(q8Var);
        }
        g9 g9Var = this.f1167a;
        h9 h9Var = g9Var.f316a;
        synchronized (h9Var.f335a) {
            h9Var.f335a.remove(g9Var);
        }
        h9Var.a();
    }

    @Override // com.adprof.sdk.d9
    public void a(q8 q8Var, long j, long j2) {
        d9 d9Var = this.f1167a.f315a;
        if (d9Var != null) {
            d9Var.a(q8Var, j, j2);
        }
    }

    @Override // com.adprof.sdk.d9
    public void b(q8 q8Var) {
        g9 g9Var = this.f1167a;
        g9Var.f1188a = 3;
        d9 d9Var = g9Var.f315a;
        if (d9Var != null) {
            d9Var.b(q8Var);
        }
        g9 g9Var2 = this.f1167a;
        h9 h9Var = g9Var2.f316a;
        synchronized (h9Var.f335a) {
            h9Var.f335a.remove(g9Var2);
        }
        h9Var.a();
    }
}
