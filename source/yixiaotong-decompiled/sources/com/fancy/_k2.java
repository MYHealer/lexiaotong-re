package com.fancy;

import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.mpsdk.provider.PtgApiProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _k2 implements _b4<_r> {
    public final /* synthetic */ PtgAdNative.InteractionExpressAdListener _a;
    public final /* synthetic */ AdSlot _b;
    public final /* synthetic */ _k3 _c;

    public _k2(_k3 _k3Var, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener, AdSlot adSlot) {
        this._c = _k3Var;
        this._a = interactionExpressAdListener;
        this._b = adSlot;
    }

    @Override // com.fancy._b4
    public final void _a(_r _rVar) {
        Logger.d("PtgInteractionAdLoader", "loadInteractionAd onSuccess");
        com.fancy.adsdk.lib.utils._d._c(new _k1(this, _rVar));
    }

    @Override // com.fancy._b4
    public final void onError(AdError adError) {
        if (this._a != null) {
            Logger.d("PtgInteractionAdLoader", _ie._a("loadInteractionAd onError error code:").append(adError.getErrorCode()).append("msg:").append(adError.getMessage()).toString());
            PtgAdNative.InteractionExpressAdListener interactionExpressAdListener = this._a;
            AdErrorImpl adErrorImpl = new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null);
            adErrorImpl._c = PtgApiProvider.providerName;
            interactionExpressAdListener.onError(adErrorImpl);
        }
    }
}
