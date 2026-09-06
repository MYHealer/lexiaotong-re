package com.baidu.mobads.sdk.api;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public enum CPUAdType {
    FEED("feed"),
    INTERSTITIAL(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL),
    REWARDVIDEO(IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO),
    OTHER(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);

    private final String value;

    public String getValue() {
        return this.value;
    }

    CPUAdType(String str) {
        this.value = str;
    }

    public static CPUAdType parse(String str) {
        for (CPUAdType cPUAdType : values()) {
            if (cPUAdType.value.equalsIgnoreCase(str)) {
                return cPUAdType;
            }
        }
        return null;
    }
}
