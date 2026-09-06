package com.fancy;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ba implements Serializable {
    public int _a;
    public int _b;
    public long _c;

    public static _ba _a(JSONObject jSONObject) {
        _ba _baVar = new _ba();
        long jOptLong = 5;
        if (jSONObject != null) {
            _baVar._a = jSONObject.optInt("autoPlayMode");
            _baVar._b = jSONObject.optInt("soundType");
            jSONObject.optInt("renderType");
            jOptLong = jSONObject.optLong("countDownTime", 5L);
        } else {
            _baVar._a = 1;
            _baVar._b = 0;
        }
        _baVar._c = jOptLong;
        return _baVar;
    }
}
