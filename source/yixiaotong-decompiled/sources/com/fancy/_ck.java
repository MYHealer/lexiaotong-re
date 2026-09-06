package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.utils.Logger;
import com.kuaishou.weapon.p0.t;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ck {
    public Set<String> _A;
    public Set<String> _B;
    public Set<String> _C;
    public Set<String> _D;
    public Set<String> _E;
    public Set<String> _F;
    public Set<String> _G;
    public Set<String> _H;
    public Set<String> _I;
    public Set<String> _J;
    public Set<String> _K;
    public String _L;
    public int _M;
    public int _N;
    public int _O;
    public int _P;
    public int _Q;
    public int _R;
    public List<String> _S;
    public String _a;
    public String _b;
    public String _c;
    public int _d;
    public String _e;
    public String _f;
    public String _g;
    public String _h;
    public long _i;
    public int _j;
    public int _k;
    public long _l;
    public int _m;
    public String _p;
    public long _q;
    public HashMap _r;
    public HashMap _s;
    public String _t;
    public String _u;
    public List<String> _v;
    public String _w;
    public int _y;
    public Set<String> _z;
    public HashMap _n = new HashMap();
    public HashMap _o = new HashMap();
    public List<String> _x = new ArrayList();

    public static HashSet _a(String str) {
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(str)) {
            hashSet.add(str);
        }
        return hashSet;
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00bf  */
    public final String _b(String str) {
        String str2;
        if (TextUtils.isEmpty(this._L)) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            switch (str) {
                case "dpTracking":
                    str2 = t.q;
                    break;
                case "rewardTracking":
                    str2 = "reward";
                    break;
                case "vpTracking":
                    str2 = "vp";
                    break;
                case "initTracking":
                    str2 = "in";
                    break;
                case "bidSucTracking":
                    str2 = "s";
                    break;
                case "bidSelectedTracking":
                    str2 = "bs";
                    break;
                case "errorTracking":
                    str2 = "e";
                    break;
                case "filterTracking":
                    str2 = "filter";
                    break;
                case "impTracking":
                    str2 = "i";
                    break;
                case "clickTracking":
                    str2 = "c";
                    break;
                case "noticeBidLossTracking":
                    str2 = "noticeBidLoss";
                    break;
                case "bidTracking":
                    str2 = t.l;
                    break;
                case "noticeBidWinTracking":
                    str2 = "noticeBidWin";
                    break;
                default:
                    str2 = null;
                    break;
            }
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return this._L.replace("__ACTION__", str2);
    }

    public final void _a(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("baseTracking");
        this._L = strOptString;
        if (TextUtils.isEmpty(strOptString)) {
            try {
                this._L = URLDecoder.decode("http%3A%2F%2Ft2.fancyapi.com%2F__ACTION__%3Fct%3D__CLIENTTYPE__%26dt%3D__DATA__%26mo%3D__OS__%26m11%3D__OAID__%26m1a%3D__ANDROIDID__%26m2%3D__IMEI__%26m5%3D__IDFA__%26m70%3D__CAID__%26tr%3D__REQUESTID__%26ver%3D0%26o%3D+", "UTF-8");
            } catch (Exception unused) {
            }
        }
        String str_b = _b("initTracking");
        if (!TextUtils.isEmpty(str_b)) {
            this._f = str_b;
        }
        String str_b2 = _b("bidSelectedTracking");
        if (!TextUtils.isEmpty(str_b2)) {
            this._F = _a(str_b2);
        }
        String str_b3 = _b("bidSucTracking");
        if (!TextUtils.isEmpty(str_b3)) {
            this._E = _a(str_b3);
        }
        String str_b4 = _b("bidTracking");
        if (!TextUtils.isEmpty(str_b4)) {
            this._z = _a(str_b4);
        }
        String str_b5 = _b("clickTracking");
        if (!TextUtils.isEmpty(str_b5)) {
            this._B = _a(str_b5);
        }
        String str_b6 = _b("rewardTracking");
        if (!TextUtils.isEmpty(str_b6)) {
            this._C = _a(str_b6);
        }
        String str_b7 = _b("dpTracking");
        if (!TextUtils.isEmpty(str_b7)) {
            this._G = _a(str_b7);
        }
        String str_b8 = _b("errorTracking");
        if (!TextUtils.isEmpty(str_b8)) {
            this._D = _a(str_b8);
        }
        String str_b9 = _b("impTracking");
        if (!TextUtils.isEmpty(str_b9)) {
            this._A = _a(str_b9);
        }
        String str_b10 = _b("vpTracking");
        if (!TextUtils.isEmpty(str_b10)) {
            this._H = _a(str_b10);
        }
        String str_b11 = _b("filterTracking");
        if (!TextUtils.isEmpty(str_b11)) {
            this._I = _a(str_b11);
        }
        String str_b12 = _b("noticeBidLossTracking");
        if (!TextUtils.isEmpty(str_b12)) {
            this._J = _a(str_b12);
        }
        String str_b13 = _b("noticeBidWinTracking");
        if (TextUtils.isEmpty(str_b13)) {
            return;
        }
        this._K = _a(str_b13);
    }

    public final boolean _c(String str) {
        try {
            boolean z_b = _b(new JSONObject(str));
            if (z_b) {
                this._a = str;
            }
            return z_b;
        } catch (JSONException e) {
            Logger.d(e.getMessage());
            return false;
        }
    }

    public final boolean _b(JSONObject jSONObject) {
        JSONArray jSONArrayNames;
        int length;
        JSONArray jSONArrayNames2;
        int length2;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
        if (jSONObjectOptJSONObject == null) {
            return true;
        }
        this._b = jSONObject.optString("packageName");
        this._d = jSONObject.optInt("mediaStatus", 0);
        this._c = jSONObject.optString("vendorId");
        this._e = jSONObjectOptJSONObject.optString("ptgApiUrl");
        this._w = jSONObjectOptJSONObject.optString("wechatAppId");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("qaList");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            try {
                int length3 = jSONArrayOptJSONArray.length();
                if (length3 > 0) {
                    for (int i = 0; i < length3; i++) {
                        if (i < 10) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i));
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        this._x = arrayList;
        this._g = jSONObjectOptJSONObject.optString("policyVersion");
        this._l = jSONObjectOptJSONObject.optLong("fetchInterval");
        this._p = jSONObjectOptJSONObject.optString("rtbLogUrl");
        this._q = jSONObjectOptJSONObject.optLong("rtbLogInterval");
        this._h = jSONObjectOptJSONObject.optString("detectRule");
        this._i = jSONObjectOptJSONObject.optLong("detectRuleInterval");
        this._j = jSONObjectOptJSONObject.optInt("fdRule", 0);
        this._k = jSONObjectOptJSONObject.optInt("qaNRTime", 0);
        this._m = jSONObjectOptJSONObject.optInt("imageUpgrade", 0);
        this._y = jSONObjectOptJSONObject.optInt("lessThanVc", 24);
        this._u = jSONObjectOptJSONObject.optString("reportUrl");
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("hostWhiteList");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            try {
                int length4 = jSONArrayOptJSONArray2.length();
                if (length4 > 0) {
                    for (int i2 = 0; i2 < length4; i2++) {
                        arrayList2.add(jSONArrayOptJSONArray2.optString(i2));
                    }
                }
            } catch (Exception unused2) {
            }
        }
        this._v = arrayList2;
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("lisAct");
        if (jSONObjectOptJSONObject2 != null) {
            this._N = jSONObjectOptJSONObject2.optInt("blin", 0);
            this._M = jSONObjectOptJSONObject2.optInt("lin", 0);
            this._Q = jSONObjectOptJSONObject2.optInt("slin", 0);
            this._O = jSONObjectOptJSONObject2.optInt("linc", 0);
            this._P = jSONObjectOptJSONObject2.optInt("lind", 0);
            this._R = jSONObjectOptJSONObject2.optInt("delayLin", 60);
            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2.optJSONArray("wlist");
            if (jSONArrayOptJSONArray3 != null) {
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    arrayList3.add(jSONArrayOptJSONArray3.optString(i3));
                }
                this._S = arrayList3;
            }
        }
        try {
            JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray("whitelist");
            if (jSONArrayOptJSONArray4 != null) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray4.getJSONObject(i4);
                    if (jSONObject2 != null) {
                        _aw _awVar_a = new _aw()._a(jSONObject2);
                        if (_awVar_a._a()) {
                            if (this._n == null) {
                                this._n = new LinkedHashMap();
                            }
                            this._n.put(_awVar_a._b, _awVar_a);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.e("parse white list error," + e.getMessage());
        }
        try {
            JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("blockPacket");
            if (jSONArrayOptJSONArray5 != null) {
                for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                    JSONObject jSONObject3 = jSONArrayOptJSONArray5.getJSONObject(i5);
                    if (jSONObject3 != null) {
                        _aw _awVar_a2 = new _aw()._a(jSONObject3);
                        if (_awVar_a2._a()) {
                            if (this._o == null) {
                                this._o = new LinkedHashMap();
                            }
                            this._o.put(_awVar_a2._b, _awVar_a2);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Logger.e("parse block packets app list error," + e2.getMessage());
        }
        _a(jSONObjectOptJSONObject);
        try {
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("appId");
            if (jSONObjectOptJSONObject3 != null && (jSONArrayNames2 = jSONObjectOptJSONObject3.names()) != null && (length2 = jSONArrayNames2.length()) > 0) {
                this._r = new HashMap();
                for (int i6 = 0; i6 < length2; i6++) {
                    String strOptString = jSONArrayNames2.optString(i6);
                    this._r.put(strOptString, jSONObjectOptJSONObject3.optString(strOptString));
                }
            }
        } catch (Exception unused3) {
        }
        try {
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("appKey");
            if (jSONObjectOptJSONObject4 != null && (jSONArrayNames = jSONObjectOptJSONObject4.names()) != null && (length = jSONArrayNames.length()) > 0) {
                this._s = new HashMap();
                for (int i7 = 0; i7 < length; i7++) {
                    String strOptString2 = jSONArrayNames.optString(i7);
                    this._s.put(strOptString2, jSONObjectOptJSONObject4.optString(strOptString2));
                }
            }
        } catch (Exception unused4) {
        }
        try {
            this._t = jSONObjectOptJSONObject.optString("pUrl", "");
        } catch (Exception unused5) {
        }
        return true;
    }
}
