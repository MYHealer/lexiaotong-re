package com.fancy;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _f0 implements Serializable {
    public int _a;
    public int _b;
    public int _c;
    public String _d;
    public int _e;
    public int _f;
    public String _g;
    public _a _h;

    public static class _a implements Serializable {
        public int _a;
        public int _b;
    }

    public static _f0 _a(JSONObject jSONObject) {
        _f0 _f0Var = new _f0();
        if (jSONObject != null) {
            _f0Var._a = jSONObject.optInt("screenType");
            jSONObject.optInt("renderType");
            _f0Var._b = jSONObject.optInt("soundType");
            _f0Var._c = jSONObject.optInt("countDownSkipSeconds");
            _f0Var._d = jSONObject.optString("rewardName");
            _f0Var._e = jSONObject.optInt("rewardQuantity");
            _f0Var._f = jSONObject.optInt("rewardConfirmType");
            _f0Var._g = jSONObject.optString("rewardCallbackUrl");
            jSONObject.optDouble("rewardProgressPercent", 0.7d);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("fastTask");
            _a _aVar = new _a();
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.optInt("type");
                _aVar._a = jSONObjectOptJSONObject.optInt("delaySec");
                _aVar._b = jSONObjectOptJSONObject.optInt("duration");
            }
            _f0Var._h = _aVar;
        }
        return _f0Var;
    }
}
