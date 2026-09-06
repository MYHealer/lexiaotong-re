package com.hihonor.adsdk.common.f;

import android.graphics.Color;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g {
    private static final String hnadsa = "ColorUtils";

    public static int hnadsa(String str) {
        return hnadsa(str, 0);
    }

    public static int hnadsa(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Color.parseColor(str);
        } catch (NumberFormatException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "parseFloat, " + str + " convert Float exception  :{" + e.getMessage() + com.alipay.sdk.util.i.d, new Object[0]);
            return i;
        }
    }
}
