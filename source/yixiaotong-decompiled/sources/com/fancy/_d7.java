package com.fancy;

import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.utils.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _d7 implements PtgAdNative.NativeExpressAdListener {
    public final /* synthetic */ PtgAdNative.NativeExpressAdListener _a;
    public final /* synthetic */ AdSlot _b;
    public final /* synthetic */ _cf _c;
    public final /* synthetic */ _em _d;

    public _d7(_cf _cfVar, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, _em _emVar) {
        this._a = nativeExpressAdListener;
        this._b = adSlot;
        this._c = _cfVar;
        this._d = _emVar;
    }

    @Override // com.fancy.adsdk.lib.interf.Error
    public final void onError(AdError adError) {
        int i_b = _ak._b(this._c, this._b);
        if (i_b <= 0) {
            Logger.d("LAYER_REQUEST", "---> req err,return result...");
            this._a.onError(adError);
            return;
        }
        Logger.d("LAYER_REQUEST", "---> req err,req next layer...");
        _cf _cfVar = this._c;
        AdSlot adSlot = this._b;
        adSlot._d(i_b);
        PtgAdNative.NativeExpressAdListener nativeExpressAdListener = this._a;
        _em _emVar = this._d;
        _d8 _d8Var = new _d8(new _d7(_cfVar, adSlot, nativeExpressAdListener, _emVar));
        _ch _chVar_a = _ak._a(_cfVar, adSlot, _d8Var);
        if (_chVar_a == null) {
            return;
        }
        Logger.d("LAYER_REQUEST", _ie._a("start req ... layer: ").append(adSlot._e()).toString());
        _emVar._a(adSlot, _chVar_a, _d8Var);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.NativeExpressAdListener
    public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
        this._a.onNativeExpressAdLoad(ptgNativeExpressAd);
    }
}
