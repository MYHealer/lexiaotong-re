package com.opos.cmn.an.f.c;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f5915a;

    public static String a(Context context) {
        try {
            b(context);
            return com.oplus.stdid.sdk.a.a() ? com.oplus.stdid.sdk.a.d(context) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static void b(Context context) {
        if (f5915a) {
            return;
        }
        com.oplus.stdid.sdk.a.b(context);
        f5915a = true;
    }
}
