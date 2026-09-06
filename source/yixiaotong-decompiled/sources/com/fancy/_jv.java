package com.fancy;

import android.app.Activity;
import android.view.ViewGroup;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.interf.NativeAdvertData;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.utils.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _jv implements PtgSplashAd {
    public final AdSlot _a;
    public final PtgSplashAd _b;
    public final _os _c;

    public class _a implements PtgSplashAd.AdInteractionListener {
        public final /* synthetic */ PtgSplashAd.AdInteractionListener _a;

        public _a(PtgSplashAd.AdInteractionListener adInteractionListener) {
            this._a = adInteractionListener;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
        public final void onAdClicked() {
            _jv _jvVar = _jv.this;
            _os _osVar = _jvVar._c;
            if (_osVar != null) {
                _osVar._t._b(_jvVar._a._u());
            }
            _ou._a()._a(_jv.this._a._i()._d(), "inAppClick", _jv.this._c, null);
            if (Boolean.parseBoolean(_jv.this._c._a())) {
                return;
            }
            this._a.onAdClicked();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
        public final void onAdShow() {
            if (_jv.this._c._p) {
                _ou._a()._a(_jv.this._a._i()._h(), "inAppImp", _jv.this._c, null);
                _jv.this._c._d();
                this._a.onAdShow();
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
        public final void onAdSkip() {
            this._a.onAdSkip();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
        public final void onAdTimeOver() {
            this._a.onAdTimeOver();
        }

        @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
        public final void onDismiss(int i) {
            this._a.onDismiss(i);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
        public final void onRenderError(AdError adError) {
            AdSlot adSlot;
            _jv _jvVar = _jv.this;
            if (_jvVar._c != null && (adSlot = _jvVar._a) != null && adSlot._i() != null) {
                _jv.this._c._a(adError);
                _ou._a()._a(_jv.this._a._i()._g(), "inAppErr", _jv.this._c, null);
            }
            this._a.onRenderError(adError);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgSplashAd.AdInteractionListener
        public final void onRenderSuccess() {
            this._a.onRenderSuccess();
        }
    }

    public _jv(PtgSplashAd ptgSplashAd, AdSlot adSlot, _os _osVar) {
        this._b = ptgSplashAd;
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

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
    public final NativeAdvertData getAdvertData() {
        return this._b.getAdvertData();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final String getConsumer() {
        return this._b.getConsumer();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final long getEcpm() {
        PtgSplashAd ptgSplashAd = this._b;
        if (ptgSplashAd != null) {
            return ptgSplashAd.getEcpm();
        }
        return 0L;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final int getInteractionType() {
        return this._b.getInteractionType();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final boolean isReady() {
        return this._b.isReady();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final boolean isResourceLoaded() {
        return this._b.isResourceLoaded();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
    public final void load() {
        this._b.load();
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
        PtgSplashAd ptgSplashAd = this._b;
        if (ptgSplashAd != null) {
            ptgSplashAd.notifyBidLoss(adBidLossReason);
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
        PtgSplashAd ptgSplashAd = this._b;
        if (ptgSplashAd != null) {
            ptgSplashAd.notifyBidWin(d, d2);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
    public final void preload() {
        PtgSplashAd ptgSplashAd = this._b;
        if (ptgSplashAd != null) {
            ptgSplashAd.preload();
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void setAdFilterAdapter(_m _mVar) {
        this._b.setAdFilterAdapter(_mVar);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
    public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        this._b.setDownloadListener(ptgAppDownloadListener);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
    public final void setSplashInteractionListener(PtgSplashAd.AdInteractionListener adInteractionListener) {
        this._b.setSplashInteractionListener(new _a(adInteractionListener));
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
    public final void showAd(ViewGroup viewGroup) {
        if (this._a._a() != null) {
            Logger.e("SplashView showAd fail, slot already exists container.");
        } else if (viewGroup != null) {
            this._b.showAd(viewGroup);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgSplashAd
    public final void showAd(ViewGroup viewGroup, Activity activity) {
        if (this._a._a() != null) {
            Logger.e("SplashView showAd fail, slot already exists container.");
        } else if (viewGroup != null) {
            this._b.showAd(viewGroup, activity);
        }
    }
}
