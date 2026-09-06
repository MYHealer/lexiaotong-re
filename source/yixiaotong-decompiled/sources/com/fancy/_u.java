package com.fancy;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _u {
    public String _a;
    public String _b;
    public String _c;
    public long _d;
    public boolean _e;
    public boolean _f;
    public boolean _g;
    public boolean _h;
    public long _i;
    public boolean _j;
    public boolean _k;
    public boolean _l;
    public String _m;

    public _u(String str, String str2, String str3, long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, boolean z5, boolean z6, boolean z7) {
        this._a = str;
        this._b = str2;
        this._c = str3;
        this._d = j;
        this._e = z;
        this._f = z2;
        this._g = z3;
        this._h = z4;
        this._i = j2;
        this._j = z5;
        this._k = z6;
        this._l = z7;
    }

    public static _u _a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("id");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        String strOptString2 = jSONObject.optString("url");
        if (TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        _u _uVar = new _u(strOptString, strOptString2, jSONObject.optString("par"), jSONObject.optLong("itv", 0L), jSONObject.optBoolean("cnp", false), jSONObject.optBoolean("ibi", false), jSONObject.optBoolean("ibl", false), jSONObject.optBoolean("nce", false), jSONObject.optLong("et", 0L), jSONObject.optBoolean("sap", false), jSONObject.optBoolean("ras", false), jSONObject.optBoolean("rsd", false));
        _uVar._m = jSONObject.toString();
        return _uVar;
    }
}
