package com.fancy;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.mpsdk.activity.PtgBaseVideoActivity;
import com.fancy.mpsdk.activity.PtgRewardVideoPortraitActivity;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;
import com.fancy.mpsdk.widget.web.AdTemplateWebView;
import com.hihonor.adsdk.base.g.j.e.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _kn implements Runnable {
    public final /* synthetic */ PtgRewardVideoPortraitActivity _a;

    public _kn(PtgRewardVideoPortraitActivity ptgRewardVideoPortraitActivity) {
        this._a = ptgRewardVideoPortraitActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _os _osVar_t;
        _or _orVar;
        try {
            if (this._a.isFinishing()) {
                return;
            }
            _md _mdVar = this._a._I;
            if (_mdVar instanceof _mt) {
                _mt _mtVar = (_mt) _mdVar;
                _lp _lpVar = _mtVar._a;
                if (_lpVar != null) {
                    _lpVar._h = true;
                    NiceVideoPlayer niceVideoPlayer = _lpVar._a;
                    if (niceVideoPlayer != null) {
                        niceVideoPlayer._c();
                        _lpVar._a = null;
                    }
                    if (_lpVar._b != null) {
                        _lpVar._b = null;
                    }
                    AdTemplateWebView adTemplateWebView = _lpVar._c;
                    if (adTemplateWebView != null) {
                        adTemplateWebView.destroy();
                        _lpVar._c = null;
                    }
                    ImageView imageView = _lpVar._d;
                    if (imageView != null) {
                        imageView.setImageBitmap(null);
                        _lpVar._d = null;
                    }
                    _lpVar._f = null;
                    _mtVar._a = null;
                }
                Handler handler = _mtVar._z;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    _mtVar._z = null;
                }
                _jd _jdVar = _mtVar._t;
                if (_jdVar != null) {
                    _jdVar._c();
                    _jdVar._c = null;
                    _jdVar._d = null;
                    _jdVar._o = null;
                    _mtVar._t = null;
                }
                WeakReference<PtgBaseVideoActivity> weakReference = _mtVar._m;
                if (weakReference != null) {
                    weakReference.clear();
                    _mtVar._m = null;
                }
                _f _fVar = _mtVar._b;
                if (_fVar != null && _fVar._a == 0) {
                    String str = _fVar._i;
                    HashMap map = _cv._a;
                    if (!TextUtils.isEmpty(str)) {
                        _cv._a.remove(com.fancy.adsdk.lib.utils._a._c(str));
                    }
                }
            }
            PtgRewardVideoPortraitActivity ptgRewardVideoPortraitActivity = this._a;
            ptgRewardVideoPortraitActivity._I = null;
            ptgRewardVideoPortraitActivity._a(false);
            this._a._b();
            this._a._I = new _me();
            PtgRewardVideoPortraitActivity ptgRewardVideoPortraitActivity2 = this._a;
            ptgRewardVideoPortraitActivity2._I._a(ptgRewardVideoPortraitActivity2, ptgRewardVideoPortraitActivity2._H, ptgRewardVideoPortraitActivity2._K);
            AdSlot adSlot = ((_me) this._a._I)._c;
            if (adSlot == null || (_osVar_t = adSlot._t()) == null || (_orVar = _osVar_t._t) == null) {
                return;
            }
            _orVar._a("webOriginal", a.S0);
        } catch (Exception unused) {
        }
    }
}
