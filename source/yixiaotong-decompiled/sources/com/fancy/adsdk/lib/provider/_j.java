package com.fancy.adsdk.lib.provider;

import android.os.Handler;
import android.os.Looper;
import com.fancy._fx;
import com.fancy._np;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _j extends _np {
    public final /* synthetic */ _np _b;
    public final /* synthetic */ AdSlot _c;

    public class _a implements Runnable {
        public final /* synthetic */ PtgSplashAd _a;

        public _a(PtgSplashAd ptgSplashAd) {
            this._a = ptgSplashAd;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this._a.load();
                _j.this._b.onSplashAdLoad(this._a);
            } catch (Exception e) {
                _j.this._b._a.onError(new AdErrorImpl(PtgErrorCode.SDK_SPLASH_SINGLE_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public _j(PtgAdNative.SplashAdListener splashAdListener, _np _npVar, AdSlot adSlot) {
        super(splashAdListener);
        this._b = _npVar;
        this._c = adSlot;
    }

    @Override // com.fancy._np, com.fancy.adsdk.lib.interf.Error
    public final void onError(AdError adError) {
        _fx._a(adError, this._c);
        super.onError(adError);
    }

    @Override // com.fancy._np, com.fancy.adsdk.lib.provider.PtgAdNative.SplashAdListener
    public final void onSplashAdLoad(PtgSplashAd ptgSplashAd) {
        new Handler(Looper.getMainLooper()).post(new _a(ptgSplashAd));
    }
}
