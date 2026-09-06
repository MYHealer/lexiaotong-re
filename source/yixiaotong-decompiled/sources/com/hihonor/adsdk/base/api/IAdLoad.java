package com.hihonor.adsdk.base.api;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.callback.BaseListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface IAdLoad<LISTENER extends BaseListener> {
    void loadAd();

    void setAdLoadListener(LISTENER listener);

    void setAdSlot(AdSlot adSlot);
}
