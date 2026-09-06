package com.fancy.adsdk.lib.interf;

import com.fancy._m;
import com.fancy.adsdk.lib.model.AdBidLossReason;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface PtgAd {
    void destroy();

    _m getAdFilterAdapter();

    String getAdId();

    String getConsumer();

    long getEcpm();

    int getInteractionType();

    boolean isReady();

    boolean isResourceLoaded();

    void notifyBidLoss(AdBidLossReason adBidLossReason);

    void notifyBidWin(double d, double d2);

    void setAdFilterAdapter(_m _mVar);
}
