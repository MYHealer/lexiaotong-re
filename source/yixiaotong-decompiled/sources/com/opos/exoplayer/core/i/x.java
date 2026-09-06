package com.opos.exoplayer.core.i;

import android.os.Trace;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class x {
    public static void a() {
        if (y.f6517a >= 18) {
            b();
        }
    }

    public static void a(String str) {
        if (y.f6517a >= 18) {
            b(str);
        }
    }

    private static void b() {
        Trace.endSection();
    }

    private static void b(String str) {
        Trace.beginSection(str);
    }
}
