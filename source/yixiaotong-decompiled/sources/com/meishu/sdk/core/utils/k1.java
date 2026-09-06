package com.meishu.sdk.core.utils;

import com.meishu.sdk.core.ad.BaseAdSlot;

/* JADX INFO: compiled from: SplashResReportUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class k1 {
    public static void a(BaseAdSlot baseAdSlot, int i, boolean z) {
        try {
            int i2 = 2;
            if (baseAdSlot.getAdPatternType() != 2) {
                i2 = 1;
            }
            o1.a(baseAdSlot.getEventUrl(), 24, 0, "{\"type\":" + i2 + ",\"source\":" + i + ",\"cache\":" + (z ? 1 : 0) + com.alipay.sdk.util.i.d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
