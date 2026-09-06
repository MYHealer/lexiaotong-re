package com.opos.cmn.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {
    public static String a() {
        String property;
        try {
            property = System.getProperty("http.agent");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DeviceUtils", "", (Throwable) e);
            property = "";
        }
        com.opos.cmn.an.f.a.b("DeviceUtils", "getUserAgent=" + (property != null ? property : "null"));
        return property;
    }
}
