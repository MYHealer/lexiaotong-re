package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f1599a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static Map<String, String> f = new HashMap();

    public static synchronized String a(String str) {
        String str2 = "apdidTokenCache" + str;
        if (f.containsKey(str2)) {
            String str3 = f.get(str2);
            if (com.alipay.security.mobile.module.a.a.b(str3)) {
                return str3;
            }
        }
        return "";
    }

    public static synchronized void a() {
    }

    public static synchronized void a(b bVar) {
        if (bVar != null) {
            f1599a = bVar.f1595a;
            b = bVar.b;
            c = bVar.c;
        }
    }

    public static synchronized void a(c cVar) {
        if (cVar != null) {
            f1599a = cVar.f1596a;
            b = cVar.b;
            d = cVar.d;
            e = cVar.e;
            c = cVar.c;
        }
    }

    public static synchronized void a(String str, String str2) {
        String str3 = "apdidTokenCache" + str;
        if (f.containsKey(str3)) {
            f.remove(str3);
        }
        f.put(str3, str2);
    }

    public static synchronized boolean a(Context context, String str) {
        long j = 86400000;
        long jA = h.a(context);
        if (jA >= 0) {
            j = jA;
        }
        try {
            if (Math.abs(System.currentTimeMillis() - h.h(context, str)) < j) {
                return true;
            }
        } catch (Throwable th) {
            com.alipay.apmobilesecuritysdk.c.a.a(th);
        }
        return false;
    }

    public static synchronized String b() {
        return f1599a;
    }

    public static void b(String str) {
        f1599a = str;
    }

    public static synchronized String c() {
        return b;
    }

    public static void c(String str) {
        b = str;
    }

    public static synchronized String d() {
        return d;
    }

    public static void d(String str) {
        c = str;
    }

    public static synchronized String e() {
        return e;
    }

    public static void e(String str) {
        d = str;
    }

    public static synchronized String f() {
        return c;
    }

    public static void f(String str) {
        e = str;
    }

    public static synchronized c g() {
        return new c(f1599a, b, c, d, e);
    }

    public static void h() {
        f.clear();
        f1599a = "";
        b = "";
        d = "";
        e = "";
        c = "";
    }
}
