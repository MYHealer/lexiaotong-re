package com.hihonor.hianalytics.hnha;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class f {
    public static String a(String str, String str2) {
        y0 y0VarC = c(str, str2);
        return y0VarC != null ? y0VarC.a() : "";
    }

    public static boolean b(String str, String str2) {
        y0 y0VarC = c(str, str2);
        return y0VarC != null && y0VarC.g();
    }

    private static y0 c(String str, String str2) {
        z0 z0VarA;
        c1 c1VarA = x0.c().a(str);
        if (c1VarA == null || (z0VarA = c1VarA.a(str2)) == null) {
            return null;
        }
        return z0VarA.e();
    }

    public static String d(String str, String str2) {
        y0 y0VarC = c(str, str2);
        return y0VarC != null ? y0VarC.c() : "";
    }

    public static boolean e(String str, String str2) {
        y0 y0VarC = c(str, str2);
        return y0VarC != null && y0VarC.h();
    }

    public static boolean f(String str, String str2) {
        z0 z0VarA;
        c1 c1VarA = x0.c().a(str);
        if (c1VarA == null || (z0VarA = c1VarA.a(str2)) == null) {
            return false;
        }
        return z0VarA.q();
    }

    public static String g(String str, String str2) {
        y0 y0VarC = c(str, str2);
        return y0VarC != null ? y0VarC.e() : "";
    }

    public static boolean h(String str, String str2) {
        y0 y0VarC = c(str, str2);
        return y0VarC != null && y0VarC.i();
    }

    public static boolean i(String str, String str2) {
        z0 z0VarA;
        c1 c1VarA = x0.c().a(str);
        if (c1VarA == null || (z0VarA = c1VarA.a(str2)) == null) {
            return false;
        }
        return z0VarA.r();
    }

    public static String j(String str, String str2) {
        y0 y0VarC = c(str, str2);
        return y0VarC != null ? y0VarC.d() : "";
    }

    public static boolean k(String str, String str2) {
        y0 y0VarC = c(str, str2);
        return y0VarC != null && y0VarC.j();
    }
}
