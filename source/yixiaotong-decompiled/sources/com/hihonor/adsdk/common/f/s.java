package com.hihonor.adsdk.common.f;

import android.content.res.Resources;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class s {
    private static final String hnadsa = "ResourcesUtils";

    public static Resources hnadsa() {
        try {
            return com.hihonor.adsdk.common.a.hnadsa().hnadsb().getResources();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "get Resources error. msg: " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static String hnadsa(int i) {
        try {
            return hnadsa().getString(i);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "get String error. msg: " + e.getMessage(), new Object[0]);
            return "";
        }
    }

    public static String hnadsa(int i, Object... objArr) {
        try {
            return hnadsa().getString(i, objArr);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "get String format error. msg: " + e.getMessage(), new Object[0]);
            return "";
        }
    }
}
