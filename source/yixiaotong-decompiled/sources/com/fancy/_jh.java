package com.fancy;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.interf.NativeAdvertData;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _jh implements PtgNativeExpressAd {
    public AdSlot _a;
    public PtgNativeExpressAd _b;
    public _os _c;

    public class _a implements PtgNativeExpressAd.AdInteractionListener {
        public final /* synthetic */ PtgNativeExpressAd.AdInteractionListener _a;

        public _a(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
            this._a = adInteractionListener;
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onAdClicked() {
            _jh _jhVar = _jh.this;
            _os _osVar = _jhVar._c;
            if (_osVar != null) {
                _osVar._t._b(_jhVar._a._u());
            }
            _ou._a()._a(_jh.this._a._i()._d(), "inAppClick", _jh.this._c, null);
            if (!Boolean.parseBoolean(_jh.this._c._a())) {
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdClicked();
                    return;
                }
                return;
            }
            _os _osVar2 = _jh.this._c;
            String strValueOf = String.valueOf(false);
            synchronized (_osVar2._s) {
                if (!TextUtils.isEmpty("iReportM")) {
                    _osVar2._s.put("iReportM", strValueOf);
                }
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onAdDismiss() {
            PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdDismiss();
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onAdShow() {
            _jh _jhVar = _jh.this;
            if (_jhVar._b != null && _jhVar._c._p) {
                _ou._a()._a(_jh.this._a._i()._h(), "inAppImp", _jh.this._c, null);
                _jh.this._c._d();
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdShow();
                }
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderFail(AdError adError) {
            AdSlot adSlot;
            _jh _jhVar = _jh.this;
            if (_jhVar._c != null && (adSlot = _jhVar._a) != null && adSlot._i() != null) {
                _jh.this._c._a(adError);
                _ou._a()._a(_jh.this._a._i()._g(), "inAppErr", _jh.this._c, null);
            }
            PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
            if (adInteractionListener != null) {
                adInteractionListener.onRenderFail(adError);
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderSuccess(View view) {
            PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
            if (adInteractionListener == null || view == null) {
                return;
            }
            adInteractionListener.onRenderSuccess(view);
        }
    }

    public class _b implements Runnable {
        public _b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgNativeExpressAd ptgNativeExpressAd = _jh.this._b;
            if (ptgNativeExpressAd != null) {
                ptgNativeExpressAd.destroy();
                _jh.this._b = null;
            }
        }
    }

    public _jh(PtgNativeExpressAd ptgNativeExpressAd, AdSlot adSlot, _os _osVar) {
        this._b = ptgNativeExpressAd;
        this._a = adSlot;
        this._c = _osVar;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd, com.fancy.adsdk.lib.interf.PtgAd
    public final void destroy() {
        com.fancy.adsdk.lib.utils._d._c(new _b());
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final _m getAdFilterAdapter() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return null;
        }
        return ptgNativeExpressAd.getAdFilterAdapter();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final String getAdId() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        return ptgNativeExpressAd == null ? "" : ptgNativeExpressAd.getAdId();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final NativeAdvertData getAdvertData() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return null;
        }
        return ptgNativeExpressAd.getAdvertData();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final String getConsumer() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        return ptgNativeExpressAd == null ? "" : ptgNativeExpressAd.getConsumer();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final PtgNativeExpressAd.CustomizeVideo getCustomizeVideo() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return null;
        }
        return ptgNativeExpressAd.getCustomizeVideo();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final long getEcpm() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd != null) {
            return ptgNativeExpressAd.getEcpm();
        }
        return 0L;
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final View getExpressAdView() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return null;
        }
        return ptgNativeExpressAd.getExpressAdView();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final List<Object> getFilterWords() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return null;
        }
        return ptgNativeExpressAd.getFilterWords();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final int getImageMode() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return -1;
        }
        return ptgNativeExpressAd.getImageMode();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final int getInteractionType() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return -1;
        }
        return ptgNativeExpressAd.getInteractionType();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final Map<String, Object> getMediaExtraInfo() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return null;
        }
        return ptgNativeExpressAd.getMediaExtraInfo();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final View getMediaView() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return null;
        }
        return ptgNativeExpressAd.getMediaView();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final boolean isReady() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return false;
        }
        return ptgNativeExpressAd.isReady();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final boolean isResourceLoaded() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return false;
        }
        return ptgNativeExpressAd.isResourceLoaded();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final boolean isSelfRender() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return false;
        }
        return ptgNativeExpressAd.isSelfRender();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final boolean isVideo() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return false;
        }
        return ptgNativeExpressAd.isVideo();
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
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.notifyBidLoss(adBidLossReason);
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
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.notifyBidWin(d, d2);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void pauseVideo() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.pauseVideo();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void registerAdvertViews(ViewGroup viewGroup, List<View> list, List<View> list2, View view) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.registerAdvertViews(viewGroup, list, list2, view);
        }
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void render() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.render();
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    public final void setAdFilterAdapter(_m _mVar) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.setAdFilterAdapter(_mVar);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void setCanInterruptVideoPlay(boolean z) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.setCanInterruptVideoPlay(z);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.setDownloadListener(ptgAppDownloadListener);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void setExpressInteractionListener(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.setExpressInteractionListener(new _a(adInteractionListener));
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void setExpressViewColor(String str) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.setExpressViewColor(str);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void setSlideIntervalTime(int i) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.setSlideIntervalTime(i);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.setVideoAdListener(ptgVideoAdListener);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void showInteractionExpressAd(Activity activity) {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.showInteractionExpressAd(activity);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd
    public final void startVideo() {
        PtgNativeExpressAd ptgNativeExpressAd = this._b;
        if (ptgNativeExpressAd == null) {
            return;
        }
        ptgNativeExpressAd.startVideo();
    }
}
