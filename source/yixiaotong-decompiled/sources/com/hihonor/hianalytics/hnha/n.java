package com.hihonor.hianalytics.hnha;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m3 f3662a;
    public final Throwable b;
    public final String c;
    public final int d;
    public final long e;
    private int f;

    public n(int i, long j) {
        this.f = -1;
        this.f3662a = null;
        this.b = null;
        this.c = null;
        this.d = i;
        this.e = j;
    }

    public n(m3 m3Var, long j) {
        this.f = -1;
        this.f3662a = m3Var;
        this.b = null;
        this.c = m3Var != null ? m3Var.a() : null;
        this.d = m3Var != null ? m3Var.b() : -1;
        this.e = j;
    }

    public n(Throwable th, long j) {
        this.f = -1;
        this.f3662a = null;
        this.b = th;
        this.c = null;
        this.d = -99;
        this.e = j;
    }

    public int a() {
        String str = this.c;
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    public int b() {
        m3 m3Var = this.f3662a;
        String strA = m3Var == null ? null : m3Var.a("X-Retry-Policy");
        m3 m3Var2 = this.f3662a;
        String strA2 = m3Var2 != null ? m3Var2.a("Retry-After") : null;
        j2.a("NetResponse", "getLimitRetrySecond policy=" + strA + ",delay=" + strA2);
        int iA = com.hihonor.hianalytics.util.b.a(strA2, -1);
        if (iA != -1) {
            this.f = iA;
        }
        return (iA <= 0 || iA > 14400) ? com.hihonor.hianalytics.util.b.a(60, 1800) : iA;
    }

    public boolean c() {
        return this.d == 429;
    }

    public boolean d() {
        return this.d == 200;
    }

    public String toString() {
        return "NetResponse#" + hashCode() + "{code=" + this.d + ",retrySecond=" + this.f + ",contentLen=" + a() + ",spendTime=" + com.hihonor.hianalytics.util.r.b(this.e) + (this.b == null ? "" : ",failE=" + this.b) + '}';
    }
}
