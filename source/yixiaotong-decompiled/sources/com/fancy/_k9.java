package com.fancy;

import android.view.View;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.model.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _k9 implements PtgNativeExpressAd.ExpressAdInteractionListener, PtgNativeExpressAd.AdInteractionListener {
    public final PtgNativeExpressAd.ExpressAdInteractionListener _a;

    public _k9(_r _rVar, PtgNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this._a = expressAdInteractionListener;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
    public final void onAdClicked() {
        PtgNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this._a;
        if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onAdClicked();
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
    public final void onAdDismiss() {
        PtgNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this._a;
        if (expressAdInteractionListener instanceof PtgNativeExpressAd.AdInteractionListener) {
            expressAdInteractionListener = (PtgNativeExpressAd.AdInteractionListener) expressAdInteractionListener;
        } else if (!(expressAdInteractionListener instanceof PtgNativeExpressAd.ExpressAdInteractionListener)) {
            return;
        }
        expressAdInteractionListener.onAdDismiss();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
    public final void onAdShow() {
        PtgNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this._a;
        if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onAdShow();
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
    public final void onRenderFail(AdError adError) {
        PtgNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this._a;
        if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onRenderFail(adError);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
    public final void onRenderSuccess(View view) {
        PtgNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this._a;
        if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onRenderSuccess(view);
        }
    }
}
