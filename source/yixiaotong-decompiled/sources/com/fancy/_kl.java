package com.fancy;

import android.content.Context;
import android.os.Looper;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.mpsdk.provider.PtgApiProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _kl implements _b4<_r> {
    public final /* synthetic */ PtgAdNative.RewardVideoAdListener _a;
    public final /* synthetic */ AdSlot _b;
    public final /* synthetic */ Context _c;
    public final /* synthetic */ _km _d;

    public class _a implements Runnable {
        public final /* synthetic */ AdError _a;

        public _a(AdError adError) {
            this._a = adError;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAdNative.RewardVideoAdListener rewardVideoAdListener = _kl.this._a;
            if (rewardVideoAdListener != null) {
                AdErrorImpl adErrorImpl = new AdErrorImpl(this._a.getErrorCode(), this._a.getMessage(), (Object) null);
                adErrorImpl._c = PtgApiProvider.providerName;
                rewardVideoAdListener.onError(adErrorImpl);
            }
        }
    }

    public _kl(_km _kmVar, PtgAdNative.RewardVideoAdListener rewardVideoAdListener, AdSlot adSlot, Context context) {
        this._d = _kmVar;
        this._a = rewardVideoAdListener;
        this._b = adSlot;
        this._c = context;
    }

    @Override // com.fancy._b4
    public final void _a(_r _rVar) {
        com.fancy.adsdk.lib.utils._d._c(new _kf(this, _rVar));
    }

    @Override // com.fancy._b4
    public final void onError(AdError adError) {
        _a _aVar = new _a(adError);
        _fv _fvVar = _fv._a;
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            _aVar.run();
        } else {
            _fv._a.post(_aVar);
        }
    }
}
