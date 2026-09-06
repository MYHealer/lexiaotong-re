package com.meishu.sdk.core.utils;

import com.meishu.sdk.core.ad.BaseAdSlot;

/* JADX INFO: compiled from: RewardReportUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a1 {
    public static void a(BaseAdSlot baseAdSlot, int i) {
        a(baseAdSlot, i, 0, "");
    }

    public static void a(BaseAdSlot baseAdSlot, int i, int i2, String str) {
        try {
            o1.a(baseAdSlot.getEventUrl(), i, i2, (i == 17 || i == 31) ? a(3, 0, 0, str) : a(3, str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String a(int i, String str) {
        return "{\"rewardType\":" + i + ",\"msg\":\"" + str + "\"}";
    }

    public static String a(int i, int i2, int i3, String str) {
        return "{\"rewardType\":" + i + ",\"rewardCompleteType\":" + i2 + ",\"rewardTempId\":" + i3 + ",\"web_temp_id\":" + i3 + ",\"msg\":\"" + str + "\"}";
    }
}
