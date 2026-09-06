package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l2 f1276a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ o2 f435a;

    public l2(o2 o2Var, l2 l2Var) {
        this.f435a = o2Var;
        this.f1276a = l2Var;
    }

    public void a() {
        pk.a("AdTracker insertToDB success, event = " + this.f435a.f530a + "  url = " + this.f435a.d + "   mRequest_id = " + this.f435a.f532b);
        l2 l2Var = this.f1276a;
        if (l2Var != null) {
            l2Var.a();
        }
    }

    public void a(Throwable th) {
        l2 l2Var = this.f1276a;
        if (l2Var != null) {
            l2Var.a(th);
        }
        pk.b("AdTracker db insert failed cb: " + th.getMessage());
    }
}
