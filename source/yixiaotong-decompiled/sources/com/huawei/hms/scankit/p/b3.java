package com.huawei.hms.scankit.p;

import java.util.Stack;

/* JADX INFO: compiled from: GlobalVariable.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4215a = true;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static float e = -1.0f;
    public static int f;
    public static int g;
    public static boolean h;
    public static boolean i;
    public static boolean j;
    public static boolean k;
    public static boolean l;
    public static boolean m;
    public static boolean n;
    public static boolean o;
    public static boolean p;
    public static boolean q;
    public static boolean[] r = new boolean[8];
    public static Stack<Integer> s = new Stack<>();
    public static boolean t = true;

    public static void a() {
        d = false;
        e = -1.0f;
        f = 0;
        l = false;
        m = false;
        n = false;
        p = false;
        i = false;
        j = false;
        k = false;
        o = false;
        r = new boolean[8];
        s = new Stack<>();
        t = true;
    }

    public static void a(int i2) {
        if (i2 % 2 == 1) {
            l = true;
        }
        if (i2 % 3 == 2) {
            m = true;
        }
        if (i2 % 5 == 4) {
            n = true;
        }
    }

    public static void a(b6 b6Var) {
        a();
        boolean z = b6Var.e;
        c = z;
        t = b6Var.g;
        if (!z) {
            a(b6Var.f);
        } else {
            a(1);
        }
    }
}
