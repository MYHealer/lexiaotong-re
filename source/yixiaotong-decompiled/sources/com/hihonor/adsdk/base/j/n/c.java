package com.hihonor.adsdk.base.j.n;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static final String hnadsa = "LocationHandlerFactory";

    public static b hnadsa(int i) {
        if (i == 1) {
            return new d();
        }
        if (i == 2) {
            return new e();
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "cannot create LocationHandler", new Object[0]);
        return null;
    }
}
