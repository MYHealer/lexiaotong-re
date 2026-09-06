package com.alipay.security.mobile.module.c;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class b {
    public static String a(String str) {
        String strA;
        try {
            strA = f.a(str);
        } catch (Throwable unused) {
            strA = "";
        }
        return com.alipay.security.mobile.module.a.a.a(strA) ? c.a(".SystemConfig" + File.separator + str) : strA;
    }
}
