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
public final class _ir implements Runnable {
    public final /* synthetic */ _r _a;
    public final /* synthetic */ _is _b;

    public class _a implements _ef {
        public final /* synthetic */ _f _a;

        public _a(_f _fVar) {
            this._a = _fVar;
        }

        @Override // com.fancy._ef
        public final void _a(long j) {
            _f _fVar = this._a;
            _fVar._m = (int) j;
            _ir.this._a(_fVar);
        }
    }

    public class _b implements PtgNativeExpressAd {
        public boolean _a = false;
        public boolean _b = false;
        public _m _c;
        public String _d;
        public final /* synthetic */ _f _e;
        public final /* synthetic */ _kd _f;

        public class _a implements PtgNativeExpressAd.AdInteractionListener {
            public final /* synthetic */ PtgNativeExpressAd.AdInteractionListener _a;

            public _a(_k9 _k9Var) {
                this._a = _k9Var;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onAdClicked() {
                this._a.onAdClicked();
            }

            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onAdDismiss() {
                this._a.onAdDismiss();
                _ir.this._b._d._b = null;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onAdShow() {
                _b _bVar = _b.this;
                _f _fVar = _bVar._e;
                _fVar._A = true;
                if (_fVar._q != null && _ir.this._b._b._t() != null) {
                    _or _orVar = _ir.this._b._b._t()._t;
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
                    AdSlot adSlot = _ir.this._b._b;
                    _m1 _m1Var = _ouVar_a._b;
                    if (_m1Var != null) {
                        _m1Var._a(_fVar2);
                    } else {
                        _m1 _m1Var2 = new _m1();
                        _ouVar_a._b = _m1Var2;
                        _m1Var2._a(_fVar2);
                    }
                }
                _ir.this._b._d._b = null;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onRenderFail(AdError adError) {
                this._a.onRenderFail(adError);
                _ir.this._b._d._b = null;
            }

            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public final void onRenderSuccess(View view) {
                this._a.onRenderSuccess(view);
            }
        }

        public _b(_f _fVar, _kd _kdVar) {
            this._e = _fVar;
            this._f = _kdVar;
            this._c = new _ip(_fVar, _ir.this._b._b);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd, com.fancy.adsdk.lib.interf.PtgAd
        public final void destroy() {
            _kd _kdVar = this._f;
            if (_kdVar != null) {
                _kdVar.destroy();
            }
            _ir.this._b._d._b = null;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final _m getAdFilterAdapter() {
            return this._c;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final String getAdId() {
            _os _osVar_t;
            if (TextUtils.isEmpty(this._d) && (_osVar_t = _ir.this._b._b._t()) != null) {
                this._d = _osVar_t._h;
            }
            return this._d;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final NativeAdvertData getAdvertData() {
            return _ib._a(5, isSelfRender(), this._e);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final String getConsumer() {
            return PtgApiProvider.providerName;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final PtgNativeExpressAd.CustomizeVideo getCustomizeVideo() {
            return null;
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
            return null;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final int getImageMode() {
            return 0;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final int getInteractionType() {
            return this._f.getInteractionType();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final Map<String, Object> getMediaExtraInfo() {
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
            return false;
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
            AdSlot adSlot = _ir.this._b._b;
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
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void registerAdvertViews(ViewGroup viewGroup, List<View> list, List<View> list2, View view) {
            this._f.registerAdvertViews(viewGroup, list, list2, view);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void render() {
            if (!this._e._t()) {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = _ir.this._b._d._a;
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
            if (_ir.this._b._b.isSelfRender()) {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener2 = _ir.this._b._d._a;
                if (adInteractionListener2 != null) {
                    adInteractionListener2.onRenderFail(new AdErrorImpl(PtgErrorCode.SDK_RENDER_ERROR, "selfRender 非法，请联系相关人员处理", (Object) null));
                    return;
                }
                return;
            }
            _kd _kdVar = this._f;
            _f _fVar = this._e;
            _kdVar._b = _fVar;
            if (_kdVar._a.isSelfRender()) {
                _dm _dmVar = _kdVar._d;
                if (_dmVar != null) {
                    _dmVar._c = _fVar;
                }
            } else {
                _do _doVar = _kdVar._e;
                if (_doVar != null) {
                    _doVar.setAdvertInfo(_fVar);
                }
            }
            this._f.render();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAd
        public final void setAdFilterAdapter(_m _mVar) {
            if (_mVar != null) {
                this._c = _mVar;
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void setCanInterruptVideoPlay(boolean z) {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
            this._f.getClass();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void setExpressInteractionListener(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
            _ir _irVar = _ir.this;
            _irVar._b._d._a = adInteractionListener;
            this._f.setExpressInteractionListener(new _a(new _k9(_irVar._a, adInteractionListener)));
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void setExpressViewColor(String str) {
            this._f.setExpressViewColor(str);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void setSlideIntervalTime(int i) {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void showInteractionExpressAd(Activity activity) {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
        public final void startVideo() {
        }
    }

    public _ir(_is _isVar, _r _rVar) {
        this._b = _isVar;
        this._a = _rVar;
    }

    public final void _a(_f _fVar) {
        try {
            _fVar.getClass();
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
            _is _isVar = this._b;
            _kd _kdVar = new _kd(_isVar._c, _fVar, _isVar._b);
            _b _bVar = new _b(_fVar, _kdVar);
            AdSlot adSlot = this._b._b;
            _kdVar._a = adSlot;
            if (adSlot.isSelfRender()) {
                _dm _dmVar = _kdVar._d;
                if (_dmVar != null) {
                    _dmVar._b = adSlot;
                }
            } else {
                _do _doVar = _kdVar._e;
                if (_doVar != null) {
                    _doVar.setAdvertSlot(adSlot);
                }
            }
            this._b._a.onNativeExpressAdLoad(_bVar);
        } catch (Exception unused2) {
            PtgAdNative.NativeExpressAdListener nativeExpressAdListener = this._b._a;
            if (nativeExpressAdListener != null) {
                _c4._a(10001, AdError.ERROR_NO_AD_STR, null, nativeExpressAdListener);
            }
            this._b._d._b = null;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<_f> list;
        _r _rVar = this._a;
        List<_f> list2 = (_rVar == null || (list = _rVar._a) == null || list.isEmpty()) ? null : this._a._a;
        if (list2 == null) {
            _c4._a(10001, AdError.ERROR_NO_AD_STR, null, this._b._a);
            return;
        }
        _f _fVar = list2.get(0);
        if (!_a9._a()) {
            _a(_fVar);
            return;
        }
        try {
            this._b._d._b = new ArbitraryAdapter();
            _is _isVar = this._b;
            _isVar._d._b.setSts(_isVar._b._q());
            _is _isVar2 = this._b;
            _isVar2._d._b.setKey(_isVar2._b._d());
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
