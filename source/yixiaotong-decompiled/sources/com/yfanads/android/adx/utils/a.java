package com.yfanads.android.adx.utils;

import android.util.Log;

/* JADX INFO: compiled from: AdxLog.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9621a;

    public static void a(String str) {
        if (f9621a) {
            Log.d("AdxAds", str);
        }
    }

    public static void b(String str) {
        if (f9621a) {
            Log.e("AdxAds", str);
        }
    }

    public static void c(String str) {
        if (f9621a) {
            Log.d("AdxAds", "[H] " + str);
        }
    }

    public static void d(String str) {
        if (f9621a) {
            Log.w("AdxAds", str);
        }
    }
}
