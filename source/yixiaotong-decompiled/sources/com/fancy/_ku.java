package com.fancy;

import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.model.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ku implements PtgSplashAd.AdInteractionListener {
    public final PtgSplashAd.AdInteractionListener _a;

    public _ku(_r _rVar, PtgSplashAd.AdInteractionListener adInteractionListener) {
        this._a = adInteractionListener;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
    public final void onAdClicked() {
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
    public final void onAdShow() {
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdShow();
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
    public final void onAdSkip() {
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdSkip();
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
    public final void onAdTimeOver() {
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdTimeOver();
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
    public final void onDismiss(int i) {
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onDismiss(i);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
    public final void onRenderError(AdError adError) {
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onRenderError(adError);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
    public final void onRenderSuccess() {
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onRenderSuccess();
        }
    }
}
