package com.opos.mobad.service.f;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    private static String a(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 0) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String a(String str, String str2, String str3) {
        return str.replace(str2, a(str3));
    }
}
