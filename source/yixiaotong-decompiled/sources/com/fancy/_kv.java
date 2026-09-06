package com.fancy;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.NativeAdvertData;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.provider.arb.ArbitraryAdapter;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.mpsdk.provider.PtgApiProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _kv implements Runnable {
    public final /* synthetic */ _r _a;
    public final /* synthetic */ _kw _b;

    public class _a implements _ef {
        public final /* synthetic */ _f _a;
        public final /* synthetic */ List _b;

        public _a(_f _fVar, ArrayList arrayList) {
            this._a = _fVar;
            this._b = arrayList;
        }

        @Override // com.fancy._ef
        public final void _a(long j) {
            _f _fVar = this._a;
            _fVar._m = (int) j;
            _kv.this._a(_fVar, this._b);
        }
    }

    public class _b implements PtgSplashAd {
        public boolean _a = false;
        public boolean _b = false;
        public _m _c;
        public String _d;
        public final /* synthetic */ _f _e;
        public final /* synthetic */ _ky _f;
        public final /* synthetic */ List _g;

        public class _a implements PtgSplashAd.AdInteractionListener {
            public final /* synthetic */ PtgSplashAd.AdInteractionListener _a;

            public _a(_ku _kuVar) {
                this._a = _kuVar;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdClicked() {
                Logger.d("PtgSplashAdManager", "onAdClicked ad on click");
                this._a.onAdClicked();
            }

            @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdShow() {
                Logger.d("PtgSplashAdManager", "onAdShow ad on show");
                _b _bVar = _b.this;
                _f _fVar = _bVar._e;
                _fVar._A = true;
                if (_fVar._q != null && _kv.this._b._b._t() != null) {
                    _or _orVar = _kv.this._b._b._t()._t;
                    String str = _b.this._e._q._d;
                    _orVar.getClass();
                    try {
                        synchronized (_orVar._a) {
                            _orVar._a.put("enBidPrice", str);
                        }
                    } catch (Exception unused) {
                    }
                }
                this._a.onAdShow();
                _b _bVar2 = _b.this;
                if (!_bVar2._a) {
                    _bVar2._a = true;
                    _ou _ouVar_a = _ou._a();
                    _b _bVar3 = _b.this;
                    _f _fVar2 = _bVar3._e;
                    AdSlot adSlot = _kv.this._b._b;
                    _m1 _m1Var = _ouVar_a._b;
                    if (_m1Var != null) {
                        _m1Var._a(_fVar2);
                    } else {
                        _m1 _m1Var2 = new _m1();
                        _ouVar_a._b = _m1Var2;
                        _m1Var2._a(_fVar2);
                    }
                }
                _kv.this._b._d._a = null;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdSkip() {
                Logger.d("PtgSplashAdManager", "onAdSkip ad on skip");
                this._a.onAdSkip();
            }

            @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onAdTimeOver() {
                Logger.d("PtgSplashAdManager", "onAdTimeOver ad on timeOver");
                this._a.onAdTimeOver();
            }

            @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onDismiss(int i) {
                Logger.d("PtgSplashAdManager", "onDismiss ad on onDismiss 关闭类型=" + i);
                this._a.onDismiss(i);
                _kv.this._b._d._a = null;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onRenderError(AdError adError) {
                Logger.d("PtgSplashAdManager", "onRenderError ad on RenderError");
                this._a.onRenderError(adError);
                _kv.this._b._d._a = null;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
            public final void onRenderSuccess() {
                Logger.d("PtgSplashAdManager", "onAdTimeOver ad onRenderSuccess");
                this._a.onRenderSuccess();
            }
        }

        public _b(_f _fVar, _ky _kyVar, List list) {
            this._e = _fVar;
            this._f = _kyVar;
            this._g = list;
            this._c = new _ip(_fVar, _kv.this._b._b);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final void destroy() {
            _nx _nxVar = this._f._a;
            if (_nxVar != null) {
                _nxVar._a();
            }
            _kv.this._b._d._a = null;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final _m getAdFilterAdapter() {
            return this._c;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final String getAdId() {
            _p _pVar_a;
            if (TextUtils.isEmpty(this._d) && (_pVar_a = ((_nj) this._c)._a()) != null) {
                this._d = _pVar_a._p;
            }
            return this._d;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
        public final NativeAdvertData getAdvertData() {
            return this._f.getAdvertData();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final String getConsumer() {
            return PtgApiProvider.providerName;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final long getEcpm() {
            _f _fVar = this._e;
            if (_fVar != null) {
                return _fVar._m;
            }
            return 0L;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final int getInteractionType() {
            this._f._a(this._g);
            return this._f.getInteractionType();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final boolean isReady() {
            _f _fVar = this._e;
            return _fVar != null && _fVar._t();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final boolean isResourceLoaded() {
            _f _fVar = this._e;
            return _fVar != null && _fVar._J;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
        public final void load() {
            if (_kv.this._b._b._a() != null) {
                _kv.this._b._b._a().removeAllViews();
                _nx _nxVar = this._f._a;
                if (_nxVar == null || _nxVar.getParent() != null) {
                    return;
                }
                ViewGroup viewGroup_s = _kv.this._b._b._s();
                if (viewGroup_s == null || viewGroup_s.getParent() == null) {
                    viewGroup_s = _kv.this._b._b._a();
                }
                if (viewGroup_s != null) {
                    viewGroup_s.addView(this._f._a);
                }
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final void notifyBidLoss(AdBidLossReason adBidLossReason) {
            if (this._e == null || this._b) {
                return;
            }
            this._b = true;
            _ou _ouVar_a = _ou._a();
            _f _fVar = this._e;
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
            if (this._e == null || this._b) {
                return;
            }
            this._b = true;
            _ou _ouVar_a = _ou._a();
            _f _fVar = this._e;
            AdSlot adSlot = _kv.this._b._b;
            _m1 _m1Var = _ouVar_a._b;
            if (_m1Var != null) {
                _m1Var._b(_fVar);
                return;
            }
            _m1 _m1Var2 = new _m1();
            _ouVar_a._b = _m1Var2;
            _m1Var2._b(_fVar);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
        public final void preload() {
            this._f.preload();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final void setAdFilterAdapter(_m _mVar) {
            if (_mVar != null) {
                this._c = _mVar;
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
        public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
            this._f.setDownloadListener(ptgAppDownloadListener);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
        public final void setSplashInteractionListener(PtgSplashAd.AdInteractionListener adInteractionListener) {
            this._f.setSplashInteractionListener(new _a(new _ku(_kv.this._a, adInteractionListener)));
        }

        @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
        public final void showAd(ViewGroup viewGroup) {
            if (_kv.this._b._b._a() != null) {
                Logger.e("SplashView showAd fail, slot already exists container.");
            } else if (viewGroup != null) {
                this._f._a(this._g);
                this._f.showAd(viewGroup);
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
        public final void showAd(ViewGroup viewGroup, Activity activity) {
            if (_kv.this._b._b._a() != null) {
                Logger.e("SplashView showAd fail, slot already exists container.");
            } else if (viewGroup != null) {
                this._f._a(this._g);
                this._f.showAd(viewGroup, activity);
            }
        }
    }

    public _kv(_kw _kwVar, _r _rVar) {
        this._b = _kwVar;
        this._a = _rVar;
    }

    public final void _a(_f _fVar, List<_f> list) {
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
            _kw _kwVar = this._b;
            _ky _kyVar = new _ky(_kwVar._c, _kwVar._a);
            _kyVar._b = _fVar;
            _nx _nxVar = _kyVar._a;
            if (_nxVar != null) {
                _nxVar.setAdvertInfo(_fVar);
            }
            AdSlot adSlot = this._b._b;
            _kyVar._c = adSlot;
            _nx _nxVar2 = _kyVar._a;
            if (_nxVar2 != null) {
                _nxVar2.setAdSlot(adSlot);
            }
            _b _bVar = new _b(_fVar, _kyVar, list);
            PtgAdNative.SplashAdListener splashAdListener = this._b._a;
            if (splashAdListener != null) {
                splashAdListener.onSplashAdLoad(_bVar);
            }
            _kw _kwVar2 = this._b;
            _kx _kxVar = _kwVar2._d;
            AdSlot adSlot2 = _kwVar2._b;
            _kxVar.getClass();
            if (adSlot2._a() != null) {
                ViewGroup viewGroup_a = adSlot2._a();
                if (viewGroup_a.getParent() != null) {
                    _kyVar._a(list);
                    viewGroup_a.removeAllViews();
                    viewGroup_a.addView(_kyVar._a);
                }
            }
        } catch (Exception unused2) {
            PtgAdNative.SplashAdListener splashAdListener2 = this._b._a;
            if (splashAdListener2 != null) {
                splashAdListener2.onError(new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
            }
            this._b._d._a = null;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<_f> list;
        ArrayList arrayList = new ArrayList();
        _r _rVar = this._a;
        if (_rVar != null && (list = _rVar._a) != null && !list.isEmpty()) {
            arrayList.addAll(this._a._a);
        }
        if (arrayList.isEmpty()) {
            PtgAdNative.SplashAdListener splashAdListener = this._b._a;
            if (splashAdListener != null) {
                splashAdListener.onError(new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
                return;
            }
            return;
        }
        _f _fVar = (_f) arrayList.get(0);
        if (!_a9._a()) {
            _a(_fVar, arrayList);
            return;
        }
        try {
            this._b._d._a = new ArbitraryAdapter();
            _kw _kwVar = this._b;
            _kwVar._d._a.setSts(_kwVar._b._q());
            _kw _kwVar2 = this._b;
            _kwVar2._d._a.setKey(_kwVar2._b._d());
            this._b._d._a.setReqId(_fVar._w);
            ArbitraryAdapter arbitraryAdapter = this._b._d._a;
            _l _lVar = _fVar._q;
            arbitraryAdapter.setAdLoaded(_lVar != null ? _lVar._a : 0L, _fVar._m, _lVar != null ? _lVar._c : 0L, _lVar != null ? _lVar._b : 0L);
            this._b._d._a.setAdLoadCallback(new _a(_fVar, arrayList));
        } catch (Exception unused) {
            PtgAdNative.SplashAdListener splashAdListener2 = this._b._a;
            if (splashAdListener2 != null) {
                splashAdListener2.onError(new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
            }
        }
    }
}
