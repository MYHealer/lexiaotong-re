package com.kwad.sdk.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class az {
    private static void a(RuntimeException runtimeException) {
        com.kwad.sdk.core.d.c.printStackTrace(runtimeException);
    }

    public static <T> T checkNotNull(T t) {
        return (T) g(t, "");
    }

    public static <T> T g(T t, String str) {
        if (t == null) {
            a(new NullPointerException("Argument cannot be null " + str));
        }
        return t;
    }

    public static String hY(String str) {
        return aC(str, "");
    }

    public static String aC(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            a(new NullPointerException("Argument cannot be null " + str2));
        }
        return str;
    }

    public static void d(Object... objArr) {
        for (int i = 0; i < 2; i++) {
            checkNotNull(objArr[i]);
        }
    }

    public static void checkArgument(boolean z, Object obj) {
        if (z) {
            return;
        }
        a(new IllegalArgumentException("Expression cannot be false " + obj));
    }
}
