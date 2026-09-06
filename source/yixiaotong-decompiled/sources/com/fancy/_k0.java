package com.fancy;

import com.fancy.adsdk.lib.interf.PtgInteractionAd;
import com.fancy.adsdk.lib.model.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _k0 implements PtgInteractionAd.AdInteractionListener {
    public final PtgInteractionAd.AdInteractionListener _a;

    public _k0(_r _rVar, PtgInteractionAd.AdInteractionListener adInteractionListener) {
        this._a = adInteractionListener;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
    public final void onAdClicked() {
        PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
    public final void onAdDismiss() {
        PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdDismiss();
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
    public final void onAdShow() {
        PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdShow();
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
    public final void onRenderError(AdError adError) {
        PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onRenderError(adError);
        }
    }
}
