package com.kwad.sdk.utils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class l {
    public static void s(String str, int i) {
        com.kwad.sdk.core.d.c.d("audioVideoLog", str + "_type_" + i + "_time_" + System.currentTimeMillis());
    }

    public static void at(String str, String str2) {
        com.kwad.sdk.core.d.c.d("callbackLog", str + str2);
    }

    public static void b(String str, String str2, String str3, String str4) {
        at(str, str2 + "_" + str3 + "_" + str4);
    }
}
