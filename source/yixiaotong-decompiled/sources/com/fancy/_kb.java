package com.fancy;

import android.content.Context;
import android.os.Looper;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.mpsdk.provider.PtgApiProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _kb implements _b4<_r> {
    public final /* synthetic */ PtgAdNative.NativeExpressAdListener _a;
    public final /* synthetic */ AdSlot _b;
    public final /* synthetic */ Context _c;
    public final /* synthetic */ _kc _d;

    public _kb(_kc _kcVar, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, AdSlot adSlot, Context context) {
        this._d = _kcVar;
        this._a = nativeExpressAdListener;
        this._b = adSlot;
        this._c = context;
    }

    @Override // com.fancy._b4
    public final void _a(_r _rVar) {
        _ka _kaVar = new _ka(this, _rVar);
        _fu _fuVar = _fu._a;
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            _kaVar.run();
        } else {
            _fu._a.post(_kaVar);
        }
    }

    @Override // com.fancy._b4
    public final void onError(AdError adError) {
        PtgAdNative.NativeExpressAdListener nativeExpressAdListener = this._a;
        if (nativeExpressAdListener != null) {
            AdErrorImpl adErrorImpl = new AdErrorImpl(adError.getErrorCode(), adError.getMessage(), (Object) null);
            adErrorImpl._c = PtgApiProvider.providerName;
            nativeExpressAdListener.onError(adErrorImpl);
        }
    }
}
