package com.hihonor.hianalytics.hnha;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class k2 {
    private static n2 d = l2.a();
    private String b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3654a = 4;
    private boolean c = false;

    private o2 a(int i, String str, String str2) {
        o2 o2Var = new o2(7, this.b, i, str);
        o2Var.a(str2);
        return o2Var;
    }

    public int a() {
        return this.f3654a;
    }

    public void a(int i, String str) {
        this.f3654a = i;
        this.b = str;
        d.a("HiAnalytics");
        this.c = true;
    }

    public boolean a(int i) {
        return this.c && i >= this.f3654a;
    }

    public void b(int i, String str, String str2) {
        if (a(i)) {
            o2 o2VarA = a(i, str, str2);
            d.a(o2VarA.d() + o2VarA.a(), i, o2VarA.e(), str2);
        }
    }

    public boolean b() {
        return this.c;
    }

    public void c(int i, String str, String str2) {
        o2 o2VarA = a(i, str, str2);
        d.a(o2VarA.d() + o2VarA.a(), i, o2VarA.e(), str2);
    }
}
