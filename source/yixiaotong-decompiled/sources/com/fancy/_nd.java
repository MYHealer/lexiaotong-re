package com.fancy;

import android.content.Context;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _nd extends _n8 implements PtgAdNative.RewardVideoAdListener {
    public _jt _a;
    public PtgAdNative.RewardVideoAdListener _b;
    public WeakReference<Context> _c;
    public PtgAdNative _d;
    public PtgRewardVideoAd _e;
    public AdSlot _f;
    public AtomicBoolean _g = new AtomicBoolean();
    public _ci _h;

    public _nd(_jt _jtVar, _ci _ciVar, PtgAdNative ptgAdNative, Context context, AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this._a = _jtVar;
        this._d = ptgAdNative;
        this._h = _ciVar;
        this._b = rewardVideoAdListener;
        this._c = new WeakReference<>(context);
        this._f = adSlot;
    }

    @Override // com.fancy._n8
    public final void _a() {
        PtgRewardVideoAd ptgRewardVideoAd;
        PtgAdNative.RewardVideoAdListener rewardVideoAdListener = this._b;
        if (rewardVideoAdListener == null || (ptgRewardVideoAd = this._e) == null) {
            return;
        }
        rewardVideoAdListener.onRewardVideoAdLoad(ptgRewardVideoAd);
    }

    @Override // com.fancy._n8
    public final void _a(AdErrorImpl adErrorImpl) {
        PtgAdNative.RewardVideoAdListener rewardVideoAdListener = this._b;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onError(adErrorImpl);
        }
    }

    @Override // com.fancy._n8
    public final boolean _b() {
        AdSlot adSlot;
        Context context = this._c.get();
        if (context == null || (adSlot = this._f) == null) {
            Logger.d("err reward ad serial request, ");
            onError(new AdErrorImpl(10010, "params miss, request is interrupted", (Object) null));
            return false;
        }
        this._d.loadRewardVideoAd(context, adSlot, this);
        Logger.d("do reward ad serial request, ");
        return true;
    }

    @Override // com.fancy._n8
    public final String _c() {
        return this._h._c;
    }

    @Override // com.fancy._n8
    public final long _d() {
        return this._h._h;
    }

    @Override // com.fancy._n8
    public final _os _e() {
        AdSlot adSlot = this._f;
        if (adSlot == null) {
            return null;
        }
        return adSlot._t();
    }

    @Override // com.fancy._n8
    public final int _f() {
        return this._h._e;
    }

    @Override // com.fancy._n8
    public final boolean _g() {
        return this._e != null;
    }

    @Override // com.fancy.adsdk.lib.interf.Error
    public final void onError(AdError adError) {
        if (!this._g.compareAndSet(false, true)) {
            Logger.d("err reward ad serial request, ");
            return;
        }
        _jt _jtVar = this._a;
        if (_jtVar != null) {
            _jtVar._a(this, adError);
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.RewardVideoAdListener
    public final void onRewardVideoAdLoad(PtgRewardVideoAd ptgRewardVideoAd) {
        if (this._g.compareAndSet(false, true)) {
            this._e = ptgRewardVideoAd;
            if (ptgRewardVideoAd == null) {
                onError(new AdErrorImpl(10001, "no ad", (Object) null));
            } else {
                this._a._b(this);
            }
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.RewardVideoAdListener
    public final void onRewardVideoCached(PtgRewardVideoAd ptgRewardVideoAd) {
        PtgAdNative.RewardVideoAdListener rewardVideoAdListener = this._b;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoCached(ptgRewardVideoAd);
        }
    }
}
