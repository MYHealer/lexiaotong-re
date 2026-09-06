package com.hihonor.adsdk.base.g;

import android.text.TextUtils;
import android.util.ArrayMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class e {
    private static final String hnadsa = "ExposureManager";
    private static final Map<String, Boolean> hnadsb = new ArrayMap();

    public static void hnadsa(String str) {
        if (TextUtils.isEmpty(str)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "#exposureAd#Exposure id is empty.", new Object[0]);
        } else {
            hnadsb.put(str, Boolean.TRUE);
        }
    }

    public static boolean hnadsb(String str) {
        if (!TextUtils.isEmpty(str)) {
            return Boolean.TRUE.equals(hnadsb.get(str));
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "#isAdExposure#Exposure id is empty.", new Object[0]);
        return false;
    }

    public static void hnadsc(String str) {
        if (TextUtils.isEmpty(str)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "#remove#Exposure id is empty.", new Object[0]);
        } else {
            hnadsb.remove(str);
        }
    }
}
