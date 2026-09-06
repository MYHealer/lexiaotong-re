package com.opos.cmn.an.f.b;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f5914a;

    public static synchronized void a(Context context, boolean z) {
        f5914a = z;
    }

    public static synchronized boolean a(Context context) {
        return f5914a;
    }
}
