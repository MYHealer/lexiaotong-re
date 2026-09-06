package com.byazt.vif;

import com.byazt.dna.eo;
import com.byazt.it.sp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 2075, 15})
public class uj {
    public static boolean c() {
        return (com.byazt.qpp.c.c().tt() & 2) == 2;
    }

    public static boolean tt() {
        return (com.byazt.qpp.c.c().tt() & 4) == 4;
    }

    private static com.byazt.dna.c c(String str) {
        return com.byazt.vxy.c.c().c(str);
    }

    public static com.byazt.it.ve c(String str, String str2) {
        return ((eo) com.byazt.ut.uj.getService("storage_service")).getGlobalStorage(c(str), str2);
    }

    public static com.byazt.it.n tt(String str, String str2) {
        return ((eo) com.byazt.ut.uj.getService("storage_service")).getLayerIsolateStore(c(str), str2);
    }

    public static sp ve(String str, String str2) {
        return ((eo) com.byazt.ut.uj.getService("storage_service")).getVersionIsolateStore(c(str), str2);
    }
}
