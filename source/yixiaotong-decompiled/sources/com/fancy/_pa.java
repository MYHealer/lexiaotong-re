package com.fancy;

import android.util.Pair;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.umeng.analytics.pro.am;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _pa {
    public int _a;
    public long _b;
    public long _c;
    public int _d = 0;
    public boolean _e;

    public _pa(String str, Map map) {
        this._a = 1;
        this._b = 0L;
        this._e = false;
        try {
            Pair pair_a = _a(map);
            this._e = ((Boolean) pair_a.first).booleanValue();
            if (((Integer) pair_a.second).intValue() > 0) {
                _a(((Integer) pair_a.second).intValue(), str);
            }
            if (!this._e) {
                this._a = 1;
                this._b = 0L;
                return;
            }
            this._c = System.currentTimeMillis();
            Object obj = map.get("maxTri");
            if (obj instanceof String) {
                this._a = Integer.parseInt(obj.toString());
            }
            Object obj2 = map.get("minSt");
            if (obj2 instanceof String) {
                this._b = Long.parseLong(obj2.toString());
            }
            int i = this._a;
            if (i > 1) {
                this._a = com.fancy.adsdk.lib.utils._a._a.nextInt(i) + 1;
            } else {
                this._a = 1;
            }
        } catch (Exception unused) {
        }
    }

    public static Pair _a(Map map) {
        if (map == null) {
            return new Pair(Boolean.FALSE, -1);
        }
        try {
            Object obj = map.get("doWb");
            if (obj == null) {
                return new Pair(Boolean.FALSE, -3);
            }
            if (!Boolean.parseBoolean(obj.toString())) {
                return new Pair(Boolean.FALSE, -4);
            }
            Object obj2 = map.get("limit");
            Object obj3 = map.get(am.aT);
            boolean z = true;
            if (obj2 == null || obj3 == null) {
                return new Pair(Boolean.FALSE, 1);
            }
            int i = Integer.parseInt(obj2.toString());
            long j = ((long) Integer.parseInt(obj3.toString())) * 1000;
            long j_a = _kr._a("sdk_local_web_limit", "limit");
            long jCurrentTimeMillis = System.currentTimeMillis() - _kr._a("sdk_local_web_last_time", "lastTime");
            boolean z2 = j_a < ((long) i);
            if (jCurrentTimeMillis <= j) {
                z = false;
            }
            return (z2 && z) ? new Pair(Boolean.TRUE, 0) : new Pair(Boolean.FALSE, 2);
        } catch (Exception unused) {
            return new Pair(Boolean.FALSE, -2);
        }
    }

    public final synchronized boolean _a() {
        boolean z = true;
        if (!this._e) {
            return true;
        }
        synchronized (this) {
            if (System.currentTimeMillis() - this._c <= this._b) {
                int i = this._d + 1;
                this._d = i;
                if (i <= this._a) {
                    z = false;
                }
            } else if (this._d == 0) {
                this._e = false;
            }
            if (z) {
                _kr._a("sdk_local_web_limit", "limit", _kr._a("sdk_local_web_limit", "limit") + 1);
                _kr._a("sdk_local_web_last_time", "lastTime", System.currentTimeMillis());
            }
        }
        return z;
    }

    public static void _a(int i, String str) {
        try {
            _os _osVar = new _os(_n4._a);
            _osVar._h = str;
            _osVar._c = "iwc";
            _or _orVar_b = _osVar._b();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("state", i);
                _orVar_b._a.put("iwc", jSONObject);
            } catch (Exception unused) {
            }
            _orVar_b._i(PtgAdSdk.config.getMediaId());
            String str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar);
            if (TextUtil.isNotEmpty(str_a)) {
                NetUtils._a(str_a);
            }
        } catch (Exception unused2) {
        }
    }
}
