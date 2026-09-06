package com.fancy;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.NativeAdvertData;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ju implements PtgRewardVideoAd {
    public AdSlot _a;
    public PtgRewardVideoAd _b;
    public _os _c;

    public class _a implements PtgRewardVideoAd.RewardAdInteractionListener {
        public final /* synthetic */ PtgRewardVideoAd.RewardAdInteractionListener _a;

        public _a(PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            this._a = rewardAdInteractionListener;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onAdClose() {
            this._a.onAdClose();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onAdShow() {
            if (_ju.this._c._p) {
                _ou._a()._a(_ju.this._a._i()._h(), "inAppImp", _ju.this._c, null);
                _ju.this._c._d();
                this._a.onAdShow();
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onAdVideoBarClick() {
            _ju _juVar = _ju.this;
            _os _osVar = _juVar._c;
            if (_osVar != null) {
                _osVar._t._b(_juVar._a._u());
            }
            if (_ju.this._a._f()) {
                _ou._a()._a(_ju.this._a._i()._d(), "inAppClick", _ju.this._c, null);
            }
            if (!Boolean.parseBoolean(_ju.this._c._a())) {
                this._a.onAdVideoBarClick();
                return;
            }
            _os _osVar2 = _ju.this._c;
            String strValueOf = String.valueOf(false);
            synchronized (_osVar2._s) {
                if (!TextUtils.isEmpty("iReportM")) {
                    _osVar2._s.put("iReportM", strValueOf);
                }
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onRenderError(AdError adError) {
            AdSlot adSlot;
            _ju _juVar = _ju.this;
            if (_juVar._c != null && (adSlot = _juVar._a) != null && adSlot._i() != null) {
                _ju.this._c._a(adError);
                _ou._a()._a(_ju.this._a._i()._g(), "inAppErr", _ju.this._c, null);
            }
            this._a.onRenderError(adError);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onRewardVerify(boolean z, Bundle bundle) {
            AdSlot adSlot;
            _ju _juVar = _ju.this;
            _os _osVar = _juVar._c;
            if (_osVar != null && _osVar._t != null && (adSlot = _juVar._a) != null && adSlot._i() != null && bundle != null) {
                _ju.this._c._t._a(Integer.valueOf(bundle.getInt("reward_type")), "reward_type");
                _ou._a()._a(_ju.this._a._i()._H, "reward", _ju.this._c, null);
            }
            this._a.onRewardVerify(z, bundle);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onSkippedVideo() {
            this._a.onSkippedVideo();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoComplete() {
            this._a.onVideoComplete();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoError(int i, String str) {
            AdSlot adSlot;
            _ju _juVar = _ju.this;
            if (_juVar._c != null && (adSlot = _juVar._a) != null && adSlot._i() != null) {
                _os _osVar = _ju.this._c;
                AdErrorImpl adErrorImpl = new AdErrorImpl();
                adErrorImpl._a = i;
                adErrorImpl._b = str;
                _osVar._a(adErrorImpl);
                _ou._a()._a(_ju.this._a._i()._g(), "inAppErr", _ju.this._c, null);
            }
            this._a.onVideoError(i, str);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoPause() {
            this._a.onVideoPause();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoProgressUpdate(long j, long j2) {
            this._a.onVideoProgressUpdate(j, j2);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoResume() {
            this._a.onVideoResume();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoStart() {
            this._a.onVideoStart();
        }
    }

    public _ju(PtgRewardVideoAd ptgRewardVideoAd, AdSlot adSlot, _os _osVar) {
        this._b = ptgRewardVideoAd;
        this._a = adSlot;
        this._c = _osVar;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void destroy() {
        this._b.destroy();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final _m getAdFilterAdapter() {
        return this._b.getAdFilterAdapter();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final String getAdId() {
        return this._b.getAdId();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd
    public final NativeAdvertData getAdvertData() {
        return this._b.getAdvertData();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final String getConsumer() {
        return this._b.getConsumer();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final long getEcpm() {
        PtgRewardVideoAd ptgRewardVideoAd = this._b;
        if (ptgRewardVideoAd != null) {
            return ptgRewardVideoAd.getEcpm();
        }
        return 0L;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final int getInteractionType() {
        return this._b.getInteractionType();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd
    public final Map<String, Object> getMediaExtraInfo() {
        return this._b.getMediaExtraInfo();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final boolean isReady() {
        return this._b.isReady();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final boolean isResourceLoaded() {
        return this._b.isResourceLoaded();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd
    public final boolean isVideoCached() {
        return this._b.isVideoCached();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void notifyBidLoss(AdBidLossReason adBidLossReason) {
        _ci _ciVar_i;
        AdSlot adSlot = this._a;
        if (adSlot != null && (_ciVar_i = adSlot._i()) != null) {
            _os _osVar = new _os(_ciVar_i._c, _ciVar_i._e(), this._a);
            _osVar._o = _ciVar_i._b;
            _osVar._a(this._a._j());
            _or _orVar = _osVar._t;
            if (_orVar != null) {
                _orVar._f(_ciVar_i._c);
                _orVar._e(_ciVar_i._e());
                _orVar._b(_ciVar_i._h);
                _orVar._a(_ciVar_i._i);
                _orVar._i(PtgAdSdk.getConfig().getMediaId());
                _orVar._n(this._a.getUserID());
                _orVar._m(this._a.getPtgSlotID());
                _orVar._c(_ciVar_i._S);
                _orVar._d(_ciVar_i._e);
                if (adBidLossReason != null) {
                    _orVar._d(adBidLossReason.getReason());
                }
            }
            _ou._a()._a(_ciVar_i._I, "inAppBidLoss", _osVar, null);
        }
        PtgRewardVideoAd ptgRewardVideoAd = this._b;
        if (ptgRewardVideoAd != null) {
            ptgRewardVideoAd.notifyBidLoss(adBidLossReason);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void notifyBidWin(double d, double d2) {
        _ci _ciVar_i;
        AdSlot adSlot = this._a;
        if (adSlot != null && (_ciVar_i = adSlot._i()) != null) {
            _os _osVar = new _os(_ciVar_i._c, _ciVar_i._e(), this._a);
            _osVar._o = _ciVar_i._b;
            _osVar._a(this._a._j());
            _or _orVar = _osVar._t;
            if (_orVar != null) {
                _orVar._f(_ciVar_i._c);
                _orVar._e(_ciVar_i._e());
                _orVar._b(_ciVar_i._h);
                _orVar._a(_ciVar_i._i);
                _orVar._i(PtgAdSdk.getConfig().getMediaId());
                _orVar._n(this._a.getUserID());
                _orVar._m(this._a.getPtgSlotID());
                _orVar._c(_ciVar_i._S);
                _orVar._d(_ciVar_i._e);
                _orVar._a(d);
                _orVar._b(d2);
            }
            _ou._a()._a(_ciVar_i._J, "inAppBidWin", _osVar, null);
        }
        PtgRewardVideoAd ptgRewardVideoAd = this._b;
        if (ptgRewardVideoAd != null) {
            ptgRewardVideoAd.notifyBidWin(d, d2);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void setAdFilterAdapter(_m _mVar) {
        this._b.setAdFilterAdapter(_mVar);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd
    public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        this._b.setDownloadListener(ptgAppDownloadListener);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd
    public final void setRewardAdInteractionListener(PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this._b.setRewardAdInteractionListener(new _a(rewardAdInteractionListener));
    }

    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd
    public final void showRewardVideoAd(Activity activity) {
        this._b.showRewardVideoAd(activity);
    }
}
