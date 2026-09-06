package com.fancy;

import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.utils.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _no extends _ak {

    public class _a implements PtgAdNative.SplashAdListener {
        public final /* synthetic */ AdSlot _a;
        public final /* synthetic */ _cf _b;
        public final /* synthetic */ PtgAdNative.SplashAdListener _c;
        public final /* synthetic */ _em _d;

        public _a(_cf _cfVar, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener, _em _emVar) {
            this._a = adSlot;
            this._b = _cfVar;
            this._c = splashAdListener;
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
            _no._a(_cfVar, adSlot, this._c, this._d);
        }

        @Override // com.fancy.adsdk.lib.provider.PtgAdNative.SplashAdListener
        public final void onSplashAdLoad(PtgSplashAd ptgSplashAd) {
            this._c.onSplashAdLoad(ptgSplashAd);
        }

        @Override // com.fancy.adsdk.lib.provider.PtgAdNative.SplashAdListener
        public final void onTimeout() {
            int i_b = _ak._b(this._b, this._a);
            if (i_b <= 0) {
                Logger.d("LAYER_REQUEST", "---> req err,return result...");
                this._c.onTimeout();
                return;
            }
            Logger.d("LAYER_REQUEST", "---> req err,req next layer...");
            _cf _cfVar = this._b;
            AdSlot adSlot = this._a;
            adSlot._d(i_b);
            _no._a(_cfVar, adSlot, this._c, this._d);
        }
    }

    public static void _a(_cf _cfVar, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener, _em<AdSlot, _np> _emVar) {
        _np _npVar = new _np(new _a(_cfVar, adSlot, splashAdListener, _emVar));
        _ch _chVar_a = _ak._a(_cfVar, adSlot, _npVar);
        if (_chVar_a == null) {
            return;
        }
        Logger.d("LAYER_REQUEST", _ie._a("start req ... layer: ").append(adSlot._e()).toString());
        _emVar._a(adSlot, _chVar_a, _npVar);
    }
}
