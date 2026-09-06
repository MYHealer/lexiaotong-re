package com.hihonor.adsdk.base.init;

import com.hihonor.adsdk.common.f.t;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static final String hnadsa = "key_oaid";
    private static final String hnadsb = "key_limit";

    public static void hnadsa(String str) {
        t.hnadsc().hnadsb(hnadsa, str);
    }

    public static String hnadsb() {
        return t.hnadsc().hnadsg(hnadsa);
    }

    public static void hnadsa(boolean z) {
        t.hnadsc().hnadsb(hnadsb, z);
    }

    public static boolean hnadsa() {
        return t.hnadsc().hnadsb(hnadsb);
    }
}
