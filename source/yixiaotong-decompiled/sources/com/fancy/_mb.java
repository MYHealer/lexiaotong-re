package com.fancy;

import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.provider.PtgAdNative;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class _mb implements PtgAdNative.RewardVideoAdListener {
    public final PtgAdNative.RewardVideoAdListener _a;

    public class _a implements Runnable {
        public final /* synthetic */ AdError _a;

        public _a(AdError adError) {
            this._a = adError;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _mb.this._a.onError(this._a);
        }
    }

    public class _b implements Runnable {
        public final /* synthetic */ PtgRewardVideoAd _a;

        public _b(PtgRewardVideoAd ptgRewardVideoAd) {
            this._a = ptgRewardVideoAd;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _mb.this._a.onRewardVideoAdLoad(this._a);
        }
    }

    public class _c implements Runnable {
        public final /* synthetic */ PtgRewardVideoAd _a;

        public _c(PtgRewardVideoAd ptgRewardVideoAd) {
            this._a = ptgRewardVideoAd;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _mb.this._a.onRewardVideoCached(this._a);
        }
    }

    public _mb(PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this._a = rewardVideoAdListener;
    }

    @Override // com.fancy.adsdk.lib.interf.Error
    public void onError(AdError adError) {
        if (this._a != null) {
            com.fancy.adsdk.lib.utils._d._c(new _a(adError));
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.RewardVideoAdListener
    public final void onRewardVideoAdLoad(PtgRewardVideoAd ptgRewardVideoAd) {
        if (this._a != null) {
            com.fancy.adsdk.lib.utils._d._c(new _b(ptgRewardVideoAd));
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.RewardVideoAdListener
    public final void onRewardVideoCached(PtgRewardVideoAd ptgRewardVideoAd) {
        if (this._a != null) {
            com.fancy.adsdk.lib.utils._d._c(new _c(ptgRewardVideoAd));
        }
    }
}
