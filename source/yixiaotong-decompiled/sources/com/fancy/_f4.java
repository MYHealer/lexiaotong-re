package com.fancy;

import com.fancy.adsdk.lib.interf.PtgInteractionAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.provider.PtgAdNative;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class _f4 implements PtgAdNative.InteractionExpressAdListener {
    public final PtgAdNative.InteractionExpressAdListener _a;

    public class _a implements Runnable {
        public final /* synthetic */ PtgInteractionAd _a;

        public _a(PtgInteractionAd ptgInteractionAd) {
            this._a = ptgInteractionAd;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _f4.this._a.onInteractionAdLoad(this._a);
        }
    }

    public class _b implements Runnable {
        public final /* synthetic */ AdError _a;

        public _b(AdError adError) {
            this._a = adError;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _f4.this._a.onError(this._a);
        }
    }

    public _f4(PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        this._a = interactionExpressAdListener;
    }

    @Override // com.fancy.adsdk.lib.interf.Error
    public void onError(AdError adError) {
        if (this._a != null) {
            com.fancy.adsdk.lib.utils._d._c(new _b(adError));
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.InteractionExpressAdListener
    public final void onInteractionAdLoad(PtgInteractionAd ptgInteractionAd) {
        if (this._a != null) {
            com.fancy.adsdk.lib.utils._d._c(new _a(ptgInteractionAd));
        }
    }
}
