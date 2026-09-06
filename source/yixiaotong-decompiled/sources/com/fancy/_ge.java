package com.fancy;

import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.utils.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ge implements PtgAdNative.NativeExpressAdListener {
    public final /* synthetic */ AdSlot _a;
    public final /* synthetic */ _cf _b;
    public final /* synthetic */ PtgAdNative.NativeExpressAdListener _c;
    public final /* synthetic */ _em _d;

    public _ge(_cf _cfVar, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, _em _emVar) {
        this._a = adSlot;
        this._b = _cfVar;
        this._c = nativeExpressAdListener;
        this._d = _emVar;
    }

    @Override // com.fancy.adsdk.lib.interf.Error
    public final void onError(AdError adError) {
        int i_b = _ak._b(this._b, this._a);
        if (i_b <= 0) {
            Logger.d("LAYER_REQUEST", "---> req err,return result...");
            this._c.onError(adError);
            return;
        }
        Logger.d("LAYER_REQUEST", "---> req err,req next layer...");
        _cf _cfVar = this._b;
        AdSlot adSlot = this._a;
        adSlot._d(i_b);
        PtgAdNative.NativeExpressAdListener nativeExpressAdListener = this._c;
        _em _emVar = this._d;
        _gf _gfVar = new _gf(new _ge(_cfVar, adSlot, nativeExpressAdListener, _emVar));
        _ch _chVar_a = _ak._a(_cfVar, adSlot, _gfVar);
        if (_chVar_a == null) {
            return;
        }
        Logger.d("LAYER_REQUEST", _ie._a("start req ... layer: ").append(adSlot._e()).toString());
        _emVar._a(adSlot, _chVar_a, _gfVar);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.NativeExpressAdListener
    public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
        this._c.onNativeExpressAdLoad(ptgNativeExpressAd);
    }
}
