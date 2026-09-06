package com.fancy;

import android.os.Handler;
import android.os.Looper;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _bh extends _bg implements PtgAdNative.NativeExpressAdListener {
    public PtgNativeExpressAd _h;
    public PtgAdNative.NativeExpressAdListener _i;
    public Integer _j;

    public class _a implements Runnable {
        public _a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Logger.e("TrackingManager:", _ie._a("doOnLoad--").append(_bh.this._b()).toString());
            _bh _bhVar = _bh.this;
            PtgNativeExpressAd ptgNativeExpressAd = _bhVar._h;
            if (ptgNativeExpressAd != null) {
                _bhVar._i.onNativeExpressAdLoad(ptgNativeExpressAd);
            } else {
                _c4._a(10001, "no ad in concurrent", null, _bhVar._i);
            }
        }
    }

    public _bh(SortedSet sortedSet, _ci _ciVar, AtomicInteger atomicInteger, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        super(sortedSet, _ciVar, atomicInteger);
        this._i = nativeExpressAdListener;
    }

    @Override // com.fancy._bg
    public final void _a() {
        new Handler(Looper.getMainLooper()).post(new _a());
    }

    @Override // com.fancy._bg
    public final void _a(AdErrorImpl adErrorImpl) {
        Logger.e("TrackingManager:", _ie._a("onError--").append(_b()).append("--onError:").append(adErrorImpl._a).append("|message:").append(adErrorImpl._b).toString());
        this._i.onError(adErrorImpl);
    }

    @Override // com.fancy._bg
    public final boolean _f() {
        return this._j != null;
    }

    @Override // com.fancy._bg
    public final boolean _g() {
        return this._h != null;
    }

    @Override // com.fancy.adsdk.lib.interf.Error
    public final void onError(AdError adError) {
        Logger.e("TrackingManager:", _ie._a("onError--").append(_b()).append("--onError:").append(adError.getErrorCode()).append("|message:").append(adError.getMessage()).toString());
        this._j = Integer.valueOf(adError.getErrorCode());
        adError.getMessage();
        this._a.add(this);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.NativeExpressAdListener
    public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
        Logger.e("TrackingManager:", _ie._a("DrawFeed onNativeExpressAdLoad--").append(_b()).toString());
        this._h = ptgNativeExpressAd;
        this._a.add(this);
    }
}
