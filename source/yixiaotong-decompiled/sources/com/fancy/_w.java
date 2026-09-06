package com.fancy;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.cdo.oaps.ad.OapsKey;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.model.PtgAdLoadType;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class _w implements AdSlot {
    public long _A;
    public long _D;
    public _c7 _E;
    public boolean _J;
    public int _K;
    public _au _L;
    public String _Q;
    public String _a;
    public String _b;
    public String _c;
    public int _d;
    public int _e;
    public int _i;
    public int _j;
    public _ci _m;
    public WeakReference<ViewGroup> _n;
    public WeakReference<ViewGroup> _o;
    public long _p;
    public int _q;
    public List<View> _r;
    public List<View> _s;
    public int _t;
    public _os _u;
    public int _v;
    public boolean _w;
    public boolean _x;
    public int _y;
    public float _f = 0.0f;
    public float _g = 0.0f;
    public boolean _l = true;
    public int _z = 1;
    public PtgAdLoadType _B = PtgAdLoadType.UNKNOWN;
    public boolean _C = true;
    public String _F = "";
    public int _G = 0;
    public String _H = "";
    public String _I = "";
    public float _M = 10.0f;
    public float _N = 10.0f;
    public float _O = 10.0f;
    public float _P = 10.0f;
    public int _R = 0;
    public String _S = "";
    public long _T = 0;
    public int _h = 1;
    public boolean _k = true;

    public _w() {
    }

    public _w(int i) {
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final ViewGroup _a() {
        WeakReference<ViewGroup> weakReference = this._n;
        return weakReference == null ? _s() : weakReference.get();
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public AdSlot _a(AdSlot adSlot) {
        if (adSlot instanceof _w) {
            _w _wVar = (_w) adSlot;
            _wVar._a = this._a;
            _wVar._b = this._b;
            _wVar._c = this._c;
            _wVar._d = this._d;
            _wVar._e = this._e;
            _wVar._f = this._f;
            _wVar._g = this._g;
            _wVar._h = this._h;
            _wVar._F = this._F;
            _wVar._G = this._G;
            _wVar._H = this._H;
            _wVar._I = this._I;
            _wVar._i = this._i;
            _wVar._j = this._j;
            _wVar._k = this._k;
            _wVar._l = this._l;
            _ci _ciVar = this._m;
            _wVar._m = _ciVar;
            _wVar._n = this._n;
            _wVar._o = this._o;
            _wVar._p = this._p;
            _wVar._q = this._q;
            _wVar._r = this._r;
            _wVar._s = this._s;
            _wVar._t = this._t;
            _wVar._u = this._u;
            _wVar._v = this._v;
            _wVar._w = this._w;
            _wVar._x = this._x;
            _wVar._y = this._y;
            _wVar._z = this._z;
            _wVar._E = this._E;
            _wVar._A = this._A;
            _wVar._K = this._K;
            _wVar._B = this._B;
            _wVar._C = this._C;
            _wVar._D = this._D;
            _wVar._L = this._L;
            _wVar._M = this._M;
            _wVar._N = this._N;
            _wVar._O = this._O;
            _wVar._P = this._P;
            _wVar._Q = this._Q;
            _wVar._R = this._R;
            _wVar._S = this._S;
            _wVar._T = this._T;
            if (_ciVar != null) {
                _wVar._c(_ciVar);
            }
        }
        return adSlot;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _a(int i) {
        this._v = i;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _a(long j) {
        this._p = j;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _a(FrameLayout frameLayout) {
        this._n = new WeakReference<>(frameLayout);
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _a(_c7 _c7Var) {
        if (_c7Var != null) {
            _n4._a = _c7Var;
        }
        this._E = _c7Var;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _a(_ci _ciVar) {
        this._m = _ciVar;
        this._b = _ciVar._O;
        this._c = _ciVar._e();
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _a(_os _osVar) {
        this._u = _osVar;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _a(String str) {
        this._S = str;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public AdSlot _b(_ci _ciVar) {
        AdSlot adSlot_a = _a(new _bw(this));
        adSlot_a._c(_ciVar);
        return adSlot_a;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _b() {
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _b(int i) {
        this._q = i;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _b(long j) {
        this._T = j;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final _au _c() {
        return this._L;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _c(_ci _ciVar) {
        _a(_ciVar);
        this._o = new WeakReference<>(_a());
        this._b = _ciVar._O;
        this._c = _ciVar._e();
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final String _d() {
        return this._S;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _d(int i) {
        this._z = i;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final int _e() {
        return this._z;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _e(int i) {
        this._K = i;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final boolean _f() {
        return this._J;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final long _g() {
        return this._p;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _h() {
        this._J = true;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final _ci _i() {
        return this._m;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final int _j() {
        return this._t;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _k() {
        this._t = 1;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final _c7 _m() {
        return this._E;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final int _n() {
        return this._y;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _o() {
        this._w = true;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final String _p() {
        return this._b;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final long _q() {
        return this._T;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final ViewGroup _s() {
        WeakReference<ViewGroup> weakReference = this._o;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final _os _t() {
        return this._u;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final int _u() {
        return this._K;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final int _v() {
        return this._q;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final int _w() {
        return this._v;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final boolean _x() {
        return this._w;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final int getAdCount() {
        return this._h;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final PtgAdLoadType getAdLoadType() {
        return this._B;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final long getBasePrice() {
        return this._A;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final List<View> getClickView() {
        return this._r;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final String getCodeId() {
        return this._c;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final long getCountdownTime() {
        return this._D;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final List<View> getCreativeView() {
        return this._s;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final float getExpressViewAcceptedHeight() {
        return this._g;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final float getExpressViewAcceptedWidth() {
        return this._f;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final String getExpressViewColor() {
        return this._Q;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final float getExpressViewPaddingBottom() {
        return this._P;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final float getExpressViewPaddingLeft() {
        return this._M;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final float getExpressViewPaddingRight() {
        return this._O;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final float getExpressViewPaddingTop() {
        return this._N;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final int getImgAcceptedHeight() {
        return this._e;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final int getImgAcceptedWidth() {
        return this._d;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final String getMediaExtra() {
        return this._H;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final String getPtgSlotID() {
        return this._a;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final int getRewardAmount() {
        return this._G;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final String getRewardName() {
        return this._F;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final int getTimeoutMs() {
        return this._R;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final String getUserID() {
        return this._I;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final boolean isAutoPlay() {
        return this._k;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final boolean isCountdownVisibility() {
        return this._C;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final boolean isPlayMuted() {
        return this._l;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final boolean isSelfRender() {
        return this._x;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void setAdCount(int i) {
        this._h = i;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void setAdLoadType(PtgAdLoadType ptgAdLoadType) {
        this._B = ptgAdLoadType;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void setBasePrice(long j) {
        this._A = j;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void setCodeID(String str) {
        this._c = str;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void setCountdownTime(long j) {
        this._D = j;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void setCountdownVisibility(boolean z) {
        this._C = z;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void setExpressViewColor(String str) {
        this._Q = str;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void setTimeoutMs(int i) {
        this._R = i;
    }

    public final String toString() {
        return _j._a(_j._a(_j._a(_j._a(_ie._a("AdSlot{mCodeId='"), this._c, '\'', ", mImgAcceptedWidth=").append(this._d).append(", mImgAcceptedHeight=").append(this._e).append(", mExpressViewAcceptedWidth=").append(this._f).append(", mExpressViewAcceptedHeight=").append(this._g).append(", mAdCount=").append(this._h).append(", mRewardName='"), this._F, '\'', ", mRewardAmount=").append(this._G).append(", mMediaExtra='"), this._H, '\'', ", mUserID='"), this._I, '\'', ", mOrientation=").append(this._i).append(", mNativeAdType=").append(this._j).append(", mIsAutoPlay=").append(this._k).append('}').toString();
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void withBid(String str) {
        _au _auVar;
        if (TextUtils.isEmpty(str)) {
            _auVar = null;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                _auVar = new _au();
                _auVar._a = jSONObject.optString("reqid");
                _auVar._c = jSONObject.optString(OapsKey.KEY_PRICE);
                _auVar._b = jSONObject.optString("data");
            } catch (Exception unused) {
                _auVar = null;
            }
        }
        this._L = _auVar;
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final String _l() {
        _os _osVar = this._u;
        return _osVar != null ? _osVar._h : "";
    }

    @Override // com.fancy.adsdk.lib.model.AdSlot
    public final void _c(int i) {
        _ci _ciVar = this._m;
        if (_ciVar != null) {
            long j = i;
            _ciVar._h = (long) (j * _ciVar._g);
            _ciVar._i = j;
        }
    }
}
