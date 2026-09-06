package com.opos.cmn.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {
    public static String a(String str) {
        return !com.opos.cmn.an.d.a.a(str) ? com.opos.cmn.an.b.c.a(str) : "";
    }

    public static boolean a(String str, String str2) {
        boolean zEquals;
        if (com.opos.cmn.an.e.b.a.a(str)) {
            zEquals = !com.opos.cmn.an.d.a.a(str2) ? com.opos.cmn.an.b.c.b(str).equals(str2) : true;
        } else {
            zEquals = false;
        }
        StringBuilder sb = new StringBuilder("verifyFileIntegrity filePath=");
        if (str == null) {
            str = "null";
        }
        StringBuilder sbAppend = sb.append(str).append(",md5=");
        if (str2 == null) {
            str2 = "null";
        }
        com.opos.cmn.an.f.a.b("FileVerifier", sbAppend.append(str2).append(",result=").append(zEquals).toString());
        return zEquals;
    }
}
