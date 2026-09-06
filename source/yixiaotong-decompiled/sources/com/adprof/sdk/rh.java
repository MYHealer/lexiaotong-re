package com.adprof.sdk;

import java.util.IllegalFormatException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class rh {
    public static String a(String str, Object... objArr) {
        String strValueOf = String.valueOf(str);
        try {
            return String.format(strValueOf, objArr);
        } catch (IllegalFormatException e) {
            pk.b("sdk preconditions had a format exception: " + e.getMessage());
            return strValueOf;
        }
    }

    public static boolean a(boolean z, boolean z2, String str, Object[] objArr) {
        if (z) {
            return true;
        }
        String strA = a(str, objArr);
        if (z2) {
            throw new IllegalArgumentException(strA);
        }
        pk.b(strA);
        return false;
    }

    public static boolean a(Object obj, boolean z, String str, Object[] objArr) {
        if (obj != null) {
            return true;
        }
        String strA = a(null, objArr);
        if (z) {
            throw new NullPointerException(strA);
        }
        pk.b(strA);
        return false;
    }
}
