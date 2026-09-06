package com.fancy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ne extends _n8 implements PtgAdNative.SplashAdListener {
    public _jt _a;
    public PtgAdNative.SplashAdListener _b;
    public WeakReference<Context> _c;
    public ViewGroup _d;
    public ViewGroup _e;
    public PtgAdNative _f;
    public PtgSplashAd _g;
    public AdSlot _h;
    public AtomicBoolean _i = new AtomicBoolean();
    public _ci _j;

    public class _a implements Runnable {
        public _a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgSplashAd ptgSplashAd;
            try {
                _ne.this._d.removeAllViews();
                _ne _neVar = _ne.this;
                _neVar._d.addView(_neVar._e);
                _ne.this._g.getInteractionType();
                _ne.this._g.load();
                _ne _neVar2 = _ne.this;
                PtgAdNative.SplashAdListener splashAdListener = _neVar2._b;
                if (splashAdListener == null || (ptgSplashAd = _neVar2._g) == null) {
                    return;
                }
                splashAdListener.onSplashAdLoad(ptgSplashAd);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public _ne(_jt _jtVar, _ci _ciVar, PtgAdNative ptgAdNative, Context context, AdSlot adSlot, ViewGroup viewGroup, ViewGroup viewGroup2, PtgAdNative.SplashAdListener splashAdListener) {
        this._a = _jtVar;
        this._d = viewGroup;
        this._e = viewGroup2;
        this._f = ptgAdNative;
        this._b = splashAdListener;
        this._c = new WeakReference<>(context);
        this._h = adSlot;
        this._j = _ciVar;
    }

    @Override // com.fancy._n8
    public final void _a() {
        new Handler(Looper.getMainLooper()).post(new _a());
    }

    @Override // com.fancy._n8
    public final void _a(AdErrorImpl adErrorImpl) {
        PtgAdNative.SplashAdListener splashAdListener = this._b;
        if (splashAdListener != null) {
            splashAdListener.onError(adErrorImpl);
        }
    }

    @Override // com.fancy._n8
    public final boolean _b() {
        AdSlot adSlot;
        Context context = this._c.get();
        if (context == null || (adSlot = this._h) == null) {
            onError(new AdErrorImpl(10010, "params miss, request is interrupted", (Object) null));
            return false;
        }
        this._f.loadSplashAd(context, adSlot, this);
        return true;
    }

    @Override // com.fancy._n8
    public final String _c() {
        return this._j._c;
    }

    @Override // com.fancy._n8
    public final long _d() {
        return this._j._h;
    }

    @Override // com.fancy._n8
    public final _os _e() {
        AdSlot adSlot = this._h;
        if (adSlot == null) {
            return null;
        }
        return adSlot._t();
    }

    @Override // com.fancy._n8
    public final int _f() {
        return this._j._e;
    }

    @Override // com.fancy._n8
    public final boolean _g() {
        return this._g != null;
    }

    @Override // com.fancy.adsdk.lib.interf.Error
    public final void onError(AdError adError) {
        _jt _jtVar;
        if (!this._i.compareAndSet(false, true) || (_jtVar = this._a) == null) {
            return;
        }
        _jtVar._a(this, adError);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.SplashAdListener
    public final void onSplashAdLoad(PtgSplashAd ptgSplashAd) {
        if (this._i.compareAndSet(false, true)) {
            this._g = ptgSplashAd;
            if (ptgSplashAd == null) {
                onError(new AdErrorImpl(10001, "no ad", (Object) null));
            } else {
                this._a._b(this);
            }
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.SplashAdListener
    public final void onTimeout() {
        PtgAdNative.SplashAdListener splashAdListener = this._b;
        if (splashAdListener != null) {
            splashAdListener.onTimeout();
        }
    }
}
