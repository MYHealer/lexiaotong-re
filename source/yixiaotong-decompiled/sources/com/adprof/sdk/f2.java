package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class f2 implements d9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1162a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p5 f286a;

    public f2(h2 h2Var, p5 p5Var, d dVar) {
        this.f286a = p5Var;
        this.f1162a = dVar;
    }

    @Override // com.adprof.sdk.d9
    public void a(q8 q8Var) {
        StringBuilder sb = new StringBuilder();
        sb.append(q8Var.f670a.getMessage());
        if (q8Var.f670a.f1255a != null) {
            sb.append(" status code ");
            sb.append(q8Var.f670a.f1255a.f1172a);
        }
        String string = sb.toString();
        p5 p5Var = this.f286a;
        if (p5Var != null) {
            p5Var.a(this.f1162a, string);
        }
    }

    @Override // com.adprof.sdk.d9
    public void a(q8 q8Var, long j, long j2) {
    }

    @Override // com.adprof.sdk.d9
    public void b(q8 q8Var) {
        p5 p5Var = this.f286a;
        if (p5Var != null) {
            p5Var.a(this.f1162a, (String) null);
        }
    }
}
