package com.fancy;

import android.content.Context;
import android.os.Looper;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.mpsdk.provider.PtgApiProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _kw implements _b4<_r> {
    public final /* synthetic */ PtgAdNative.SplashAdListener _a;
    public final /* synthetic */ AdSlot _b;
    public final /* synthetic */ Context _c;
    public final /* synthetic */ _kx _d;

    public _kw(_kx _kxVar, PtgAdNative.SplashAdListener splashAdListener, AdSlot adSlot, Context context) {
        this._d = _kxVar;
        this._a = splashAdListener;
        this._b = adSlot;
        this._c = context;
    }

    @Override // com.fancy._b4
    public final void _a(_r _rVar) {
        _kv _kvVar = new _kv(this, _rVar);
        _fv _fvVar = _fv._a;
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            _kvVar.run();
        } else {
            _fv._a.post(_kvVar);
        }
    }

    @Override // com.fancy._b4
    public final void onError(AdError adError) {
        PtgAdNative.SplashAdListener splashAdListener = this._a;
        if (splashAdListener != null) {
            AdErrorImpl adErrorImpl = new AdErrorImpl(adError.getErrorCode(), adError.getMessage(), (Object) null);
            adErrorImpl._c = PtgApiProvider.providerName;
            splashAdListener.onError(adErrorImpl);
        }
    }
}
