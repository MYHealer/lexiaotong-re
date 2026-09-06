package com.oplus.log.d;

import android.text.TextUtils;
import android.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class g {
    private static Map<String, String> q = new ConcurrentHashMap(16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5821a = a("T1BQTw==");
    public static final String b = a(com.cdo.oaps.ad.a.c);
    public static final String c = a("T3Bwbw==");
    public static final String d = a("UmVhbG1l");
    public static final String e = a("cmVhbG1l");
    public static final String f = a("T25lUGx1cw==");
    public static final String g = a("b25lcGx1cw==");
    public static final String h = a("Q29sb3JPUw==");
    public static final String i = a("Q09MT1JPUw==");
    public static final String j = a("Y29sb3Jvcw==");
    public static final String k = a("Y29sb3JPUw==");
    public static final String l = a("Y29sb3I=");
    public static final String m = a("Q29sb3JCdWlsZA==");
    public static final String n = a("T3BsdXNPUw==");
    public static final String o = a("SHlkcm9nZW4gT1Mg");
    public static final String p = a("T3h5Z2VuIE9TIA==");

    private static String a(String str) {
        String str2 = q.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String str3 = new String(Base64.decode(str.getBytes(), 0));
        q.put(str, str3);
        return str3;
    }
}
