package com.hihonor.adsdk.common.video.g.l;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    public static final String hnadsa = "adsdk";

    public static String hnadsa(String str) {
        return hnadsb(str) ? str.substring(5) : "";
    }

    public static boolean hnadsb(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(hnadsa);
    }
}
