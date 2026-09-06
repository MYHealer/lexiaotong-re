package com.opos.cmn.func.a.b.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f {
    public static String a() {
        try {
            return System.getProperty("http.agent");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("Utils", "getUA", e);
            return "";
        }
    }
}
