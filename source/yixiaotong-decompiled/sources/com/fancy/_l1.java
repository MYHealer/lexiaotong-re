package com.fancy;

import android.content.Context;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.interf.PtgInteractionAd;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.tracking.ActionTrackManager;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _l1 implements PtgAdNative {
    public PtgAdNative _a;

    public class _a implements PtgAdNative.SplashAdListener {
        public final /* synthetic */ _os _a;
        public final /* synthetic */ _ci _b;
        public final /* synthetic */ PtgAdNative.SplashAdListener _c;
        public final /* synthetic */ AdSlot _d;

        /* JADX INFO: renamed from: com.fancy._l1$_a$_a, reason: collision with other inner class name */
        public class C0369_a implements PtgSplashAd.AdInteractionListener {
            @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdClicked() {
            }

            @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdShow() {
            }

            @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdSkip() {
            }

            @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdTimeOver() {
            }

            @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onDismiss(int i) {
            }

            @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onRenderError(AdError adError) {
            }

            @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onRenderSuccess() {
            }
        }

        public _a(_os _osVar, _ci _ciVar, PtgAdNative.SplashAdListener splashAdListener, AdSlot adSlot) {
            this._a = _osVar;
            this._b = _ciVar;
            this._c = splashAdListener;
            this._d = adSlot;
        }

        @Override // com.fancy.adsdk.lib.interf.Error
        public final void onError(AdError adError) {
            this._a._a(adError);
            this._a._t._f(0);
            if (adError.getErrorCode() != 10001) {
                _ou._a()._a(this._b._g(), "inAppErr", this._a, null);
            }
            this._c.onError(adError);
        }

        @Override // com.fancy.adsdk.lib.provider.PtgAdNative.SplashAdListener
        public final void onSplashAdLoad(PtgSplashAd ptgSplashAd) {
            this._a._a(this._d);
            _l1._a(_l1.this, ptgSplashAd.getAdFilterAdapter(), this._a);
            _pi._e._a(this._d, ptgSplashAd);
            this._a._t._b(this._b._h);
            this._a._t._a(this._b._i);
            this._a._c();
            boolean z_a = _n._a(ptgSplashAd.getAdFilterAdapter(), this._a);
            this._a._t._h(!z_a ? 1 : 0);
            _ou._a()._a(this._b._b(), "inAppBidSuc", this._a, null);
            if (!z_a) {
                if (ptgSplashAd.getAdFilterAdapter() != null && ((_nj) ptgSplashAd.getAdFilterAdapter())._a() != null) {
                    _ou._a()._a(this._b._G, "inAppFilter", this._a, ((_nj) ptgSplashAd.getAdFilterAdapter())._a()._a().toString());
                }
                onError(new AdErrorImpl(10001, "the ad prohibits display", (Object) null));
                return;
            }
            if (!this._d._x()) {
                _ou._a()._a(this._b._a(), "bidSel", this._a, null);
            }
            _jv _jvVar = new _jv(ptgSplashAd, this._d, this._a);
            _jvVar.setSplashInteractionListener(new C0369_a());
            this._c.onSplashAdLoad(_jvVar);
        }

        @Override // com.fancy.adsdk.lib.provider.PtgAdNative.SplashAdListener
        public final void onTimeout() {
            this._a._a(new AdErrorImpl(10004, "advert time out", (Object) null));
            this._a._t._f(0);
            _ou._a()._a(this._b._g(), "inAppErr", this._a, null);
            this._c.onTimeout();
        }
    }

    public class _b implements PtgAdNative.NativeExpressAdListener {
        public final /* synthetic */ _os _a;
        public final /* synthetic */ _ci _b;
        public final /* synthetic */ PtgAdNative.NativeExpressAdListener _c;
        public final /* synthetic */ AdSlot _d;

        public _b(_os _osVar, _ci _ciVar, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, AdSlot adSlot) {
            this._a = _osVar;
            this._b = _ciVar;
            this._c = nativeExpressAdListener;
            this._d = adSlot;
        }

        @Override // com.fancy.adsdk.lib.interf.Error
        public final void onError(AdError adError) {
            this._a._a(adError);
            this._a._t._f(0);
            if (adError.getErrorCode() != 10001) {
                _ou._a()._a(this._b._g(), "inAppErr", this._a, null);
            }
            this._c.onError(adError);
        }

        @Override // com.fancy.adsdk.lib.provider.PtgAdNative.NativeExpressAdListener
        public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
            this._a._a(this._d);
            _l1._a(_l1.this, ptgNativeExpressAd.getAdFilterAdapter(), this._a);
            this._a._t._b(this._b._h);
            this._a._t._a(this._b._i);
            this._a._c();
            boolean z_a = _n._a(ptgNativeExpressAd.getAdFilterAdapter(), this._a);
            this._a._t._h(!z_a ? 1 : 0);
            _ou._a()._a(this._b._b(), "inAppBidSuc", this._a, null);
            if (!z_a) {
                if (ptgNativeExpressAd.getAdFilterAdapter() != null && ((_nj) ptgNativeExpressAd.getAdFilterAdapter())._a() != null) {
                    _ou._a()._a(this._b._G, "inAppFilter", this._a, ((_nj) ptgNativeExpressAd.getAdFilterAdapter())._a()._a().toString());
                }
                onError(new AdErrorImpl(10001, "the ad prohibits display", (Object) null));
                return;
            }
            if (!this._d._x()) {
                _ou._a()._a(this._b._a(), "bidSel", this._a, null);
            }
            _jh _jhVar = new _jh(ptgNativeExpressAd, this._d, this._a);
            _jhVar.setExpressInteractionListener(_q._a);
            this._c.onNativeExpressAdLoad(_jhVar);
        }
    }

    public class _c implements PtgAdNative.RewardVideoAdListener {
        public _ju _a;
        public final /* synthetic */ _os _b;
        public final /* synthetic */ _ci _c;
        public final /* synthetic */ PtgAdNative.RewardVideoAdListener _d;
        public final /* synthetic */ AdSlot _e;

        public _c(_os _osVar, _ci _ciVar, PtgAdNative.RewardVideoAdListener rewardVideoAdListener, AdSlot adSlot) {
            this._b = _osVar;
            this._c = _ciVar;
            this._d = rewardVideoAdListener;
            this._e = adSlot;
        }

        @Override // com.fancy.adsdk.lib.interf.Error
        public final void onError(AdError adError) {
            this._b._a(adError);
            this._b._t._f(0);
            if (adError.getErrorCode() != 10001) {
                _ou._a()._a(this._c._g(), "inAppErr", this._b, null);
            }
            this._d.onError(adError);
        }

        @Override // com.fancy.adsdk.lib.provider.PtgAdNative.RewardVideoAdListener
        public final void onRewardVideoAdLoad(PtgRewardVideoAd ptgRewardVideoAd) {
            this._b._a(this._e);
            _l1._a(_l1.this, ptgRewardVideoAd.getAdFilterAdapter(), this._b);
            _pi._e._a(this._e, ptgRewardVideoAd);
            this._b._t._b(this._c._h);
            this._b._t._a(this._c._i);
            this._b._c();
            boolean z_a = _n._a(ptgRewardVideoAd.getAdFilterAdapter(), this._b);
            this._b._t._h(!z_a ? 1 : 0);
            _ou._a()._a(this._c._b(), "inAppBidSuc", this._b, null);
            if (!z_a) {
                if (ptgRewardVideoAd.getAdFilterAdapter() != null && ((_nj) ptgRewardVideoAd.getAdFilterAdapter())._a() != null) {
                    _ou._a()._a(this._c._G, "inAppFilter", this._b, ((_nj) ptgRewardVideoAd.getAdFilterAdapter())._a()._a().toString());
                }
                onError(new AdErrorImpl(10001, "the ad prohibits display", (Object) null));
                return;
            }
            if (!this._e._x()) {
                _ou._a()._a(this._c._a(), "bidSel", this._b, null);
            }
            _ju _juVar = new _ju(ptgRewardVideoAd, this._e, this._b);
            this._a = _juVar;
            this._d.onRewardVideoAdLoad(_juVar);
        }

        @Override // com.fancy.adsdk.lib.provider.PtgAdNative.RewardVideoAdListener
        public final void onRewardVideoCached(PtgRewardVideoAd ptgRewardVideoAd) {
            PtgAdNative.RewardVideoAdListener rewardVideoAdListener = this._d;
            _ju _juVar = this._a;
            if (_juVar != null) {
                ptgRewardVideoAd = _juVar;
            }
            rewardVideoAdListener.onRewardVideoCached(ptgRewardVideoAd);
        }
    }

    public class _d implements PtgAdNative.NativeExpressAdListener {
        public final /* synthetic */ _os _a;
        public final /* synthetic */ _ci _b;
        public final /* synthetic */ PtgAdNative.NativeExpressAdListener _c;
        public final /* synthetic */ AdSlot _d;

        public _d(_os _osVar, _ci _ciVar, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, AdSlot adSlot) {
            this._a = _osVar;
            this._b = _ciVar;
            this._c = nativeExpressAdListener;
            this._d = adSlot;
        }

        @Override // com.fancy.adsdk.lib.interf.Error
        public final void onError(AdError adError) {
            this._a._a(adError);
            this._a._t._f(0);
            if (adError.getErrorCode() != 10001) {
                _ou._a()._a(this._b._g(), "inAppErr", this._a, null);
            }
            this._c.onError(adError);
        }

        @Override // com.fancy.adsdk.lib.provider.PtgAdNative.NativeExpressAdListener
        public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
            this._a._a(this._d);
            _l1._a(_l1.this, ptgNativeExpressAd.getAdFilterAdapter(), this._a);
            _pi._e._a(this._d, ptgNativeExpressAd);
            this._a._t._b(this._b._h);
            this._a._t._a(this._b._i);
            this._a._c();
            boolean z_a = _n._a(ptgNativeExpressAd.getAdFilterAdapter(), this._a);
            this._a._t._h(!z_a ? 1 : 0);
            _ou._a()._a(this._b._b(), "inAppBidSuc", this._a, null);
            if (!z_a) {
                if (ptgNativeExpressAd.getAdFilterAdapter() != null && ((_nj) ptgNativeExpressAd.getAdFilterAdapter())._a() != null) {
                    _ou._a()._a(this._b._G, "inAppFilter", this._a, ((_nj) ptgNativeExpressAd.getAdFilterAdapter())._a()._a().toString());
                }
                onError(new AdErrorImpl(10001, "the ad prohibits display", (Object) null));
                return;
            }
            if (!this._d._x()) {
                _ou._a()._a(this._b._a(), "bidSel", this._a, null);
            }
            _jh _jhVar = new _jh(ptgNativeExpressAd, this._d, this._a);
            _jhVar.setExpressInteractionListener(_q._a);
            this._c.onNativeExpressAdLoad(_jhVar);
        }
    }

    public class _e implements PtgAdNative.InteractionExpressAdListener {
        public final /* synthetic */ _os _a;
        public final /* synthetic */ _ci _b;
        public final /* synthetic */ PtgAdNative.InteractionExpressAdListener _c;
        public final /* synthetic */ AdSlot _d;

        public _e(_os _osVar, _ci _ciVar, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener, AdSlot adSlot) {
            this._a = _osVar;
            this._b = _ciVar;
            this._c = interactionExpressAdListener;
            this._d = adSlot;
        }

        @Override // com.fancy.adsdk.lib.interf.Error
        public final void onError(AdError adError) {
            this._a._a(adError);
            this._a._t._f(0);
            if (adError.getErrorCode() != 10001) {
                _ou._a()._a(this._b._g(), "inAppErr", this._a, null);
            }
            this._c.onError(adError);
        }

        @Override // com.fancy.adsdk.lib.provider.PtgAdNative.InteractionExpressAdListener
        public final void onInteractionAdLoad(PtgInteractionAd ptgInteractionAd) {
            this._a._a(this._d);
            _l1._a(_l1.this, ptgInteractionAd.getAdFilterAdapter(), this._a);
            _pi._e._a(this._d, ptgInteractionAd);
            this._a._t._b(this._b._h);
            this._a._t._a(this._b._i);
            this._a._c();
            boolean z_a = _n._a(ptgInteractionAd.getAdFilterAdapter(), this._a);
            this._a._t._h(!z_a ? 1 : 0);
            _ou._a()._a(this._b._b(), "inAppBidSuc", this._a, null);
            if (!z_a) {
                if (ptgInteractionAd.getAdFilterAdapter() != null && ((_nj) ptgInteractionAd.getAdFilterAdapter())._a() != null) {
                    _ou._a()._a(this._b._G, "inAppFilter", this._a, ((_nj) ptgInteractionAd.getAdFilterAdapter())._a()._a().toString());
                }
                onError(new AdErrorImpl(10001, "the ad prohibits display", (Object) null));
                return;
            }
            if (!this._d._x()) {
                _ou._a()._a(this._b._a(), "bidSel", this._a, null);
            }
            _jg _jgVar = new _jg(ptgInteractionAd, this._d, this._a);
            _jgVar.setAdInteractionListener(_q._b);
            this._c.onInteractionAdLoad(_jgVar);
        }
    }

    public class _f implements PtgAdNative.NativeExpressAdListener {
        public final /* synthetic */ _os _a;
        public final /* synthetic */ _ci _b;
        public final /* synthetic */ PtgAdNative.NativeExpressAdListener _c;
        public final /* synthetic */ AdSlot _d;

        public _f(_os _osVar, _ci _ciVar, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, AdSlot adSlot) {
            this._a = _osVar;
            this._b = _ciVar;
            this._c = nativeExpressAdListener;
            this._d = adSlot;
        }

        @Override // com.fancy.adsdk.lib.interf.Error
        public final void onError(AdError adError) {
            this._a._a(adError);
            this._a._t._f(0);
            if (adError.getErrorCode() != 10001) {
                _ou._a()._a(this._b._g(), "inAppErr", this._a, null);
            }
            this._c.onError(adError);
        }

        @Override // com.fancy.adsdk.lib.provider.PtgAdNative.NativeExpressAdListener
        public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
            this._a._a(this._d);
            _l1._a(_l1.this, ptgNativeExpressAd.getAdFilterAdapter(), this._a);
            _pi._e._a(this._d, ptgNativeExpressAd);
            this._a._t._b(this._b._h);
            this._a._t._a(this._b._i);
            this._a._c();
            boolean z_a = _n._a(ptgNativeExpressAd.getAdFilterAdapter(), this._a);
            this._a._t._h(!z_a ? 1 : 0);
            _ou._a()._a(this._b._b(), "inAppBidSuc", this._a, null);
            if (!z_a) {
                if (ptgNativeExpressAd.getAdFilterAdapter() != null && ((_nj) ptgNativeExpressAd.getAdFilterAdapter())._a() != null) {
                    _ou._a()._a(this._b._G, "inAppFilter", this._a, ((_nj) ptgNativeExpressAd.getAdFilterAdapter())._a()._a().toString());
                }
                onError(new AdErrorImpl(10001, "the ad prohibits display", (Object) null));
                return;
            }
            if (!this._d._x()) {
                _ou._a()._a(this._b._a(), "bidSel", this._a, null);
            }
            _jh _jhVar = new _jh(ptgNativeExpressAd, this._d, this._a);
            _jhVar.setExpressInteractionListener(_q._a);
            this._c.onNativeExpressAdLoad(_jhVar);
        }
    }

    public _l1(com.fancy.adsdk.lib.provider._b _bVar) {
        this._a = _bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _a(_l1 _l1Var, _m _mVar, _os _osVar) {
        _l1Var.getClass();
        if (_mVar != null) {
            T t = ((_ip) _mVar)._a;
            Map<String, String> map = t != 0 ? ((com.fancy._f) t)._t : null;
            synchronized (_osVar._s) {
                if (map != null) {
                    _osVar._s.clear();
                    _osVar._s.putAll(map);
                }
            }
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final String getBiddingToken(AdSlot adSlot, int i) {
        return "";
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final String getName() {
        PtgAdNative ptgAdNative = this._a;
        return ptgAdNative == null ? "null" : ptgAdNative.getName();
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void init(Context context) {
        PtgAdNative ptgAdNative = this._a;
        if (ptgAdNative == null) {
            return;
        }
        ptgAdNative.init(context);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadBannerExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (this._a == null) {
            _c4._a(10013, "可用SDK为空，请确认分发策略配置，以及是否引用该模块", null, nativeExpressAdListener);
            return;
        }
        ActionTrackManager._a()._b();
        _ci _ciVar_i = adSlot._i();
        if (_ciVar_i == null) {
            _c4._a(10019, "内部错误，无分发策略", null, nativeExpressAdListener);
            return;
        }
        adSlot.setCodeID(_ciVar_i._e());
        adSlot._a(5);
        _os _osVar = new _os(_ciVar_i._c, _ciVar_i._e(), adSlot);
        _d _dVar = new _d(_osVar, _ciVar_i, nativeExpressAdListener, adSlot);
        try {
            _osVar._o = _ciVar_i._b;
            _osVar._a(adSlot._j());
            _osVar._t._i(PtgAdSdk.getConfig().getMediaId());
            _osVar._t._n(adSlot.getUserID());
            _osVar._t._m(adSlot.getPtgSlotID());
            _osVar._t._e(_ciVar_i._e());
            _osVar._t._f(_ciVar_i._c);
            _osVar._t._c(_ciVar_i._S);
            _osVar._t._d(_ciVar_i._e);
            _a(nativeExpressAdListener, adSlot, _osVar);
            _ou._a()._a(_ciVar_i._c(), "inAppBid", _osVar, null);
            adSlot._a(_osVar);
            this._a.loadBannerExpressAd(context, adSlot, _dVar);
        } catch (Exception e) {
            _dVar.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadDrawExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (this._a == null) {
            _c4._a(10013, "可用SDK为空，请确认分发策略配置，以及是否引用该模块", null, nativeExpressAdListener);
            return;
        }
        ActionTrackManager._a()._b();
        _ci _ciVar_i = adSlot._i();
        if (_ciVar_i == null) {
            _c4._a(10019, "内部错误，无分发策略", null, nativeExpressAdListener);
            return;
        }
        adSlot.setCodeID(_ciVar_i._e());
        adSlot._a(101);
        _os _osVar = new _os(_ciVar_i._c, _ciVar_i._e(), adSlot);
        _f _fVar = new _f(_osVar, _ciVar_i, nativeExpressAdListener, adSlot);
        try {
            _osVar._o = _ciVar_i._b;
            _osVar._a(adSlot._j());
            _osVar._t._i(PtgAdSdk.getConfig().getMediaId());
            _osVar._t._n(adSlot.getUserID());
            _osVar._t._m(adSlot.getPtgSlotID());
            _osVar._t._e(_ciVar_i._e());
            _osVar._t._f(_ciVar_i._c);
            _osVar._t._c(_ciVar_i._S);
            _osVar._t._d(_ciVar_i._e);
            _a(nativeExpressAdListener, adSlot, _osVar);
            _ou._a()._a(_ciVar_i._c(), "inAppBid", _osVar, null);
            adSlot._a(_osVar);
            this._a.loadDrawExpressAd(context, adSlot, _fVar);
        } catch (Exception e) {
            _fVar.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadInteractionExpressAd(Context context, AdSlot adSlot, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        if (this._a == null) {
            interactionExpressAdListener.onError(new AdErrorImpl(10013, "可用SDK为空，请确认分发策略配置，以及是否引用该模块", (Object) null));
            return;
        }
        ActionTrackManager._a()._b();
        _ci _ciVar_i = adSlot._i();
        if (_ciVar_i == null) {
            interactionExpressAdListener.onError(new AdErrorImpl(10019, "内部错误，无分发策略", (Object) null));
            return;
        }
        adSlot.setCodeID(_ciVar_i._e());
        adSlot._a(7);
        _os _osVar = new _os(_ciVar_i._c, _ciVar_i._e(), adSlot);
        _e _eVar = new _e(_osVar, _ciVar_i, interactionExpressAdListener, adSlot);
        try {
            _osVar._o = _ciVar_i._b;
            _osVar._a(adSlot._j());
            _osVar._t._i(PtgAdSdk.getConfig().getMediaId());
            _osVar._t._n(adSlot.getUserID());
            _osVar._t._m(adSlot.getPtgSlotID());
            _osVar._t._e(_ciVar_i._e());
            _osVar._t._f(_ciVar_i._c);
            _osVar._t._c(_ciVar_i._S);
            _osVar._t._d(_ciVar_i._e);
            _a(interactionExpressAdListener, adSlot, _osVar);
            _ou._a()._a(_ciVar_i._c(), "inAppBid", _osVar, null);
            adSlot._a(_osVar);
            this._a.loadInteractionExpressAd(context, adSlot, _eVar);
        } catch (Exception e) {
            _eVar.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadNativeExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (this._a == null) {
            _c4._a(10013, "可用SDK为空，请确认分发策略配置，以及是否引用该模块", null, nativeExpressAdListener);
            return;
        }
        ActionTrackManager._a()._b();
        _ci _ciVar_i = adSlot._i();
        if (_ciVar_i == null) {
            _c4._a(10019, "内部错误，无分发策略", null, nativeExpressAdListener);
            return;
        }
        adSlot.setCodeID(_ciVar_i._e());
        adSlot._a(8);
        _os _osVar = new _os(_ciVar_i._c, _ciVar_i._e(), adSlot);
        _b _bVar = new _b(_osVar, _ciVar_i, nativeExpressAdListener, adSlot);
        try {
            _osVar._o = _ciVar_i._b;
            _osVar._a(adSlot._j());
            _osVar._t._i(PtgAdSdk.getConfig().getMediaId());
            _osVar._t._n(adSlot.getUserID());
            _osVar._t._m(adSlot.getPtgSlotID());
            _or _orVar = _osVar._t;
            boolean zIsSelfRender = adSlot.isSelfRender();
            _orVar.getClass();
            try {
                synchronized (_orVar._a) {
                    try {
                        _orVar._a.put("selfRender", zIsSelfRender);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e) {
                Error error = _orVar._b;
                if (error != null) {
                    error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
                }
            }
            _osVar._t._e(_ciVar_i._e());
            _osVar._t._f(_ciVar_i._c);
            _osVar._t._c(_ciVar_i._S);
            _osVar._t._d(_ciVar_i._e);
            _a(nativeExpressAdListener, adSlot, _osVar);
            _ou._a()._a(_ciVar_i._c(), "inAppBid", _osVar, null);
            adSlot._a(_osVar);
            this._a.loadNativeExpressAd(context, adSlot, _bVar);
        } catch (Exception e2) {
            _bVar.onError(new AdErrorImpl(10019, e2.getMessage(), (Object) null));
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadRewardVideoAd(Context context, AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (this._a == null) {
            rewardVideoAdListener.onError(new AdErrorImpl(10013, "可用SDK为空，请确认分发策略配置，以及是否引用该模块", (Object) null));
            return;
        }
        ActionTrackManager._a()._b();
        _ci _ciVar_i = adSlot._i();
        if (_ciVar_i == null) {
            rewardVideoAdListener.onError(new AdErrorImpl(10019, "内部错误，无分发策略", (Object) null));
            return;
        }
        adSlot.setCodeID(_ciVar_i._e());
        adSlot._a(100);
        _os _osVar = new _os(_ciVar_i._c, _ciVar_i._e(), adSlot);
        _c _cVar = new _c(_osVar, _ciVar_i, rewardVideoAdListener, adSlot);
        try {
            _osVar._o = _ciVar_i._b;
            _osVar._a(adSlot._j());
            _osVar._t._i(PtgAdSdk.getConfig().getMediaId());
            _osVar._t._n(adSlot.getUserID());
            _osVar._t._m(adSlot.getPtgSlotID());
            _osVar._t._e(_ciVar_i._e());
            _osVar._t._f(_ciVar_i._c);
            _osVar._t._c(_ciVar_i._S);
            _osVar._t._d(_ciVar_i._e);
            _a(rewardVideoAdListener, adSlot, _osVar);
            _ou._a()._a(_ciVar_i._c(), "inAppBid", _osVar, null);
            adSlot._a(_osVar);
            this._a.loadRewardVideoAd(context, adSlot, _cVar);
        } catch (Exception e) {
            _cVar.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadSplashAd(Context context, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener) {
        if (this._a == null) {
            splashAdListener.onError(new AdErrorImpl(10013, "可用SDK为空，请确认分发策略配置，以及是否引用该模块", (Object) null));
            return;
        }
        ActionTrackManager._a()._b();
        _ci _ciVar_i = adSlot._i();
        if (_ciVar_i == null) {
            splashAdListener.onError(new AdErrorImpl(10019, "内部错误，无分发策略", (Object) null));
            return;
        }
        adSlot.setCodeID(_ciVar_i._e());
        adSlot._a(6);
        _os _osVar = new _os(_ciVar_i._c, _ciVar_i._e(), adSlot);
        _a _aVar = new _a(_osVar, _ciVar_i, splashAdListener, adSlot);
        try {
            _osVar._o = _ciVar_i._b;
            _osVar._a(adSlot._j());
            _osVar._t._i(PtgAdSdk.getConfig().getMediaId());
            _osVar._t._n(adSlot.getUserID());
            _osVar._t._m(adSlot.getPtgSlotID());
            _osVar._t._e(_ciVar_i._e());
            _osVar._t._f(_ciVar_i._c);
            _osVar._t._c(_ciVar_i._S);
            _osVar._t._d(_ciVar_i._e);
            _a(splashAdListener, adSlot, _osVar);
            _ou._a()._a(_ciVar_i._c(), "inAppBid", _osVar, null);
            adSlot._a(_osVar);
            this._a.loadSplashAd(context, adSlot, _aVar);
        } catch (Exception e) {
            _aVar.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
        }
    }

    public static void _a(Object obj, AdSlot adSlot, _os _osVar) {
        if (obj instanceof _bg) {
            _bg _bgVar = (_bg) obj;
            _bgVar._b = adSlot;
            _bgVar._d = _osVar;
        }
    }
}
