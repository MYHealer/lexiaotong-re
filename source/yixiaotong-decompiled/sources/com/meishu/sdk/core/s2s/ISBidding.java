package com.meishu.sdk.core.s2s;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ISBidding {
    public static final String ADN_ID = "adnId";
    public static final String EXPECT_COST_PRICE = "expectCostPrice";
    public static final String HIGHEST_LOSS_PRICE = "highestLossPrice";
    public static final String LOSS_REASON = "lossReason";
    public static final String WIN_PRICE = "winPrice";

    void sendLossNotification(Map<String, Object> map);

    void sendWinNotification(Map<String, Object> map);
}
