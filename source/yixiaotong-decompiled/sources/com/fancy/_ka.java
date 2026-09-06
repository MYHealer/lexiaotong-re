package com.fancy;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.NativeAdvertData;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.provider.arb.ArbitraryAdapter;
import com.fancy.mpsdk.provider.PtgApiProvider;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ka implements Runnable {
    public final /* synthetic */ _r _a;
    public final /* synthetic */ _kb _b;

    public class _a implements _ef {
        public final /* synthetic */ _f _a;

        public _a(_f _fVar) {
            this._a = _fVar;
        }

        @Override // com.fancy._ef
        public final void _a(long j) {
            _f _fVar = this._a;
            _fVar._m = (int) j;
            _ka.this._a(_fVar);
        }
    }

    public class _b implements PtgNativeExpressAd {
        public _m _a;
        public String _b;
        public boolean _c = false;
        public boolean _d = false;
        public final /* synthetic */ _f _e;
        public final /* synthetic */ _kd _f;

        public class _a implements PtgNativeExpressAd.AdInteractionListener {
            public final /* synthetic */ PtgNativeExpressAd.AdInteractionListener _a;

            public _a(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
                this._a = adInteractionListener;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onAdClicked() {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdClicked();
                }
            }

            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onAdDismiss() {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdDismiss();
                }
                _ka.this._b._d._b = null;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onAdShow() {
                _b _bVar = _b.this;
                _f _fVar = _bVar._e;
                if (_fVar != null) {
                    _fVar._A = true;
                }
                if (_fVar._q != null && _ka.this._b._b._t() != null) {
                    _or _orVar = _ka.this._b._b._t()._t;
                    String str = _b.this._e._q._d;
                    _orVar.getClass();
                    try {
                        synchronized (_orVar._a) {
                            _orVar._a.put("enBidPrice", str);
                        }
                    } catch (Exception unused) {
                    }
                }
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdShow();
                }
                _b _bVar2 = _b.this;
                if (!_bVar2._c) {
                    _bVar2._c = true;
                    _ou _ouVar_a = _ou._a();
                    _b _bVar3 = _b.this;
                    _f _fVar2 = _bVar3._e;
                    AdSlot adSlot = _ka.this._b._b;
                    _m1 _m1Var = _ouVar_a._b;
                    if (_m1Var != null) {
                        _m1Var._a(_fVar2);
                    } else {
                        _m1 _m1Var2 = new _m1();
                        _ouVar_a._b = _m1Var2;
                        _m1Var2._a(_fVar2);
                    }
                }
                _ka.this._b._d._b = null;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onRenderFail(AdError adError) {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onRenderFail(adError);
                }
                _ka.this._b._d._b = null;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onRenderSuccess(View view) {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onRenderSuccess(view);
                }
            }
        }

        public _b(_f _fVar, _kd _kdVar) {
            this._e = _fVar;
            this._f = _kdVar;
            this._a = new _ip(_fVar, _ka.this._b._b);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd, com.fancy.adsdk.lib.interf.PtgAd
        public final void destroy() {
            this._f.destroy();
            _kc _kcVar = _ka.this._b._d;
            _kcVar._a = null;
            _kcVar._b = null;
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

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final NativeAdvertData getAdvertData() {
            return _ib._a(8, isSelfRender(), this._e);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final String getConsumer() {
            return PtgApiProvider.providerName;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final PtgNativeExpressAd.CustomizeVideo getCustomizeVideo() {
            return this._f.getCustomizeVideo();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final long getEcpm() {
            _f _fVar = this._e;
            if (_fVar != null) {
                return _fVar._m;
            }
            return 0L;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final View getExpressAdView() {
            return this._f.getExpressAdView();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final List<Object> getFilterWords() {
            this._f.getClass();
            return null;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final int getImageMode() {
            _f _fVar = this._e;
            if (_fVar == null) {
                return -1;
            }
            try {
                return Integer.parseInt(_fVar._k());
            } catch (Exception unused) {
                return 0;
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final int getInteractionType() {
            _f _fVar = this._e;
            if (_fVar == null) {
                return -1;
            }
            int i = _fVar._a;
            if (i == 0) {
                return 0;
            }
            if (i != 1) {
                return i != 2 ? -1 : 3;
            }
            return 1;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final Map<String, Object> getMediaExtraInfo() {
            this._f.getClass();
            return null;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final View getMediaView() {
            return this._f.getMediaView();
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

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final boolean isSelfRender() {
            return this._f._a.isSelfRender();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final boolean isVideo() {
            return this._f.isVideo();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final void notifyBidLoss(AdBidLossReason adBidLossReason) {
            if (this._e == null || this._d) {
                return;
            }
            this._d = true;
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
            if (this._e == null || this._d) {
                return;
            }
            this._d = true;
            _ou _ouVar_a = _ou._a();
            _f _fVar = this._e;
            AdSlot adSlot = _ka.this._b._b;
            _m1 _m1Var = _ouVar_a._b;
            if (_m1Var != null) {
                _m1Var._b(_fVar);
                return;
            }
            _m1 _m1Var2 = new _m1();
            _ouVar_a._b = _m1Var2;
            _m1Var2._b(_fVar);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void pauseVideo() {
            this._f.pauseVideo();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void registerAdvertViews(ViewGroup viewGroup, List<View> list, List<View> list2, View view) {
            this._f.registerAdvertViews(viewGroup, list, list2, view);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void render() {
            _f _fVar = this._e;
            if (_fVar != null && !_fVar._t()) {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = _ka.this._b._d._a;
                if (adInteractionListener != null) {
                    AdErrorImpl adErrorImpl = new AdErrorImpl();
                    adErrorImpl._c = PtgApiProvider.providerName;
                    adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_5;
                    adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl._b = PtgErrorCode.SDK_RENDER_ERROR_5;
                    adInteractionListener.onRenderFail(adErrorImpl);
                    return;
                }
                return;
            }
            _kd _kdVar = this._f;
            _f _fVar2 = this._e;
            _kdVar._b = _fVar2;
            if (_kdVar._a.isSelfRender()) {
                _dm _dmVar = _kdVar._d;
                if (_dmVar != null) {
                    _dmVar._c = _fVar2;
                }
            } else {
                _do _doVar = _kdVar._e;
                if (_doVar != null) {
                    _doVar.setAdvertInfo(_fVar2);
                }
            }
            this._f.render();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final void setAdFilterAdapter(_m _mVar) {
            if (_mVar != null) {
                this._a = _mVar;
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void setCanInterruptVideoPlay(boolean z) {
            this._f.getClass();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
            this._f.getClass();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void setExpressInteractionListener(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
            _ka.this._b._d._a = adInteractionListener;
            this._f.setExpressInteractionListener(new _a(adInteractionListener));
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void setExpressViewColor(String str) {
            this._f.setExpressViewColor(str);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void setSlideIntervalTime(int i) {
            this._f.getClass();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
            this._f.setVideoAdListener(ptgVideoAdListener);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void showInteractionExpressAd(Activity activity) {
            this._f.getClass();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void startVideo() {
            this._f.startVideo();
        }
    }

    public _ka(_kb _kbVar, _r _rVar) {
        this._b = _kbVar;
        this._a = _rVar;
    }

    public final void _a(_f _fVar) {
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
            _kb _kbVar = this._b;
            _b _bVar = new _b(_fVar, new _kd(_kbVar._c, _fVar, _kbVar._b));
            PtgAdNative.NativeExpressAdListener nativeExpressAdListener = this._b._a;
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onNativeExpressAdLoad(_bVar);
            }
        } catch (Exception unused2) {
            PtgAdNative.NativeExpressAdListener nativeExpressAdListener2 = this._b._a;
            if (nativeExpressAdListener2 != null) {
                _c4._a(10001, AdError.ERROR_NO_AD_STR, null, nativeExpressAdListener2);
            }
            this._b._d._b = null;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<_f> list = this._a._a;
        if (list == null || list.isEmpty()) {
            _c4._a(10001, AdError.ERROR_NO_AD_STR, null, this._b._a);
            return;
        }
        _f _fVar = list.get(0);
        if (!_a9._a()) {
            _a(_fVar);
            return;
        }
        try {
            this._b._d._b = new ArbitraryAdapter();
            _kb _kbVar = this._b;
            _kbVar._d._b.setSts(_kbVar._b._q());
            _kb _kbVar2 = this._b;
            _kbVar2._d._b.setKey(_kbVar2._b._d());
            this._b._d._b.setReqId(_fVar._w);
            ArbitraryAdapter arbitraryAdapter = this._b._d._b;
            _l _lVar = _fVar._q;
            arbitraryAdapter.setAdLoaded(_lVar != null ? _lVar._a : 0L, _fVar._m, _lVar != null ? _lVar._c : 0L, _lVar != null ? _lVar._b : 0L);
            this._b._d._b.setAdLoadCallback(new _a(_fVar));
        } catch (Exception unused) {
            PtgAdNative.NativeExpressAdListener nativeExpressAdListener = this._b._a;
            if (nativeExpressAdListener != null) {
                _c4._a(10001, AdError.ERROR_NO_AD_STR, null, nativeExpressAdListener);
            }
        }
    }
}
