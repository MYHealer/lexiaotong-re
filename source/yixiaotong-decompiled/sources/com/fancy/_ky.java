package com.fancy;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.NativeAdvertData;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.mpsdk.provider.PtgApiProvider;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ky implements PtgSplashAd {
    public _nx _a;
    public _f _b;
    public AdSlot _c;

    public _ky(Context context, PtgAdNative.SplashAdListener splashAdListener) {
        _a(context, splashAdListener);
    }

    public final void _a(Context context, PtgAdNative.SplashAdListener splashAdListener) {
        _nx _nxVar = new _nx(context);
        this._a = _nxVar;
        _nxVar.setAdListener(splashAdListener);
    }

    public final void _a(List<_f> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this._b = list.get(0);
        ViewGroup viewGroup_a = this._c._a();
        if (viewGroup_a == null) {
            viewGroup_a = this._c._s();
        }
        this._a._a(this._b, viewGroup_a, null);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void destroy() {
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final _m getAdFilterAdapter() {
        return null;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final String getAdId() {
        return null;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
    public final NativeAdvertData getAdvertData() {
        return _ib._a(6, false, this._b);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final String getConsumer() {
        return PtgApiProvider.providerName;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final long getEcpm() {
        _f _fVar = this._b;
        if (_fVar != null) {
            return _fVar._m;
        }
        return 0L;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final int getInteractionType() {
        int i = this._b._a;
        if (i == 0) {
            return 0;
        }
        if (i != 1) {
            return i != 2 ? -1 : 3;
        }
        return 1;
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

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
    public final void load() {
        _nx _nxVar = this._a;
        if (_nxVar != null) {
            _nxVar.setAdSlot(this._c);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void notifyBidLoss(AdBidLossReason adBidLossReason) {
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void notifyBidWin(double d, double d2) {
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
    public final void preload() {
        _ij _ijVar;
        _nx _nxVar = this._a;
        if (_nxVar != null) {
            _ih _ihVar = _ih._b._a;
            _f _fVar = _nxVar._m;
            _o0 _o0Var = new _o0(_nxVar);
            _ihVar.getClass();
            if (_fVar != null) {
                try {
                    _ijVar = _fVar._C;
                } catch (Exception e) {
                    e.getMessage();
                    return;
                }
            } else {
                _ijVar = null;
            }
            if (_ijVar != null) {
                if (_ijVar._a()) {
                    _l3 _l3Var = _ijVar._f;
                    String str = _l3Var._b;
                    if (TextUtils.isEmpty(str)) {
                        _ihVar._a(_l3Var._a, _o0Var);
                        return;
                    } else {
                        _ihVar._a(str, _o0Var);
                        return;
                    }
                }
                List<_jz> list = _ijVar._e;
                if (list == null || list.isEmpty()) {
                    return;
                }
                int size = list.size();
                int i = 0;
                while (i < size) {
                    _ihVar._a(list.get(i)._a, i == 0 ? _o0Var : null);
                    i++;
                }
            }
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void setAdFilterAdapter(_m _mVar) {
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
    public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        _nx _nxVar = this._a;
        if (_nxVar != null) {
            _nxVar.setDownloadListener(ptgAppDownloadListener);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
    public final void setSplashInteractionListener(PtgSplashAd.AdInteractionListener adInteractionListener) {
        _nx _nxVar = this._a;
        if (_nxVar != null) {
            _nxVar.setAdInteractionListener(adInteractionListener);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
    public final void showAd(ViewGroup viewGroup) {
        showAd(viewGroup, viewGroup.getContext() instanceof Activity ? (Activity) viewGroup.getContext() : null);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
    public final void showAd(ViewGroup viewGroup, Activity activity) {
        _f _fVar = this._b;
        if (_fVar == null) {
            PtgSplashAd.AdInteractionListener adInteractionListener = this._a.getAdInteractionListener();
            if (adInteractionListener != null) {
                AdErrorImpl adErrorImpl = new AdErrorImpl();
                adErrorImpl._c = PtgApiProvider.providerName;
                adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._e = "because ad is null.";
                adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._b = "because ad is null.";
                adInteractionListener.onRenderError(adErrorImpl);
                return;
            }
            return;
        }
        if (!_fVar._t()) {
            PtgSplashAd.AdInteractionListener adInteractionListener2 = this._a.getAdInteractionListener();
            if (adInteractionListener2 != null) {
                AdErrorImpl adErrorImpl2 = new AdErrorImpl();
                adErrorImpl2._c = PtgApiProvider.providerName;
                adErrorImpl2._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl2._e = PtgErrorCode.SDK_RENDER_ERROR_5;
                adErrorImpl2._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl2._b = PtgErrorCode.SDK_RENDER_ERROR_5;
                adInteractionListener2.onRenderError(adErrorImpl2);
                return;
            }
            return;
        }
        if (this._c == null) {
            PtgSplashAd.AdInteractionListener adInteractionListener3 = this._a.getAdInteractionListener();
            if (adInteractionListener3 != null) {
                AdErrorImpl adErrorImpl3 = new AdErrorImpl();
                adErrorImpl3._c = PtgApiProvider.providerName;
                adErrorImpl3._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl3._e = "because adSlot is null.";
                adErrorImpl3._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl3._b = "because adSlot is null.";
                adInteractionListener3.onRenderError(adErrorImpl3);
                return;
            }
            return;
        }
        _nx _nxVar = this._a;
        if (_nxVar != null) {
            if (_nxVar.getParent() == null) {
                this._a._a(this._b, viewGroup, activity);
                viewGroup.addView(this._a);
                return;
            }
            PtgSplashAd.AdInteractionListener adInteractionListener4 = this._a.getAdInteractionListener();
            if (adInteractionListener4 != null) {
                AdErrorImpl adErrorImpl4 = new AdErrorImpl();
                adErrorImpl4._c = PtgApiProvider.providerName;
                adErrorImpl4._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl4._e = "The ad has already been rendered. Please destroy it and try again.";
                adErrorImpl4._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl4._b = "The ad has already been rendered. Please destroy it and try again.";
                adInteractionListener4.onRenderError(adErrorImpl4);
            }
        }
    }
}
