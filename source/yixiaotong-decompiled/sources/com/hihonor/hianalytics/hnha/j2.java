package com.hihonor.hianalytics.hnha;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final k2 f3650a = new k2();

    public static int a() {
        return f3650a.a();
    }

    public static void a(int i, String str) {
        f3650a.a(i, str);
        e("HiLog", "init priority=" + i);
    }

    public static void a(int i, String str, String str2) {
        f3650a.b(i, str, str2);
    }

    public static void a(int i, String str, String str2, Object... objArr) {
        if (!a(i) || str2 == null) {
            return;
        }
        a(i, str, String.format(str2, objArr));
    }

    public static void a(String str, String str2) {
        f3650a.b(3, str, str2);
    }

    public static void a(String str, String str2, Object... objArr) {
        if (!b() || str2 == null) {
            return;
        }
        a(str, String.format(str2, objArr));
    }

    public static void a(boolean z, String str, String str2) {
        if (z) {
            d(str, str2);
        } else {
            c(str, str2);
        }
    }

    public static void a(boolean z, String str, String str2, Object... objArr) {
        if (z) {
            d(str, str2, objArr);
        } else {
            c(str, str2, objArr);
        }
    }

    public static boolean a(int i) {
        return f3650a.a(i);
    }

    public static void b(String str, String str2) {
        f3650a.b(6, str, str2);
    }

    public static void b(String str, String str2, Object... objArr) {
        if (!c() || str2 == null) {
            return;
        }
        b(str, String.format(str2, objArr));
    }

    public static void b(boolean z, String str, String str2) {
        if (z) {
            e(str, str2);
        } else {
            g(str, str2);
        }
    }

    public static void b(boolean z, String str, String str2, Object... objArr) {
        if (z) {
            e(str, str2, objArr);
        } else {
            g(str, str2, objArr);
        }
    }

    public static boolean b() {
        return f3650a.a(3);
    }

    public static void c(String str, String str2) {
        f3650a.b(4, str, str2);
    }

    public static void c(String str, String str2, Object... objArr) {
        if (!d() || str2 == null) {
            return;
        }
        c(str, String.format(str2, objArr));
    }

    public static boolean c() {
        return f3650a.a(6);
    }

    public static void d(String str, String str2) {
        f3650a.c(4, str, str2);
    }

    public static void d(String str, String str2, Object... objArr) {
        d(str, String.format(str2, objArr));
    }

    public static boolean d() {
        return f3650a.a(4);
    }

    public static void e(String str, String str2) {
        f3650a.c(5, str, str2);
    }

    public static void e(String str, String str2, Object... objArr) {
        d(str, String.format(str2, objArr));
    }

    public static boolean e() {
        return f3650a.b();
    }

    public static void f(String str, String str2) {
        f3650a.b(2, str, str2);
    }

    public static void f(String str, String str2, Object... objArr) {
        if (!f() || str2 == null) {
            return;
        }
        f(str, String.format(str2, objArr));
    }

    public static boolean f() {
        return f3650a.a(2);
    }

    public static void g(String str, String str2) {
        f3650a.b(5, str, str2);
    }

    public static void g(String str, String str2, Object... objArr) {
        if (!g() || str2 == null) {
            return;
        }
        g(str, String.format(str2, objArr));
    }

    public static boolean g() {
        return f3650a.a(5);
    }
}
