package com.fancy;

import android.app.Activity;
import android.text.TextUtils;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.NativeAdvertData;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.interf.PtgInteractionAd;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.provider.arb.ArbitraryAdapter;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.fancy.mpsdk.activity.PtgInteractionPortraitActivity;
import com.fancy.mpsdk.provider.PtgApiProvider;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _k1 implements Runnable {
    public final /* synthetic */ _r _a;
    public final /* synthetic */ _k2 _b;

    public class _a implements _ef {
        public final /* synthetic */ _f _a;
        public final /* synthetic */ String _b;

        public _a(_f _fVar, String str) {
            this._a = _fVar;
            this._b = str;
        }

        @Override // com.fancy._ef
        public final void _a(long j) {
            _f _fVar = this._a;
            _fVar._m = (int) j;
            _k1.this._a(_fVar, this._b);
        }
    }

    public class _b implements PtgInteractionAd {
        public _m _a;
        public String _b;
        public boolean _c = false;
        public final /* synthetic */ _f _d;
        public final /* synthetic */ String _e;

        public class _a implements PtgInteractionAd.AdInteractionListener {
            public boolean _a = false;

            public _a() {
            }

            @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
            public final void onAdClicked() {
                Logger.d("PtgInteractionAdLoader", "loadInteractionAd onAdClicked");
                PtgInteractionAd.AdInteractionListener adInteractionListener = _k1.this._b._c._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdClicked();
                }
            }

            @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
            public final void onAdDismiss() {
                Logger.d("PtgInteractionAdLoader", "loadInteractionAd onAdDismiss");
                PtgInteractionAd.AdInteractionListener adInteractionListener = _k1.this._b._c._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdDismiss();
                }
                _k1.this._b._c._b = null;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
            public final void onAdShow() {
                Logger.d("PtgInteractionAdLoader", "loadInteractionAd onAdShow");
                _b _bVar = _b.this;
                _f _fVar = _bVar._d;
                if (_fVar != null) {
                    _fVar._A = true;
                    if (_fVar._q != null && _k1.this._b._b._t() != null) {
                        _or _orVar = _k1.this._b._b._t()._t;
                        String str = _b.this._d._q._d;
                        _orVar.getClass();
                        try {
                            synchronized (_orVar._a) {
                                _orVar._a.put("enBidPrice", str);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                PtgInteractionAd.AdInteractionListener adInteractionListener = _k1.this._b._c._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdShow();
                }
                if (!this._a) {
                    this._a = true;
                    _ou _ouVar_a = _ou._a();
                    _b _bVar2 = _b.this;
                    _f _fVar2 = _bVar2._d;
                    AdSlot adSlot = _k1.this._b._b;
                    _m1 _m1Var = _ouVar_a._b;
                    if (_m1Var != null) {
                        _m1Var._a(_fVar2);
                    } else {
                        _m1 _m1Var2 = new _m1();
                        _ouVar_a._b = _m1Var2;
                        _m1Var2._a(_fVar2);
                    }
                }
                _k1.this._b._c._b = null;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
            public final void onRenderError(AdError adError) {
                Logger.d("PtgInteractionAdLoader", "loadInteractionAd onRenderError");
                PtgInteractionAd.AdInteractionListener adInteractionListener = _k1.this._b._c._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onRenderError(adError);
                }
                _k1.this._b._c._b = null;
            }
        }

        /* JADX INFO: renamed from: com.fancy._k1$_b$_b, reason: collision with other inner class name */
        public class C0368_b implements PtgVideoAdListener {
            public final /* synthetic */ PtgVideoAdListener _a;

            public C0368_b(PtgVideoAdListener ptgVideoAdListener) {
                this._a = ptgVideoAdListener;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
            public final void onVideoComplete() {
                PtgVideoAdListener ptgVideoAdListener = this._a;
                if (ptgVideoAdListener != null) {
                    ptgVideoAdListener.onVideoComplete();
                }
            }

            @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
            public final void onVideoError(int i, String str) {
                PtgVideoAdListener ptgVideoAdListener = this._a;
                if (ptgVideoAdListener != null) {
                    ptgVideoAdListener.onVideoError(i, str);
                }
            }

            @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
            public final void onVideoPause() {
                PtgVideoAdListener ptgVideoAdListener = this._a;
                if (ptgVideoAdListener != null) {
                    ptgVideoAdListener.onVideoPause();
                }
            }

            @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
            public final void onVideoProgressUpdate(long j, long j2) {
                PtgVideoAdListener ptgVideoAdListener = this._a;
                if (ptgVideoAdListener != null) {
                    ptgVideoAdListener.onVideoProgressUpdate(j, j2);
                }
            }

            @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
            public final void onVideoResume() {
                PtgVideoAdListener ptgVideoAdListener = this._a;
                if (ptgVideoAdListener != null) {
                    ptgVideoAdListener.onVideoResume();
                }
            }

            @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
            public final void onVideoStart() {
                PtgVideoAdListener ptgVideoAdListener = this._a;
                if (ptgVideoAdListener != null) {
                    ptgVideoAdListener.onVideoStart();
                }
            }
        }

        public _b(_f _fVar, String str) {
            this._d = _fVar;
            this._e = str;
            this._a = new _ip(_fVar, _k1.this._b._b);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd
        public final void closureInterstitialAd() {
            PtgInteractionPortraitActivity._d _dVar;
            _f _fVar = this._d;
            int i = PtgInteractionPortraitActivity._f;
            if (_fVar == null) {
                return;
            }
            try {
                _fg _fgVar_a = _fg._a();
                String strValueOf = String.valueOf(_fVar.hashCode());
                _fgVar_a.getClass();
                if (TextUtils.isEmpty(strValueOf) || (_dVar = _fgVar_a._f.get(strValueOf)) == null) {
                    return;
                }
                _dVar._a();
            } catch (Exception unused) {
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final void destroy() {
            _fg._a()._a(this._e);
            _k1.this._b._c._b = null;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final _m getAdFilterAdapter() {
            return this._a;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final String getAdId() {
            _p _pVar_a;
            if (TextUtils.isEmpty(this._b) && (_pVar_a = ((_nj) this._a)._a()) != null) {
                this._b = _pVar_a._p;
            }
            return this._b;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd
        public final NativeAdvertData getAdvertData() {
            return _ib._a(7, false, this._d);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final String getConsumer() {
            return PtgApiProvider.providerName;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final long getEcpm() {
            _f _fVar = this._d;
            if (_fVar != null) {
                return _fVar._m;
            }
            return 0L;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final int getInteractionType() {
            return 0;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd
        public final Map<String, Object> getMediaExtraInfo() {
            return Collections.emptyMap();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final boolean isReady() {
            _f _fVar = this._d;
            return _fVar != null && _fVar._t();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final boolean isResourceLoaded() {
            _f _fVar = this._d;
            return _fVar != null && _fVar._J;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final void notifyBidLoss(AdBidLossReason adBidLossReason) {
            if (this._d == null || this._c) {
                return;
            }
            this._c = true;
            _ou _ouVar_a = _ou._a();
            _f _fVar = this._d;
            _m1 _m1Var = _ouVar_a._b;
            if (_m1Var != null) {
                _m1Var._a(_fVar, adBidLossReason);
                return;
            }
            _m1 _m1Var2 = new _m1();
            _ouVar_a._b = _m1Var2;
            _m1Var2._a(_fVar, adBidLossReason);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final void notifyBidWin(double d, double d2) {
            if (this._d == null || this._c) {
                return;
            }
            this._c = true;
            _ou _ouVar_a = _ou._a();
            _f _fVar = this._d;
            AdSlot adSlot = _k1.this._b._b;
            _m1 _m1Var = _ouVar_a._b;
            if (_m1Var != null) {
                _m1Var._b(_fVar);
                return;
            }
            _m1 _m1Var2 = new _m1();
            _ouVar_a._b = _m1Var2;
            _m1Var2._b(_fVar);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final void setAdFilterAdapter(_m _mVar) {
            if (_mVar != null) {
                this._a = _mVar;
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd
        public final void setAdInteractionListener(PtgInteractionAd.AdInteractionListener adInteractionListener) {
            _k1 _k1Var = _k1.this;
            _k1Var._b._c._a = new _k0(_k1Var._a, adInteractionListener);
            _fg _fgVar_a = _fg._a();
            String str = this._e;
            _a _aVar = new _a();
            _fgVar_a.getClass();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (_fgVar_a._d.contains(str)) {
                _fgVar_a._d.remove(str);
            }
            _fgVar_a._d.put(str, _aVar);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd
        public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd
        public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
            _fg _fgVar_a = _fg._a();
            String str = this._e;
            C0368_b c0368_b = new C0368_b(ptgVideoAdListener);
            _fgVar_a.getClass();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (_fgVar_a._e.contains(str)) {
                _fgVar_a._e.remove(str);
            }
            _fgVar_a._e.put(str, c0368_b);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd
        public final void showInteractionAd(Activity activity) {
            String str;
            if (!this._d._t()) {
                PtgInteractionAd.AdInteractionListener adInteractionListener = _k1.this._b._c._a;
                if (adInteractionListener != null) {
                    AdErrorImpl adErrorImpl = new AdErrorImpl();
                    adErrorImpl._c = PtgApiProvider.providerName;
                    adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_5;
                    adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl._b = PtgErrorCode.SDK_RENDER_ERROR_5;
                    adInteractionListener.onRenderError(adErrorImpl);
                    return;
                }
                return;
            }
            _f _fVar = this._d;
            AdSlot adSlot = _k1.this._b._b;
            int i = PtgInteractionPortraitActivity._f;
            com.fancy.mpsdk.activity._a _aVar = new com.fancy.mpsdk.activity._a(activity, _fVar, adSlot);
            try {
                if (_fVar == null) {
                    if (_fVar != null) {
                        _fg._a()._a(String.valueOf(_fVar.hashCode()), "资源对象为空!");
                        _fg._a()._a(String.valueOf(_fVar.hashCode()));
                        return;
                    }
                    return;
                }
                if (_fVar._u()) {
                    _l3 _l3Var_m = _fVar._m();
                    str = TextUtil.isNotEmpty(_l3Var_m._b) ? _l3Var_m._b : _l3Var_m._a;
                } else {
                    List<_jz> list_h = _fVar._h();
                    str = (list_h == null || list_h.isEmpty()) ? "" : list_h.get(0)._a;
                }
                com.fancy.mpsdk.activity._b _bVar = new com.fancy.mpsdk.activity._b(_fVar, _aVar);
                AtomicBoolean atomicBoolean = _ev._a;
                if (TextUtil.isEmpty(str)) {
                    return;
                }
                com.fancy.adsdk.lib.utils._d._b(new _ex(str, _bVar));
            } catch (Exception e) {
                String string = _ie._a("资源加载异常: ").append(e.getMessage()).toString();
                if (_aVar._b != null) {
                    _fg._a()._a(String.valueOf(_aVar._b.hashCode()), string);
                    _fg._a()._a(String.valueOf(_aVar._b.hashCode()));
                }
            }
        }
    }

    public _k1(_k2 _k2Var, _r _rVar) {
        this._b = _k2Var;
        this._a = _rVar;
    }

    public final void _a(_f _fVar, String str) {
        try {
            this._b._b._c(_fVar._m);
            try {
                _fVar._x = com.fancy.adsdk.lib.utils._a._a(String.valueOf(_fVar._m), _oi._a());
            } catch (Exception unused) {
                _fVar._x = "";
            }
            _ci _ciVar_i = this._b._b._i();
            if (_ciVar_i != null) {
                _ciVar_i._T = _fVar._l;
            }
            this._b._a.onInteractionAdLoad(new _b(_fVar, str));
        } catch (Exception unused2) {
            PtgAdNative.InteractionExpressAdListener interactionExpressAdListener = this._b._a;
            if (interactionExpressAdListener != null) {
                interactionExpressAdListener.onError(new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
            }
            this._b._c._b = null;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<_f> list;
        _r _rVar = this._a;
        List<_f> list2 = (_rVar == null || (list = _rVar._a) == null || list.isEmpty()) ? null : this._a._a;
        if (list2 == null) {
            this._b._a.onError(new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
            return;
        }
        _f _fVar = list2.get(0);
        String strValueOf = String.valueOf(_fVar.hashCode());
        if (!_a9._a()) {
            _a(_fVar, strValueOf);
            return;
        }
        try {
            this._b._c._b = new ArbitraryAdapter();
            _k2 _k2Var = this._b;
            _k2Var._c._b.setSts(_k2Var._b._q());
            _k2 _k2Var2 = this._b;
            _k2Var2._c._b.setKey(_k2Var2._b._d());
            this._b._c._b.setReqId(_fVar._w);
            ArbitraryAdapter arbitraryAdapter = this._b._c._b;
            _l _lVar = _fVar._q;
            arbitraryAdapter.setAdLoaded(_lVar != null ? _lVar._a : 0L, _fVar._m, _lVar != null ? _lVar._c : 0L, _lVar != null ? _lVar._b : 0L);
            this._b._c._b.setAdLoadCallback(new _a(_fVar, strValueOf));
        } catch (Exception unused) {
            PtgAdNative.InteractionExpressAdListener interactionExpressAdListener = this._b._a;
            if (interactionExpressAdListener != null) {
                interactionExpressAdListener.onError(new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
            }
        }
    }
}
