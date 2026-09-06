package com.hihonor.adsdk.common.b;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class b {
    static {
        try {
            Class<?> cls = Class.forName("com.hihonor.adsdk.base.BuildConfig");
            String str = (String) cls.getField("SDK_VERSION").get(null);
            String str2 = (String) cls.getField("FLAVOR").get(null);
            com.hihonor.adsdk.common.b.i.e.hnadse = str;
            com.hihonor.adsdk.common.b.i.e.hnadsf = str2;
        } catch (Exception unused) {
            Log.e("HiAdsLog", "reflect buildconfig error");
        }
        d.hnadsa(new com.hihonor.adsdk.common.b.h.b());
    }

    private b() {
    }

    public static void hnadsa(String str, String str2) {
        com.hihonor.adsdk.common.b.i.e.hnadse = str;
        com.hihonor.adsdk.common.b.i.e.hnadsf = str2;
    }

    public static void hnadsb(String str, String str2, Object... objArr) {
        d.hnadsa(str, (Throwable) null, str2, objArr);
    }

    public static void hnadsc(String str, String str2, Object... objArr) {
        d.hnadsc(str, str2, objArr);
    }

    public static void hnadsd(String str, String str2, Object... objArr) {
        d.hnadsd(str, str2, objArr);
    }

    public static void hnadse(String str, String str2, Object... objArr) {
        d.hnadse(str, str2, objArr);
    }

    public static void hnadsf(String str, String str2, Object... objArr) {
        d.hnadsf(str, str2, objArr);
    }

    public static void hnadsa(int i, String str, String str2, Throwable th) {
        d.hnadsa(i, str, str2, th);
    }

    public static void hnadsa(String str, String str2, Object... objArr) {
        d.hnadsa(str, str2, objArr);
    }

    public static void hnadsa(String str, Object obj) {
        d.hnadsa(str, obj);
    }

    public static void hnadsa(String str, Throwable th, String str2, Object... objArr) {
        d.hnadsa(str, th, str2, objArr);
    }

    public static void hnadsa(boolean z) {
        d.hnadsa(z);
    }
}
