package com.hihonor.adsdk.base.init.j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private static volatile c hnadsa;

    public static synchronized c hnadsa() {
        if (hnadsa != null) {
            return hnadsa;
        }
        hnadsa = new a();
        return hnadsa;
    }
}
