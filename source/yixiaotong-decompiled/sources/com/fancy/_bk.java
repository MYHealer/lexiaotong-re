package com.fancy;

import android.os.Handler;
import android.os.Looper;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _bk extends _bg implements PtgAdNative.RewardVideoAdListener {
    public PtgRewardVideoAd _h;
    public PtgAdNative.RewardVideoAdListener _i;
    public Integer _j;

    public class _a implements Runnable {
        public final /* synthetic */ PtgRewardVideoAd _a;

        public _a(PtgRewardVideoAd ptgRewardVideoAd) {
            this._a = ptgRewardVideoAd;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Logger.e("TrackingManager:", "onRewardVideoCached--" + _bk.this._b());
                _bk.this._i.onRewardVideoCached(this._a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class _b implements Runnable {
        public _b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Logger.e("TrackingManager:", _ie._a("doOnLoad--").append(_bk.this._b()).toString());
            _bk _bkVar = _bk.this;
            PtgRewardVideoAd ptgRewardVideoAd = _bkVar._h;
            if (ptgRewardVideoAd != null) {
                _bkVar._i.onRewardVideoAdLoad(ptgRewardVideoAd);
            } else {
                _bkVar._i.onError(new AdErrorImpl(10001, "no ad in concurrent", (Object) null));
            }
        }
    }

    public _bk(SortedSet sortedSet, _ci _ciVar, AtomicInteger atomicInteger, PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        super(sortedSet, _ciVar, atomicInteger);
        this._i = rewardVideoAdListener;
    }

    @Override // com.fancy._bg
    public final void _a() {
        new Handler(Looper.getMainLooper()).post(new _b());
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

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.RewardVideoAdListener
    public final void onRewardVideoAdLoad(PtgRewardVideoAd ptgRewardVideoAd) {
        Logger.e("TrackingManager:", _ie._a("onRewardVideoAdLoad--").append(_b()).toString());
        this._h = ptgRewardVideoAd;
        this._a.add(this);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.RewardVideoAdListener
    public final void onRewardVideoCached(PtgRewardVideoAd ptgRewardVideoAd) {
        new Handler(Looper.getMainLooper()).post(new _a(ptgRewardVideoAd));
    }
}
