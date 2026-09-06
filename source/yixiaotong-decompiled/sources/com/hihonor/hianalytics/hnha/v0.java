package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import android.util.Pair;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final v0 f3690a = new v0();

    private static class a extends w0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f3691a;
        String b;

        public a(String str, String str2) {
            this.f3691a = str;
            this.b = str2;
        }

        @Override // com.hihonor.hianalytics.hnha.w0
        public String a() {
            return f.d(this.f3691a, this.b);
        }

        @Override // com.hihonor.hianalytics.hnha.w0
        public String a(String str) {
            return com.hihonor.hianalytics.util.i.a(str);
        }

        @Override // com.hihonor.hianalytics.hnha.w0
        public String b() {
            return f.g(this.f3691a, this.b);
        }

        @Override // com.hihonor.hianalytics.hnha.w0
        public String c() {
            return f.j(this.f3691a, this.b);
        }

        @Override // com.hihonor.hianalytics.hnha.w0
        public int d() {
            return (f.k(this.f3691a, this.b) ? 4 : 0) | (f.e(this.f3691a, this.b) ? 2 : 0) | (f.h(this.f3691a, this.b) ? 1 : 0);
        }
    }

    public static v0 a() {
        return f3690a;
    }

    public String a(String str, String str2) {
        return g.a(str, str2);
    }

    public String b(String str, String str2) {
        return g.b(str, str2);
    }

    public s0 c(String str, String str2) {
        return new a(str, str2).e();
    }

    public String d(String str, String str2) {
        return h.e(str, str2);
    }

    public String e(String str, String str2) {
        return h.i(str, str2);
    }

    public Pair<String, String> f(String str, String str2) {
        if (!f.f(str, str2)) {
            return new Pair<>("", "");
        }
        String strN = x0.c().b().n();
        String strO = x0.c().b().o();
        if (!TextUtils.isEmpty(strN) && !TextUtils.isEmpty(strO)) {
            return new Pair<>(strN, strO);
        }
        Pair<String, String> pairB = com.hihonor.hianalytics.util.n.b();
        x0.c().b().f((String) pairB.first);
        x0.c().b().g((String) pairB.second);
        return pairB;
    }

    public String g(String str, String str2) {
        return h.h(str, str2);
    }
}
