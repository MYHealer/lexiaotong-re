package com.fancy;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _bl extends _bg implements PtgAdNative.SplashAdListener {
    public ViewGroup _h;
    public ViewGroup _i;
    public PtgAdNative.SplashAdListener _j;
    public volatile Integer _k;
    public volatile boolean _l;
    public volatile PtgSplashAd _m;

    public class _a implements Runnable {
        public _a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Logger.e("TrackingManager:", _ie._a("doOnLoad--").append(_bl.this._b()).toString());
            try {
                if (_bl.this._m == null) {
                    PtgAdNative.SplashAdListener splashAdListener = _bl.this._j;
                    if (splashAdListener != null) {
                        splashAdListener.onError(new AdErrorImpl(10001, "no ad in concurrent", (Object) null));
                        return;
                    }
                    return;
                }
                ViewGroup viewGroup = _bl.this._h;
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                    _bl _blVar = _bl.this;
                    _blVar._h.addView(_blVar._i);
                }
                _bl.this._m.getInteractionType();
                _bl.this._m.load();
                _bl _blVar2 = _bl.this;
                PtgAdNative.SplashAdListener splashAdListener2 = _blVar2._j;
                if (splashAdListener2 != null) {
                    splashAdListener2.onSplashAdLoad(_blVar2._m);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _bl(SortedSet sortedSet, _ci _ciVar, ViewGroup viewGroup, ViewGroup viewGroup2, AtomicInteger atomicInteger, PtgAdNative.SplashAdListener splashAdListener) {
        super(sortedSet, _ciVar, atomicInteger);
        this._h = viewGroup;
        this._i = viewGroup2;
        this._j = splashAdListener;
    }

    @Override // com.fancy._bg
    public final void _a() {
        new Handler(Looper.getMainLooper()).post(new _a());
    }

    @Override // com.fancy._bg
    public final void _a(AdErrorImpl adErrorImpl) {
        Logger.e("TrackingManager:", _ie._a("onError--").append(_b()).append("--onError:").append(adErrorImpl._a).append("|message:").append(adErrorImpl._b).toString());
        PtgAdNative.SplashAdListener splashAdListener = this._j;
        if (splashAdListener != null) {
            splashAdListener.onError(adErrorImpl);
        }
    }

    @Override // com.fancy._bg
    public final boolean _f() {
        return this._k != null || this._l;
    }

    @Override // com.fancy._bg
    public final boolean _g() {
        return this._m != null;
    }

    @Override // com.fancy.adsdk.lib.interf.Error
    public final void onError(AdError adError) {
        Logger.e("TrackingManager:", _ie._a("onError--").append(_b()).append("--onError:").append(adError.getErrorCode()).append("|message:").append(adError.getMessage()).toString());
        this._k = Integer.valueOf(adError.getErrorCode());
        adError.getMessage();
        this._a.add(this);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.SplashAdListener
    public final void onSplashAdLoad(PtgSplashAd ptgSplashAd) {
        Logger.e("TrackingManager:", _ie._a("onSplashAdLoad--").append(_b()).toString());
        this._m = ptgSplashAd;
        this._a.add(this);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.SplashAdListener
    public final void onTimeout() {
        Logger.e("TrackingManager:", _ie._a("onTimeout--").append(_b()).toString());
        this._l = true;
        this._a.add(this);
    }
}
