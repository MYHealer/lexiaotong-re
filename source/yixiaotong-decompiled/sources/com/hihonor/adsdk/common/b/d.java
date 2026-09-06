package com.hihonor.adsdk.common.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class d {
    public static final int hnadsa = 2;
    public static final int hnadsb = 3;
    public static final int hnadsc = 4;
    public static final int hnadsd = 5;
    public static final int hnadse = 6;
    public static final int hnadsf = 7;
    private static final e hnadsg = new c();

    private d() {
    }

    public static void hnadsa(f fVar) {
        hnadsg.hnadsa(fVar);
    }

    public static void hnadsb(String str, String str2, Object... objArr) {
        hnadsg.hnadsa(str, (Throwable) null, str2, objArr);
    }

    public static void hnadsc(String str, String str2, Object... objArr) {
        hnadsg.hnadsf(str, str2, objArr);
    }

    public static void hnadsd(String str, String str2, Object... objArr) {
        hnadsg.hnadse(str, str2, objArr);
    }

    public static void hnadse(String str, String str2, Object... objArr) {
        hnadsg.hnadsb(str, str2, objArr);
    }

    public static void hnadsf(String str, String str2, Object... objArr) {
        hnadsg.hnadsc(str, str2, objArr);
    }

    public static void hnadsa(boolean z) {
        hnadsg.hnadsa(z);
    }

    public static void hnadsa(int i, String str, String str2, Throwable th) {
        hnadsg.hnadsa(i, str, str2, th);
    }

    public static void hnadsa(String str, String str2, Object... objArr) {
        hnadsg.hnadsa(str, str2, objArr);
    }

    public static void hnadsa(String str, Object obj) {
        hnadsg.hnadsa(str, obj);
    }

    public static void hnadsa(String str, Throwable th, String str2, Object... objArr) {
        hnadsg.hnadsa(str, th, str2, objArr);
    }
}
