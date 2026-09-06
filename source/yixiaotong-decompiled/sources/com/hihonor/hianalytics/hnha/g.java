package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class g {
    public static String a(String str) {
        String strC = TextUtils.isEmpty(str) ? "" : h.c(str);
        return TextUtils.isEmpty(strC) ? c() : strC;
    }

    public static String a(String str, String str2) {
        return !TextUtils.isEmpty(f.a(str, str2)) ? f.a(str, str2) : c(str, str2);
    }

    public static String a(boolean z) {
        return z ? x0.c().b().v() : "";
    }

    public static Set<String> a() {
        return x0.c().a();
    }

    public static void a(int i) {
        x0.c().b().a(i);
    }

    public static void a(String[] strArr) {
        x0.c().b().a(strArr);
    }

    public static String b() {
        return x0.c().b().a();
    }

    public static String b(String str, String str2) {
        if (!"oper".equals(str2) && !"maint".equals(str2) && !"diffprivacy".equals(str2) && !"preins".equals(str2)) {
            j2.g("GlobalDataAccess", "getChannel Invalid type: " + str2);
            return "";
        }
        return d(str, str2);
    }

    public static void b(int i) {
        x0.c().b().b(i);
    }

    public static void b(String str) {
        x0.c().b().a(str);
    }

    public static void b(boolean z) {
        x0.c().b().a(z);
    }

    public static String c() {
        return x0.c().b().j();
    }

    private static String c(String str, String str2) {
        if (!f.b(str, str2)) {
            return "";
        }
        if (TextUtils.isEmpty(b())) {
            b(com.hihonor.hianalytics.util.n.a());
        }
        return b();
    }

    public static void c(int i) {
        x0.c().b().e(i);
    }

    public static void c(String str) {
        x0.c().b().d(str);
    }

    public static void c(boolean z) {
        x0.c().b().b(z);
    }

    public static String d() {
        return x0.c().b().b();
    }

    private static String d(String str, String str2) {
        if (!TextUtils.isEmpty(h.b(str, str2))) {
            return h.b(str, str2);
        }
        b1 b1VarB = x0.c().b();
        if (TextUtils.isEmpty(b1VarB.e())) {
            String strA = u0.a();
            if (!com.hihonor.hianalytics.util.o.b("channel", strA, 256)) {
                strA = "";
            }
            b1VarB.b(strA);
        }
        return b1VarB.e();
    }

    public static void d(String str) {
        x0.c().b().c(str);
    }

    public static void d(boolean z) {
        x0.c().b().c(z);
    }

    public static int e() {
        return x0.c().b().c();
    }

    public static void e(boolean z) {
        x0.c().b().d(z);
    }

    public static int f() {
        int iF = p2.b().f();
        return iF != -1 ? iF : x0.c().b().d();
    }

    public static int g() {
        return x0.c().b().d();
    }

    public static String h() {
        return x0.c().b().f();
    }

    public static int i() {
        return x0.c().b().g();
    }

    public static int j() {
        return x0.c().b().h();
    }

    public static String k() {
        return x0.c().b().i();
    }

    public static b1 l() {
        return x0.c().b();
    }

    public static String m() {
        return x0.c().b().m();
    }

    public static boolean n() {
        return x0.c().b().x();
    }

    public static synchronized String o() {
        return x0.c().b().p();
    }

    public static String p() {
        return x0.c().b().k();
    }

    public static String[] q() {
        return x0.c().b().q();
    }

    public static int r() {
        int iH = p2.b().h();
        return iH != -1 ? iH : x0.c().b().r();
    }

    public static int s() {
        return x0.c().b().r();
    }

    public static int t() {
        return x0.c().b().s();
    }

    public static int u() {
        int i = p2.b().i();
        if (i != -1) {
            return i;
        }
        return -1;
    }

    public static boolean v() {
        Boolean boolM = p2.b().m();
        return boolM != null ? boolM.booleanValue() : x0.c().b().w();
    }

    public static boolean w() {
        return x0.c().b().w();
    }

    public static boolean x() {
        return x0.c().b().y();
    }

    public static boolean y() {
        return x0.c().b().z();
    }

    public static void z() {
        x0.c().b().A();
    }
}
