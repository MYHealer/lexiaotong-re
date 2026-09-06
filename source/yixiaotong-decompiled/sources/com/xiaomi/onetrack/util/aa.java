package com.xiaomi.onetrack.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class aa {
    private static SharedPreferences c;
    private static SharedPreferences.Editor d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9506a = ijiami_1011.s.s.s.d(new byte[]{94, 88, 80, Ascii.ETB, 65, 83, 2, 15}, "165c32");
    private static final String b = ijiami_1011.s.s.s.d(new byte[]{91, 89, 7, 110, SignedBytes.MAX_POWER_OF_TWO, Ascii.ETB, 0, 7, 13, Base64.padSymbol, 65, Ascii.ETB, 81, 81}, "47b14e");
    private static final String e = ijiami_1011.s.s.s.d(new byte[]{94, 82, 67, 66, 102, 65, 17, 8, 9, 3, 85, 58, 83, 80, 68, 95, 79, 81, 62, 16, 15, 15, 84}, "230694");
    private static final String f = ijiami_1011.s.s.s.d(new byte[]{92, 85, 68, SignedBytes.MAX_POWER_OF_TWO, 58, 19, 17, 8, 9, 3, 85, 58, 69, 71, 86, 83, 0, 57, Ascii.NAK, 13, 11, 7}, "0474ef");
    private static final String g = ijiami_1011.s.s.s.d(new byte[]{88, 89, 66, 76, 105, 5, 14, 8, 10, 7, 82, 17, 107, 91, 67, 89, 69, 14, 62, 16, 15, 15, 84}, "48186f");
    private static final String h = ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 93, 70, 88, 75, 69, 62, 7, Ascii.DC4, 3, 66, 13, 58, 76, 95, 84, 82, 84, Ascii.NAK}, "e86791");
    private static final String i = ijiami_1011.s.s.s.d(new byte[]{10, 81, Ascii.ETB, 76, 104, Ascii.SYN, 4, 7, Ascii.DC4, 7, 69, 58, 13, 85, Ascii.GS, 103, 67, 12, 12, 1}, "f0d87e");
    private static final String j = ijiami_1011.s.s.s.d(new byte[]{93, 3, 66, 70, 102, 80, 14, 9, 11, 13, 95, 58, 82, 14, 94, 71, 93, 108, Ascii.NAK, 13, 11, 7}, "1b1293");
    private static final String k = ijiami_1011.s.s.s.d(new byte[]{87, 86, 75, SignedBytes.MAX_POWER_OF_TWO, 58, Ascii.SYN, 17, 0, 7, Ascii.SYN, 84, 58, 90, 92, 94, 89, 10, 13, 62, 7, 9, 12, 87, 58, 77, 90, 94, 81}, "9334ec");
    private static final String l = ijiami_1011.s.s.s.d(new byte[]{81, 10, 12, 88, 91, 89, 62, 7, 10, 13, 68, 1, 109, 1, 0, 65, 85}, "2ea547");
    private static final String m = ijiami_1011.s.s.s.d(new byte[]{81, 9, 94, 15, 9, 10, 62, 7, 9, 12, 87, 12, 85, 57, 91, 3, Ascii.NAK, 12}, "2f3bfd");
    private static final String n = ijiami_1011.s.s.s.d(new byte[]{75, 102, Ascii.NAK}, "89a9f1");
    private static final String o = ijiami_1011.s.s.s.d(new byte[]{93, Base64.padSymbol, 71}, "1b3e72");
    private static final String p = ijiami_1011.s.s.s.d(new byte[]{0, 105, Ascii.SYN}, "e6b923");
    private static final String q = ijiami_1011.s.s.s.d(new byte[]{69, 81, 0, 19, 0, Ascii.NAK, 62, 15, 3, Ascii.ESC, 110, 1, 87, SignedBytes.MAX_POWER_OF_TWO, 2}, "64caea");
    private static final String r = ijiami_1011.s.s.s.d(new byte[]{66, 86, 81, 8, 93, 86, 62, Ascii.SYN, 19, 14}, "036a28");
    private static final String s = ijiami_1011.s.s.s.d(new byte[]{68, 69, 7, 7, 58, 94, 15, Ascii.ETB, Ascii.DC2, 3, 95, 6, 81, 104, 11, 5}, "47bae7");
    private static final String t = ijiami_1011.s.s.s.d(new byte[]{70, 17, 82, 85, 104, 13, 15, Ascii.ETB, Ascii.DC2, 3, 95, 6, 83, 60, 94, 87, 104, 8, 0, Ascii.ETB, Ascii.DC2, Base64.padSymbol, 68, Ascii.SYN, 83, 60, 67, 90, 90, 1}, "6c737d");
    private static final String u = ijiami_1011.s.s.s.d(new byte[]{9, 2, Ascii.NAK, 69, 105, 76, Ascii.DC2, 5, 1, 7, 110, Ascii.ETB, 0, 16, 19, 92, 83, 102, 2, 11, 11, Ascii.DC2, 94, 11, 0, 13, Ascii.DC2}, "ecf169");
    private static final String v = ijiami_1011.s.s.s.d(new byte[]{15, 84, 67, Ascii.NAK, 107, 16, Ascii.DC2, 5, 1, 7, 110, Ascii.ETB, 6, 70, 69, 12, 81, 58, Ascii.NAK, 13, 11, 7}, "c50a4e");
    private static final String w = ijiami_1011.s.s.s.d(new byte[]{94, 93, 68, Ascii.DC4, 89, 65, 10, 59, 7, 1, 82, 0, 67, 75, 111, 6, 88, 82, 3, 8, 3, 6}, "080c63");
    private static final String x = ijiami_1011.s.s.s.d(new byte[]{2, 95, 11, 91, 78, 85, 14, 17, Ascii.NAK, Base64.padSymbol, 84, 11, 2, 83, 8, 80, 83}, "c1d578");
    private static final String y = ijiami_1011.s.s.s.d(new byte[]{13, 10, 3, 69, 66, 84, 2, 15, 57, 4, 88, Ascii.ETB, 17, 16, 57, 94, SignedBytes.MAX_POWER_OF_TWO, 80, 15}, "bdf105");
    private static final String z = ijiami_1011.s.s.s.d(new byte[]{7, 87, Ascii.SYN, 57, 85, 86, Ascii.DC2, 16, 57, Ascii.SYN, 88, 8, 6}, "c6cf97");
    private static final String A = ijiami_1011.s.s.s.d(new byte[]{88, 10, 3, 68, 67, 3, 2, 15, 57, Ascii.ETB, 66, 0, 69, 59, 15, 84}, "7df01b");
    private static final String B = ijiami_1011.s.s.s.d(new byte[]{90, 10, 86, 77, SignedBytes.MAX_POWER_OF_TWO, 4, 2, 15, 57, Ascii.ETB, 66, 0, 71, 59, 71, SignedBytes.MAX_POWER_OF_TWO, 66, 0}, "5d392e");
    private static final String C = ijiami_1011.s.s.s.d(new byte[]{6, 66, 68, 16, 86, 94, 62, 13, 2}, "e77d93");
    private static final String D = ijiami_1011.s.s.s.d(new byte[]{19, 83, 86, 82, 102, 87, 15, 0}, "c21792");
    private static final String E = ijiami_1011.s.s.s.d(new byte[]{14, 85, 71, Ascii.NAK, 105, 88, 17, Ascii.DC4, 57, Ascii.DC4, 84, Ascii.ETB, 17, 93, 91, 15}, "b44a69");
    private static final String F = ijiami_1011.s.s.s.d(new byte[]{95, 92, Ascii.SYN, 70, SignedBytes.MAX_POWER_OF_TWO, 105, 13, 5, 19, 12, 82, 13, 102, 65, 13, 88, 81}, "95d546");
    private static final String G = ijiami_1011.s.s.s.d(new byte[]{66, 19, 1, 2, 105, 91, Ascii.DC4, Ascii.ETB, Ascii.DC2, 13, 92, 58, 66, 19, 13, Ascii.DC2, 87, 91, Ascii.CAN, 59, Ascii.SYN, 13, 93, 12, 81, Ascii.CAN, 59}, "2add68");
    private static final String H = ijiami_1011.s.s.s.d(new byte[]{85, 68, Ascii.SYN, 102, 7, 10, 15, 2, 15, 5, 110, Ascii.ETB, 81, 83, 15, 86, 10}, "44f9de");

    public static String A() {
        return a(E, "");
    }

    public static long B() {
        return a(F, 0L);
    }

    public static String C() {
        return a(H, "");
    }

    private static void D() {
        if (d != null) {
            return;
        }
        synchronized (aa.class) {
            if (d == null) {
                SharedPreferences sharedPreferences = com.xiaomi.onetrack.f.a.a().getSharedPreferences(b, 0);
                c = sharedPreferences;
                d = sharedPreferences.edit();
            }
        }
    }

    public static long a() {
        return a(e, 0L);
    }

    private static long a(String str, long j2) {
        D();
        return c.getLong(str, j2);
    }

    public static String a(Context context) {
        return a(C, "");
    }

    private static String a(String str, String str2) {
        D();
        return c.getString(str, str2);
    }

    public static void a(long j2) {
        b(e, j2);
    }

    public static void a(Context context, String str) {
        b(C, str);
    }

    public static void a(String str) {
        b(q, str);
    }

    private static void a(String str, float f2) {
        D();
        d.putFloat(str, f2).apply();
    }

    public static void a(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c(G + str, z2);
    }

    public static void a(boolean z2) {
        c(w, z2);
    }

    private static float b(String str, float f2) {
        D();
        return c.getFloat(str, f2);
    }

    public static long b() {
        return a(g, 0L);
    }

    public static long b(long j2) {
        return a(f, j2);
    }

    public static void b(String str) {
        b(r, str);
    }

    private static void b(String str, long j2) {
        D();
        d.putLong(str, j2).apply();
    }

    private static void b(String str, String str2) {
        D();
        d.putString(str, str2).apply();
    }

    public static void b(boolean z2) {
        c(x, z2);
    }

    private static boolean b(String str, boolean z2) {
        D();
        return c.getBoolean(str, z2);
    }

    public static long c() {
        return a(h, 0L);
    }

    public static void c(long j2) {
        b(g, j2);
    }

    public static void c(String str) {
        b(m, str);
    }

    private static void c(String str, boolean z2) {
        D();
        d.putBoolean(str, z2).apply();
    }

    public static void c(boolean z2) {
        c(y, z2);
    }

    public static long d() {
        return a(n, 0L);
    }

    public static void d(long j2) {
        b(h, j2);
    }

    public static void d(String str) {
        b(l, str);
    }

    public static long e() {
        return a(o, 0L);
    }

    public static void e(long j2) {
        b(f, j2);
    }

    public static void e(String str) {
        b(s, str);
        k(ac.a());
    }

    public static long f() {
        return a(p, 0L);
    }

    public static void f(long j2) {
        b(n, j2);
    }

    public static void f(String str) {
        b(u, str);
    }

    public static String g() {
        return a(q, "");
    }

    public static void g(long j2) {
        b(o, j2);
    }

    public static void g(String str) {
        b(A, str);
    }

    public static String h() {
        return a(r, "");
    }

    public static void h(long j2) {
        b(p, j2);
    }

    public static void h(String str) {
        b(B, str);
    }

    public static long i() {
        return a(i, 0L);
    }

    public static void i(long j2) {
        b(i, j2);
    }

    public static void i(String str) {
        b(D, str);
    }

    public static long j() {
        return a(k, 0L);
    }

    public static void j(long j2) {
        b(k, j2);
    }

    public static void j(String str) {
        b(E, str);
    }

    public static String k() {
        return a(m, "");
    }

    public static void k(long j2) {
        b(t, j2);
    }

    public static boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return b(G + str, true);
    }

    public static String l() {
        return a(l, "");
    }

    public static void l(long j2) {
        b(v, j2);
    }

    public static void l(String str) {
        b(H, str);
    }

    public static String m() {
        return a(s, "");
    }

    public static void m(long j2) {
        b(z, j2);
    }

    private static void m(String str) {
        D();
        d.remove(str).apply();
    }

    public static long n() {
        return a(t, 0L);
    }

    public static void n(long j2) {
        b(F, j2);
    }

    public static String o() {
        return a(u, "");
    }

    public static long p() {
        return a(v, 0L);
    }

    public static boolean q() {
        return b(w, true);
    }

    public static boolean r() {
        return b(x, false);
    }

    public static boolean s() {
        return b(y, true);
    }

    public static long t() {
        return a(z, 0L);
    }

    public static String u() {
        return a(A, "");
    }

    public static void v() {
        m(A);
    }

    public static String w() {
        return a(B, "");
    }

    public static void x() {
        m(B);
    }

    public static long y() {
        return a(w, 0L);
    }

    public static String z() {
        return a(D, "");
    }
}
