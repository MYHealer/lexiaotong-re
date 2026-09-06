package com.fancy.adsdk.lib.provider;

import com.fancy._fx;
import com.fancy._gf;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _l extends _gf {
    public final /* synthetic */ AdSlot _b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public _l(PtgAdNative.NativeExpressAdListener nativeExpressAdListener, AdSlot adSlot) {
        super(nativeExpressAdListener);
        this._b = adSlot;
    }

    @Override // com.fancy._gf, com.fancy.adsdk.lib.interf.Error
    public final void onError(AdError adError) {
        _fx._a(adError, this._b);
        super.onError(adError);
    }
}
