package com.opos.mobad.service;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f7327a;
    private static volatile Context b;

    public static Context a(Context context) {
        return f7327a != null ? f7327a : context;
    }

    public static void a() {
        f7327a = null;
        b = null;
    }

    public static void a(Context context, Context context2) {
        f7327a = context;
        b = context2;
    }

    public static Context b(Context context) {
        return b != null ? b : context;
    }
}
