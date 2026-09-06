package com.fancy;

import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _bj extends _bg implements PtgAdNative.NativeExpressAdListener {
    public PtgAdNative.NativeExpressAdListener _h;
    public volatile Integer _i;
    public volatile PtgNativeExpressAd _j;

    public _bj(SortedSet sortedSet, _ci _ciVar, AtomicInteger atomicInteger, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        super(sortedSet, _ciVar, atomicInteger);
        this._h = nativeExpressAdListener;
    }

    @Override // com.fancy._bg
    public final void _a(AdErrorImpl adErrorImpl) {
        Logger.e("TrackingManager:", _ie._a("onError--").append(_b()).append("--onError:").append(adErrorImpl._a).append("|message:").append(adErrorImpl._b).toString());
        this._h.onError(adErrorImpl);
    }

    @Override // com.fancy._bg
    public final boolean _f() {
        return this._i != null;
    }

    @Override // com.fancy._bg
    public final boolean _g() {
        return this._j != null;
    }

    @Override // com.fancy.adsdk.lib.interf.Error
    public final void onError(AdError adError) {
        Logger.e("TrackingManager:", _ie._a("onError--").append(_b()).append("--onError:").append(adError.getErrorCode()).append("|message:").append(adError.getMessage()).toString());
        this._i = Integer.valueOf(adError.getErrorCode());
        adError.getMessage();
        this._a.add(this);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.NativeExpressAdListener
    public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
        Logger.e("TrackingManager:", _ie._a("onNativeExpressAdLoad--").append(_b()).toString());
        this._j = ptgNativeExpressAd;
        this._a.add(this);
    }

    @Override // com.fancy._bg
    public final void _a() {
        Logger.e("TrackingManager:", _ie._a("doOnLoad--").append(_b()).toString());
        if (this._j != null) {
            this._h.onNativeExpressAdLoad(this._j);
        } else {
            _c4._a(10001, "no ad in concurrent", null, this._h);
        }
    }
}
