package com.fancy;

import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.provider.PtgAdNative;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class _np implements PtgAdNative.SplashAdListener {
    public final PtgAdNative.SplashAdListener _a;

    public class _a implements Runnable {
        public final /* synthetic */ AdError _a;

        public _a(AdError adError) {
            this._a = adError;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAdNative.SplashAdListener splashAdListener = _np.this._a;
            if (splashAdListener != null) {
                splashAdListener.onError(this._a);
            }
        }
    }

    public class _b implements Runnable {
        public _b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAdNative.SplashAdListener splashAdListener = _np.this._a;
            if (splashAdListener != null) {
                splashAdListener.onTimeout();
            }
        }
    }

    public class _c implements Runnable {
        public final /* synthetic */ PtgSplashAd _a;

        public _c(PtgSplashAd ptgSplashAd) {
            this._a = ptgSplashAd;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgSplashAd ptgSplashAd;
            PtgAdNative.SplashAdListener splashAdListener = _np.this._a;
            if (splashAdListener == null || (ptgSplashAd = this._a) == null) {
                return;
            }
            splashAdListener.onSplashAdLoad(ptgSplashAd);
        }
    }

    public _np(PtgAdNative.SplashAdListener splashAdListener) {
        this._a = splashAdListener;
    }

    @Override // com.fancy.adsdk.lib.interf.Error
    public void onError(AdError adError) {
        if (this._a != null) {
            com.fancy.adsdk.lib.utils._d._c(new _a(adError));
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.SplashAdListener
    public void onSplashAdLoad(PtgSplashAd ptgSplashAd) {
        if (this._a != null) {
            com.fancy.adsdk.lib.utils._d._c(new _c(ptgSplashAd));
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.SplashAdListener
    public final void onTimeout() {
        if (this._a != null) {
            com.fancy.adsdk.lib.utils._d._c(new _b());
        }
    }
}
