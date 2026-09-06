package com.fancy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.NativeAdvertData;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.mpsdk.activity.PtgRewardVideoLandscapeActivity;
import com.fancy.mpsdk.activity.PtgRewardVideoPortraitActivity;
import com.fancy.mpsdk.provider.PtgApiProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _kk implements PtgRewardVideoAd {
    public _m _a;
    public String _b;
    public final /* synthetic */ _f _c;
    public final /* synthetic */ String _d;
    public final /* synthetic */ AtomicBoolean _e;
    public final /* synthetic */ _kf _f;

    public class _a implements PtgRewardVideoAd.RewardAdInteractionListener {
        public boolean _a = false;
        public final /* synthetic */ PtgRewardVideoAd.RewardAdInteractionListener _b;

        public _a(PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            this._b = rewardAdInteractionListener;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onAdClose() {
            PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onAdClose();
            }
            _kk.this._f._b._d._b = null;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onAdShow() {
            _kk _kkVar = _kk.this;
            _f _fVar = _kkVar._c;
            if (_fVar != null) {
                _fVar._A = true;
            }
            _kkVar._f._b._b._h();
            _kk _kkVar2 = _kk.this;
            if (_kkVar2._c._q != null && _kkVar2._f._b._b._t() != null) {
                _or _orVar = _kk.this._f._b._b._t()._t;
                String str = _kk.this._c._q._d;
                _orVar.getClass();
                try {
                    synchronized (_orVar._a) {
                        _orVar._a.put("enBidPrice", str);
                    }
                } catch (Exception unused) {
                }
            }
            PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onAdShow();
            }
            if (!this._a) {
                this._a = true;
                _ou _ouVar_a = _ou._a();
                _kk _kkVar3 = _kk.this;
                _f _fVar2 = _kkVar3._c;
                AdSlot adSlot = _kkVar3._f._b._b;
                _m1 _m1Var = _ouVar_a._b;
                if (_m1Var != null) {
                    _m1Var._a(_fVar2);
                } else {
                    _m1 _m1Var2 = new _m1();
                    _ouVar_a._b = _m1Var2;
                    _m1Var2._a(_fVar2);
                }
            }
            _kk.this._f._b._d._b = null;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onAdVideoBarClick() {
            PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onAdVideoBarClick();
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onRenderError(AdError adError) {
            PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onRenderError(adError);
            }
            _kk.this._f._b._d._b = null;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onRewardVerify(boolean z, Bundle bundle) {
            PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onRewardVerify(z, bundle);
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onSkippedVideo() {
            PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onSkippedVideo();
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoComplete() {
            PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onVideoComplete();
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoError(int i, String str) {
            PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onVideoError(i, str);
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoPause() {
            PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onVideoPause();
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoProgressUpdate(long j, long j2) {
            PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onVideoProgressUpdate(j, j2);
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoResume() {
            PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onVideoResume();
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public final void onVideoStart() {
            PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this._b;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onVideoStart();
            }
        }
    }

    public _kk(_kf _kfVar, _f _fVar, String str, AtomicBoolean atomicBoolean) {
        this._f = _kfVar;
        this._c = _fVar;
        this._d = str;
        this._e = atomicBoolean;
        this._a = new _ip(_fVar, _kfVar._b._b);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void destroy() {
        this._e.set(true);
        _m8._a()._b(this._d);
        this._f._b._d._b = null;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final _m getAdFilterAdapter() {
        return this._a;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final String getAdId() {
        _os _osVar_t;
        if (TextUtils.isEmpty(this._b) && (_osVar_t = this._f._b._b._t()) != null) {
            this._b = _osVar_t._h;
        }
        return this._b;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd
    public final NativeAdvertData getAdvertData() {
        return _ib._a(100, false, this._c);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final String getConsumer() {
        return PtgApiProvider.providerName;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final long getEcpm() {
        _f _fVar = this._c;
        if (_fVar != null) {
            return _fVar._m;
        }
        return 0L;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final int getInteractionType() {
        return 0;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd
    public final Map<String, Object> getMediaExtraInfo() {
        return null;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final boolean isReady() {
        _f _fVar = this._c;
        return _fVar != null && _fVar._t();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final boolean isResourceLoaded() {
        _f _fVar = this._c;
        return _fVar != null && _fVar._J;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd
    public final boolean isVideoCached() {
        _f _fVar = this._c;
        if (_fVar == null) {
            return false;
        }
        if (!_fVar._u() || TextUtils.isEmpty(this._c._o())) {
            return true;
        }
        Context context = this._f._b._c;
        if (context == null) {
            return this._c._J;
        }
        try {
            return _hz._a(context)._a(this._c._o());
        } catch (Throwable unused) {
            return this._c._J;
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void notifyBidLoss(AdBidLossReason adBidLossReason) {
        if (this._c != null) {
            _km _kmVar = this._f._b._d;
            if (_kmVar._a) {
                return;
            }
            _kmVar._a = true;
            _ou _ouVar_a = _ou._a();
            _f _fVar = this._c;
            _m1 _m1Var = _ouVar_a._b;
            if (_m1Var != null) {
                _m1Var._a(_fVar, adBidLossReason);
                return;
            }
            _m1 _m1Var2 = new _m1();
            _ouVar_a._b = _m1Var2;
            _m1Var2._a(_fVar, adBidLossReason);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void notifyBidWin(double d, double d2) {
        if (this._c != null) {
            _km _kmVar = this._f._b._d;
            if (_kmVar._a) {
                return;
            }
            _kmVar._a = true;
            _ou _ouVar_a = _ou._a();
            _f _fVar = this._c;
            AdSlot adSlot = this._f._b._b;
            _m1 _m1Var = _ouVar_a._b;
            if (_m1Var != null) {
                _m1Var._b(_fVar);
                return;
            }
            _m1 _m1Var2 = new _m1();
            _ouVar_a._b = _m1Var2;
            _m1Var2._b(_fVar);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void setAdFilterAdapter(_m _mVar) {
        if (_mVar != null) {
            this._a = _mVar;
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd
    public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        _m8 _m8Var_a = _m8._a();
        String str = this._d;
        synchronized (_m8Var_a._d) {
            List arrayList = (List) _m8Var_a._d.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                _m8Var_a._d.put(str, arrayList);
            }
            if (!arrayList.contains(ptgAppDownloadListener)) {
                arrayList.add(ptgAppDownloadListener);
            }
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd
    public final void setRewardAdInteractionListener(PtgRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        _m8 _m8Var_a = _m8._a();
        String str = this._d;
        _a _aVar = new _a(rewardAdInteractionListener);
        if (str == null) {
            _m8Var_a.getClass();
            return;
        }
        synchronized (_m8Var_a._c) {
            List arrayList = (List) _m8Var_a._c.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                _m8Var_a._c.put(str, arrayList);
            }
            if (!arrayList.contains(_aVar)) {
                arrayList.add(_aVar);
            }
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgRewardVideoAd
    public final void showRewardVideoAd(Activity activity) {
        if (!this._c._t()) {
            _m8 _m8Var_a = _m8._a();
            String str = this._d;
            AdErrorImpl adErrorImpl = new AdErrorImpl();
            adErrorImpl._c = PtgApiProvider.providerName;
            adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
            adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_5;
            adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
            adErrorImpl._b = PtgErrorCode.SDK_RENDER_ERROR_5;
            _m8Var_a._a(str, adErrorImpl);
            return;
        }
        _f _fVar = this._c;
        AdSlot adSlot = this._f._b._b;
        int i = PtgRewardVideoPortraitActivity._M;
        if (activity == null || _fVar == null || adSlot == null) {
            return;
        }
        _f0 _f0Var = _fVar._E;
        int i2 = _f0Var != null ? _f0Var._a : 0;
        _m8 _m8Var_a2 = _m8._a();
        synchronized (_m8Var_a2._a) {
            _m8Var_a2._a.put(String.valueOf(_fVar.hashCode()), _fVar);
        }
        synchronized (_m8Var_a2._a) {
            _m8Var_a2._b.put(String.valueOf(_fVar.hashCode()), adSlot);
        }
        Intent intent = i2 == 0 ? new Intent(activity, (Class<?>) PtgRewardVideoPortraitActivity.class) : new Intent(activity, (Class<?>) PtgRewardVideoLandscapeActivity.class);
        intent.putExtra("VIDEO_ADVERT_ID", String.valueOf(_fVar.hashCode()));
        activity.startActivity(intent);
    }
}
