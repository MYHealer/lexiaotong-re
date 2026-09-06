package com.fancy;

import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _kj implements Runnable {
    public final /* synthetic */ AtomicBoolean _a;
    public final /* synthetic */ PtgRewardVideoAd _b;
    public final /* synthetic */ _kf _c;

    public _kj(PtgRewardVideoAd ptgRewardVideoAd, _kf _kfVar, AtomicBoolean atomicBoolean) {
        this._c = _kfVar;
        this._a = atomicBoolean;
        this._b = ptgRewardVideoAd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgAdNative.RewardVideoAdListener rewardVideoAdListener;
        if (this._a.get() || (rewardVideoAdListener = this._c._b._a) == null) {
            return;
        }
        rewardVideoAdListener.onRewardVideoCached(this._b);
    }
}
