package com.fancy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.fancy.adsdk.lib.R;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.tracking.ActionTrackManager;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.fancy.adsdk.lib.utils.dev.ScreenUtils;
import com.fancy.mpsdk.component.widgets.PtgShakeView;
import com.fancy.mpsdk.widget.web.AdTemplateWebView;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.openalliance.ad.constant.ba;
import com.huawei.openalliance.ad.constant.bi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _o2 extends _an {
    public FrameLayout _f;
    public AdTemplateWebView _g;
    public LinearLayout _h;
    public PtgShakeView _i;
    public TextView _j;
    public AdSlot _k;
    public _f _l;
    public long _m;
    public Handler _n;
    public _o1 _o;
    public volatile boolean _p;
    public final _a _q;

    public class _a implements _pc {
        public _a() {
        }

        @Override // com.fancy._pc
        public final void _a(int i, JSONObject jSONObject) {
            TextView textView;
            if (i == 1) {
                FrameLayout frameLayout = _o2.this._f;
                if (frameLayout != null) {
                    frameLayout.performClick();
                    return;
                }
                return;
            }
            if (i != 2) {
                if (i != 3 || (textView = _o2.this._j) == null) {
                    return;
                }
                Object tag = textView.getTag(R.id.fancy_native_view_tag);
                if (tag instanceof _ok) {
                    _ok _okVar = (_ok) tag;
                    _okVar._i = jSONObject.optInt("ux");
                    _okVar._j = jSONObject.optInt("uy");
                    _okVar._g = jSONObject.optInt("dx");
                    _okVar._h = jSONObject.optInt("dy");
                }
                _o2.this._j.performClick();
                return;
            }
            if (_o2.this._b != null) {
                int iOptInt = jSONObject.optInt(CrashHianalyticsData.TIME, 0);
                _nx._d _dVar = (_nx._d) _o2.this._b;
                ActionTrackManager._a()._a(_hr._a(_nx.this._m), (_nx.this._a - ((long) iOptInt)) / 1000);
                PtgSplashAd.AdInteractionListener adInteractionListener = _nx.this._i;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdSkip();
                }
                PtgSplashAd.AdInteractionListener adInteractionListener2 = _nx.this._i;
                if (adInteractionListener2 != null) {
                    adInteractionListener2.onDismiss(1);
                }
                _nx.this._a();
            }
        }

        @Override // com.fancy._pc
        public final void _b(String str) {
            _o1 _o1Var;
            _o2 _o2Var = _o2.this;
            Handler handler = _o2Var._n;
            if (handler != null && (_o1Var = _o2Var._o) != null) {
                handler.removeCallbacks(_o1Var);
                _o2Var._o = null;
            }
            _o2 _o2Var2 = _o2.this;
            _v _vVar = _o2Var2._c;
            if (_vVar != null) {
                _vVar._a(_o2Var2, PtgErrorCode.SDK_RESOURCE_ERROR, new Exception(str));
            }
        }

        @Override // com.fancy._pc
        public final void _f() {
            _h _hVar = _o2.this._b;
            if (_hVar != null) {
                _nx._d _dVar = (_nx._d) _hVar;
                ActionTrackManager._a()._a(_hr._a(_nx.this._m), _nx.this._a / 1000);
                PtgSplashAd.AdInteractionListener adInteractionListener = _nx.this._i;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdTimeOver();
                }
                PtgSplashAd.AdInteractionListener adInteractionListener2 = _nx.this._i;
                if (adInteractionListener2 != null) {
                    adInteractionListener2.onDismiss(2);
                }
                _nx.this._a();
            }
        }

        @Override // com.fancy._pc
        public final void _g() {
            _o1 _o1Var;
            _o2.this._p = true;
            _o2 _o2Var = _o2.this;
            Handler handler = _o2Var._n;
            if (handler != null && (_o1Var = _o2Var._o) != null) {
                handler.removeCallbacks(_o1Var);
                _o2Var._o = null;
            }
            _o2 _o2Var2 = _o2.this;
            if (_o2Var2._l != null) {
                Context context = _o2Var2.getContext();
                _o2 _o2Var3 = _o2.this;
                _b3._a(context, _o2Var3, _o2Var3._l, _o2Var3._f, _o2Var3._j, _o2Var3._h, _o2Var3._b);
            }
            _v _vVar = _o2.this._c;
            if (_vVar != null) {
                _vVar._a();
            }
        }
    }

    public _o2(Context context) {
        super(context);
        this._m = 5000L;
        this._p = false;
        this._q = new _a();
    }

    @Override // com.fancy._an
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.fancy_splash_webview_layout, (ViewGroup) null);
        this._a = viewInflate;
        this._f = (FrameLayout) viewInflate.findViewById(R.id.ptgAdvertLayout);
        this._g = (AdTemplateWebView) this._a.findViewById(R.id.adTemplateWebView);
        this._j = (TextView) this._a.findViewById(R.id.ptgSplashHotArea);
        this._h = (LinearLayout) this._a.findViewById(R.id.ptgSplashShakeLayout);
        this._i = (PtgShakeView) this._a.findViewById(R.id.ptgSplashShakeIv);
        _db._a(this._j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this._a, layoutParams);
        setGravity(17);
        this._n = new Handler(Looper.getMainLooper());
    }

    @Override // com.fancy._an
    public final void _c() {
        _o1 _o1Var;
        super._c();
        Handler handler = this._n;
        if (handler != null && (_o1Var = this._o) != null) {
            handler.removeCallbacks(_o1Var);
            this._o = null;
        }
        this._n = null;
        AdTemplateWebView adTemplateWebView = this._g;
        if (adTemplateWebView != null) {
            adTemplateWebView.post(new _2(adTemplateWebView, "stopTime", null));
            this._g.destroy();
            this._g = null;
        }
        PtgShakeView ptgShakeView = this._i;
        if (ptgShakeView != null) {
            ImageView imageView = ptgShakeView._a;
            if (imageView != null) {
                imageView.clearAnimation();
            }
            _mz _mzVar = ptgShakeView._d;
            if (_mzVar != null) {
                _mzVar.cancel();
                ptgShakeView._d = null;
            }
        }
        this._l = null;
        this._k = null;
    }

    @Override // com.fancy._an
    public void setAd(_f _fVar) {
        String str;
        _o1 _o1Var;
        AdSlot adSlot;
        this._l = _fVar;
        if (TextUtil.isEmpty(_fVar._M)) {
            _v _vVar = this._c;
            if (_vVar != null) {
                _vVar._a(this, PtgErrorCode.SDK_RESOURCE_ERROR, new Exception("WebSource为空"));
                return;
            }
            return;
        }
        this._m = _io._a(_fVar, this._k);
        String strReplace = _fVar._M;
        String strReplace2 = "";
        if (TextUtil.isEmpty(strReplace) || (adSlot = this._k) == null) {
            str = strReplace2;
        } else {
            float screenWidth = adSlot.getExpressViewAcceptedWidth() <= 0.0f ? ScreenUtils.getScreenWidth(getContext()) : ScreenUtils.dp2px(this._k.getExpressViewAcceptedWidth());
            float screenHeight = this._k.getExpressViewAcceptedHeight() <= 0.0f ? ScreenUtils.getScreenHeight(getContext()) : ScreenUtils.dp2px(this._k.getExpressViewAcceptedHeight());
            boolean zIsCountdownVisibility = this._k.isCountdownVisibility();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("width", screenWidth);
                jSONObject.put("height", screenHeight);
                jSONObject.put("hideAdFeedBack", _fVar._V);
                strReplace = strReplace.replace("__E__", jSONObject.toString());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(CrashHianalyticsData.TIME, this._m / 1000);
                jSONObject2.put("count_visible", zIsCountdownVisibility ? 1 : 2);
                jSONObject2.put(ba.at, _fVar._j());
                jSONObject2.put("title", _fVar._l());
                jSONObject2.put("desc", _fVar._d());
                jSONObject2.put("logo", _fVar._i());
                jSONObject2.put("reqId", _fVar._w);
                AdSlot adSlot2 = this._k;
                if (adSlot2 != null) {
                    _c7 _c7Var_m = adSlot2._m();
                    jSONObject2.put("devInfo", _c7Var_m != null ? _c7Var_m._a() : "");
                }
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put(bi.Code, jSONArray);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(IAdInterListener.AdReqParam.WIDTH, _fVar._p());
                jSONObject3.put(IAdInterListener.AdReqParam.HEIGHT, _fVar._g());
                jSONObject3.put("url", _fVar._f() != null ? _fVar._f()._a : "");
                jSONArray.put(jSONObject3);
                strReplace2 = strReplace.replace("__C__", jSONObject2.toString());
                str = strReplace2;
            } catch (JSONException unused) {
                str = strReplace;
            }
        }
        int iMax = Math.max(Math.min(_fVar._j, 5000), 1000);
        Handler handler = this._n;
        if (handler != null) {
            if (handler != null && (_o1Var = this._o) != null) {
                handler.removeCallbacks(_o1Var);
                this._o = null;
            }
            _o1 _o1Var2 = new _o1(this);
            this._o = _o1Var2;
            this._n.postDelayed(_o1Var2, iMax);
        }
        System.currentTimeMillis();
        this._g.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);
        this._g.setWebViewBridgeListener(this._q);
    }

    public void setAdSlot(AdSlot adSlot) {
        this._k = adSlot;
    }
}
