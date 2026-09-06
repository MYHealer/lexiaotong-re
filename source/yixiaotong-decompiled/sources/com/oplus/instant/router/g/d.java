package com.oplus.instant.router.g;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f5778a;

    public static void a() {
        f5778a = true;
    }

    public static void a(String str, String str2) {
        if (f5778a) {
            Log.d(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        String str3;
        StringBuilder sbAppend;
        String message;
        if (th != null) {
            if (f5778a) {
                sbAppend = new StringBuilder().append(str2).append("##Throwable##");
                message = Log.getStackTraceString(th);
            } else {
                sbAppend = new StringBuilder().append(str2);
                message = th.getMessage();
            }
            Log.d(str, sbAppend.append(message).toString());
            str3 = null;
        } else {
            str3 = "throwable is null";
        }
        c(str, str2 + str3);
    }

    public static void a(String str, Throwable th) {
        a(str, "", th);
    }

    public static void b(String str, String str2) {
        if (f5778a) {
            Log.i(str, str2);
        }
    }

    public static void c(String str, String str2) {
        Log.e(str, str2);
    }
}
