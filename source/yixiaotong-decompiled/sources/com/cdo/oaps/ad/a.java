package com.cdo.oaps.ad;

import android.util.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3113a = "Y29tLm9uZXBsdXMubWFya2V0";
    public static final String b = "Y29tLm9wcG8ubWFya2V0";
    public static final String c = "b3Bwbw==";

    public static String a() {
        return b(f3113a);
    }

    public static String a(String str) {
        return new String(Base64.encode(str.getBytes(), 0));
    }

    public static String b() {
        return b(b);
    }

    public static String b(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static String c() {
        return b(c);
    }
}
