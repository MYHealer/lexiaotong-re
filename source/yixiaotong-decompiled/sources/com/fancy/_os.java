package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _os {
    public String _a;
    public String _b;
    public String _c;
    public _c7 _d;
    public _a7 _e;
    public int _f;
    public String _g;
    public String _h;
    public String _i;
    public String _j;
    public String _k;
    public String _l;
    public String _m;
    public String _n;
    public int _q;
    public String _r;
    public long _o = 0;
    public boolean _p = true;
    public HashMap _s = new HashMap();
    public _or _t = new _or(0);

    public _os(_c7 _c7Var) {
        this._d = _c7Var;
    }

    public _os(String str, String str2, AdSlot adSlot) {
        String str_a = "";
        String ptgSlotID = adSlot == null ? "" : adSlot.getPtgSlotID();
        long j_g = adSlot != null ? adSlot._g() : 0L;
        int i_v = adSlot != null ? adSlot._v() : 0;
        _c7 _c7Var_m = adSlot == null ? null : adSlot._m();
        if (adSlot != null && adSlot._c() != null) {
            str_a = adSlot._c()._a();
        }
        this._b = str2;
        this._r = str;
        this._a = ptgSlotID;
        this._d = _c7Var_m;
        if (TextUtils.isEmpty(str_a)) {
            this._h = _a(i_v, j_g, this._a);
        } else {
            this._h = str_a;
        }
    }

    public static _os _a(AdSlot adSlot, String str) {
        _ci _ciVar_i = adSlot._i();
        if (_ciVar_i == null) {
            return null;
        }
        _os _osVar = new _os(_ciVar_i._c, _ciVar_i._e(), adSlot);
        _osVar._c = str;
        _or _orVar_b = _osVar._b();
        _orVar_b._i(PtgAdSdk.getConfig().getMediaId());
        _orVar_b._f(_ciVar_i._c);
        _orVar_b._e(_ciVar_i._e());
        _orVar_b._b(_ciVar_i._h);
        _orVar_b._a(_ciVar_i._i);
        _orVar_b._n(adSlot.getUserID());
        _orVar_b._m(adSlot.getPtgSlotID());
        _orVar_b._c(_ciVar_i._S);
        _orVar_b._d(_ciVar_i._e);
        return _osVar;
    }

    public static String _a(int i, long j, String str) {
        return String.format("%s-%d-%d", str, Long.valueOf(j), Integer.valueOf(i));
    }

    public static String _a(String str) {
        String hexString;
        StringBuilder sbAppend;
        if (str != null) {
            try {
                byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
                StringBuilder sb = new StringBuilder(40);
                for (byte b : bArrDigest) {
                    int i = b & 255;
                    if ((i >> 4) == 0) {
                        sbAppend = sb.append("0");
                        hexString = Integer.toHexString(i);
                    } else {
                        hexString = Integer.toHexString(i);
                        sbAppend = sb;
                    }
                    sbAppend.append(hexString);
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public final void _a(int i) {
        this._q = i;
        this._t._a(i);
    }

    public final void _c() {
        this._f = 0;
        this._t._e(0);
    }

    public final void _d() {
        this._p = false;
        _or _orVar = this._t;
        _orVar.getClass();
        try {
            synchronized (_orVar._a) {
                try {
                    JSONObject jSONObject = _orVar._a;
                    if (jSONObject != null) {
                        jSONObject.remove("enBidPrice");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception unused) {
        }
    }

    public final _or _b() {
        this._e = _ca._b();
        _or _orVar = this._t;
        _orVar._j(PtgAdSdk.getConfig().getPolicyVersion());
        _c7 _c7Var = this._d;
        if (_c7Var != null) {
            this._m = _c7Var._q;
            this._i = _a(_c7Var._c);
            _c7 _c7Var2 = this._d;
            this._k = _c7Var2._d;
            this._j = _a(_c7Var2._e);
            _dz _dzVar = this._d._m;
            this._n = _dzVar != null ? _dzVar.toString() : null;
            _c7 _c7Var3 = this._d;
            this._l = _c7Var3._a;
            _orVar._b(_c7Var3._s);
            _orVar._c(this._d._r);
            this._d.getClass();
            _orVar._k(PtgAdSdk.getConfig().getSdkVersionCode());
            this._d.getClass();
            _orVar._l(PtgAdSdk.getConfig().getSdkVersionName());
        }
        if ("inAppClick".equals(this._c)) {
            boolean z = Boolean.parseBoolean(_a());
            try {
                synchronized (_orVar._a) {
                    _orVar._a.put("iReportM", z);
                }
            } catch (Exception e) {
                Error error = _orVar._b;
                if (error != null) {
                    error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
                }
            }
        }
        return _orVar;
    }

    public final String _a() {
        synchronized (this._s) {
            if (TextUtils.isEmpty("iReportM")) {
                return "";
            }
            return (String) this._s.get("iReportM");
        }
    }

    public final void _a(AdError adError) {
        this._f = adError.getErrorCode();
        this._g = adError.getMessage();
        this._t._e(adError.getErrorCode());
        this._t._g(adError.getMessage());
        if (adError instanceof AdErrorImpl) {
            _or _orVar = this._t;
            AdErrorImpl adErrorImpl = (AdErrorImpl) adError;
            String str = adErrorImpl.getConsumerErrCode() + "（" + adErrorImpl.getConsumerErrMsg() + "）";
            _orVar.getClass();
            try {
                synchronized (_orVar._a) {
                    _orVar._a.put("customerErrorMessage", str);
                }
            } catch (Exception e) {
                Error error = _orVar._b;
                if (error != null) {
                    error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
                }
            }
        }
    }

    public final void _a(AdSlot adSlot) {
        _ci _ciVar_i;
        if (!TextUtils.isEmpty(this._b) || adSlot == null || (_ciVar_i = adSlot._i()) == null) {
            return;
        }
        String str_e = _ciVar_i._e();
        this._b = str_e;
        _or _orVar = this._t;
        if (_orVar != null) {
            _orVar._e(str_e);
        }
    }
}
