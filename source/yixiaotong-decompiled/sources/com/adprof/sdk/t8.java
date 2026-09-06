package com.adprof.sdk;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class t8 {
    public static String a(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(new String(str.getBytes(), StandardCharsets.UTF_8), "UTF-8");
        } catch (Throwable th) {
            pk.b("toURLEncoded error: ", th);
            return "";
        }
    }
}
