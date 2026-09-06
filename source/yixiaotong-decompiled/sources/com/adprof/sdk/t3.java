package com.adprof.sdk;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class t3 {
    public static void a(Object obj) {
        if (obj != null) {
            return;
        }
        Log.d("ASSERTION-FAILED", "invoke trace", new Exception("invoke trace"));
    }
}
