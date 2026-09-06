package com.fancy;

import android.content.Context;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.mpsdk.provider.PtgApiProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _is implements _b4<_r> {
    public final /* synthetic */ PtgAdNative.NativeExpressAdListener _a;
    public final /* synthetic */ AdSlot _b;
    public final /* synthetic */ Context _c;
    public final /* synthetic */ _it _d;

    public _is(_it _itVar, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, AdSlot adSlot, Context context) {
        this._d = _itVar;
        this._a = nativeExpressAdListener;
        this._b = adSlot;
        this._c = context;
    }

    @Override // com.fancy._b4
    public final void _a(_r _rVar) {
        com.fancy.adsdk.lib.utils._d._c(new _ir(this, _rVar));
    }

    @Override // com.fancy._b4
    public final void onError(AdError adError) {
        PtgAdNative.NativeExpressAdListener nativeExpressAdListener = this._a;
        AdErrorImpl adErrorImpl = new AdErrorImpl(adError.getErrorCode(), adError.getMessage(), (Object) null);
        adErrorImpl._c = PtgApiProvider.providerName;
        nativeExpressAdListener.onError(adErrorImpl);
    }
}
