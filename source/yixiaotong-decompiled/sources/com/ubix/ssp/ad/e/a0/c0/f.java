package com.ubix.ssp.ad.e.a0.c0;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f8638a;

    private f() {
    }

    public static void a(Object obj) {
        if (f8638a) {
            if (obj == null) {
                obj = "<null>";
            }
            Log.d("OAID", obj.toString());
        }
    }
}
