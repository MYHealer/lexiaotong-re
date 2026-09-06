package com.huawei.hms.ads;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class fh {
    private static fi Code = new fi();

    private static boolean B() {
        return Code.Code(6);
    }

    private static String Code(String str, Object[] objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Throwable unused) {
            return str;
        }
    }

    public static void Code(int i, String str, String str2) {
        Code.Code(i, str, str2);
        StringBuilder sb = new StringBuilder("\n============================================================================\n====== ");
        sb.append(V()).append("\n====== Brand: ");
        sb.append(Build.BRAND).append(" Model: ").append(Build.MODEL).append(" Release: ").append(Build.VERSION.RELEASE).append(" API: ").append(Build.VERSION.SDK_INT).append("\n============================================================================");
        Code.Code(str2, sb.toString());
    }

    public static void Code(int i, String str, String str2, Throwable th) {
        Code.Code(i, str, str2, th);
    }

    public static void Code(int i, Throwable th) {
        Code.Code(i, "", th);
    }

    public static void Code(String str, String str2) {
        Code.V(3, str, str2);
    }

    public static void Code(String str, String str2, Object... objArr) {
        if (!Code() || str2 == null) {
            return;
        }
        Code(str, Code(str2, objArr));
    }

    public static boolean Code() {
        return Code.Code(3);
    }

    public static void I(String str, String str2) {
        Code.V(5, str, str2);
    }

    public static void I(String str, String str2, Object... objArr) {
        if (!Z() || str2 == null) {
            return;
        }
        I(str, Code(str2, objArr));
    }

    private static boolean I() {
        return Code.Code(4);
    }

    private static String V() {
        return "HiAd-13.4.81.300";
    }

    public static void V(String str, String str2) {
        Code.V(4, str, str2);
    }

    public static void V(String str, String str2, Object... objArr) {
        if (!I() || str2 == null) {
            return;
        }
        V(str, Code(str2, objArr));
    }

    public static void Z(String str, String str2) {
        Code.V(6, str, str2);
    }

    public static void Z(String str, String str2, Object... objArr) {
        if (!B() || str2 == null) {
            return;
        }
        Z(str, Code(str2, objArr));
    }

    private static boolean Z() {
        return Code.Code(5);
    }
}
