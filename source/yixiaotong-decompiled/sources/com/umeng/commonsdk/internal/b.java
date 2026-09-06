package com.umeng.commonsdk.internal;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: compiled from: UMInternalData.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {
    private static b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9224a;
    private c c;

    public c a() {
        return this.c;
    }

    private b(Context context) {
        this.f9224a = context;
        this.c = new c(context);
    }

    public static synchronized b a(Context context) {
        if (b == null) {
            b = new b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        return b;
    }
}
