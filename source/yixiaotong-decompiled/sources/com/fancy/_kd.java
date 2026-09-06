package com.fancy;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fancy.adsdk.lib.constants.AdConstant;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.NativeAdvertData;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.mpsdk.provider.PtgApiProvider;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _kd implements PtgNativeExpressAd {
    public AdSlot _a;
    public _f _b;
    public PtgNativeExpressAd.AdInteractionListener _c;
    public _dm _d;
    public _do _e;

    public _kd(Context context, _f _fVar, AdSlot adSlot) {
        _a(context, _fVar, adSlot);
    }

    public final void _a(Context context, _f _fVar, AdSlot adSlot) {
        this._a = adSlot;
        this._b = _fVar;
        if (adSlot.isSelfRender()) {
            this._d = new _dm(context, _fVar, adSlot);
            return;
        }
        _do _doVar = new _do(context);
        this._e = _doVar;
        _doVar.setAdvertSlot(adSlot);
        this._e.setAdvertInfo(_fVar);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd, com.fancy.adsdk.lib.interf.PtgAd
    public final void destroy() {
        _do _doVar = this._e;
        if (_doVar != null) {
            _doVar._e();
        }
        _dm _dmVar = this._d;
        if (_dmVar != null) {
            _dmVar._a();
            this._d = null;
        }
        if (this._c != null) {
            this._c = null;
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final _m getAdFilterAdapter() {
        return null;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final String getAdId() {
        return null;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final NativeAdvertData getAdvertData() {
        return null;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final String getConsumer() {
        return PtgApiProvider.providerName;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final PtgNativeExpressAd.CustomizeVideo getCustomizeVideo() {
        _dm _dmVar;
        _en _enVar;
        if (!this._a.isSelfRender() || (_dmVar = this._d) == null || (_enVar = _dmVar._h) == null) {
            return null;
        }
        return _enVar.getCustomizeVideo();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final long getEcpm() {
        _f _fVar = this._b;
        if (_fVar != null) {
            return _fVar._m;
        }
        return 0L;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final View getExpressAdView() {
        if (this._a.isSelfRender()) {
            _dm _dmVar = this._d;
            if (_dmVar != null) {
                return _dmVar._d;
            }
            return null;
        }
        _do _doVar = this._e;
        if (_doVar != null) {
            return _doVar;
        }
        return null;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final List<Object> getFilterWords() {
        return null;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final int getImageMode() {
        _f _fVar = this._b;
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
        _f _fVar = this._b;
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
        return null;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final View getMediaView() {
        _dm _dmVar;
        _en _enVar;
        if (!this._a.isSelfRender() || (_dmVar = this._d) == null || (_enVar = _dmVar._h) == null) {
            return null;
        }
        return _enVar._c();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final boolean isReady() {
        _f _fVar = this._b;
        return _fVar != null && _fVar._t();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final boolean isResourceLoaded() {
        _f _fVar = this._b;
        return _fVar != null && _fVar._J;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final boolean isSelfRender() {
        return this._a.isSelfRender();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final boolean isVideo() {
        _dm _dmVar;
        _f _fVar;
        return this._a.isSelfRender() && (_dmVar = this._d) != null && (_fVar = _dmVar._c) != null && _fVar._u();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void notifyBidLoss(AdBidLossReason adBidLossReason) {
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void notifyBidWin(double d, double d2) {
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void pauseVideo() {
        _dm _dmVar;
        _en _enVar;
        if (!this._a.isSelfRender() || (_dmVar = this._d) == null || (_enVar = _dmVar._h) == null) {
            return;
        }
        _enVar.pauseVideo();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void registerAdvertViews(ViewGroup viewGroup, List<View> list, List<View> list2, View view) {
        AdSlot adSlot = this._a;
        if (adSlot != null && !adSlot.isSelfRender()) {
            PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._c;
            if (adInteractionListener != null) {
                AdErrorImpl adErrorImpl = new AdErrorImpl();
                adErrorImpl._c = PtgApiProvider.providerName;
                adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._e = "请使用模板渲染！或配置为自渲染";
                adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._b = "请使用模板渲染！或配置为自渲染";
                adInteractionListener.onRenderFail(adErrorImpl);
                return;
            }
            return;
        }
        _dm _dmVar = this._d;
        if (_dmVar != null) {
            if (viewGroup == null) {
                throw new IllegalArgumentException("container不能为null");
            }
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("clickView不能为null");
            }
            AdSlot adSlot2 = _dmVar._b;
            if (adSlot2 != null && !adSlot2.isSelfRender()) {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener2 = _dmVar._a;
                if (adInteractionListener2 != null) {
                    AdErrorImpl adErrorImpl2 = new AdErrorImpl();
                    adErrorImpl2._c = PtgApiProvider.providerName;
                    adErrorImpl2._d = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl2._e = "请使用模板渲染！或配置为自渲染";
                    adErrorImpl2._a = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl2._b = "请使用模板渲染！或配置为自渲染";
                    adInteractionListener2.onRenderFail(adErrorImpl2);
                    return;
                }
                return;
            }
            _dmVar._d = viewGroup;
            _dmVar._e = list;
            _dmVar._f = list2;
            _dmVar._g = view;
            _gq _gqVar = _dmVar._i;
            if (_gqVar != null) {
                _gqVar._g = viewGroup;
                _gqVar._h = list;
                _gqVar._c();
            }
            View view2 = _dmVar._g;
            if (view2 != null) {
                view2.setOnClickListener(new _dl(_dmVar));
            }
            _en _enVar = _dmVar._h;
            if (_enVar != null) {
                _enVar._a(_dmVar._d);
                _dmVar._h._a(new _dj(_dmVar));
                _dmVar._h._b();
            }
            _fv._a.post(new _dk(_dmVar));
        }
    }

    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0112  */
    /* JADX WARN: Code duplicated, block: B:90:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:92:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:95:0x01df  */
    /* JADX WARN: Code duplicated, block: B:97:0x021b  */
    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void render() {
        AdErrorImpl adErrorImpl;
        PtgNativeExpressAd.AdInteractionListener adInteractionListener;
        _aq _ahVar;
        ViewGroup.LayoutParams layoutParams;
        _do._a _aVar;
        _f _fVar = this._b;
        if (_fVar == null) {
            return;
        }
        if (!_fVar._t()) {
            PtgNativeExpressAd.AdInteractionListener adInteractionListener2 = this._c;
            if (adInteractionListener2 != null) {
                AdErrorImpl adErrorImpl2 = new AdErrorImpl();
                adErrorImpl2._c = PtgApiProvider.providerName;
                adErrorImpl2._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl2._e = PtgErrorCode.SDK_RENDER_ERROR_5;
                adErrorImpl2._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl2._b = PtgErrorCode.SDK_RENDER_ERROR_5;
                adInteractionListener2.onRenderFail(adErrorImpl2);
                return;
            }
            return;
        }
        if (this._a.isSelfRender()) {
            _dm _dmVar = this._d;
            if (_dmVar != null) {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener3 = this._c;
                _dmVar._a = adInteractionListener3;
                _en _enVar = _dmVar._h;
                if (_enVar != null) {
                    _enVar._a(adInteractionListener3);
                }
                _gq _gqVar = _dmVar._i;
                if (_gqVar != null) {
                    _gqVar._e = adInteractionListener3;
                }
                this._d.getClass();
                return;
            }
            return;
        }
        _do _doVar = this._e;
        if (_doVar != null) {
            _doVar.setExpressInteractionListener(this._c);
            _do _doVar2 = this._e;
            _f _fVar2 = _doVar2._c;
            if (_fVar2 == null) {
                _do._a _aVar2 = _doVar2._R;
                if (_aVar2 == null) {
                    return;
                }
                adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_RENDER_ERROR, PtgErrorCode.SDK_RENDER_ERROR_6, (Object) null);
                adErrorImpl._c = PtgApiProvider.providerName;
                adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_6;
                adInteractionListener = _do.this._a;
                if (adInteractionListener == null) {
                    return;
                }
            } else {
                int i = _fVar2._B;
                ConcurrentHashMap<String, Long> concurrentHashMap = _io._a;
                float f = 0.66f;
                if (i == 8) {
                    String str_k = _fVar2._k();
                    if (TextUtils.isEmpty(str_k)) {
                        _ahVar = null;
                    } else {
                        if (AdConstant.NATIVE_TYPE.TOP_TEXT.equals(str_k)) {
                            _ahVar = new _gv(_doVar2.getContext());
                        } else if (AdConstant.NATIVE_TYPE.TOP_IMAGE.equals(str_k)) {
                            _ahVar = new _gu(_doVar2.getContext());
                        } else if (AdConstant.NATIVE_TYPE.TEXT_FLOAT.equals(str_k)) {
                            _ahVar = new _gs(_doVar2.getContext());
                        } else {
                            if (AdConstant.NATIVE_TYPE.LEFT_IMAGE.equals(str_k)) {
                                _ahVar = new _go(_doVar2.getContext());
                            } else if (AdConstant.NATIVE_TYPE.LEFT_TEXT.equals(str_k)) {
                                _ahVar = new _gp(_doVar2.getContext());
                            } else if (AdConstant.NATIVE_TYPE.THREE_IMAGES.equals(str_k)) {
                                _ahVar = new _gt(_doVar2.getContext());
                            } else {
                                _ahVar = null;
                            }
                            _ahVar.setNativeRatio(0.66f);
                        }
                        _ahVar.setNativeRatio(0.55f);
                    }
                    _doVar2._J = _ahVar;
                    if (_ahVar == null) {
                        _doVar2._K = true;
                        _doVar2._J.setVideoProgressListener(_doVar2._H);
                        _doVar2._J.setVideoStateListener(_doVar2._I);
                        _doVar2._J.setOnErrorListener(_doVar2._G);
                        _doVar2._J.setOnCompletionListener(_doVar2._F);
                        _doVar2._J.setExpressAdInteractionListener(_doVar2._R);
                        _doVar2._J.setAdvertSlot(_doVar2._d);
                        _doVar2._J.setAd(_doVar2._c);
                        layoutParams = _doVar2._J.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        }
                        _doVar2._J.setLayoutParams(layoutParams);
                        _fv._a.post(new _dq(_doVar2));
                        _n1._a(_doVar2, _doVar2._J.getAdRootView(), (View) null);
                        _doVar2.addView(_doVar2._J);
                        return;
                    }
                    _aVar = _doVar2._R;
                    if (_aVar != null) {
                        return;
                    }
                    adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_RENDER_ERROR, PtgErrorCode.SDK_RENDER_ERROR_8, (Object) null);
                    adErrorImpl._c = PtgApiProvider.providerName;
                    adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_8;
                    adInteractionListener = _do.this._a;
                    if (adInteractionListener == null) {
                        return;
                    }
                } else if (i == 5) {
                    AdSlot adSlot = _doVar2._d;
                    String str_k2 = _fVar2._k();
                    if (TextUtils.isEmpty(str_k2)) {
                        _ahVar = null;
                    } else {
                        float expressViewAcceptedWidth = adSlot.getExpressViewAcceptedWidth();
                        float expressViewAcceptedHeight = adSlot.getExpressViewAcceptedHeight();
                        if (expressViewAcceptedWidth <= 0.0f || expressViewAcceptedHeight <= 0.0f) {
                            if ("501".equals(str_k2)) {
                                _ahVar = new _aj(_doVar2.getContext());
                                f = 0.5f;
                            } else if ("502".equals(str_k2)) {
                                _ahVar = new _aj(_doVar2.getContext());
                            } else if ("503".equals(str_k2)) {
                                _ahVar = new _aj(_doVar2.getContext());
                                f = 0.83f;
                            } else if ("504".equals(str_k2)) {
                                _ahVar = new _ai(_doVar2.getContext());
                            } else if ("505".equals(str_k2)) {
                                _ahVar = new _ag(_doVar2.getContext());
                            } else if ("506".equals(str_k2)) {
                                _ahVar = new _ag(_doVar2.getContext());
                                f = 0.57f;
                            } else if ("507".equals(str_k2)) {
                                _ahVar = new _ah(_doVar2.getContext());
                                _ahVar.setNativeRatio(0.56f);
                            } else {
                                _ahVar = null;
                            }
                            _ahVar.setNativeRatio(f);
                        } else {
                            _ahVar = new _af(_doVar2.getContext());
                            _ahVar.setAdLayoutParams(adSlot);
                        }
                    }
                    _doVar2._J = _ahVar;
                    if (_ahVar == null) {
                        _doVar2._K = true;
                        _doVar2._J.setVideoProgressListener(_doVar2._H);
                        _doVar2._J.setVideoStateListener(_doVar2._I);
                        _doVar2._J.setOnErrorListener(_doVar2._G);
                        _doVar2._J.setOnCompletionListener(_doVar2._F);
                        _doVar2._J.setExpressAdInteractionListener(_doVar2._R);
                        _doVar2._J.setAdvertSlot(_doVar2._d);
                        _doVar2._J.setAd(_doVar2._c);
                        layoutParams = _doVar2._J.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        }
                        _doVar2._J.setLayoutParams(layoutParams);
                        _fv._a.post(new _dq(_doVar2));
                        _n1._a(_doVar2, _doVar2._J.getAdRootView(), (View) null);
                        _doVar2.addView(_doVar2._J);
                        return;
                    }
                    _aVar = _doVar2._R;
                    if (_aVar != null) {
                        return;
                    }
                    adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_RENDER_ERROR, PtgErrorCode.SDK_RENDER_ERROR_8, (Object) null);
                    adErrorImpl._c = PtgApiProvider.providerName;
                    adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_8;
                    adInteractionListener = _do.this._a;
                    if (adInteractionListener == null) {
                        return;
                    }
                } else {
                    _do._a _aVar3 = _doVar2._R;
                    if (_aVar3 == null) {
                        return;
                    }
                    adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_RENDER_ERROR, PtgErrorCode.SDK_RENDER_ERROR_7, (Object) null);
                    adErrorImpl._c = PtgApiProvider.providerName;
                    adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_7;
                    adInteractionListener = _do.this._a;
                    if (adInteractionListener == null) {
                        return;
                    }
                }
            }
            adInteractionListener.onRenderFail(adErrorImpl);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void setAdFilterAdapter(_m _mVar) {
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void setCanInterruptVideoPlay(boolean z) {
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    @Deprecated
    public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void setExpressInteractionListener(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
        this._c = adInteractionListener;
        if (!this._a.isSelfRender()) {
            _do _doVar = this._e;
            if (_doVar != null) {
                _doVar.setExpressInteractionListener(adInteractionListener);
                return;
            }
            return;
        }
        _dm _dmVar = this._d;
        if (_dmVar != null) {
            _dmVar._a = adInteractionListener;
            _en _enVar = _dmVar._h;
            if (_enVar != null) {
                _enVar._a(adInteractionListener);
            }
            _gq _gqVar = _dmVar._i;
            if (_gqVar != null) {
                _gqVar._e = adInteractionListener;
            }
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void setExpressViewColor(String str) {
        AdSlot adSlot = this._a;
        if (adSlot != null) {
            adSlot.setExpressViewColor(str);
        }
        _do _doVar = this._e;
        if (_doVar != null) {
            _doVar.setExpressViewColor(str);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void setSlideIntervalTime(int i) {
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        _en _enVar;
        if (!this._a.isSelfRender()) {
            _do _doVar = this._e;
            if (_doVar != null) {
                _doVar.setVideoAdListener(ptgVideoAdListener);
                return;
            }
            return;
        }
        _dm _dmVar = this._d;
        if (_dmVar == null || (_enVar = _dmVar._h) == null) {
            return;
        }
        _enVar.setVideoAdListener(ptgVideoAdListener);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void showInteractionExpressAd(Activity activity) {
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void startVideo() {
        _dm _dmVar;
        _en _enVar;
        if (!this._a.isSelfRender() || (_dmVar = this._d) == null || (_enVar = _dmVar._h) == null) {
            return;
        }
        _enVar.startVideo();
    }
}
