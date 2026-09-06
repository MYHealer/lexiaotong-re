package com.alipay.sdk.app.statistic;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1627a = "alipay_cashier_statistic_record";
    private static c b;

    public static void a(Context context) {
        if (b != null) {
            return;
        }
        b = new c(context);
    }

    public static void a(Context context, String str) {
        new Thread(new b(context, str)).start();
    }

    public static synchronized void b(Context context, String str) {
        c cVar = b;
        if (cVar == null) {
            return;
        }
        a(context, cVar.a(str));
        b = null;
    }

    public static void a(String str, Throwable th) {
        if (b == null || th == null || th.getClass() == null) {
            return;
        }
        b.a(str, th.getClass().getSimpleName(), th);
    }

    public static void a(String str, String str2, Throwable th, String str3) {
        c cVar = b;
        if (cVar == null) {
            return;
        }
        cVar.a(str, str2, th, str3);
    }

    public static void a(String str, String str2, Throwable th) {
        c cVar = b;
        if (cVar == null) {
            return;
        }
        cVar.a(str, str2, th);
    }

    public static void a(String str, String str2, String str3) {
        c cVar = b;
        if (cVar == null) {
            return;
        }
        cVar.a(str, str2, str3);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        try {
            c cVar = new c(context);
            cVar.a(str, str2, str3);
            a(context, cVar.a(""));
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }
}
