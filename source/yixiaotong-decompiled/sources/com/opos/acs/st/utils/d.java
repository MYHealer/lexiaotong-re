package com.opos.acs.st.utils;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5860a;
    private static String b;
    private static String c;
    private static volatile boolean d;

    public static String a(Context context) {
        if (TextUtils.isEmpty(b)) {
            b = com.opos.cmn.biz.a.d.a(context);
        }
        return b;
    }

    public static void a() {
        d = true;
    }

    public static void a(Context context, String str) {
        com.opos.cmn.biz.a.d.a(context, "CN");
    }

    public static void a(boolean z) {
        f5860a = z;
    }

    public static String b(Context context) {
        return TextUtils.isEmpty(c) ? com.opos.cmn.biz.a.b.a(context) : c;
    }

    public static void b(Context context, String str) {
        com.opos.cmn.biz.a.b.a(context, str);
    }

    public static boolean b() {
        return d;
    }

    public static void c(Context context) {
        if (context != null) {
            try {
                com.opos.cmn.g.a.b.d(context);
            } catch (Exception e) {
                f.c("InitUtil", "", e);
            }
        }
    }
}
