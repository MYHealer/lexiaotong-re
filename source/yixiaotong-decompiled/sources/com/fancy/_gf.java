package com.fancy;

import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.provider.PtgAdNative;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class _gf implements PtgAdNative.NativeExpressAdListener {
    public PtgAdNative.NativeExpressAdListener _a;

    public class _a implements Runnable {
        public final /* synthetic */ AdError _a;

        public _a(AdError adError) {
            this._a = adError;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _gf.this._a.onError(this._a);
        }
    }

    public class _b implements Runnable {
        public final /* synthetic */ PtgNativeExpressAd _a;

        public _b(PtgNativeExpressAd ptgNativeExpressAd) {
            this._a = ptgNativeExpressAd;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _gf.this._a.onNativeExpressAdLoad(this._a);
        }
    }

    public _gf(PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        this._a = nativeExpressAdListener;
    }

    @Override // com.fancy.adsdk.lib.interf.Error
    public void onError(AdError adError) {
        if (this._a != null) {
            com.fancy.adsdk.lib.utils._d._c(new _a(adError));
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.NativeExpressAdListener
    public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
        if (this._a != null) {
            com.fancy.adsdk.lib.utils._d._c(new _b(ptgNativeExpressAd));
        }
    }
}
