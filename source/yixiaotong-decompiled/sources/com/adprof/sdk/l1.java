package com.adprof.sdk;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class l1 {
    public static String a(String str) {
        if (String.valueOf(2).equals(str)) {
            return MediationConstant.RIT_TYPE_SPLASH;
        }
        if (String.valueOf(4).equals(str)) {
            return MediationConstant.RIT_TYPE_INTERSTITIAL;
        }
        if (String.valueOf(5).equals(str)) {
            return "reward";
        }
        if (String.valueOf(1).equals(str)) {
            return "native";
        }
        return String.valueOf(3).equals(str) ? "banner" : "unknown";
    }
}
