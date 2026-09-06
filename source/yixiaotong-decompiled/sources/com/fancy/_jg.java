package com.fancy;

import android.app.Activity;
import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.interf.NativeAdvertData;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.interf.PtgInteractionAd;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _jg implements PtgInteractionAd {
    public final AdSlot _a;
    public final PtgInteractionAd _b;
    public final _os _c;

    public class _a implements PtgInteractionAd.AdInteractionListener {
        public final /* synthetic */ PtgInteractionAd.AdInteractionListener _a;

        public _a(PtgInteractionAd.AdInteractionListener adInteractionListener) {
            this._a = adInteractionListener;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onAdClicked() {
            _jg _jgVar = _jg.this;
            _os _osVar = _jgVar._c;
            if (_osVar != null) {
                _osVar._t._b(_jgVar._a._u());
            }
            _ou._a()._a(_jg.this._a._i()._d(), "inAppClick", _jg.this._c, null);
            _os _osVar2 = _jg.this._c;
            if (_osVar2 != null) {
                String str_a = _osVar2._a();
                if (!TextUtils.isEmpty(str_a) && Boolean.parseBoolean(str_a)) {
                    _os _osVar3 = _jg.this._c;
                    String strValueOf = String.valueOf(false);
                    synchronized (_osVar3._s) {
                        if (!TextUtils.isEmpty("iReportM")) {
                            _osVar3._s.put("iReportM", strValueOf);
                        }
                    }
                    return;
                }
            }
            PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onAdDismiss() {
            PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdDismiss();
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onAdShow() {
            if (_jg.this._c._p) {
                _ou._a()._a(_jg.this._a._i()._h(), "inAppImp", _jg.this._c, null);
                _jg.this._c._d();
                PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdShow();
                }
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onRenderError(AdError adError) {
            AdSlot adSlot;
            _jg _jgVar = _jg.this;
            if (_jgVar._c != null && (adSlot = _jgVar._a) != null && adSlot._i() != null) {
                _jg.this._c._a(adError);
                _ou._a()._a(_jg.this._a._i()._g(), "inAppErr", _jg.this._c, null);
            }
            PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
            if (adInteractionListener != null) {
                adInteractionListener.onRenderError(adError);
            }
        }
    }

    public class _b implements PtgVideoAdListener {
        public final /* synthetic */ PtgVideoAdListener _a;

        public _b(PtgVideoAdListener ptgVideoAdListener) {
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

    public class _c implements Runnable {
        public _c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            _jg.this._b.destroy();
        }
    }

    public _jg(PtgInteractionAd ptgInteractionAd, AdSlot adSlot, _os _osVar) {
        this._b = ptgInteractionAd;
        this._a = adSlot;
        this._c = _osVar;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd
    public final void closureInterstitialAd() {
        this._b.closureInterstitialAd();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void destroy() {
        com.fancy.adsdk.lib.utils._d._c(new _c());
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final _m getAdFilterAdapter() {
        return this._b.getAdFilterAdapter();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final String getAdId() {
        return this._b.getAdId();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd
    public final NativeAdvertData getAdvertData() {
        return this._b.getAdvertData();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final String getConsumer() {
        return this._b.getConsumer();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final long getEcpm() {
        PtgInteractionAd ptgInteractionAd = this._b;
        if (ptgInteractionAd != null) {
            return ptgInteractionAd.getEcpm();
        }
        return 0L;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final int getInteractionType() {
        return this._b.getInteractionType();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd
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
        PtgInteractionAd ptgInteractionAd = this._b;
        if (ptgInteractionAd != null) {
            ptgInteractionAd.notifyBidLoss(adBidLossReason);
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
        PtgInteractionAd ptgInteractionAd = this._b;
        if (ptgInteractionAd != null) {
            ptgInteractionAd.notifyBidWin(d, d2);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void setAdFilterAdapter(_m _mVar) {
        this._b.setAdFilterAdapter(_mVar);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd
    public final void setAdInteractionListener(PtgInteractionAd.AdInteractionListener adInteractionListener) {
        this._b.setAdInteractionListener(new _a(adInteractionListener));
    }

    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd
    public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        this._b.setDownloadListener(ptgAppDownloadListener);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd
    public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        this._b.setVideoAdListener(new _b(ptgVideoAdListener));
    }

    @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd
    public final void showInteractionAd(Activity activity) {
        this._b.showInteractionAd(activity);
    }
}
