package com.adprof.sdk.api;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface IBiddingNotify {
    public static final String LOSS_ADN_ID = "loss_adn_id";
    public static final String LOSS_FIRST_PRICE = "loss_first_price";
    public static final String LOSS_REASON = "loss_reason";
    public static final String MEDIATION = "mediation";
    public static final String WIN_FIRST_PRICE = "win_first_price";
    public static final String WIN_HIGHEST_LOSS_PRICE = "win_highest_loss_price";

    public static class AdLoseType {
        public static final int LowEcpm = 100;
        public static final int Timeout = 200;
        public static final int Uknown = 0;
    }

    void sendLossNotify(Map<String, Object> map);

    void sendWinNotify(Map<String, Object> map);
}
