package com.hihonor.adsdk.base.mediation.core.imp;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.IAdLoad;
import com.hihonor.adsdk.base.callback.BaseListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AdManager<LISTENER extends BaseListener> implements IAdLoad<LISTENER> {
    private static final String TAG = "AdManagerTAG";
    private IAdLoad<LISTENER> hnAdLoad;
    private AdSlot mAdSlot;
    private LISTENER mListener;
    private IAdLoad<LISTENER> mLoader;
    private IAdLoad<LISTENER> polymerizationAdLoad;

    public AdManager(IAdLoad<LISTENER> iAdLoad, IAdLoad<LISTENER> iAdLoad2) {
        this.hnAdLoad = iAdLoad;
        this.polymerizationAdLoad = iAdLoad2;
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    public void loadAd() {
        if (!HnAds.get().isInitialized()) {
            com.hihonor.adsdk.common.b.b.hnadsc(TAG, "loadAd isInitialized is false", new Object[0]);
            handleNotInit(String.valueOf(30002), "the SDK is not initialized");
            return;
        }
        this.mLoader = com.hihonor.adsdk.base.api.d.hnadsa(this.mAdSlot, this.hnAdLoad, this.polymerizationAdLoad);
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "handleLoadAd mLoader = " + this.mLoader, new Object[0]);
        this.mLoader.setAdLoadListener(this.mListener);
        this.mLoader.setAdSlot(this.mAdSlot);
        this.mLoader.loadAd();
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    public void setAdLoadListener(LISTENER listener) {
        this.mListener = listener;
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    public void setAdSlot(AdSlot adSlot) {
        this.mAdSlot = adSlot;
    }

    private void handleNotInit(String str, String str2) {
        LISTENER listener = this.mListener;
        if (listener != null) {
            listener.onFailed(String.valueOf(str), str2);
            this.mListener = null;
        }
    }
}
